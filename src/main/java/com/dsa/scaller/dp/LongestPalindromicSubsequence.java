package com.dsa.scaller.dp;

import java.util.Arrays;

public class LongestPalindromicSubsequence {
    // Method to compute the length of the longest common subsequence (LCS)
    public int lcs(String s1, String s2, int i, int j, int[][] dp) {
        // Base case: if either of the strings is empty, return 0
        if (i < 0 || j < 0) return 0;

        // If the value for the current state is already computed, return it
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        // Initialize answer variable
        int ans = 0;

        // If the characters at the current indices are the same
        if (s1.charAt(i) == s2.charAt(j)) {
            // Increment the answer by 1 and recursively compute LCS for (i-1, j-1)
            ans = 1 + lcs(s1, s2, i - 1, j - 1, dp);
        } else {
            // If the characters are different, choose the maximum LCS from either excluding s1[i] or s2[j]
            ans = Math.max(lcs(s1, s2, i - 1, j, dp), lcs(s1, s2, i, j - 1, dp));
        }

        // Store the computed value in the DP table for memoization
        dp[i][j] = ans;

        // Return the LCS length for the current indices
        return dp[i][j];
    }

    // Method to initiate LCS computation
    public int solve(String A) {
        // Reverse the input string to compare it with itself
        String s2 = new StringBuilder(A).reverse().toString();

        // Initialize the DP table with dimensions (A.length() + 1) x (A.length() + 1)
        int[][] dp = new int[A.length() + 1][A.length() + 1];

        // Initialize the DP table with -1 to indicate that no computation has been done yet
        Arrays.stream(dp).forEach(data -> Arrays.fill(data, -1));

        // Call the LCS method to compute the length of the LCS and return the result
        return lcs(A, s2, A.length() - 1, A.length() - 1, dp);
    }

    public static void main(String[] args) {
        // Create an instance of the Solution class
        LongestPalindromicSubsequence solution = new LongestPalindromicSubsequence();

        // Test input string
        String inputString = "abcdefg";

        // Call the solve method to find the length of the longest common subsequence
        int lcsLength = solution.solve(inputString);

        // Print the length of the longest common subsequence
        System.out.println("Length of the Longest Common Subsequence: " + lcsLength);
    }
}
