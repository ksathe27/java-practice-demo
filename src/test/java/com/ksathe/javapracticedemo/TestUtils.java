package com.ksathe.javapracticedemo;

public class TestUtils {

    public static boolean doubleArraysEqual(double[] arr1, double[] arr2) {
        double epsilon = 1e-6;
        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (Math.abs(arr1[i] - arr2[i]) > epsilon) {
                return false;
            }
        }

        return true;
    }
}
