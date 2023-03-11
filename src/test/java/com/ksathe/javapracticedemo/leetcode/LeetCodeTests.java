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
}
