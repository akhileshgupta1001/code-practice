package com.dsa.geeksforgeek.dyanmic.programing.lcs;

public class LongestRepeatingSubsequence {

    public static String findLongestRepeatingSubsequence(String str) {
        int n = str.length();

        // Create a 2D array to store the length of the longest repeating subsequence
        int[][] dp = new int[n + 1][n + 1];

        // Build the DP matrix
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (str.charAt(i - 1) == str.charAt(j - 1) && i != j) {
                    // Characters match and the indices are different (not diagonal)
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    // Characters don't match, take the maximum of the previous cells
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Reconstruct the longest repeating subsequence
        StringBuilder lrs = new StringBuilder();
        int i = n, j = n;
        while (i > 0 && j > 0) {
            if (dp[i][j] == dp[i - 1][j - 1] + 1) {
                // Current characters match, append to the result
                lrs.append(str.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i][j] == dp[i - 1][j]) {
                // Move to the cell with a maximum value in the same column
                i--;
            } else {
                // Move to the cell with a maximum value in the same row
                j--;
            }
        }

        // Reverse the result to get the correct order
        return lrs.reverse().toString();
    }

    public static void main(String[] args) {
        String str = "AABEBCDD";
        String longestRepeatingSubsequence = findLongestRepeatingSubsequence(str);
        System.out.println("Longest Repeating Subsequence: " + longestRepeatingSubsequence);
    }
}

