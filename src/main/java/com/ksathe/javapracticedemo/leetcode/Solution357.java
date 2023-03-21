package com.ksathe.javapracticedemo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution357 {
    final int DISTINCT_WAYS = 10;
    Map<Integer, Integer> lookup = new HashMap<>();
    public int countNumbersWithUniqueDigits(int num) {
        //
        if (num < 2) {
            return num == 1 ? 10 : 1;
        } else {
            int result = 1;
            for (int i = 1; i <= num; i++) {
                int temp = 9, ind = 0;
                while (ind < (i - 1)) {
                    temp = temp * (9 - ind);
                    ind++;
                }
                result += temp;
            }
            return result;
        }
    }

}
