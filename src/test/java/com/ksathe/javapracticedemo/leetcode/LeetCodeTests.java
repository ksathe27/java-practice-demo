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

    @Test
    public void testLeetcode3() {
        //https://leetcode.com/problems/greatest-sum-divisible-by-three/
        int[] input1 = {3,6,5,1,8};
        int[] input2 = {5,2, 2, 2};
        int[] input3 = {1,2,3,4,4};
        Solution1262 s = new Solution1262();
        assertEquals(12, s.maxSumDivThree(input3));
        assertEquals(s.maxSumDivThree(new int[]{2, 19, 6, 16, 5, 10, 7, 4, 11, 6}), 84);
        assertEquals(s.maxSumDivThree(input1), 18);
        assertEquals(9, s.maxSumDivThree(input2));
    }

    @Test
    public void testLeetcode4() {
        //https://leetcode.com/problems/decode-ways/
        Solution92 s = new Solution92();
        String input1 = "111111111111111111111111111111111111111111111";
        String input2 = "226";
        String input3 = "06";

        assertEquals(5, s.numDecodings("1111"));
        assertEquals(1836311903, s.numDecodings2(input1));
        assertEquals(3, s.numDecodings(input2));
        assertEquals(0, s.numDecodings(input3));
    }

    @Test
    public void testLeetCode5() {
        Solution357 s = new Solution357();
        assertEquals(739, s.countNumbersWithUniqueDigits(3));
        assertEquals(10,s.countNumbersWithUniqueDigits(1));
        assertEquals(91, s.countNumbersWithUniqueDigits(2));
    }

    @Test
    public void testLeetCode6() {
        Solution1155 s = new Solution1155();

        //assertEquals(1, s.numRollsToTarget(1, 6, 3));
        assertEquals(1, s.numRollsToTarget(1, 6, 3));
        assertEquals(6, s.numRollsToTarget(2, 6, 7));
        assertEquals(222616187, s.numRollsToTarget(30, 30, 500));
        assertEquals(469310697, s.numRollsToTarget(30, 30, 666));
    }
}
