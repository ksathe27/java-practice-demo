package com.ksathe.javapracticedemo.leetcode.multi;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Sol552_1067_1088 {
    //urls not needed in comment, since using class name for leetcode id now but adding them below for last time
    // https://leetcode.com/problems/confusing-number-ii/
    // https://leetcode.com/problems/student-attendance-record-ii/
    // https://leetcode.com/problems/digit-count-in-range/

    //1 1088
    Set<Integer> confusingdigits = Stream.of(0, 1, 6, 8, 9).collect(Collectors.toSet());
    Map<Character, Character> rotateMap = new HashMap<>();
    Set<Integer> lookup = new HashSet<>();
    public int confusingNumberII(int n) {
        //
        //1 find length of n
        int len = String.valueOf(n).length();
        rotateMap.put('0', '0');
        rotateMap.put('1', '1');
        rotateMap.put('8', '8');
        rotateMap.put('6', '9');
        rotateMap.put('9', '6');
        // iterate each of 5 confusing numbers from 0 to len(n) and get all combinations
        //       for each combination
        //              get 180 turn by calling rotate()
        //              and add key as combo and rotated value as lookup
        // loop over lookup key-value pair
        // skip pairs where key == value
        for (int i = 1; i<= len; i++) {
            recurseGenerate(i, new StringBuilder(), n);
        }
        // return count
        return lookup.size();
    }


    void recurseGenerate(int remainingLen, StringBuilder sb, int n) {
        if(remainingLen > 0) {
            for (int v : confusingdigits) {
                StringBuilder sbNew = new StringBuilder(sb.toString());
                sbNew.append(v);
                recurseGenerate(remainingLen-1, sbNew, n);
            }
        } else {
            int current = Integer.parseInt(sb.toString());
            if (current <= n) {
                int rotated = rotate(current);
                if (current != rotated) {
                    lookup.add(current);
                }
            }
        }
    }
    int rotate(int num) {
        int len = String.valueOf(num).length();
        StringBuilder sb = new StringBuilder(String.valueOf(num));
        int low = 0, high = len - 1;
        while(low < high) {
            char lowChar = sb.charAt(low);
            sb.setCharAt(low, rotateMap.get(sb.charAt(high)));
            sb.setCharAt(high, rotateMap.get(lowChar));
            low++;
            high--;
        }
        if (len == 1) {
            char ch = String.valueOf(num).charAt(0);
            return Integer.parseInt(String.valueOf(rotateMap.get(ch)));
        }
        return Integer.parseInt(sb.toString());
    }
    //2

    //3
}
