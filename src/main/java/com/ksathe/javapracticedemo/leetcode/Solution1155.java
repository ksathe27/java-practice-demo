package com.ksathe.javapracticedemo.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution1155 {
    //https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/editorial/
    final int MOD = 1000000007;
    Map<String, Integer> lookup = new HashMap<>();
    public int numRollsToTarget(int n, int k, int target) {
        if (n == 0 || k == 0 || target == 0) {
            return 0;
        }
        int[][] dp = new int[n + 1][target + 1];
        for (int[] dpRow: dp) {
            Arrays.fill(dpRow, 0);
        }
        for (int i = 1; i<=k && i <= target; i++) {
            dp[1][i] = 1;
        }
        if (n == 1) {
            return dp[n][target];
        }
        for (int nIndex = 2; nIndex <= n; nIndex++) {
            int  maxLevel = Math.min((nIndex * k), target);// dp[nIndex][nIndex to maxLevel]
            for (int j = nIndex; j <= maxLevel; j++) {
                // agg for each nIndex, currTarget from base to base + k;
                int tempSum = 0;
                for(int i=1; i <= k; i++) {
                    if ((j - i) > 0) {
                        tempSum = tempSum + dp[nIndex - 1][j - i];
                        tempSum = tempSum % MOD;
                    }
                }
                dp[nIndex][j] = tempSum;
            }
        }

        return dp[n][target];
    }

}
