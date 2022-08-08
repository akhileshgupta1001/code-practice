package com.dsa.geeksforgeek.searching;

public class SearchElementSortedRotedArray {
   // 10,20,40,60,5,8
    //5
    public static int searchElement(int[] arr, int key){

        int low =0;int high =arr.length;
        while (low<=high){
            int mid = (low+high)/2;
            if(arr[mid]==key) return mid;

            // Left half sorted
            if(arr[mid]>arr[low]){
              if(key>=arr[low] && key< arr[mid]){
                  high=mid-1;
              }else {
                  low=mid+1;
              }
            }
            // Right half sorted
            else{
             if(key>arr[mid] && key<arr[high]){
                 low =mid+1;
             }else {
                 high = mid-1;
             }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(searchElement(new int[]{10,20,40,60,5,8},5));
    }
}
