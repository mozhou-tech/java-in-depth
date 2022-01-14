package com.tenstone.juc.locks;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * ABA问题
 * Created by liuyuancheng on 2022/1/7  <br/>
 *
 * @author liuyuancheng
 */
@Slf4j
public class CasABAProblemDemo {

    @AllArgsConstructor
    @Data
    static class Student {
        private String name;

        @Override
        public String toString() {
            return "student:" + name + "\n";
        }
    }

    /**
     * 聚合类的原子性问题
     */
    public static void question1() {
        log.info("=================================聚合类的原子性问题=======================================");
        Student a = new Student("a");
        Student b = new Student("b");
        Student c = new Student("c");
        AtomicReference<Student> atomicReference = new AtomicReference<>(a);
        // compareAndSet(A,B)  A为期望变量中存在的值，B为新值；如果A不符合期望，则返回False
        log.info("a->b {}", atomicReference.compareAndSet(a, b));
        log.info("b->a {}", atomicReference.compareAndSet(b, a));
        a.setName("a1");
        log.info("a->c {} (此处对象a已被修改但CAS操作仍然成功，说明聚合类不具备原子性)", atomicReference.compareAndSet(a, c));
        log.info("===========================解决方案===================================");
        AtomicStampedReference<Student> atomicStampedReference = new AtomicStampedReference<>(a, 0);
        log.info("a印0->b印1 {} (value: b印1)", atomicStampedReference.compareAndSet(a, b, 0, 1));
        log.info("b印1->a印2 {} (value: a印2)", atomicStampedReference.compareAndSet(b, a, 1, 2));
        log.info("a印0->c印1 {} (value为a印2，不符合预期的a印0)", atomicStampedReference.compareAndSet(a, c, 0, 1));
        log.info("\n");
    }

    /**
     * 在多线程的环境中，线程a从共享的地址X中读取到了对象A。
     * 在线程a准备对地址X进行更新之前，线程b将地址X中的值修改为了B。
     * 接着线程b将地址X中的值又修改回了A。
     * 最新线程a对地址X执行CAS，发现X中存储的还是对象A，对象匹配，CAS成功。
     */
    public static void question2() {
        Student a = new Student("a");
        Student b = new Student("b");
        Student c = new Student("c");
        log.info("===============================ABA===================================================");
        // 也可以使用AtomicStampedReference
        AtomicMarkableReference<Student> atomicMarkableReference = new AtomicMarkableReference<Student>(a, true);
        log.info("\n");
    }

    public static void main(String[] args) {
        question1();
        question2();
    }
}
