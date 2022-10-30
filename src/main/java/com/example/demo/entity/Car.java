package com.example.demo.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 文件名：
 * 版权：Copyright 2017-2022 CMCC ALL Right Reserved.
 * 描述：
 */
@Repository
public class Car {
    @Autowired
    private wheel wheel;

//    public Car() {
//
//    }

    public void run() {
        wheel.roll();
    }
}
