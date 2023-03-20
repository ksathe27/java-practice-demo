package com.ksathe.javapracticedemo.leetcode;

import java.util.Arrays;

public class Solution300 {
    //https://leetcode.com/problems/longest-increasing-subsequence/
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;

        int[] result = new int[nums.length];
        result[0] = nums[0];
        int index = 1;
        for (int i = 1; i < nums.length - 1; i++) {
            if (result[index - 1] < nums[i]) {
                result[index] = nums[i];
                index++;
            } else {
                int idx = Arrays.binarySearch(result, 0, index - 1, nums[i]);
                if (idx < 0) {
                    idx = -1 * idx - 1;
                }
                result[idx] = nums[i];
            }
        }
        return index;
    }

    public int lengthOfLIS2(int[] input) {
        if (input == null || input.length < 1) return 0;

        int[] dp = new int[input.length];
        Arrays.fill(dp, 1);
        for (int i=0; i < input.length; i++) {
            for (int j=0; j < i; j++) {
                if (input[j] < input[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int currMax = 1;
        for (int val : dp) {
            currMax = Math.max(val, currMax);
        }
        return currMax;
    }
}
