package com.tenstone.jdk.multithread;

import java.text.SimpleDateFormat;

/**
 * 描述： 演示ThreadLocal用法2：避免传递参数的麻烦（同一个线程中，从threadLocal去拿-线程中共享变量）
 * 在不同的线程间共享变量
 */
public class ThreadLocalNormalUsage06 {

    public static void main(String[] args) {
        new Service1().process("");
    }
}

class Service1 {

    public void process(String name) {
        UserContextHolder.holder.set(new User("超哥"));
        UserContextHolder.holder1.set(new User("超哥-1"));
        new Service2().process();
    }
}

class Service2 {
    public void process() {
        User user = UserContextHolder.holder.get();
        User user1 = UserContextHolder.holder1.get();
        System.out.println("Service2拿到用户名：" + user.name);
        System.out.println("Service2拿到用户名：" + user1.name);
        new Service3().process();
    }
}

class Service3 {

    public void process() {
        User user = UserContextHolder.holder.get();
        System.out.println("Service3拿到用户名：" + user.name);
        UserContextHolder.holder.remove();
    }
}

class UserContextHolder {
    public static ThreadLocal<User> holder = new ThreadLocal<>();
    public static ThreadLocal<User> holder1 = new ThreadLocal<>();
}

class User {
    String name;
    public User(String name) {
        this.name = name;
    }
}