package com.example.suanfa.nov4;

import java.util.Arrays;

/**
 * 文件名：
 * 版权：Copyright 2017-2022 CMCC ALL Right Reserved.
 * 描述：
 */
public class Fibonacci {
    /**
     * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
     * F(0) = 0, F(1) = 1, F(2) = 1, F(3) = 2, F(4) = 3,F(5) = 5,F(6) = 8,F(7) = 13;
     * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
     */
    public static void main(String[] args) {
//        System.out.println(fib(2));
        System.out.println(fibonacci2(48));
        System.out.println(fibonacci3(48));
    }

    // 递归
    public static int fib(int n) {
        // F(N) = F(N - 1) + F(N - 2);
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int sum = fib(n - 1) + fib(n - 2);
        return sum % 1000000007;
    }

    // 自顶向下备忘录法
    public static int fibonacci2(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return fib2(n, memo);
    }

    private static int fib2(int n, int[] memo) {
        if (memo[n] != -1) return memo[n];
        if (n <= 2) {
            memo[n] = 1;
        } else {
            memo[n] = fib2(n - 1, memo) + fib2(n - 2, memo);
        }
        return memo[n];
    }

    // 自底向上
    public static int fibonacci3(int n) {
        if (n < 2) return n;
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }


}
