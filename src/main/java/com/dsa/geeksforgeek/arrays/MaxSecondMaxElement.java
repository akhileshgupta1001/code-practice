package com.dsa.geeksforgeek.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxSecondMaxElement {


    public static ArrayList<Integer> largestAndSecondLargest(int sizeOfArray, int arr[]) {
        int max = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;
        for (int i = 0; i < sizeOfArray; i++) {
            max = Math.max(max, arr[i]);
        }
        for (int i = 0; i < sizeOfArray; i++) {
            if (arr[i] != max) {
                secondMax = Math.max(secondMax, arr[i]);
            }
        }
        if (secondMax == Integer.MIN_VALUE) secondMax = -1;
        ArrayList<Integer> ans = new ArrayList(Arrays.asList(max,secondMax));

        return ans ;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(largestAndSecondLargest(arr.length,arr));
    }
}
