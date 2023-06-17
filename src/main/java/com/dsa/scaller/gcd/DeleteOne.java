package com.dsa.scaller.gcd;

import java.util.Arrays;

public class DeleteOne {
    //Problem Description
    //
    //Given an integer array A of size N. You have to delete one element such that the GCD(Greatest common divisor) of the remaining array is maximum.
    //
    //Find the maximum value of GCD.
    //
    //
    //
    //Problem Constraints
    //
    //2 <= N <= 105
    //1 <= A[i] <= 109
    //
    //
    //
    //Input Format
    //
    //First argument is an integer array A.
    //
    //
    //
    //Output Format
    //
    //Return an integer denoting the maximum value of GCD.
    //
    //
    //
    //Example Input
    //
    //Input 1:
    //
    // A = [12, 15, 18]
    //Input 2:
    //
    // A = [5, 15, 30]
    //
    //
    //Example Output
    //
    //Output 1:
    //
    // 6
    //Output 2:
    //
    // 15
    //
    //
    //Example Explanation
    //
    //Explanation 1:
    //
    //
    // If you delete 12, gcd will be 3.
    // If you delete 15, gcd will be 6.
    // If you delete 18, gcd will 3.
    // Maximum vallue of gcd is 6.
    //Explanation 2:
    //
    // If you delete 5, gcd will be 15.
    // If you delete 15, gcd will be 5.
    // If you delete 30, gcd will be 5.

    public static int gcd(int A, int B) {
        if (A == 0) return B;
        return gcd(B % A, A);
    }

    public static int solve(int[] A) {
        int n = A.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = A[0];
        suffix[n - 1] = A[n - 1];
        for (int i = 1; i < n; i++) {
            prefix[i] = gcd(prefix[i - 1], A[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = gcd(suffix[i + 1], A[i]);
        }
        int ans = 1;
        for (int i = 0; i < n; i++) {
            int pre = 0;
            int suf = 0;
            if (i - 1 >= 0) {
                pre = prefix[i - 1];
            }
            if (i + 1 < n) {
                suf = suffix[i + 1];
            }
            int current = gcd(pre, suf);
            ans = Math.max(ans, current);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{12,15,18};
        System.out.println(solve(arr));

    }
}
