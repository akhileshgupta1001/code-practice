package com.dsa.geeksforgeek.searching.important;

//Important
//https://www.geeksforgeeks.org/find-rotation-count-rotated-sorted-array/
public class NumberofTimesSortedArrayRotated {
    // 11 12 15 18 2 5 6 8
    public static int  getMinimumElement(int[] arr){
        int len = arr.length;
        int low =0;
        int high = arr.length-1;
        while (low<=high){
            int mid = low+ (high-low)/2;
            // if first element is mid or
            // last element is mid
            // then simply use modulo so it
            // never goes out of bound.
           int prev = (mid-1+len) % len;
           int next = (mid+1) % len;
            if (arr[mid] <= arr[prev]
                    && arr[mid] <= arr[next])
                return mid;
            else if(arr[low]<=arr[mid]){
                low = mid+1;
            }else if(arr[high]<= arr[mid]){
                high = mid-1;
            }
        }
       return 0;
    }

    public static void main(String[] args) {
        //int[] arr = { 15, 18, 2, 3, 6, 12 };
       int[] arr ={4,5,6,7,0,1,2};
        int n = arr.length;
        System.out.println(getMinimumElement(arr));
    }
}
