package com.dsa.geeksforgeek.searching;

public class Count1s {

    public static int countOnes(int[] arr) {
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (arr[mid] == 0)
                return mid + 1;
            else {
                if (mid == 0 || arr[mid - 1] == 0)
                    return arr.length - mid;
                else
                    high = mid - 1;
            }

        }
        return 0;

    }
}
