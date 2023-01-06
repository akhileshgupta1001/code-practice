package com.dsa.geeksforgeek.dyanmic.programing.knapsack;

import java.util.Arrays;

public class EqualPartitionSubset {

    //Input: arr[] = {1, 5, 11, 5}
    //Output: true
    //The array can be partitioned as {1, 5, 5} and {11}
    //
    //Input: arr[] = {1, 5, 3}
    //Output: false
    //The array cannot be partitioned into equal sum sets.


    public static boolean equalPartitionSubset(int[] arr){
        int size = arr.length;
        int sum = Arrays.stream(arr).sum();
        if(sum % 2 != 0) return false;
        return SubsetSumProblem.isSubsetSumProblem(arr,size,sum/2);
    }

    public static void main(String[] args) {
        System.out.println(equalPartitionSubset(new int[]{1, 5, 3}));
    }
}
