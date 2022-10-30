package com.example.demo.demo04Option;

import org.junit.jupiter.api.Test;

import java.util.Optional;

/**
 * 文件名：
 * 版权：Copyright 2017-2022 CMCC ALL Right Reserved.
 * 描述：
 */
public class Test3 {
    @Test
    public void test1() {
//        Optional<Object> o = Optional.of(null);
        Optional<Object> o = Optional.of(null);
        Object o1 = o.get();
    }

    /**
     * ofNullable:如果传参为null 则返回一个空optional
     */
    @Test
    public void test2() {
        Optional<Object> o = Optional.ofNullable(null);
        System.out.println(o.get());//NoSuchElementException
    }

    /**
     * empty() 返回一个空的optional对象
     */
    @Test
    public void test3(){
        Optional<Object> empty = Optional.empty();
        System.out.println(empty.get());//NoSuchElementException
    }

    /**
     * isPresent 值存在返回true 不存在返回false
     */
    @Test
    public void test4(){
        String s = null;
        Optional<String> s1 = Optional.ofNullable(s);
        System.out.println(s1.isPresent()); //这样就避免了空指针
    }

    /**
     * orElse 如果有值将其返回 否则返回orElse方法传入的参数
     */
    @Test
    public void test5(){
        String s = null;
        String s1 = Optional.ofNullable(s).orElse("???");
        System.out.println(s1);//???
    }
}
