package com.tenstone.jdk.jvm;

import lombok.extern.slf4j.Slf4j;

/**
 * Created by liuyuancheng on 2022/2/21  <br/>
 *
 * @author liuyuancheng
 */
@Slf4j
public class ClassLoaderDemo {

    public static void main(String[] args) {
        log.info("{}", System.getProperty("sun.boot.class.path"));
        log.info("{}", System.getProperty("java.ext.dirs"));
        log.info("{}", System.getProperty("java.class.path"));
        // 用户类由AppClassLoader加载
        // AppClassLoader位于rt.jar包（/jre/lib目录下），该目录所有jar包被bootClassLoader加载
        log.info("my classloader : {}", ClassLoaderDemo.class.getClassLoader());
        // jdk9以后，使用PlatformClassLoader替代ExtClassLoader
        // PlatformClassLoader是AppClassLoader的父加载器
        log.info("my classloader's parent : {}", ClassLoaderDemo.class.getClassLoader().getParent());
        log.info("my classloader's parent's parent : {}", ClassLoaderDemo.class.getClassLoader().getParent().getParent());
    }

}
