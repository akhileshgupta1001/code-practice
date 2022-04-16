package com.dsa.geeksforgeek.arrays;

public class MoveAllZeroToEnd {
    public static int[] moveAllZero(int[] arr) {

        //{8, 0,5, 0, 10}
        // o/p {8,5,10}
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == 0) {

                for (int j = i; j < arr.length; j++) {

                    if (arr[j] != 0) {
                        arr = swap(arr, i, j);
                        break;
                    }
                }
            }
        }
        return arr;
    }

    //O(n)
    public static int[] moveZero(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {

            if (arr[i] != 0) {
                arr = swap(arr, i, count);
                count++;
            }
        }
        return arr;
    }

    private static int[] swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }


    public static void main(String[] args) {
        for (int i : moveAllZero(new int[]{8, 0, 5, 0, 10})) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i : moveZero(new int[]{8, 0, 5, 0, 10})) {
            System.out.print(i + " ");
        }
    }
}
