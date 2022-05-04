package com.tenstone.jdk.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.http.*;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.DnsResolver;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.impl.conn.SystemDefaultDnsResolver;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.pool.PoolStats;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

//HTTP 协议处理帮助类
@Slf4j
public class HttpClientHelper {
    private static final long KEEP_ALIVE_DURATION = 600000;//长连接的保持时长， 单位ms
    private static final int CONNECT_TIMEOUT = 2000;//客户端和服务器建立连接的超时时长， 单位ms
    private static final int SOCKET_TIMEOUT = 2000;//建立连接后，客户端从服务器读取数据的超时时长， 单位ms
    private static final int REQUEST_TIMEOUT = 2000;//从连接池获取连接的超时时长， 单位ms
    private static final int EXPIRED_CHECK_GAP = 6000;//无效线程的清理间隔，单位ms
    private static final int VALIDATE_AFTER_INACTIVITY = 2000;//连接池对不活跃连接的检查间隔，单位ms
    private static final int POOL_MAX_TOTAL = 500;
    private static final int MAX_PER_ROUTE = 500;
    // 发送请求的客户端单例
    private static CloseableHttpClient httpClient;
    private static ScheduledExecutorService monitorExecutor = null;

    //单例：HTTP长连接管理器，也就是连接池
    private static PoolingHttpClientConnectionManager httpClientConnectionManager;

    //单例：全局的池化HTTP客户端实例
    private static CloseableHttpClient pooledHttpClient;


    /**
     * 1 直接创建客户端
     *
     * @return HttpClient
     */
    private static CloseableHttpClient getDirectHttpClient() {
        CloseableHttpClient client = HttpClientBuilder.create().build();
        return client;
    }

    /**
     * 2 简单的发送请求
     *
     * @param url 连接地址
     * @return 请求字符串
     */
    public static String simpleGet(String url) throws IOException {
        // 1 直接创建客户端
        CloseableHttpClient client = HttpClientBuilder.create().build();
        //2 创建请求
        HttpGet httpGet = new HttpGet(url);
        //3 超时配置
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(1000)
                .setSocketTimeout(1000)
                .setConnectTimeout(1000)
                .build();
        httpGet.setConfig(requestConfig);
        //4 发送请求，处理响应
        return simpleRequestData(url, client, httpGet);
    }

    /**
     * 2 简单的发送请求
     *
     * @param url 连接地址
     * @return 请求字符串
     */
    public static String simplePost(String url) throws IOException {
        // 1 直接创建客户端
        CloseableHttpClient client = HttpClientBuilder.create().build();
        //2 创建请求
        HttpPost httpGet = new HttpPost(url);
        //3 超时配置
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(1000)
                .setSocketTimeout(1000)
                .setConnectTimeout(1000)
                .build();
        httpGet.setConfig(requestConfig);
        //4 发送请求，处理响应
        return simpleRequestData(url, client, httpGet);
    }

    /**
     * 仅仅获得内容长度
     *
     * @param url 连接地址
     * @return 请求字符串
     */
    public static long justLength(String url) throws IOException {
        // 1 直接创建客户端
        CloseableHttpClient client = HttpClientBuilder.create().build();
        //2 创建请求
        HttpGet request = new HttpGet(url);
        //3 超时配置
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectionRequestTimeout(1000)
                .setSocketTimeout(1000)
                .setConnectTimeout(1000)
                .build();
        request.setConfig(requestConfig);
        //4 发送请求，处理响应
        CloseableHttpResponse response = null;
        InputStream in = null;
        long length = -1;
        try {
            HttpHost httpHost = getHost(url);
            response = client.execute(httpHost, request, HttpClientContext.create());
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                length = entity.getContentLength();
            }
        } finally {
            quietlyClose(in);
            quietlyClose(response);
            //释放HttpClient 连接。
            quietlyClose(client);
        }

        return length;

    }

    /**
     * 使用JDK的 java.net.HttpURLConnection发起HTTP请求
     */
    public static String jdkGet(String url) {
        //输入流
        InputStream inputStream = null;
        //HTTP连接实例
        HttpURLConnection httpConnection = null;
        StringBuilder builder = new StringBuilder();
        try {
            URL restServiceURL = new URL(url);
            //打开HttpURLConnection连接实例
            httpConnection =
                    (HttpURLConnection) restServiceURL.openConnection();
            //设置请求头
            httpConnection.setRequestMethod("GET");
            httpConnection.setRequestProperty("Accept", "application/json");
            //建立连接，发送请求
            httpConnection.connect();
            //读取响应
            if (httpConnection.getResponseCode() != 200) {
                throw new RuntimeException("HTTP GET Request Failed with Error code : "
                        + httpConnection.getResponseCode());
            }
            //读取响应内容（字节流）
            inputStream = httpConnection.getInputStream();
            byte[] b = new byte[1024];
            int length = -1;
            while ((length = inputStream.read(b)) != -1) {
                builder.append(new String(b, 0, length));
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流和连接
            quietlyClose(inputStream);
            httpConnection.disconnect();
        }
        return builder.toString();
    }

    /**
     * 设置post请求的参数
     *
     * @param httpPost 主机ip和端口
     * @param params   请求参数
     */
    private static void setPostParams(HttpPost httpPost, Map<String, String> params) {
        if (null == params) {
            return;
        }
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        Set<String> keys = params.keySet();
        for (String key : keys) {
            nvps.add(new BasicNameValuePair(key, params.get(key)));
        }
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 使用连接池中的请求发送
     *
     * @param url    连接地址
     * @param params 参数
     * @return 请求字符串
     */
    public static String post(String url, Map<String, String> params) {
        //取得连接池
        CloseableHttpClient client = pooledHttpClient();
        HttpPost httpPost = new HttpPost(url);
        setPostParams(httpPost, params);
        return poolRequestData(url, client, httpPost);
    }


    /**
     * 直接发送请求
     *
     * @param url    连接地址
     * @param params 参数
     * @return 请求字符串
     */
    public static String simplePost(String url, Map<String, String> params) throws IOException {
        //取得连接池
        CloseableHttpClient client = getDirectHttpClient();
        HttpPost httpPost = new HttpPost(url);
        setPostParams(httpPost, params);
        return simpleRequestData(url, client, httpPost);
    }


    /**
     * 内部的请求发送
     *
     * @param url     连接地址
     * @param client  客户端
     * @param request post 或者 getStr 或者其他请求
     * @return 请求字符串
     */
    private static String simpleRequestData(String url, CloseableHttpClient client, HttpRequest request) throws IOException {
        CloseableHttpResponse response = null;
        InputStream in = null;
        String result = null;
        try {
            HttpHost httpHost = getHost(url);
            response = client.execute(httpHost, request, HttpClientContext.create());
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                in = entity.getContent();
                result = IOUtils.toString(in, "utf-8");
            }
        } finally {
            quietlyClose(in);
            quietlyClose(response);
            //释放HttpClient 连接。
            quietlyClose(client);
        }

        return result;
    }


    /**
     * 内部的请求发送
     *
     * @param url     连接地址
     * @param client  客户端
     * @param request post 或者 getStr 或者其他请求
     * @return 请求字符串
     */
    private static String getRequestContent(String url, CloseableHttpClient client, HttpRequest request) throws IOException {
        CloseableHttpResponse response = null;
        InputStream in = null;
        String result = null;
        try {
            HttpHost httpHost = getHost(url);
            response = client.execute(httpHost, request, HttpClientContext.create());
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                in = entity.getContent();
                result = IOUtils.toString(in, "utf-8");
            }
        } finally {
            quietlyClose(in);
            quietlyClose(response);
            //释放HttpClient 连接。
            quietlyClose(client);
        }

        return result;
    }


    /**
     * 使用带连接池的HTTP客户端，发送请求
     *
     * @param url     连接地址
     * @param client  客户端
     * @param request post、get或者其他请求
     * @return 响应字符串
     */
    private static String poolRequestData(
            String url, CloseableHttpClient client, HttpRequest request) {
        CloseableHttpResponse response = null;
        InputStream in = null;
        String result = null;
        try {
            //从url中获取HttpHost实例，含主机和端口
            HttpHost httpHost = getHost(url);
            //执行HTTP请求
            response = client.execute(httpHost, request, HttpClientContext.create());
            //获取HTTP响应
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                in = entity.getContent();
                result = IOUtils.toString(in, "utf-8");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            quietlyClose(in);
            quietlyClose(response);
            //无论执行成功或出现异常，HttpClient 都会自动处理并保证释放连接。
        }

        return result;
    }


    /**
     * 从url中获取HttpHost实例，含主机和端口
     *
     * @param url url 地址
     * @return HttpHost
     */
    private static HttpHost getHost(String url) {
        String hostName = url.split("/")[2];
        int port = 80;
        if (hostName.contains(":")) {
            String[] args = hostName.split(":");
            hostName = args[0];
            port = Integer.parseInt(args[1]);
        }
        HttpHost httpHost = new HttpHost(hostName, port);
        return httpHost;
    }

    /**
     * 使用带连接池的HTTP客户端，发送GET请求
     *
     * @param url 连接地址
     * @return 请求字符串
     */
    public static String get(String url) {
        //1 取得带连接池的客户端
        CloseableHttpClient client = pooledHttpClient();
        //2 创建一个HTTP请求实例
        HttpGet httpGet = new HttpGet(url);
        //3 使用带连接池的HTTP客户端，发送请求，并且获取结果
        return poolRequestData(url, client, httpGet);
    }

    /**
     * 创建带连接池的 httpClient 客户端
     */
    public static CloseableHttpClient pooledHttpClient() {
        if (null != pooledHttpClient) {
            return pooledHttpClient;
        }
        createHttpClientConnectionManager();
        log.info(" Apache httpclient 初始化HTTP连接池  starting===");

        //请求配置实例
        RequestConfig.Builder requestConfigBuilder = RequestConfig.custom();
        // 等待数据超时设置
        requestConfigBuilder.setSocketTimeout(SOCKET_TIMEOUT);
        // 连接超时设置
        requestConfigBuilder.setConnectTimeout(CONNECT_TIMEOUT);
        //从连接池获取连接的等待超时时间设置
        requestConfigBuilder.setConnectionRequestTimeout(REQUEST_TIMEOUT);
        RequestConfig config = requestConfigBuilder.build();

        // httpclient建造者实例
        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
        //设置连接池管理器
        httpClientBuilder.setConnectionManager(httpClientConnectionManager);
        //设置请求配置信息
        httpClientBuilder.setDefaultRequestConfig(config);

        //httpclient默认提供了一个Keep-Alive策略
        //这里进行定制：确保客户端与服务端在长连接的保持时长一致
        httpClientBuilder.setKeepAliveStrategy(new ConnectionKeepAliveStrategy() {
            @Override
            public long getKeepAliveDuration(HttpResponse response, HttpContext context) {
                //获取响应头中HTTP.CONN_KEEP_ALIVE中的“Keep-Alive”部分值
                //如服务端响应“Keep-Alive: timeout=60”，表示服务端保持时长为60秒
                //则客户端也设置连接的保持时长为60秒
                //目的：确保客户端与服务端在长连接的保持时长一致
                HeaderElementIterator it = new BasicHeaderElementIterator
                        (response.headerIterator(HTTP.CONN_KEEP_ALIVE));
                while (it.hasNext()) {
                    HeaderElement he = it.nextElement();
                    String param = he.getName();
                    String value = he.getValue();
                    if (value != null && param.equalsIgnoreCase
                            ("timeout")) {
                        try {
                            return Long.parseLong(value) * 1000;
                        } catch (final NumberFormatException ignore) {
                        }
                    }
                }
                //如果服务端响应头中没有设置保持时长，则使用客户端统一定义时长为600s
                return KEEP_ALIVE_DURATION;
            }
        });
        //实例化：全局的池化HTTP客户端实例
        pooledHttpClient = httpClientBuilder.build();
        log.info(" Apache httpclient 初始化HTTP连接池  finished===");
        //启动定时处理线程：对异常和空闲连接进行关闭
        startExpiredConnectionsMonitor();
        return pooledHttpClient;
    }

    //连接池：HTTP管理器
    public static void createHttpClientConnectionManager() {

        //DNS解析器
        DnsResolver dnsResolver = SystemDefaultDnsResolver.INSTANCE;
        //负责HTTP传输的Socket套接字工厂
        ConnectionSocketFactory plainSocketFactory =
                PlainConnectionSocketFactory.getSocketFactory();
        //负责HTTPS传输的安全Socket套接字工厂
        LayeredConnectionSocketFactory sslSocketFactory =
                SSLConnectionSocketFactory.getSocketFactory();
        //根据应用层协议，为其注册传输层的套接字工厂
        Registry<ConnectionSocketFactory> registry =
                RegistryBuilder.<ConnectionSocketFactory>create()
                        .register("http", plainSocketFactory)
                        .register("https", sslSocketFactory)
                        .build();
        //创建连接池管理器
        httpClientConnectionManager = new PoolingHttpClientConnectionManager(
                registry,  //传输层套接字注册器
                null,
                null,
                dnsResolver,   //DNS解析器
                KEEP_ALIVE_DURATION,  //长连接的连接保持时长
                TimeUnit.MILLISECONDS);  //保持时长的时间单位

        //在从连接池获取连接时，连接不活跃多长时间后需要进行一次验证
        // 默认为2s  TimeUnit.MILLISECONDS
        httpClientConnectionManager.setValidateAfterInactivity(VALIDATE_AFTER_INACTIVITY);
        //最大连接数，高于这个值时的新连接请求，需要阻塞和排队等待
        httpClientConnectionManager.setMaxTotal(POOL_MAX_TOTAL);
        // 设置每个route默认的最大连接数
        //路由是对MaxTotal的细分。
        //每个路由实际最大连接数默认值是由DefaultMaxPerRoute控制。
        //MaxPerRoute设置的过小，无法支持大并发
        httpClientConnectionManager.setDefaultMaxPerRoute(MAX_PER_ROUTE);
    }

    /**
     * 定时处理线程：对异常和空闲连接进行关闭
     */
    private static void startExpiredConnectionsMonitor() {
        //空闲监测,配置文件默认为6s,生产环境建议稍微放大一点
        int idleCheckGap = EXPIRED_CHECK_GAP;
        // 设置保持连接的时长,根据实际情况调整配置
        long keepAliveTimeout = KEEP_ALIVE_DURATION;
        //开启监控线程,对异常和空闲线程进行关闭
        monitorExecutor = Executors.newScheduledThreadPool(1);
        monitorExecutor.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                //关闭异常连接
                httpClientConnectionManager.closeExpiredConnections();
                //关闭keepAliveTimeout（保持连接时长）超时的不活跃的连接
                httpClientConnectionManager.closeIdleConnections(keepAliveTimeout, TimeUnit.MILLISECONDS);
                //获取连接池的状态
                PoolStats status = httpClientConnectionManager.getTotalStats();
                //输出连接池的状态,仅供测试使用
                /*
                log.info(" manager.getRoutes().size():" + manager.getRoutes().size());
                log.info(" status.getAvailable():" + status.getAvailable());
                log.info(" status.getPending():" + status.getPending());
                log.info(" status.getLeased():" + status.getLeased());
                log.info(" status.getMax():" + status.getMax());
                */
            }
        }, idleCheckGap, idleCheckGap, TimeUnit.MILLISECONDS);
    }

    /**
     * 安静的关闭可关闭对象
     *
     * @param closeable 可关闭对象
     */
    private static void quietlyClose(java.io.Closeable closeable) {
        if (null == closeable) return;
        try {
            closeable.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}