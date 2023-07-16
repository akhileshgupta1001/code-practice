package com.dsa.scaller.hasing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class SubArrayWith0sum {

//Problem Description
//Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.
//
//If the given array contains a sub-array with sum zero return 1, else return 0.
//
//
//
//Problem Constraints
//1 <= |A| <= 100000
//
//-10^9 <= A[i] <= 10^9
//
//
//
//Input Format
//The only argument given is the integer array A.
//
//
//
//Output Format
//Return whether the given array contains a subarray with a sum equal to 0.
//
//
//
//Example Input
//Input 1:
//
// A = [1, 2, 3, 4, 5]
//Input 2:
//
// A = [-1, 1]
//
//
//Example Output
//Output 1:
//
// 0
//Output 2:
//
// 1
//
//
//Example Explanation
//Explanation 1:
//
// No subarray has sum 0.
//Explanation 2:
//
// The array has sum 0.

    public int solve2(int[] A) {
        // Just write your code below to complete the function. Required input is available to you as the function arguments.
        // Do not print the result or any output. Just return the result via this function.

        for (int i = 0; i < A.length; i++) {
            // int sum = A[i];
            int sum = 0;
            for (int j = i; j < A.length; j++) {
                sum += A[j];
                if (sum == 0) return 1;
            }
        }
        return 0;
    }

    public int solve(int[] A) {
        // Just write your code below to complete the function. Required input is available to you as the function arguments.
        // Do not print the result or any output. Just return the result via this function.
        HashSet<Long> has = new HashSet<>();
        long sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum = sum + A[i];
            if (sum == 0) return 1;
            has.add(sum);
        }
        if (has.size() < A.length) {
            return 1;
        }
        return 0;
    }

    public int solve3(int[] A) {
        // Just write your code below to complete the function. Required input is available to you as the function arguments.
        // Do not print the result or any output. Just return the result via this function.
        HashSet<Long> set = new HashSet<Long>();
        long sum = 0;
        set.add(sum);
        for (int x : A) {
            sum += x;
            if (set.contains(sum)) return 1;
            else
                set.add(sum);

        }
        return 0;
    }


    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<>(Arrays.asList(1, 2, 3, 3, 3, 4, 5, 6));
        System.out.println(integers);
        integers.remove(integers.indexOf(3));
        System.out.println(integers);

    }

}
