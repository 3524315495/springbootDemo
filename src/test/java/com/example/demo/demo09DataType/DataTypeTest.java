package com.example.demo.demo09DataType;

import org.junit.jupiter.api.Test;

/**
 * 文件名：
 * 版权：Copyright 2017-2022 CMCC ALL Right Reserved.
 * 描述：
 */
public class DataTypeTest {
    @Test
    public void test() {
        byte b = 1;
        short s = 128;
        // 只能低精度在换成高精度，反之需要强制转化可能会损失精度
//        b = (byte) s;
//        System.out.println("short转换成byte：" + b); // -128

//        int i = 10000000;
//        i = b;
//        System.out.println(i); // 1

//        char c = (char)6553788;
//        System.out.println(c);
//        int i = c;
//        System.out.println("char转换成int：" + i);
//        c = (char) 2147483456;
//        System.out.println("char转换成int：" + c);
    }

    @Test
    public void testString() {
        String s1 = "hello";
        String s2 = "hello";
        String s3 = new String("hello");
        String s4 = "hell" + "o";
        if (s1 == s2) {
            //true
            System.out.println("s1 和 s2 指向同一个地址");
        }
        if (s1 == s3) {
            //false
            System.out.println("s1 和 s3 指向同一个地址");
        }
        if (s1 == s4) {
            // true
            System.out.println("s1 和 s4 指向同一个地址");
        }
    }
}
