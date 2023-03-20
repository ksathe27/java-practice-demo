package com.ksathe.javapracticedemo.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeetCodeTests {

    @Test
    public void testLeetcode1() {
        //https://leetcode.com/problems/reduce-array-size-to-the-half/description/
        int[] arr1 = {3,3,3,3,5,5,5,2,2,7};
        Solution1338 s = new Solution1338();
        int result = s.minSetSize(arr1);
        int result2 = s.minSetSize2(arr1);
        assertEquals(result, 2);
        assertEquals(result, result2);
        System.out.println(" test complete ");
    }

    @Test
    public void testLeetcode2() {
        //https://leetcode.com/problems/longest-increasing-subsequence/
        int[] input1 = { 2, 5, 3, 7, 11, 7, 10, 13, 6 };;
        int[] input2 = { 2, 5, 3, 7, 11, 8, 10, 13, 6 };
        Solution300 s = new Solution300();

        int result1 = s.lengthOfLIS(input1);
        int result2 = s.lengthOfLIS(input2);
        assertEquals(result1, s.lengthOfLIS2(input1));
        assertEquals(result2, s.lengthOfLIS2(input2));
    }
}
