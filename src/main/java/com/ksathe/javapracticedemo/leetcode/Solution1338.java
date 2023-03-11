package com.ksathe.javapracticedemo.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution1338 {
    //https://leetcode.com/problems/reduce-array-size-to-the-half/description/
    public int minSetSize(int[] arr) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->Integer.compare(b[1],a[1]));
        int cnt[] = new int[100001];
        for(int i:arr){
            cnt[i]++;  //count each occurance
        }
        for(int i=1;i<=100000;i++){
            if(cnt[i]>0){
                pq.offer(new int[]{i,cnt[i]});
            }
        }
        int res=0,n=arr.length,ans=0;
        while(res<(n+1)/2){
            res+=pq.poll()[1];
            ans++;
        }
        return ans;
    }

    public int minSetSize2(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i: arr) {
            Integer count = countMap.getOrDefault(i, 0) + 1;
            countMap.put(i, count);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b)->Integer.compare(b.getValue(), a.getValue()));

        countMap.entrySet().forEach(e -> pq.offer(e));
        int ans = 0, current = 0;
        int halfLength = (arr.length + 1) / 2;
        while(current < halfLength) {
            current += pq.poll().getValue();
            ans++;
        }

        return ans;
    }
}
