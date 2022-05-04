package com.dsa.geeksforgeek.searching;

public class BinarySearch {

    public static int binarySearch(int[] arr, int searchElement) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == searchElement)
                return mid;
            if (arr[mid] > searchElement)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }

    public static int recursiveBinarySearch(int arr[], int low, int high, int searchElement) {
        if (low > high) return -1;
        int mid = (low + high) / 2;
        if (arr[mid] == searchElement)
            return mid;
        if (arr[mid] > searchElement)
            return recursiveBinarySearch(arr, low, mid - 1, searchElement);
        else
            return recursiveBinarySearch(arr, mid + 1, high, searchElement);

    }

}
