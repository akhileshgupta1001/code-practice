package com.dsa.geeksforgeek.dyanmic.programing;

import java.util.Arrays;

public class MaximumSumIncreasingSubSequence {
    //https://www.geeksforgeeks.org/maximum-sum-increasing-subsequence-dp-14/
    // For example, if input is {1, 101, 2, 3, 100, 4, 5}, then output should be 106 (1 + 2 + 3 + 100), if the input array is {3, 4, 5, 10}, then output should be 22 (3 + 4 + 5 + 10) and if the input array is {10, 5, 4, 3}, then output should be 10

    public static int getMaximumSumIncreasingSubSequence(int[] arr){
        int n = arr.length;
        int[] maximumSumIncreasingSubSequence = new int[n];
        for(int i=1;i<arr.length;i++){
            maximumSumIncreasingSubSequence[i]=arr[i];
            for(int j=0;j<i;j++){
                if(arr[i]>arr[j])
                maximumSumIncreasingSubSequence[i]= Math.max(maximumSumIncreasingSubSequence[i],maximumSumIncreasingSubSequence[i]+arr[j]);
            }
        }
        return Arrays.stream(maximumSumIncreasingSubSequence).max().getAsInt();
    }

    public static void main(String[] args) {
        System.out.println(getMaximumSumIncreasingSubSequence(new int[]{1, 101, 2, 3, 100, 4, 5}));
    }
}
