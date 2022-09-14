package com.dsa.geeksforgeek.arrays;

import java.util.Arrays;

public class MaximumSumSubArray {

    public static int getMaximumSumSubArray(int[] arr){
        int result =arr[0];
        int maxEnding = result;
        for(int i =1;i<arr.length;i++){
           maxEnding = Math.max(maxEnding*arr[i],arr[i]);
           result = Math.max(maxEnding,result);
        }
        System.out.println("Result : "+ result);
        return result;
    }

    public static void main(String[] args) {
        getMaximumSumSubArray(new int[]{2,3,-2,4});
    }
}
