package com.dsa.geeksforgeek.searching;

public class SearchElementInInfinteArray {

    public static int findPosition(int[] arr,int key){

        if(arr[0]==key) return 0;
        int i=1;
        while (arr[i]<key){
            i =i*2;
            if(arr[i]==key) return i;
        }
        return binarySearch(arr,key,i/2+1,i-1);
    }

    private static int binarySearch(int[] arr, int key, int low, int high) {

        while (low<=high){
            int mid = (low+high)/2;
            if(arr[mid]==key) return mid;
            else if (arr[mid]>key) {
                high =mid-1;
            }else {
                low = mid+1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{3, 5, 7, 9, 10, 90,
                100, 130, 140, 160, 170};
        int ans = findPosition(arr,10);
        System.out.println(ans);
    }
}
