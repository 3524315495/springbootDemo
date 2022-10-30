package com.example.suanfa.oct28;

/**
 * 文件名：
 * 版权：Copyright 2017-2022 CMCC ALL Right Reserved.
 * 描述：
 */
public class Leet724 {
    /**
     * 给你一个整数数组 nums ，请计算数组的 中心下标 。
     * 数组 中心下标是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
     * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
     * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
     *
     * @param args
     */
    public static void main(String[] args) {
        int[] ints = {1, -1, -1};
//        System.out.println(pivotIndex(ints));
        System.out.println(pivotIndex2(ints));
    }

    public static int pivotIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // 左边元素之和 0 ~ i-1
            int sumLeft = 0;
            for (int i1 = 0; i1 <= i - 1; i1++) {
                sumLeft += nums[i1];
            }
            int sumRight = 0;
            // 右边元素之和 i+1 ~ nums.length - 1
            for (int i1 = i + 1; i1 <= nums.length - 1; i1++) {
                sumRight += nums[i1];
            }
            if (sumLeft == sumRight) {
                return i;
            }
        }
        return -1;
    }

    public static int pivotIndex2(int[] nums) {
        // sumLeft * 2 + nums[中心索引] = sumTotal
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int leftSum = 0;
        for (int i = 0; i < nums.length; i++) {
            leftSum += nums[i];
            if ((leftSum - nums[i]) * 2 + nums[i] == sum) {
                return i;
            }
        }
        return -1;
    }
}
