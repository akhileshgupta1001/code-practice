package com.dsa.geeksforgeek.arrays;

import java.util.Arrays;

public class MinimumPlatformRequired {
    //https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    //https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
    static int findPlatform(int arr[], int dep[], int n)
    {
        // add your code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i=0,j=0;
        int result = 0;
        int count =0;

        while(i<n){
            if(arr[i]<=dep[j]){
                count++;
                result = Math.max(count,result);
                i++;
            }else{
                j++;
                count--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int arr[] = { 100, 300, 500 };
        int dep[] = { 900, 400, 600 };

        int arr1[] = { 1,5,7,1 };
        int dep2[] = { 7,8,8,8};

        int n = 4;
        System.out.println(findPlatform(arr1, dep2, n));
    }
}
