package com.dsa.geeksforgeek.dyanmic.programing.lcs;

public class PrintSCS {

    public static String printSCS(String first, String second, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];

        // Calculate the LCS matrix using dynamic programming
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0; // Base case: if either string is empty, LCS length is 0
                else if (first.charAt(i - 1) == second.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1]; // Characters match, increment LCS length
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // Characters don't match
            }
        }

        // Calculate the length of SCS
        int scsLength = m + n - dp[m][n];

        // Create a character array to store the SCS string
        char[] scs = new char[scsLength];

        int i = m;
        int j = n;
        int k = scsLength - 1; // Index for the SCS array
        while (i > 0 && j > 0) {
            if (first.charAt(i - 1) == second.charAt(j - 1)) {
                // If the characters match, it's part of the SCS
                scs[k] = first.charAt(i - 1);
                i--;
                j--;
                k--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                // Move in the direction of the larger value in the dp matrix
                scs[k] = first.charAt(i - 1);
                i--;
                k--;
            } else {
                scs[k] = second.charAt(j - 1);
                j--;
                k--;
            }
        }

        // Add the remaining characters from the first and second strings
        while (i > 0) {
            scs[k] = first.charAt(i - 1);
            i--;
            k--;
        }

        while (j > 0) {
            scs[k] = second.charAt(j - 1);
            j--;
            k--;
        }

        // Convert the character array to a string, which is the SCS
        return String.valueOf(scs);
    }

    public static void main(String[] args) {
        String X = "ACBEF";
        String Y = "ABCDAF";
        int m = X.length();
        int n = Y.length();
        String scs = printSCS(X, Y, m, n);
        System.out.println("Shortest Common Supersequence: " + scs);
    }
}
