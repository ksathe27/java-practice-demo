package com.ksathe.javapracticedemo.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Solution2444 {
    //https://leetcode.com/problems/count-subarrays-with-fixed-bounds/
    public long countSubarrays(int[] nums, int minK, int maxK) {
        // minPosition, maxPosition: the MOST RECENT positions of minK and maxK.
        // leftBound: the MOST RECENT value outside the range [minK, maxK].
        long answer = 0;
        int minPosition = -1, maxPosition = -1, leftBound = -1;

        // Iterate over nums, for each number at index i:
        for (int i = 0; i < nums.length; ++i) {
            // If the number is outside the range [minK, maxK], update the most recent leftBound.
            if (nums[i] < minK || nums[i] > maxK)
                leftBound = i;

            // If the number is minK or maxK, update the most recent position.
            if (nums[i] == minK)
                minPosition = i;
            if (nums[i] == maxK)
                maxPosition = i;

            // The number of valid subarrays equals the number of elements between leftBound and
            // the smaller of the two most recent positions (minPosition and maxPosition).
            answer += Math.max(0, Math.min(maxPosition, minPosition) - leftBound);
        }
        return answer;
    }

    public long countSubarrays2(int[] nums, int minK, int maxK) {
        long[][] dpMin = new long[nums.length][nums.length];
        long[][] dpMax = new long[nums.length][nums.length];
        System.out.println(" len " + nums.length);
        //init dp
        for (int i = 0; i < nums.length; i++) {
            dpMax[i][i] = nums[i];
            dpMin[i][i] = nums[i];
        }

        //loop
        for (int row=0; row < nums.length; row++) {
            for (int col=row+1; col < nums.length; col++) {
                dpMin[row][col] = Math.min(dpMin[row][col-1], dpMin[col][col]);
                dpMax[row][col] = Math.max(dpMax[row][col-1], dpMax[col][col]);
            }
        }

        //sum results
        long result = 0;
        for (int i=0; i<nums.length; i++) {
            for (int j=i; j< nums.length; j++) {
                if (dpMin[i][j] == minK && dpMax[i][j] == maxK) {
                    result++;
                }
            }
        }
        return result;
    }
}
