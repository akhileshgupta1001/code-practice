package com.dsa.geeksforgeek.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class ReverseArrayInGroups {
    public static ArrayList<Integer>  revrse(ArrayList<Integer> arr, int start, int end) {

        while (start <= end) {
            int temp = arr.get(start);
            arr.set(start, arr.get(end));
            arr.set(end, temp);
            start++;
            end--;
        }

        return arr;
    }

    //Function to reverse every sub-array group of size k.
    public static ArrayList<Integer>  reverseInGroups(ArrayList<Integer> arr, int n, int k) {
        for (int i = 0; i <= n; i = i + k) {
           // Important
            arr = revrse(arr, i, Math.min(i+k-1,n-1));
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(reverseInGroups(new ArrayList<Integer>(Arrays.asList(1,2,3,4,5)),5,3));
    }
}
