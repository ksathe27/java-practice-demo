package com.ksathe.javapracticedemo.leetcode;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Solution1531 {
    // https://leetcode.com/problems/string-compression-ii/

    private class Pair {
        String s;
        Integer k;
        public Pair(String ss, Integer kk) {
            s = ss;
            k = kk;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || obj.getClass() != getClass()) {
                return false;
            }
            Pair p = (Pair) obj;
            return this.s.equals(p.s) && this.k.equals(p.k);
        }

        @Override
        public int hashCode() {
            return Objects.hash(s, k);
        }
    }
    public int getLengthOfOptimalCompression(String s, int k) {
        if (s.length() < k) return 0;
        if ((s.length() - k) <= 2) return s.length() - k;
        Map<Pair, Integer> stringCurrKPairMap = new HashMap<>();
        Integer minResult = buildRLEBuilder(s).length();
        for (int kk = 0; kk <= k; kk++) {
            //for (int i = 0; i < kk; i++) {
                Integer value = findBest(kk, s, stringCurrKPairMap);
                Pair key = new Pair(s, kk);
                stringCurrKPairMap.put(key, value);
                minResult = Math.min(minResult, value);
            //}
        }
        int i = 0;
        return minResult;
    }

    private Integer findBest(int k, String currData, Map<Pair, Integer> dp) {
        Pair key = new Pair(currData, k);
        Integer curr = dp.get(key);
        if (curr == null) {
            //calculate it for all
            StringBuilder sb = new StringBuilder(currData);
            Integer minSoFar = buildRLEBuilder(currData).length();
            if (k > 0) {
                if (minSoFar == uniqueChars(sb.toString()) || ((currData.length() - k) <= 2)) {
                    minSoFar = sb.length() - k;
                } else {
                    int i = 0;
                    while (i < currData.length()) {
                        //remove each char and call recursively
                        Character ch = sb.charAt(i);
                        sb.deleteCharAt(i);
                        int currMin = findBest(k - 1, sb.toString(), dp);
                        sb.insert(i, ch);
                        minSoFar = Math.min(currMin, minSoFar);
                        //int count= ;
                        i = i + getCurrCharRepeatCount(sb.toString(), i);
                    }
                }
            }
            dp.put(key, minSoFar);
            return minSoFar;
        } else {
            return curr;
        }
    }


    private StringBuilder buildRLEBuilder(String s) {
        int ind = 0;
        StringBuilder sb = new StringBuilder();
        while(ind < s.length()) {
            sb.append(s.charAt(ind));
            int count = getCurrCharRepeatCount(s, ind);
            if (count > 1)  { sb.append(count); }
            ind = ind + count;
        }
        return sb;
    }

    private int getCurrCharRepeatCount(String s, int index) {
        int count = 0;
        int curr = s.charAt(index);
        while(index < s.length() && curr == s.charAt(index++)) {
            count++;
        }
        return count;
    }

    private int uniqueChars(String s) {
         return s.chars().mapToObj(c -> (char) c).collect(Collectors.toSet()).size();
    }
}
