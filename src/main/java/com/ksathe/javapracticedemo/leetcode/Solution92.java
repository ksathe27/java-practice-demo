package com.ksathe.javapracticedemo.leetcode;

import java.util.*;

public class Solution92 {
    //https://leetcode.com/problems/decode-ways/
    Map<String, String> decodeMap = new HashMap<>(); //build map for '1' -> 'A' ...
    Set<List<String>> result = new HashSet<>();
    Integer result2 = 0;
    List<String> VALID_APPENDERS = Arrays.asList("1", "2");

    void buildMaps() {
        char base = 'A';
        for (int i = 0; i < 26; i++) {
            //encodeMap.put( String.valueOf((char)('A'+i)), i + 1);
            decodeMap.put(String.valueOf(i + 1), String.valueOf((char)('A'+i)));
        }
        result2 = 0;
    }
    public int numDecodings(String s) {
        result.clear();
        buildMaps();
        List<String> first = new ArrayList<>();
        for (Character ch : s.toCharArray()) {
            first.add(String.valueOf(ch));
        }
        recurse(first, 0);
        return result2;
    }

    private void recurse(List<String> input, int currIndex) {
        if (isValid(input)) {
            //result.add(input);
            result2++;
        } else {
            return ;
        }
        for (int i = currIndex; i < (input.size() -1); i++) {
            // recurs here
            String curr = input.get(i);
            if(VALID_APPENDERS.contains(curr)) {
                List<String> nextList = new ArrayList<>(input);
                String nextElement = curr + nextList.get(i + 1);
                nextList.remove(i);
                nextList.remove(i);
                nextList.add(i, nextElement);
                recurse(nextList, i + 1);
            }
        }
    }

    private boolean isValid(List<String> curr) {
        for (String str : curr) {
            if (!decodeMap.containsKey(str)) {
                return false;
            }
        }
        return true;
    }

    /// v2


    public int numDecodings2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= n; i++) {
            int oneDigit = Integer.parseInt(s.substring(i - 1, i));
            int twoDigits = Integer.parseInt(s.substring(i - 2, i));
            if (oneDigit >= 1 && oneDigit <= 9) {
                dp[i] += dp[i - 1];
            }
            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}
