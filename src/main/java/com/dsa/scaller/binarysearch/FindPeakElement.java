package com.dsa.scaller.binarysearch;

public class FindPeakElement {
    //Problem Description
    //Given an array of integers A, find and return the peak element in it.
    //An array element is considered a peak if it is not smaller than its neighbors. For corner elements, we need to consider only one neighbor.
    //
    //NOTE:
    //
    //It is guaranteed that the array contains only a single peak element.
    //Users are expected to solve this in O(log(N)) time. The array may contain duplicate elements.
    //
    //
    //Problem Constraints
    //1 <= |A| <= 100000
    //
    //1 <= A[i] <= 109
    //
    //
    //
    //Input Format
    //The only argument given is the integer array A.
    //
    //
    //
    //Output Format
    //Return the peak element.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //A = [1, 2, 3, 4, 5]
    //Input 2:
    //
    //A = [5, 17, 100, 11]
    //
    //
    //Example Output
    //Output 1:
    //
    // 5
    //Output 2:
    //
    // 100
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // 5 is the peak.
    //Explanation 2:
    //
    // 100 is the peak.

    public static int solve(int[] A) {
        int low = 0;
        int n = A.length;
        int high = n - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((mid == 0 || A[mid] >= A[mid - 1]) && (mid == n - 1 || A[mid] > A[mid + 1])) {
                return A[mid];
            } else if (mid > 0 && A[mid] > A[mid - 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (n == 2) return Math.max(A[0], A[1]);
        return -1;
    }

    //A peak element is an element that is strictly greater than its neighbors.
    //
    //Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.
    //
    //You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.
    //
    //You must write an algorithm that runs in O(log n) time.
    //
    //
    //
    //Example 1:
    //
    //Input: nums = [1,2,3,1]
    //Output: 2
    //Explanation: 3 is a peak element and your function should return the index number 2.
    //Example 2:
    //
    //Input: nums = [1,2,1,3,5,6,4]
    //Output: 5
    //Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
    //
    //
    //Constraints:
    //
    //1 <= nums.length <= 1000
    //-231 <= nums[i] <= 231 - 1
    //nums[i] != nums[i + 1] for all valid i.

    public static int findPeakElement(int[] arr) {
        if(arr.length==1) return 0;
        int low =0;
        int high = arr.length-1;
        int n= arr.length;

        while(low<=high){
            int mid = (high+low)/2;
            if((mid==0 || arr[mid]>arr[mid-1])
                    &&(mid ==n-1  || arr[mid]>arr[mid+1])){
                return mid;
            }
            if(mid>0 || arr[mid-1]<arr[mid]){
                low = mid+1;
            }else{
                high= mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        findPeakElement (new int[]{1,2,3,1});
    }


}
