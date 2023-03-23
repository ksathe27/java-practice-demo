package com.ksathe.javapracticedemo.leetcode;

import java.util.*;

public class Solution1048 {
    Map<Integer, List<String>> lookup = new TreeMap<>();

    public int longestStrChain(String[] words) {
        Map<String, Integer> wordCountMap = new HashMap<>();
        int globalMax = 1;
        for (String w: words) {
            List<String> levelList = lookup.getOrDefault(w.length(), new ArrayList<>());
            levelList.add(w);
            lookup.put(w.length(), levelList);
        }
        // create array of <len, string> sorted by
        List<List<String>> allLists = new ArrayList<>(lookup.values());
        for (int i = 1; i<allLists.size(); i++) {
            List<String> sameLevelWords = allLists.get(i);
            int wordLen = (sameLevelWords.isEmpty()) ? 1 : sameLevelWords.get(0).length();
            for (String curr : sameLevelWords) {
                int currMax = wordCountMap.getOrDefault(curr, 1);
                for (String prev: lookup.getOrDefault(wordLen - 1, new ArrayList<>())) {
                    int prevMax = wordCountMap.getOrDefault(prev, 1);
                    if (isPredecessor(curr, prev)) {
                        currMax = Math.max(currMax, prevMax + 1);
                        wordCountMap.put(curr, currMax);
                    }
                }
                globalMax = Math.max(globalMax, wordCountMap.getOrDefault(curr, 1));
            }
        }
        return globalMax;
    }

    boolean isPredecessor(String bigger, String curr) {
        for (int i=0; i < bigger.length(); i++) {
            String prevSubstring = bigger.substring(0, i) + bigger.substring(i+1);
            if (prevSubstring.equals(curr)) return true;
        }
        return false;
    }
}
