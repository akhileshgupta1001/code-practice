package com.dsa.scaller.dp;

import java.util.Arrays;

//https://www.scaler.com/academy/mentee-dashboard/class/81993/assignment/problems/18/?navref=cl_pb_nv_tb

//Problem Description
//Given a string A, partition A such that every substring of the partition is a palindrome.
//
//Return the minimum cuts needed for a palindrome partitioning of A.
//
//
//
//Problem Constraints
//1 <= length(A) <= 501
//
//
//
//Input Format
//The first and the only argument contains the string A.
//
//
//
//Output Format
//Return an integer, representing the minimum cuts needed.
//
//
//
//Example Input
//Input 1:
//
// A = "aba"
//Input 2:
//
// A = "aab"
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
// "aba" is already a palindrome, so no cuts are needed.
//Explanation 2:
//
// Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.

public class PalindromePartitioningMinimumCuts {
    // Helper function to calculate if substrings of A are palindromic
    public boolean[][] isPalindrom(String A) {
        int n = A.length();
        boolean[][] isPalindrom = new boolean[n + 1][n + 1];

        // Loop to fill the isPalindrom matrix
        for (int l = 1; l <= n; l++) {
            for (int i = 0; i < n; i++) {
                int j = l + i - 1;
                if (j >= n) break;

                if (l == 1) {
                    isPalindrom[i][j] = true; // Single character is always a palindrome
                } else if (l == 2) {
                    isPalindrom[i][j] = (A.charAt(i) == A.charAt(j)); // Two characters palindrome check
                } else {
                    isPalindrom[i][j] = (A.charAt(i) == A.charAt(j) && isPalindrom[i + 1][j - 1]);
                    // For longer substrings, check if the current characters match and the inner substring is also a palindrome.
                }
            }
        }
        return isPalindrom;
    }

    // Main function to find the minimum number of cuts
    public int minCut(String A) {
        int n = A.length();
        int[] cuts = new int[n];
        Arrays.fill(cuts, Integer.MAX_VALUE);
        boolean[][] isPalindrom = isPalindrom(A);

        // Loop through the string to find the minimum cuts
        for (int i = 0; i < n; i++) {
            if (isPalindrom[0][i]) {
                cuts[i] = 0; // No cut needed if the entire string is a palindrome
            } else {
                for (int j = 0; j < i; j++) {
                    if (isPalindrom[j + 1][i]) {
                        cuts[i] = Math.min(cuts[i], 1 + cuts[j]);
                        // If there's a palindrome from j+1 to i, consider making a cut at j and update the cut count.
                    }
                }
            }
        }
        return cuts[n - 1]; // Return the minimum cuts for the entire string.
    }

    public int minCut2(String A) {
        int n = A.length();
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return minPartition(A, 0, n - 1, dp);
    }

    boolean isPalindrome(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    int minPartition(String A, int start, int end, int[][] dp) {
        if (start >= end || isPalindrome(A, start, end)) {
            return 0;
        }

        if (dp[start][end] != -1) return dp[start][end];

        int result = Integer.MAX_VALUE;

        for (int k = start; k < end; k++) {
            int cut = minPartition(A, start, k, dp) + 1 + minPartition(A, k + 1, end, dp);
            result = Math.min(cut, result);
        }

        dp[start][end] = result; // Update dp table outside the loop
        return dp[start][end];
    }
}
