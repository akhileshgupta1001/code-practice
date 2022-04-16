package com.dsa.geeksforgeek.arrays;

import java.util.Arrays;

public class ReverseArray {

    public static int[] reverse(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start<end){
            arr = swap(arr,start,end);
            start++;
            end--;
        }
    return arr;
    }

    private static int[] swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        return arr;
    }

    public static void main(String[] args) {
        Arrays.stream(reverse(new int[]{30,7,6,5,10})).forEach(data-> System.out.print(data+" "));
    }
}
