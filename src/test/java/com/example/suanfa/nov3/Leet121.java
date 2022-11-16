package com.example.suanfa.nov3;


public class Leet121 {
    public static void main(String[] args) {
        /**
         * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
         * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
         * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
         */
//        int[] prices = {1, 2, 5, 4, 2, -5, 100};
//        int[] prices = {7, 1, 5, 3, 6, 4};
//        int[] prices = {1, 2, 4};
        int[] prices = {1, 2};
        System.out.println(maxProfit3(prices));
    }

    // 最小数在最大数的左边
    // 最大数 - 最小数的 保证是最大的 则获利最大
    // 这种做法是时间换空间 【超时】
    public static int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > max) {
                    max = prices[j] - prices[i];
                }
            }
        }
        return max;
    }

    // [1][2] [1][3] [1][4]
    // [2][3] [2][4]
    // [3][4]

    // 超出内存限制！！！ 原因：二维数组浪费空间
    public static int maxProfit2(int[] prices) {
        if (prices.length < 2) return 0;
        int[][] memo = new int[prices.length][prices.length]; // 二维数组造成了空间浪费
        int max = 0;
        memo[0][0] = 0;
        for (int i = 0; i < memo.length; i++) {
            for (int j = i; j < memo.length; j++) {
                memo[i][j] = prices[j] - prices[i];
                if (max < memo[i][j]) max = memo[i][j];
            }
        }
        return max;
    }

    public static int maxProfit3(int[] prices) {
        if (prices.length < 2) return 0;
        int max = 0;
        int min = prices[0];
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(max,prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return max;
    }

}
