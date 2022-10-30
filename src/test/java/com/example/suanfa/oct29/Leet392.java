package com.example.suanfa.oct29;

/**
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * 进阶：
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。
 * 在这种情况下，你会怎样改变代码
 */
public class Leet392 {
    public static void main(String[] args) {
        System.out.println(isSubsequence("aaaa", "aabb"));
    }

    public static boolean isSubsequence(String s, String t) {
        // 根据下标来判断。
        // 遍历s的每一个字符，获取该字符在t中的下标 并记录为 index
        // 继续遍历s 后一个字符串，获取该字符在t中的下标，如果当前下标小于 index 返回false
        int index = -1;
        for (int i = 0; i < s.length(); i++) {
            index = t.indexOf(s.charAt(i), index + 1);
            if (index == -1) return false;
        }
        return true;
    }
}
