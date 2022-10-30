package com.example.demo.demo08Enum;

import org.junit.jupiter.api.Test;

/**
 * 文件名：
 * 版权：Copyright 2017-2022 CMCC ALL Right Reserved.
 * 描述：
 */
public class EnumDemo {
    public enum Color {
        RED(1,"Red"){
            @Override
            public String toString() {
                return "ssss";
            }
        }, GREEN(2,"Green"), BLUE(3,"Blue");
        private int id;
        private String name1;

        Color(int id, String name) {
            this.id = id;
            this.name1 = name;
        }

    }

    @Test
    public void test1() {
        Color[] values = Color.values();
        for (Color value : values) {
            System.out.println("toString = " + value.toString());
            System.out.println("name = " + value.name());
            System.out.println("id = " + value.id);
            System.out.println("name1 = " + value.name1);
        }
    }
}
