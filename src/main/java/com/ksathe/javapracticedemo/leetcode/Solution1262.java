package com.ksathe.javapracticedemo.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Solution1262 {
    //https://leetcode.com/problems/greatest-sum-divisible-by-three/
    public int maxSumDivThree(int[] nums) {
        int MOD_DIVISOR = 3;
        int result = 0;
        Map<Integer, List<Integer>> modLookup = new HashMap<>();

        for (int i : nums) {
            int mod = i % MOD_DIVISOR;
            List<Integer> modList = modLookup.getOrDefault(mod, new ArrayList<>());
            modList.add(i);
            modLookup.put(mod, modList);
        }

        result = modLookup.getOrDefault(0, new ArrayList<>()).stream().mapToInt(Integer::intValue).sum();

        List<Integer> modOne = modLookup.getOrDefault(1, new ArrayList<>()).stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        List<Integer> modTwo = modLookup.getOrDefault(2, new ArrayList<>()).stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        result += (modOne.size() > modTwo.size()) ? findLargestSum(modOne, modTwo) : findLargestSum(modTwo, modOne);
        return result;
    }

    private int findLargestSum(List<Integer> big, List<Integer> small) {
        int sum = 0;
        int index = 0;
        for (int i : small) {
            sum += i + big.get(index++);
        }

        if ((big.size() - small.size()) > 2) {
            int ind = small.size();
            while( ind < (big.size() - 2)) {
                sum += big.get(ind) + big.get(ind+1) + big.get(ind+2);
                ind += 3;
            }
        }

        int alternateSum = AggregateByThree(big) + AggregateByThree(small);
        //optimization (needs improvement)
        int thirdOption = AggregateByThree(big);
        int bigRemainInd = 3 * (big.size()/3);
        int smallInd = 0;
        while (bigRemainInd < big.size() && smallInd < small.size()) {
            thirdOption += big.get(bigRemainInd) + small.get(smallInd);
            bigRemainInd++;
            smallInd++;
        }
        thirdOption += AggregateByThree(small.subList(smallInd, small.size()));
        alternateSum = (alternateSum > thirdOption) ? alternateSum : thirdOption;
        return (alternateSum > sum) ? alternateSum : sum;
    }

    private int AggregateByThree(List<Integer> arr) {
        int i = 0, sum = 0;
        if (arr.size() < 3) return 0;
        while (i < (arr.size() - 2)) {
            sum += arr.get(i) + arr.get(i+1) + arr.get(i+2);
            i += 3;
        }
        return sum;
    }
}
