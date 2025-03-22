package com.ksathe.javapracticedemo.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class CommonDataStructureUtils {
    //list of one-liners, like convert int[] to set-of-int and so on....
    public Set<Integer> getUniq(int[] input) {
        //or Set<Integer> uniq = new HashSet<Integer>(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        return Arrays.stream(input).boxed().collect(Collectors.toSet());
    }
}
