package com.example.demo.demo11Lambda;

/**
 * 文件名：
 * 版权：Copyright 2017-2022 CMCC ALL Right Reserved.
 * 描述：
 */
public class LambdaDemo01 {
    public static void main(String[] args) {
        System.out.println(compare((x, y) -> x - y));
    }

    public static int compare(MyCompare compare) {
        return compare.compare(1, -2);
    }

}

