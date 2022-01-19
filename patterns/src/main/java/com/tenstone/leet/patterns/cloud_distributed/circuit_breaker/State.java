package com.tenstone.leet.patterns.cloud_distributed.circuit_breaker;

/**
 * Created by liuyuancheng on 2022/1/19  <br/>
 *
 * @author liuyuancheng
 */
public enum State {
    CLOSED,
    OPEN,
    HALF_OPEN;
}
