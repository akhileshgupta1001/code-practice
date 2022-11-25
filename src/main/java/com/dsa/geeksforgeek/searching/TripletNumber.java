package com.dsa.geeksforgeek.searching;

import java.util.Arrays;

//https://ide.geeksforgeeks.org/dZdvRjkmkr
public class TripletNumber {

    static boolean find3Numbers(int A[], int arr_size, int sum){
        Arrays.sort(A);
        for(int i=0;i<arr_size-2;i++){
            if(isPairExist(A,sum-A[i],i+1)){
              return true;
            }
        }
        return false;
    }

    private static boolean isPairExist(int[] arr, int target, int starting) {
        int low =starting;
        int high = arr.length-1;
        while (low<=high){
            if(arr[low]+arr[high]==target){
                return true;
            }else if(arr[low]+arr[high]<target){
                low++;
            }else {
                high--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int A[] = { 1, 4, 45, 6, 10, 8 };
        int sum = 22;
        int arr_size = A.length-1;
        System.out.println(find3Numbers(A,arr_size,sum));
    }
}
