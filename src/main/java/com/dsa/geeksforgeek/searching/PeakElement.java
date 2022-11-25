package com.dsa.geeksforgeek.searching;

//https://practice.geeksforgeeks.org/problems/peak-element/1
//https://leetcode.com/problems/peak-index-in-a-mountain-array/
public class PeakElement {
    // NIEVE SOLUTION

    //Input: nums = [1,2,3,1]
    //Output: 2
    //Explanation: 3 is a peak element and your function should return the index number 2.
    public static  int getPickElement(int[] arr){
        if(arr.length==1) return arr[0];
        if(arr[0]>= arr[1]) return arr[0];
        if (arr[arr.length-1]>=arr[arr.length-2]) return arr[arr.length-1];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>=arr[i-1] && arr[i]>= arr[i+1]){
                return arr[i];
            }
        }
        return -1;
    }


    // O(logn)
    public static int getPeak(int[] arr,int n){
        int low=0;
        int high =arr.length-1;
        while (low<=high){
            int mid = (low+high)/2;
            if((mid ==0 || arr[mid-1]<=arr[mid])
            && (mid==arr.length-1 || arr[mid+1]<=arr[mid])){
                return mid;
            }
            // if arr[mid]<= arr[mid-1] then always go to the left side else right side
            if(mid>0 && arr[mid]<=arr[mid-1]){
                high= mid-1;
            }else {
                low= mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {5, 20, 40, 30, 20, 50, 60}, n = 7;

        System.out.println(getPeak(arr, n));
    }
}
