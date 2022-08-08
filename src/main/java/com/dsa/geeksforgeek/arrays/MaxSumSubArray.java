package com.dsa.geeksforgeek.arrays;

public class MaxSumSubArray {

    public static int maxSumSubArray(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum = sum + arr[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    public static int maXSum(int[] arr) {
        int res = arr[0];
        int maxEnding = res;

        for (int i = 1; i < arr.length; i++) {
            maxEnding = Math.max(maxEnding + arr[i], arr[i]);
            res = Math.max(maxEnding, res);
           // res = Math.max(res+arr[i],arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, -2, 3, -1, 2};
        //4
        //System.out.println(maxSumSubArray(arr));
        int[] arr2 = new int[]{-1, -2, -3, -4};//-1
        int[] arr3 = new int[]{1, 2, 3, -2, 5};// 9
        int[] arr4 = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};//6
        System.out.println(maXSum(arr2));
    }
}
