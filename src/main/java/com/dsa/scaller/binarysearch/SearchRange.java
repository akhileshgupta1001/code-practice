package com.dsa.scaller.binarysearch;

import java.util.Arrays;

public class SearchRange {
    //Problem Description
    //Given a sorted array of integers A (0-indexed) of size N, find the left most and the right most index of a given integer B in the array A.
    //
    //Return an array of size 2, such that
    //          First element = Left most index of B in A
    //          Second element = Right most index of B in A.
    //If B is not found in A, return [-1, -1].
    //
    //Note : Your algorithm's runtime complexity must be in the order of O(log n).

    //Problem Constraints
    //1 <= N <= 106
    //1 <= A[i], B <= 109
    //
    //
    //Input Format
    //The first argument given is the integer array A.
    //The second argument given is the integer B.
    //
    //
    //Output Format
    //Return the left most and right most index (0-based) of B in A as a 2-element array. If B is not found in A, return [-1, -1].
    //
    //
    //Example Input
    //Input 1:
    //
    // A = [5, 7, 7, 8, 8, 10]
    // B = 8
    //Input 2:
    //
    // A = [5, 17, 100, 111]
    // B = 3
    //
    //
    //Example Output
    //Output 1:
    //
    // [3, 4]
    //Output 2:
    //
    // [-1, -1]
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // The first occurrence of 8 in A is at index 3.
    // The last occurrence of 8 in A is at index 4.
    // ans = [3, 4]
    //Explanation 2:
    //
    // There is no occurrence of 3 in the array.

    public int firstOccurance(int[] A, int B){
        int low =0;
        int high = A.length-1;
        int n  = A.length;
        if(n==1 && A[0]==B) return 0;

        while(low<=high){
            int mid = low + (high-low)/2;

            if(A[mid]==B && (mid==0|| A[mid]>A[mid-1])){
                return mid;
            } else if(A[mid]<B){
                low = mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }

    public int lastOccurance(int[] A, int B){
        int low =0;
        int high = A.length-1;
        int n  = A.length;
        if(n==1 && A[0]==B) return 0;
        //if(n==2 && A[0]==B) return 0;

        while(low<=high){
            int mid = low + (high-low)/2;

            if (A[mid] == B) {
                if (mid == A.length - 1 || A[mid] < A[mid + 1]) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            } else if(A[mid]<B){
                low = mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }
    public int[] searchRange(final int[] A, int B) {
        //  Arrays.stream(A).forEach(System.out::println);
        int firstOccurance = firstOccurance(A,B);
        int second = lastOccurance(A,B);

        return new int[]{firstOccurance,second};
    }

    public static void main(String[] args) {
        SearchRange searchRange = new SearchRange();
        searchRange.searchRange(new int[]{1,2,2},2);
    }
}
