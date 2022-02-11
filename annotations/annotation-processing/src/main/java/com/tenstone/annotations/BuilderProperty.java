package com.tenstone.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by liuyuancheng on 2022/2/11 <br/>
 *
 * @author liuyuancheng
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.METHOD)
public @interface BuilderProperty {

}
