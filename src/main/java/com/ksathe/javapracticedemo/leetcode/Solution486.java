package com.ksathe.javapracticedemo.leetcode;

import java.util.Arrays;

public class Solution486 {
    //https://leetcode.com/problems/predict-the-winner/description/
    // and 877 https://leetcode.com/problems/stone-game/
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }

        for (int step=2; step <= n; step++) {
            for (int i=0; i <= n - step; i++) {
                int j = i + step - 1;
                dp[i][j] = Math.max(nums[i] - dp[i+1][j], nums[j] - dp[i][j-1]);
            }
        }
        return dp[0][n-1] >= 0;
    }

    //
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];
        String[][] result = new String[n][n];
        Arrays.stream(result).forEach(a -> Arrays.fill(a, ""));

        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (piles[i] - dp[i+1][j] > piles[j] - dp[i][j-1]) {
                    //i picked
                    result[i][j] = i + "->" + result[i+1][j];
                } else {
                    // j picked
                    result[i][j] = j + "->" + result[i][j-1];
                }
                dp[i][j] = Math.max(piles[i] - dp[i+1][j], piles[j] - dp[i][j-1]);
            }
        }
        return dp[0][n-1] > 0;
    }
}
