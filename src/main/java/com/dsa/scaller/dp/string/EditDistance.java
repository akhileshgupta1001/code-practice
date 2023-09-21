package com.dsa.scaller.dp.string;

import java.util.Arrays;

public class EditDistance {
    //Problem Description
    //Given two strings A and B, find the minimum number of steps required to convert A to B. (each operation is counted as 1 step.)
    //
    //You have the following 3 operations permitted on a word:
    //
    //Insert a character
    //Delete a character
    //Replace a character
    //
    //
    //Problem Constraints
    //1 <= length(A), length(B) <= 450
    //
    //
    //
    //Input Format
    //The first argument of input contains a string, A.
    //The second argument of input contains a string, B.
    //
    //
    //
    //Output Format
    //Return an integer, representing the minimum number of steps required.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = "abad"
    // B = "abac"
    //Input 2:
    //
    // A = "Anshuman"
    // B = "Antihuman
    //
    //
    //Example Output
    //Output 1:
    //
    // 1
    //Output 2:
    //
    // 2
    //
    //
    //Example Explanation
    //Exlanation 1:
    //
    // A = "abad" and B = "abac"
    // After applying operation: Replace d with c. We get A = B.
    //
    //Explanation 2:
    //
    // A = "Anshuman" and B = "Antihuman"
    // After applying operations: Replace s with t and insert i before h. We get A = B.

    public static int minDistance(String word1, String word2, int m, int n, int[][] memo) {
        // Check if the result is already computed
        if (memo[m][n] != -1) {
            return memo[m][n];
        }

        if (m == 0) {
            memo[m][n] = n;
        } else if (n == 0) {
            memo[m][n] = m;
        } else if (word1.charAt(m - 1) == word2.charAt(n - 1)) {
            memo[m][n] = minDistance(word1, word2, m - 1, n - 1, memo);
        } else {
            int insert = 1 + minDistance(word1, word2, m, n - 1, memo);
            int delete = 1 + minDistance(word1, word2, m - 1, n, memo);
            int replace = 1 + minDistance(word1, word2, m - 1, n - 1, memo);
            memo[m][n] = Math.min(Math.min(insert, delete), replace);
        }

        return memo[m][n];
    }

    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        // Initialize memoization array
        int[][] memo = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(memo[i], -1);
        }

        return minDistance(word1, word2, m, n, memo);
    }

    public static int minDistanceUsingDp(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1],
                            dp[i - 1][j - 1]));
            }
        }
        return dp[m][n];
    }
}
