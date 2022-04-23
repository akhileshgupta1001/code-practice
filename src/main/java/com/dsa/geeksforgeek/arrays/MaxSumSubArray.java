package com.dsa.geeksforgeek.arrays;

public class MaxSumSubArray {

    public static int maxSumSubArray(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int current = 0;
            for (int j = i; j < arr.length; j++) {
                current = current + arr[j];
                res = Math.max(res, current);
            }
        }
        return res;
    }

    public static int maXSum(int[] arr) {
        int res = arr[0];
        int maxEnding = res;

        for (int i = 1; i < arr.length; i++) {
            maxEnding = Math.max(maxEnding + arr[i], arr[i]);
            res = Math.max(maxEnding, res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, -2, 3, -1, 2};
        //4
        //System.out.println(maxSumSubArray(arr));

        System.out.println(maXSum(arr));
    }
}
