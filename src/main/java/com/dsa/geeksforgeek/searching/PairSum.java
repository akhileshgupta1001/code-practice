package com.dsa.geeksforgeek.searching;

import java.util.Arrays;

//https://www.geeksforgeeks.org/given-an-array-a-and-a-number-x-check-for-pair-in-a-with-sum-as-x/
//Check if a pair exists with given sum in given array
public class PairSum {

    //Input: arr[] = {0, -1, 2, -3, 1}, x= -2
    //Output: Yes
    //Explanation:  If we calculate the sum of the output,1 + (-3) = -2
    //
    //Input: arr[] = {1, -2, 1, 0, 5}, x = 0
    //Output: No

    public static boolean isPairExist(int[] arr, int sum){
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]+arr[j]==sum)
                    return true;
            }
        }
        return false;
    }

    //buy using two pointer
    //Time Complexity: O(NlogN), Time complexity for sorting the array
    //Auxiliary Space: O(1)
    public static boolean isPairExistByTwoPointer(int[] arr, int sum){
        Arrays.sort(arr);
        int low =0;
        int high= arr.length-1;
        while (low<=high){
            if(arr[low]+arr[high]==sum){
                return true;
            }else if(arr[low]+arr[high]<sum){
                low++;
            }else {
                high--;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPairExistByTwoPointer(new int[]{0, -1, 2, -3, 1},-2));
    }
}
