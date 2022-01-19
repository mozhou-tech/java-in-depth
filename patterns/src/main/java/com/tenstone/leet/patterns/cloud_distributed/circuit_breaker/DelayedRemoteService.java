package com.tenstone.leet.patterns.cloud_distributed.circuit_breaker;

/**
 * Created by liuyuancheng on 2022/1/18  <br/>
 *
 * @author liuyuancheng
 */
public class DelayedRemoteService implements IRemoteService {

    private long serverStartTime;

    private int delay;

    public DelayedRemoteService(long serverStartTime, int delay) {
        this.serverStartTime = serverStartTime;
        this.delay = delay;
    }

    @Override
    public String call() {
        return "delayed remote service.";
    }
}
