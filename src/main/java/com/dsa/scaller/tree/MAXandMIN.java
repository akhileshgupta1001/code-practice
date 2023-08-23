package com.dsa.scaller.tree;

import java.util.ArrayList;
import java.util.Arrays;

public class MAXandMIN {
    //Problem Description
    //Given an array of integers A.
    //
    //The value of an array is computed as the difference between the maximum element in the array and the minimum element in the array A.
    //
    //Calculate and return the sum of values of all possible subarrays of A modulo 109+7.
    //
    //
    //
    //Problem Constraints
    //1 <= |A| <= 100000
    //
    //1 <= A[i] <= 1000000
    //
    //
    //
    //Input Format
    //The first and only argument given is the integer array A.
    //
    //
    //
    //Output Format
    //Return the sum of values of all possible subarrays of A modulo 109+7.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = [1]
    //Input 2:
    //
    // A = [4, 7, 3, 8]
    //
    //
    //Example Output
    //Output 1:
    //
    // 0
    //Output 2:
    //
    // 26
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    //Only 1 subarray exists. Its value is 0.
    //Explanation 2:
    //
    //value ( [4] ) = 4 - 4 = 0
    //value ( [7] ) = 7 - 7 = 0
    //value ( [3] ) = 3 - 3 = 0
    //value ( [8] ) = 8 - 8 = 0
    //value ( [4, 7] ) = 7 - 4 = 3
    //value ( [7, 3] ) = 7 - 3 = 4
    //value ( [3, 8] ) = 8 - 3 = 5
    //value ( [4, 7, 3] ) = 7 - 3 = 4
    //value ( [7, 3, 8] ) = 8 - 3 = 5
    //value ( [4, 7, 3, 8] ) = 8 - 3 = 5
    //sum of values % 10^9+7 = 26

    // n3

    public static int solve(ArrayList<Integer> A) {
        if (A.isEmpty() || A.size() == 1) return 0;
        long ans = 0;
        int mod = (int) (1e9 + 7);
        for (int i = 0; i < A.size(); i++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            // System.out.println("I value : "+i);
            for (int j = i; j < A.size(); j++) {
                for (int k = i; k <= j; k++) {
                    //System.out.print(A.get(j)+ ", ");
                    min = Math.min(min, A.get(k));
                    max = Math.max(max, A.get(k));
                }
                ans = ((ans % mod) + (max - min) % mod) % mod;
            }
        }
        return (int) ans;
    }

    public static int solve2(ArrayList<Integer> A) {
        if (A.isEmpty() || A.size() == 1) return 0;
        long ans = 0;
        int mod = (int) (1e9 + 7);
        for (int i = 0; i < A.size(); i++) {
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int j = i; j < A.size(); j++) {
                min = Math.min(min, A.get(j));
                max = Math.max(max, A.get(j));
                ans = ((ans % mod) + (max - min) % mod) % mod;

            }
        }
        return (int) ans;
    }




    public static void main(String[] args) {
        solve(new ArrayList<>(Arrays.asList(992387, 932142, 971117, 934674, 988917, 967890, 948508, 970347)));
    }
}
