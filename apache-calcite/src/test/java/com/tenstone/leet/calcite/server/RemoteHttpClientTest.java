package com.tenstone.leet.calcite.server;

import org.apache.calcite.avatica.ConnectionConfig;
import org.apache.calcite.avatica.remote.*;
import org.apache.calcite.avatica.server.HttpServer;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * Created by liuyuancheng on 2022/1/25  <br/>
 *
 * @author liuyuancheng
 */
@RunWith(Parameterized.class)
public class RemoteHttpClientTest {

    private static Map<String, String> getHeaders() {
        return HEADERS_REF.get();
    }

    static {
        try {
            Class.forName("org.apache.calcite.avatica.remote.Driver");
            final Enumeration<java.sql.Driver> drivers = DriverManager.getDrivers();
            while (drivers.hasMoreElements()){
                System.out.println(drivers.nextElement());
            }
            DriverManager.registerDriver(new Driver());
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private static final AtomicReference<Map<String, String>> HEADERS_REF = new AtomicReference<>();

    private static final AvaticaServersForTest SERVERS = new AvaticaServersForTest();

    @Parameterized.Parameters(name = "{0}")
    public static List<Object[]> parameters() throws Exception {
        SERVERS.startServers();
        return SERVERS.getJUnitParameters();
    }

    @AfterClass
    public static void afterClass() throws Exception {
        if (null != SERVERS) {
            SERVERS.stopServers();
        }
    }

    private final HttpServer server;
    private final String url;
    private final int port;
    private final Driver.Serialization serialization;

    public RemoteHttpClientTest(Driver.Serialization serialization, HttpServer server) {
        this.server = server;
        this.port = this.server.getPort();
        this.serialization = serialization;
        this.url = SERVERS.getJdbcUrl(port, serialization);
    }

    static String generateString(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            sb.append('a');
        }
        return sb.toString();
    }

    @Test
    public void testLargeHeaders() throws Exception {
        ConnectionSpec.getDatabaseLock().lock();
        // 32K header. Relies on the default value of 64K from HttpServer.Builder
        HEADERS_REF.set(Collections.singletonMap("MyLargeHeader", generateString(1024 * 32)));
        String modifiedUrl = url + ";httpclient_factory=" + HttpClientFactoryForTest.class.getName();
        try (Connection conn = DriverManager.getConnection(modifiedUrl);
             Statement stmt = conn.createStatement()) {
            assertFalse(stmt.execute("CREATE TABLE largeHeaders(pk integer not null primary key)"));
            assertFalse(stmt.execute("DROP TABLE largeHeaders"));
        } finally {
            ConnectionSpec.getDatabaseLock().unlock();
        }
    }

    /**
     * Factory class to inject a custom HttpClient
     */
    public static class HttpClientFactoryForTest implements AvaticaHttpClientFactory {
        @Override
        public AvaticaHttpClient getClient(URL url, ConnectionConfig config,
                                           KerberosConnection kerberosUtil) {
            Map<String, String> headers = getHeaders();
            return new HeaderInjectingHttpClient(headers, url);
        }
    }

    /**
     * HttpClient implementation which supports injecting custom HTTP headers
     */
    public static class HeaderInjectingHttpClient extends AvaticaHttpClientImpl {
        private final Map<String, String> headers;

        public HeaderInjectingHttpClient(Map<String, String> headers, URL url) {
            super(url);
            this.headers = Objects.requireNonNull(headers);
        }
    }
}

