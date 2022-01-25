package com.tenstone.leet.calcite;

import lombok.extern.slf4j.Slf4j;
import org.apache.calcite.avatica.metrics.MetricsSystemConfiguration;
import org.apache.calcite.avatica.remote.Driver;
import org.apache.calcite.avatica.remote.Service;
import org.apache.calcite.avatica.server.*;

/**
 * Created by liuyuancheng on 2022/1/24  <br/>
 *
 * @author liuyuancheng
 */
@Slf4j
public class SqlParserDemo {

    private static final String[] SERVER_ARGS = {"test"};

    public static void main(String[] args) throws Exception {
        new SqlParserDemo().start();
    }

    /**
     * https://calcite.apache.org/avatica/docs/index.html
     */
    public void start() throws Exception {

        // Bind to '0' to pluck an ephemeral port instead of expecting a certain one to be free
        final HttpServer jsonServer = Main.start(SERVER_ARGS, 0, new Main.HandlerFactory() {
            @Override
            public AvaticaJsonHandler createHandler(Service service) {
                return new AvaticaJsonHandler(service);
            }
        });
        jsonServer.start();
    }

    /**
     * Starts Avatica server and cache.
     */
    public void startServer(HandlerFactory factory, Service service, Driver.Serialization serialization,
                            MetricsSystemConfiguration metricsConfig,
                            AvaticaServerConfiguration serverConfig) {
        AvaticaHandler handler = factory.getHandler(service, serialization,
                metricsConfig, serverConfig);
        final HttpServer server = new HttpServer.Builder().withHandler(handler)
                .withPort(0).build();
        server.start();
    }
}
