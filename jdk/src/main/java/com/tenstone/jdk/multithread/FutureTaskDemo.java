package com.tenstone.jdk.multithread;

import com.google.common.base.Stopwatch;
import org.apache.commons.lang3.time.StopWatch;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by liuyuancheng on 2022/5/2  <br/>
 *
 * @author liuyuancheng
 */
public class FutureTaskDemo {

    public static void main(String[] args) throws TimeoutException, ExecutionException, InterruptedException {
        Stopwatch stopwatch = Stopwatch.createStarted();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(() -> {
            return Integer.MAX_VALUE;
        });
        System.out.println( stopwatch.elapsed(TimeUnit.MICROSECONDS));
        new Thread(futureTask).start();
        System.out.println(stopwatch.elapsed(TimeUnit.MICROSECONDS));
        final Integer integer = futureTask.get(2, TimeUnit.MILLISECONDS);
        System.out.println(integer);
    }

}
