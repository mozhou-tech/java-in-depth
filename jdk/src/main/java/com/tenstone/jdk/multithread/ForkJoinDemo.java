package com.tenstone.jdk.multithread;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * Created by liuyuancheng on 2022/1/26  <br/>
 * Fork/Join线程池，它可以执行一种特殊的任务：把一个大任务拆成多个小任务并行执行。
 *
 * @author liuyuancheng
 */
public class ForkJoinDemo {

    @Test
    void  parallelStream(){
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        // 基于ForkJoin实现，打印时无序
        numbers.parallelStream().forEach(System.out::print);
        System.out.println();
        // 按顺序打印
        numbers.forEach(System.out::print);
    }

    @Test
    void forkjoin(){
        // 创建2000个随机数组成的数组:
        long[] array = new long[2000];
        long expectedSum = 0;
        for (int i = 0; i < array.length; i++) {
            array[i] = random();
            expectedSum += array[i];
        }
        System.out.println("Expected sum: " + expectedSum);
        // fork/join: 任务数符合斐波那契数列
        ForkJoinTask<Long> task = new SumTask(array, 0, array.length);
        long startTime = System.currentTimeMillis();
        // 执行任务并获取结果
        Long result = ForkJoinPool.commonPool().invoke(task);
        long endTime = System.currentTimeMillis();
        System.out.println("Fork/join sum: " + result + " in " + (endTime - startTime) + " ms.");
    }

    static Random random = new Random(0);

    static long random() {
        return random.nextInt(10000);
    }

    /**
     * 递归分裂出子任务 RecursiveTask
     */
    static class SumTask extends RecursiveTask<Long> {
        static final int THRESHOLD = 100;
        long[] array;
        int start;
        int end;

        SumTask(long[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        /**
         * 核心方法
         * @return
         */
        @Override
        protected Long compute() {
            if (end - start <= THRESHOLD) {
                // 如果任务足够小,直接计算:
                long sum = 0;
                for (int i = start; i < end; i++) {
                    sum += this.array[i];
                    // 故意放慢计算速度:
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                    }
                }
                return sum;
            }
            // 任务太大,一分为二:
            int middle = (end + start) / 2;
            System.out.println(String.format("split %d~%d ==> %d~%d, %d~%d", start, end, start, middle, middle, end));
            SumTask subtask1 = new SumTask(this.array, start, middle);
            SumTask subtask2 = new SumTask(this.array, middle, end);
            // invokeAll会并行运行两个子任务:
            invokeAll(subtask1, subtask2);
            // 获得子任务的结果:
            Long subresult1 = subtask1.join();
            Long subresult2 = subtask2.join();
            // 汇总结果
            Long result = subresult1 + subresult2;
            System.out.println("result = " + subresult1 + " + " + subresult2 + " ==> " + result);
            return result;
        }
    }
}
