package com.dsa.geeksforgeek.arrays.practice;

import java.util.Arrays;

public class WaveArray {
    public static int[] reverse(int[] arr, int start, int end){
        while(start<end){
            int temp =arr[start];
            arr[start]= arr[end];
            arr[end]= temp;
            start++;
            end--;
        }
        return arr;
    }
    public static int[] convertToWave(int n, int[] a) {
        int k =2;
        for(int i=0;i<=n;i=i+k){
            a = reverse(a,i,Math.min(i+k-1,n-1));
        }
        return a;
    }

    public static void main(String[] args) {
        int[] arr= {1,2,3,4,5};
       arr = convertToWave(arr.length,arr);
        Arrays.stream(arr).forEach(System.out::println);
    }
}
