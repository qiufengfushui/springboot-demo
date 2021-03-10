package com.z11g.base.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @program：demo
 * @description：用来 跳过 登录验证
 * @author：z11g
 * @create：2021-01-25
 **/
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface PassLoginAnnotation {
    boolean required() default true;
}