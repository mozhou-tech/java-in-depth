package com.tenstone.net;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by liuyuancheng on 2022/1/28  <br/>
 *
 * @author liuyuancheng
 */
public class HttpServerDemo {

    private HttpServer httpServer;

    static class MyRootHandler implements HttpHandler {

        @Override
        public void handle(HttpExchange exchange) throws IOException {
            if ("GET".equals(exchange.getRequestMethod())) {
                /*
                 * PS: 必须按顺序设置响应: 添加响应头, 发送响应码和内容长度, 写出响应内容, 关闭处理器
                 */
                // 响应内容
                byte[] respContents = "Hello World!".getBytes(StandardCharsets.UTF_8);
                // 设置响应头
                exchange.getResponseHeaders().add("Content-Type", "text/html; charset=UTF-8");
                // 设置响应code和内容长度
                exchange.sendResponseHeaders(200, respContents.length);
                // 设置响应内容
                exchange.getResponseBody().write(respContents);
                // 关闭处理器, 同时将关闭请求和响应的输入输出流（如果还没关闭）
                exchange.close();
            }
        }
    }

    public HttpServerDemo() {
        try {
            httpServer = HttpServer.create(new InetSocketAddress(8080), 0);
            final LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
            final ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1, 1, 100,
                    TimeUnit.SECONDS, queue, Executors.defaultThreadFactory());
            httpServer.setExecutor(threadPool);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        final HttpServerDemo serverDemo = new HttpServerDemo();
        serverDemo.httpServer.createContext("/", new MyRootHandler());
        serverDemo.httpServer.start();
    }
}
