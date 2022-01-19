package com.tenstone.leet.patterns.cloud_distributed.circuit_breaker;


/**
 * Created by liuyuancheng on 2022/1/18  <br/>
 *
 * @author liuyuancheng
 */
public class DefaultCircuitBreaker implements CircuitBreaker {

    private IRemoteService service;

    private long timeout;

    private long retryTimePeriod;

    private long lastFailureTime;

    private String lastFailureResponse;

    private int failureThreshold;

    private State state;

    private long futureTime = 1000 * 1000 * 1000 * 1000;

    private int failureCount;

    public DefaultCircuitBreaker(IRemoteService remoteService, long timeout, long retryTimePeriod, int failureThreshold) {
        this.service = remoteService;
        this.state = State.CLOSED;
        this.failureThreshold = failureThreshold;
        this.timeout = timeout;
        this.retryTimePeriod = retryTimePeriod;
        this.lastFailureTime = System.nanoTime() + futureTime;
        this.failureCount = 0;
    }

    @Override
    public void recordSuccess() {
        this.failureCount = 0;
        this.lastFailureTime = System.nanoTime() + futureTime;
        this.state = State.CLOSED;
    }

    @Override
    public void recordFailure(String response) {
        failureCount += failureCount;
        this.lastFailureTime = System.nanoTime();
        this.lastFailureResponse = response;
    }

    protected void evaluateState() {
        if (failureCount >= failureThreshold) {
            if ((System.nanoTime() - lastFailureTime) > retryTimePeriod) {
                state = State.HALF_OPEN;
            } else {
                state = State.CLOSED;
            }
        }else {
            state = State.CLOSED;
        }
    }

    @Override
    public String getState() {
        evaluateState();
        return state.name();
    }

    @Override
    public void setState(State state) {
        this.state = state;
        switch (state){
            case OPEN:
                this.failureCount = failureThreshold;
                this.lastFailureTime = System.nanoTime();
                break;
            case HALF_OPEN:
                this.failureCount = failureThreshold;
                this.lastFailureTime = System.nanoTime()-retryTimePeriod;
                break;
            default:
                this.failureCount = 0;
        }
    }

    @Override
    public String attemptRequest() throws RemoteServiceException{
        evaluateState();
        if(state == State.OPEN){
            return this.lastFailureResponse;
        }else{
            try {
                var response = service.call();
                recordSuccess();
                return response;
            }catch (RemoteServiceException e){
                recordFailure(e.getMessage());
                throw e;
            }
        }
    }
}
