package com.tenstone.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by liuyuancheng on 2022/2/7 <br/>
 *
 * @author liuyuancheng
 */
@Retention(value = RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
public @interface MethodDemoAnnotation2 {
    char value() default '-';
    int loop() default 1;
}
