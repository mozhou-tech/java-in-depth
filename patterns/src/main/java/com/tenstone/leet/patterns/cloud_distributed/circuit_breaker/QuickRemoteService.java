package com.tenstone.leet.patterns.cloud_distributed.circuit_breaker;

/**
 * Created by liuyuancheng on 2022/1/18  <br/>
 *
 * @author liuyuancheng
 */
public class QuickRemoteService implements IRemoteService {
    
    @Override
    public String call() {
        return "quick remote service.";
    }
}
