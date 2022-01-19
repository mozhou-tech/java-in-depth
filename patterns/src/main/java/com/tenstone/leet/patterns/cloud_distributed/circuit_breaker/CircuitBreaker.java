package com.tenstone.leet.patterns.cloud_distributed.circuit_breaker;

/**
 * Created by liuyuancheng on 2022/1/18  <br/>
 *
 * @author liuyuancheng
 */
public interface CircuitBreaker {
    void recordSuccess();

    void recordFailure(String response);

    String getState();
    void setState(State state);
    String attemptRequest();

}
