package com.example.suanfa.nov4;

import java.util.HashMap;
import java.util.Map;

/**
 * 文件名：
 * 版权：Copyright 2017-2022 CMCC ALL Right Reserved.
 * 描述：
 */
public class Leet409 {
    /**
     * 给定一个包含大写字母和小写字母的字符串 s，返回通过这些字母构造成的 最长的回文串。
     * 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
     */
    public static void main(String[] args) {
        System.out.println(longestPalindrome2("aab"));

    }

    // 1、奇数：第一次计数为奇数的全部用于构成回文字符串，之后计数为奇数的字符数量减一可用于构成字符串
    // 2、偶数：可全用于构成回文字符串
    public static int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int len = 0;
        boolean b = true; // 如果对奇数次的字符进行了全统计，则为false
        // 再次遍历 map，将value相加 ，如果是奇数 第一次出现的奇数全加，后面的减一
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 != 0 && !b) {
                // 多次奇数
                len += entry.getValue() - 1;
            } else if (entry.getValue() % 2 == 0) {
                // 偶数
                len += entry.getValue();
            } else { // 奇数并且第一次出现
                b = false;
                len += entry.getValue();
            }
        }
        return len;
    }

    public static int longestPalindrome2(String s) {
        // arrays 记录了每个字符出现的次数
        int[] arrays = new int[128];
        for (char c : s.toCharArray()) {
            arrays[c]++;
        }
        int length = 0;
        // 遍历 arrays，偶数 % 2 == 0；奇数 % 2 == 1 , 当遇到第一个奇数时，长度 ++
        for (int v : arrays) {
            length += v/2 * 2;
            if (length % 2 == 0 && v % 2 == 1){
                length ++;
            }
        }
        return length;
    }

}
