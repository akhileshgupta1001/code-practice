package com.dsa.geeksforgeek.searching.important;

//Important
//https://www.geeksforgeeks.org/find-rotation-count-rotated-sorted-array/
public class NumberofTimesSortedArrayRotated {
    // 11 12 15 18 2 5 6 8
    public static int getMinimumElement(int[] arr) {
        int len = arr.length;
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // if first element is mid or
            // last element is mid
            // then simply use modulo so it
            // never goes out of bound.
           int prev = (mid-1+len) % len;
           int next = (mid+1) % len;
            if (arr[mid] <= arr[prev]
                    && arr[mid] <= arr[next])
                return mid;
            else if (arr[mid] >= arr[low]) {
                low = mid + 1;
            } else if (arr[mid] <= arr[high]) {
                high = mid - 1;
            }
        }
        return 0;
    }



    public static int getSearchRotedArray(int[] arr, int target){
        int low =0;
        int high = arr.length-1;
        //int[] nums = {4, 5, 6, 7, 0, 1, 2};
        //int target = 0;
        while (low<=high){
            int mid = low + (high-low)/2;
            if(arr[mid]== target){
                return mid;
            }

            // left sorted
            // left> right
            if(arr[low]<= arr[mid]){
                if (target >= arr[low] && target < arr[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }else{
                if(target>arr[mid] && target<= arr[high]){
                    low = mid+1;
                }else {
                    high = mid-1;
                }
            }
        }
        return -1;
    }

    public static int getSortedRotedArray(int[] arr, int key, int low  , int high){
        if(low>high) return  -1;

        int mid = low + (high-low)/2;
        if(arr[mid]==key) return mid;

        if(arr[low]<=arr[mid]){
            if(key>= arr[low] && key <= arr[mid]){
                return getSortedRotedArray(arr,key,low,mid-1);
            }
            return getSortedRotedArray(arr,key,mid+1,high);
        }
        if(key>=arr[mid] && key<= arr[high]){
            return getSortedRotedArray(arr,key,mid+1,high);
        }
        return getSortedRotedArray(arr,key,low,mid-1);
    }

    // Best Way

    public static int binarySearch(int[] arr, int low, int high, int target){
        while(low<= high){
            int mid = low + (high-low)/2;
            if(arr[mid]==target) return mid;
            else if(target> arr[mid]){
                low = mid +1;
            }else {
                high = mid-1;
            }
        }
        return -1;
    }

    public static int pivotElement(int[] nums){
        int low = 0;
        int high = nums.length-1;
        while(low< high){
            int mid = low + (high-low)/2;
            if(nums[mid]>nums[high]){
                low = mid+1;
            }else {
                high = mid;
            }
        }
        return low;
    }
    public static int search(int[] nums, int target) {
        int n = nums.length-1;
        if(n==0 && nums[0]==target) return n;
        else if(n==0 && nums[0] != target) return -1;

        int pivot = pivotElement(nums);

        if(nums[pivot]== target){
            return pivot;

        }else if(target>= nums[pivot] && target<= nums[n]){
            return binarySearch(nums,pivot,n,target);
        }else{
            return binarySearch(nums,0,pivot-1,target);
        }

    }

    public static void main(String[] args) {
       int[] arr ={4,5,6,7,0,1,2};
      //  int[] arr = {3,1};
        int n = arr.length-1;
       // System.out.println(getPeakElement(arr,0,n,n));
        //System.out.println(getSortedRotedArray(arr,12,0,arr.length-1));
        System.out.println(search(arr,5));
    }
}
