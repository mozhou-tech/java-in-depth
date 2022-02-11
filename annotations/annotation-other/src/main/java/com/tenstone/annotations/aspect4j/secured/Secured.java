package com.tenstone.annotations.aspect4j.secured;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by liuyuancheng on 2022/2/9  <br/>
 *
 * @author liuyuancheng
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Secured {
    boolean isLocked() default false;
}
