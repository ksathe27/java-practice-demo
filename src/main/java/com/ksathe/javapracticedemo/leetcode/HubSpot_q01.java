package com.ksathe.javapracticedemo.leetcode;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class HubSpot_q01 {
/*
Given a string (e.g. "inengineering"), write a method of signature (string str, int n) -> string that returns the most frequently occurring substring of length n in str.
For example, with str equal to "inengineering" and n = 2, the substrings would be:
in, ne, en, ng, gi, in, ne, ee, er, ri, in, ng
and the most frequently occurring substring is in.
 */

       public String mostFrequentSubstring(String input, int substringLen) {
           //0 create map of String, Integer
           Map<String, Integer> lookup = new HashMap<>();
           //TODO check min string len and substringlen

           //1 iterate through sliding window of size substringLen from 0 to end of string
           // -> for each substring add/increment count for that key

           for (int index = 0; index <= (input.length() - substringLen); index++) {
               String substr = input.substring(index, index + substringLen);
               Integer count = lookup.getOrDefault(substr, 0) + 1;
               lookup.put(substr, count);
           }

           //2  get all map.entries and sort them by value desc and return 1st key for map.entry
           PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.getValue(), a.getValue()));

           for (Map.Entry<String, Integer> e: lookup.entrySet()) {
               pq.offer(e);
           }
           if (pq.isEmpty()) {
               return "";
           }
           String result = pq.peek().getKey();
           return result;
       }
}
