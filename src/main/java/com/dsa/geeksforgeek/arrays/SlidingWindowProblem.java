package com.dsa.geeksforgeek.arrays;

public class SlidingWindowProblem {

    //Input  : arr[] = {100, 200, 300, 400}, k = 2
    //Output : 700
    public static int getMaxSum(int[] arr, int window){

        int currentSum= 0;
        int maxSum= currentSum;
        for(int i=0;i<window;i++){
            currentSum = currentSum+arr[i];
        }
        maxSum = currentSum;
        for (int i=window;i<arr.length;i++){
            currentSum = currentSum-arr[i-window]+arr[i];
            maxSum = Math.max(currentSum,maxSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(getMaxSum(new  int[]{100, 200, 300, 400},2));
    }
}
