package com.dsa.geeksforgeek.arrays;

public class LeftRotateArray {

    //O(n^2)
    //inp {1,2,3,4,5} d=2
    //op={3,4,5,1,2}
    public static int[] leftRotateElement(int[] arr, int d) {

        for (int i = 0; i < d; i++) {
            arr = leftRotateElementByOne(arr);
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        return arr;
    }

    private static int[] leftRotateElementByOne(int[] arr) {
        int temp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }
        arr[arr.length - 1] = temp;
        return arr;
    }

    //2nd
    public static void leftRotateElementUsingExtarSpace(int[] arr, int d) {
        int temp[] = new int[d];
        for (int i = 0; i < d; i++) {
            temp[i] = arr[i];
        }
        for (int x = d; x < arr.length; x++) {
            arr[x - d] = arr[x];
        }
        for (int x = 0; x < temp.length; x++) {
            arr[arr.length - d + x] = temp[x];
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    //3rd
    public static int[] leftRotate(int[] arr, int d) {
        arr = reverse(arr, 0, d - 1);
        arr = reverse(arr, d, arr.length - 1);
        arr = reverse(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        return arr;
    }

    private static int[] reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;

        }
        return arr;
    }

    public static void main(String[] args) {
        // leftRotateElement(new int[]{1, 2, 3, 4, 5}, 2);
        //leftRotateElementUsingExtarSpace(new int[]{1, 2, 3, 4, 5}, 2);
        leftRotate(new int[]{1, 2, 3, 4, 5}, 2);

    }
}
