package com.tenstone.leet.calcite.server;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by liuyuancheng on 2022/1/25  <br/>
 *
 * @author liuyuancheng
 */
public class ConnectionSpec {
    public final String url;
    public final String username;
    public final String password;
    public final String driver;

    // CALCITE-687 HSQLDB seems to fail oddly when multiple tests are run concurrently
    private static final ReentrantLock HSQLDB_LOCK = new ReentrantLock();

    public ConnectionSpec(String url, String username, String password,
                          String driver) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.driver = driver;
    }

    public static final ConnectionSpec HSQLDB =
            new ConnectionSpec("test", "test",
                   "test", "org.hsqldb.jdbcDriver");

    /**
     * Return a lock used for controlling concurrent access to the database as it has been observed
     * that concurrent access is causing problems with HSQLDB.
     */
    public static ReentrantLock getDatabaseLock() {
        return HSQLDB_LOCK;
    }
}

