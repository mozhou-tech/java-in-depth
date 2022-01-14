package com.tenstone.benchmark;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * Created by liuyuancheng on 2022/1/7  <br/>
 *
 * @author liuyuancheng
 */

/**
 * @BenchmarkMode
 * 基准测试类型。这里选择的是 Throughput 也就是吞吐量。根据源码点进去，每种类型后面都有对应的解释，比较好理解，吞吐量会得到单位时间内可以进行的操作数。
 *
 * Throughput - 整体吞吐量，例如“1 秒内可以执行多少次调用”。
 * AverageTime - 调用的平均时间，例如“每次调用平均耗时 xxx 毫秒”。
 * SampleTime - 随机取样，最后输出取样结果的分布，例如“99%的调用在 xxx 毫秒以内，99.99%的调用在 xxx 毫秒以内”
 * SingleShotTime - 以上模式都是默认一次 iteration 是 1s，唯有 SingleShotTime 是只运行一次。往往同时把 warmup 次数设为 0，用于测试冷启动时的性能。
 * All - 所有模式
 */
@BenchmarkMode(Mode.Throughput)
@Warmup(iterations = 2)
/**
 * 度量，其实就是一些基本的测试参数。
 *
 * iterations - 进行测试的轮次
 * time - 每轮进行的时长
 * timeUnit - 时长单位
 * 都是一些基本的参数，可以根据具体情况调整。一般比较重的东西可以进行大量的测试，放到服务器上运行。
 */
@Measurement(iterations = 2, time = 1, timeUnit = TimeUnit.SECONDS)
// 每个进程中的测试线程，这个非常好理解，根据具体情况选择，一般为 cpu 乘以 2。
@Threads(8)
// Fork 2个进程进行测试
@Fork(2)
// 这个比较简单了，基准测试结果的时间类型。一般选择秒、毫秒、微秒。
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class JmhStringBuilderBenchmark {

    /**
     * 性能最差
     */
    @Benchmark
    public void testStringAdd() {
        String a = "";
        for (int i = 0; i < 10; i++) {
            a += i;
        }
    }

    /**
     * 非线程安全，性能最高
     */
    @Benchmark
    public void testStringBuilderAdd() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(i);
        }
    }

    /**
     * Benchmark为方法级注解，与junit的@Test类似
     *
     * 线程安全，性能中档
     */
    @Benchmark
    public void testStringBufferAdd(){
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            sb.append(i);
        }
    }

    public static void main(String[] args) throws RunnerException {
        StringBuilder outputPath = new StringBuilder(System.getProperty("user.dir"));
        outputPath.append("/").append("cocurrent/src/main/java/com/tenstone/leet/juc/benchmark/");
        outputPath.append("jmh-benchmark.log");
        Options options = new OptionsBuilder().include(JmhStringBuilderBenchmark.class.getSimpleName()).output(outputPath.toString()).build();
        new Runner(options).run();

        /**
         * Benchmark                                     Mode  Cnt      Score       Error   Units
         * JmhStringBuilderBenchmark.testStringAdd         thrpt    4  10802.993 ±  8773.085  ops/ms
         * JmhStringBuilderBenchmark.testStringBufferAdd   thrpt    4  23757.569 ± 18782.998  ops/ms
         * JmhStringBuilderBenchmark.testStringBuilderAdd  thrpt    4  25895.895 ± 38813.322  ops/ms
         */
    }
}
