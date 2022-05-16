package com.dsa.geeksforgeek.searching;

public class CountOcuranceInSortedArray {

    public static int getMaxOccurance(int[] arr, int searchElement) {
        int firstOccurance = FirstLastOccurance.findFirstOccurance(arr, searchElement);
        if (firstOccurance == -1)
            return 0;
        else
            return (FirstLastOccurance.findLastOccurance(arr, searchElement)
                    - firstOccurance + 1);
    }

    public static void main(String[] args) {
        int[] arr= new int[]{10,20,20,20,40,40};
        System.out.println(getMaxOccurance(arr,20));
    }

}
