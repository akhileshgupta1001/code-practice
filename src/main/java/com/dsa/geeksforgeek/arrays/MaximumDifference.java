package com.dsa.geeksforgeek.arrays;

public class MaximumDifference {
    //i/p : {2,3,10,6,4,8,1}
    //o/p 8

    //i/p : {7,9,5,6,3,2 }
    //o/p 2

    public static void maxDifference(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (max < (arr[j] - arr[i]))
                    max = (arr[j] - arr[i]);
            }
        }
        System.out.println(max);
    }

    public static void maxDifferenceOptimization(int[] arr) {
        int res = arr[1] - arr[0];
        int min = arr[0];

        for (int i = 1; i < arr.length; i++) {
            res = Math.max(res, arr[i] - min);
            min = Math.min(min, arr[i]);
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        //maxDifference(new int[]{7, 9, 5, 6, 3, 2});
        maxDifferenceOptimization(new int[]{7, 9, 5, 6, 3, 2});
    }
}
