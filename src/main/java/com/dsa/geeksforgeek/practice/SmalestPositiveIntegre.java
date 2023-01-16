package com.dsa.geeksforgeek.practice;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SmalestPositiveIntegre {
//Find the smallest positive integer value that cannot be represented as sum of any subset of a given array
    //Given an array of positive numbers, find the smallest positive integer value that cannot be represented as the sum of elements of any subset of a given set.
    //The expected time complexity is O(nlogn).
    //
    //Examples:
    //
    //Input:  arr[] = {1, 10, 3, 11, 6, 15};
    //Output: 2
    //
    //Input:  arr[] = {1, 1, 1, 1};
    //Output: 5
    //
    //Input:  arr[] = {1, 1, 3, 4};
    //Output: 10
    //
    //Input:  arr[] = {1, 2, 5, 10, 20, 40};
    //Output: 4
    //
    //Input:  arr[] = {1, 2, 3, 4, 5, 6};
    //Output: 22

    public static int findSmallest(int[] arr){
        Arrays.sort(arr);
        int res= 1;
        for(int i =0;i<arr.length;i++){
            if(arr[i]>res){
                return res;
            }else {
                res = res+arr[i];
            }
        }
        return res;
    }
    public static void main(String[] args)
    {
        SmalestPositiveIntegre small = new SmalestPositiveIntegre();
        int arr1[] = {1, 3, 4, 5};
        int n1 = arr1.length;
        System.out.println(small.findSmallest(arr1));

        int arr2[] = {1, 2, 6, 10, 11, 15};
        int n2 = arr2.length;
        System.out.println(small.findSmallest(arr2));

        int arr3[] = {1, 1, 1, 1};
        int n3 = arr3.length;
        System.out.println(small.findSmallest(arr3));

        int arr4[] = {1, 1, 3, 4};
        int n4 = arr4.length;
        System.out.println(small.findSmallest(arr4));

    }
}
