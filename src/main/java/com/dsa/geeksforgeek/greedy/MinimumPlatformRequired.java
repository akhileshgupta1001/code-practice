package com.dsa.geeksforgeek.greedy;


import java.lang.reflect.Array;
import java.util.Arrays;

//https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
public class MinimumPlatformRequired {
    public static void main(String[] args)
    {
        int arr[] = { 900, 940, 950, 1100, 1500, 1800 };
        int dep[] = { 910, 1200, 1120, 1130, 1900, 2000 };
        int n = arr.length;
        System.out.println(
                "Minimum Number of Platforms Required = "
                        + findPlatform(arr, dep, n));
    }

    private static int findPlatform(int[] arr, int[] dep, int n) {

        Arrays.sort(arr);
        Arrays.sort(dep);

        int arrival =0,departure=0;
        int count = 0;
        int maxCount = 0;

        while (arrival<n){

            if(arr[arrival]<=dep[departure]){
                count++;
                maxCount= Math.max(maxCount,count);
                arrival++;
            }else if(arr[arrival]>dep[departure]){
                count--;
                departure++;
            }
        }
   return maxCount;
    }
}
