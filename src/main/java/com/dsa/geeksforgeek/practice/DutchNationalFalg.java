package com.dsa.geeksforgeek.practice;


import java.lang.reflect.Array;
import java.util.Arrays;

public class DutchNationalFalg {
    //Sort an array of 0s, 1s and 2s | Dutch National Flag problem
    //Input: {0, 1, 2, 0, 1, 2}
    //Output: {0, 0, 1, 1, 2, 2}
    //
    //Input: {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1}
    //Output: {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}
    // O(n)
    public static int[] swap(int[] arr, int low, int high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
        return arr;
    }

    public static int[] DNF(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        int mid = low;
        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                swap(arr, mid, high);
                high--;
            }
        }
        Arrays.stream(arr).forEach(System.out::print);
        return arr;
    }

    public static void main(String[] args) {

        int arr[] = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        int arr_size = arr.length;
        DNF(arr);
    }
}
