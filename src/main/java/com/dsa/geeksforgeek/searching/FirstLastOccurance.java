package com.dsa.geeksforgeek.searching;

public class FirstLastOccurance {

    public static int findFirstOccurance(int[] arr, int searchElement) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > searchElement)
                high = mid - 1;
            else if (arr[mid] < searchElement)
                low = mid + 1;
            else {
                if (mid == 0 || arr[mid - 1] != arr[mid])
                    return mid;
                else
                    high = mid - 1;
            }
        }
        return -1;
    }

    public static int findLastOccurance(int[] arr,int searchElement){
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > searchElement)
                high = mid - 1;
            else if (arr[mid] < searchElement)
                low = mid + 1;
            else {
                if (mid !=arr.length-1 || arr[mid] != arr[mid+1])
                    return mid;
                else
                    low = mid +1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{5,10,10,20,20};
        int searchElement = 10;
        //System.out.println(findFirstOccurance(arr,searchElement));
        System.out.println(findLastOccurance(arr,searchElement));

    }
}
