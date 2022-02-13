package com.tenstone.jdk.multithread;

import com.alibaba.ttl.TransmittableThreadLocal;
import com.alibaba.ttl.TtlRunnable;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by liuyuancheng on 2022/1/7  <br/>
 * https://github.com/alibaba/transmittable-thread-local
 * ThreadLocal的需求场景即TransmittableThreadLocal的潜在需求场景，
 * 如果你的业务需要『在使用线程池等会池化复用线程的执行组件情况下传递ThreadLocal值』则是TransmittableThreadLocal目标场景。
 * <p>
 * 下面是几个典型场景例子：
 * 分布式跟踪系统 或 全链路压测（即链路打标）
 * 日志收集记录系统上下文
 * Session级Cache
 * 应用容器或上层框架跨应用代码给下层SDK传递信息
 * <p>
 * 框架目的：透明且自动完成所有异步执行上下文的可定制、规范化的捕捉与传递。
 * TransmittableThreadLocal类继承并加强InheritableThreadLocal类
 *
 * @author liuyuancheng
 */
public class TransmittableThreadLocalDemo {

    static TransmittableThreadLocal<String> context = new TransmittableThreadLocal<>();

    public static void main(String[] args) {
        final ExecutorService executorService = Executors.newFixedThreadPool(2);
        // 在父线程中设置
        context.set("value-set-in-parent");

        Runnable task = new RunnableTask();
        // 额外的处理，生成修饰了的对象ttlRunnable
        Runnable ttlRunnable = TtlRunnable.get(task);
        executorService.submit(ttlRunnable);
        // Task中可以读取，值是"value-set-in-parent"
        executorService.shutdownNow();
    }

    @Slf4j
    static class RunnableTask implements Runnable {

        public String result;

        @Override
        public void run() {
            this.result = TransmittableThreadLocalDemo.context.get();
            log.info("父进程传值到子进程： {}", result);
        }
    }

}
