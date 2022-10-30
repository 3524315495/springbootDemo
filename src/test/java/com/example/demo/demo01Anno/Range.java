package com.example.demo.demo01Anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 文件名：
 * 版权：Copyright 2017-2022 CMCC ALL Right Reserved.
 * 描述：
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Range {
    int min() default 1;
    int max() default 120;
    String name() default "NoName";
}
