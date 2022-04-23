package com.dsa.geeksforgeek.arrays;

public class MaximumCircularSubArraySum {

    // Kadan Algorithm

    public static int maxSum(int[] arr) {
        int res = arr[0];
        int maxEnding = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxEnding = Math.max(maxEnding + arr[i], arr[i]);
            res = Math.max(maxEnding, res);
        }
        return res;
    }

    public static int maxCircularSubArraySum(int[] arr) {
        int maxSum = maxSum(arr);
        if (maxSum < 0)
            return maxSum;
        int currentSum = 0;
        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];
            arr[i] = -arr[i];
        }
        currentSum = currentSum + maxSum(arr);
        return Math.max(currentSum, maxSum);
    }

    public static void main(String[] args) {
        //{8,-4,3,-5,4}
        //12
        int[] arr = new int[]{8, -4, 3, -5, 4};
        System.out.println(maxCircularSubArraySum(arr));
    }
}
