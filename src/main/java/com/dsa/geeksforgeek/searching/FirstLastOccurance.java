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

    public static int firstOccurrence(int[] arr, int low,int high,int searchKey,int size){
        if(low>high) return -1;
        int mid = ( high+low)/2;
        if(arr[mid]>searchKey)
            return firstOccurrence(arr,low,mid-1,searchKey,size);
        else if(arr[mid]<searchKey)
            return firstOccurrence(arr,mid+1,high,searchKey,size);
        else{
            if(mid ==0 || arr[mid-1] != arr[mid]){
                return mid;
            }
            else{
                return firstOccurrence(arr,low,mid-1,searchKey,size);            }

        }

    }

    public static int lastOccurrence(int[] arr, int low,int high,int searchKey,int size){
        if(low>high) return -1;
        int mid = ( high+low)/2;
        if(arr[mid]>searchKey)
            return lastOccurrence(arr,low,mid-1,searchKey,size);
        else if(arr[mid]<searchKey)
            return lastOccurrence(arr,mid+1,high,searchKey,size);
        else{
            if(mid==size-1 || arr[mid] != arr[mid+1]){
                return mid;
            }
            else{
                return lastOccurrence(arr,mid+1,high,searchKey,size);            }

        }

    }

    public static void main(String[] args) {
        //int arr[] = new int[]{5,10,10,20,20};
        int[] arr= new int[]{10,20,20,20,20,40,40};
        int searchElement = 20;
        //System.out.println(findFirstOccurance(arr,searchElement));
        System.out.println(lastOccurrence(arr,0,arr.length-1,searchElement,arr.length
        -1));

    }
}
