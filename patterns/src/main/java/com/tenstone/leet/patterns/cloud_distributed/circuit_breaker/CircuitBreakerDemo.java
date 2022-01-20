package com.tenstone.leet.patterns.cloud_distributed.circuit_breaker;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by liuyuancheng on 2022/1/19  <br/>
 *
 * @author liuyuancheng
 */
@Slf4j
public class CircuitBreakerDemo {

    public static void main(String[] args) {
        final long serverStartTime = System.nanoTime();
        final DelayedRemoteService delayedService = new DelayedRemoteService(serverStartTime, 5);
        final DefaultCircuitBreaker delayedServiceCircuitBreaker = new DefaultCircuitBreaker(delayedService, 3000, 2, 2000 * 1000 * 1000);
        final QuickRemoteService quickService = new QuickRemoteService();
        final DefaultCircuitBreaker quickServiceCircuitBreaker = new DefaultCircuitBreaker(quickService, 3000, 2, 2000 * 1000 * 1000);
        var monitoringService = new MonitoringService(delayedServiceCircuitBreaker, quickServiceCircuitBreaker);
        log.info(monitoringService.localResourceResponse());
        log.info(monitoringService.delayedServiceResponse());
        log.info(monitoringService.delayedServiceResponse());
        log.info(delayedServiceCircuitBreaker.getState());
        log.info(monitoringService.quickServiceResponse());
        log.info(quickServiceCircuitBreaker.getState());
        try {
            log.info(delayedServiceCircuitBreaker.getState());
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info(delayedServiceCircuitBreaker.getState());
        log.info(monitoringService.delayedServiceResponse());
        log.info(delayedServiceCircuitBreaker.getState());
    }

}
