package com.example.demo.demo12dataStructure;

import java.util.HashMap;
import java.util.Map;

/**
 * 文件名：
 * 版权：Copyright 2017-2022 CMCC ALL Right Reserved.
 * 描述：
 */
public class DataTest1 {
    public static void main(String[] args) {
//        HashMap<Object, Object> map = new HashMap<>();
        Map arg = new HashMap();
        arg.put("1",100000L);
        System.out.println(arg.get("1").toString());
    }
}
