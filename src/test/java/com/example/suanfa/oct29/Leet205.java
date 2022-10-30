package com.example.suanfa.oct29;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 文件名：
 * 版权：Copyright 2017-2022 CMCC ALL Right Reserved.
 * 描述：
 */
public class Leet205 {
    /**
     * 给定两个字符串s和t，判断它们是否是同构的。
     * 如果s中的字符可以按某种映射关系替换得到t，那么这两个字符串是同构的。
     * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
     */
    public static void main(String[] args) {
        boolean isomorphic = isIsomorphic("add", "egg");
        System.out.println(isomorphic);
    }

    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))) {
                if (map.containsValue(t.charAt(i))) {
                    return false;
                }
                map.put(s.charAt(i), t.charAt(i));
            } else {
                if (map.get(s.charAt(i)) != t.charAt(i)) {
                    // 键重复，判断值是否重复，不重复返回false
                    return false;
                }
            }
        }
        return true;
    }
}
