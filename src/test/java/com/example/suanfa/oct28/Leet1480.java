package com.example.suanfa.oct28;

/**
 * 文件名：
 * 版权：Copyright 2017-2022 CMCC ALL Right Reserved.
 * 描述：
 */
public class Leet1480 {
//    给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
//    请返回 nums 的动态和。
    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6, 7};
        int[] sum = runningSum(ints);
    }

    public static int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; ++i) {
            nums[i] += nums[i-1];
        }
        return nums;
    }
}
