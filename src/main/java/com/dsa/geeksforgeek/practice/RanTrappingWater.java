package com.dsa.geeksforgeek.practice;

public class RanTrappingWater {

    //Time Complexity: O(N). Only one traversal of the array is needed, So time Complexity is O(N).
    //Space Complexity: O(N). Two extra arrays are needed, each of size N.
    public static  int getTrappingWater(int[] arr){
        //        int arr[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int size = arr.length;
        int[] leftMax = new int[size];
        int[] rightMax = new int[size];

        leftMax[0]= arr[0];
        for(int i =1;i<arr.length;i++){
            leftMax[i]= Math.max(leftMax[i-1],arr[i] );
        }
        rightMax[size-1] = arr[size-1];
        for(int i= size-2;i>=0;i--){
            rightMax[i] = Math.max(rightMax[i+1],arr[i] );
        }
        int result = 0;
        for(int i=0;i<arr.length;i++){
            result  = result+ Math.min(leftMax[i],rightMax[i] )-arr[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(getTrappingWater(arr));
    }
}
