package com.tenstone.leet.patterns.cloud_distributed.circuit_breaker;



/**
 * Created by liuyuancheng on 2022/1/18  <br/>
 *
 * @author liuyuancheng
 */
public class MonitoringService {

    private CircuitBreaker delayService;

    private CircuitBreaker quickService;

    public MonitoringService(CircuitBreaker delayService, CircuitBreaker quickService) {
        this.delayService = delayService;
        this.quickService = quickService;
    }

    public String localResourceResponse(){
        return "Local Service is working";
    }

    public String delayedServiceResponse(){
        try {
            return this.delayService.attemptRequest();
        }catch (RemoteServiceException e){
            return e.getMessage();
        }
    }

    public String quickServiceResponse(){
        try {
            return this.quickService.attemptRequest();
        }catch (RemoteServiceException e){
            return e.getMessage();
        }
    }
}
