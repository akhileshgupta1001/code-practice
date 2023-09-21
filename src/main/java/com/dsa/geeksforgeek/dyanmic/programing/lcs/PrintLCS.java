package com.dsa.geeksforgeek.dyanmic.programing.lcs;

public class PrintLCS {

    public static void printLCS(String first, String second, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (first.charAt(i - 1) == second.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        // Following code is used to print LCS
        int index = dp[m][n];
        int temp = index;

        // Create a character array to store the lcs string
        char[] lcs = new char[index];
      //  lcs[index]
        //        = '\u0000'; // Set the terminating character

        // Start from the right-most-bottom-most corner and
        // one by one store characters in lcs[]
        int i = m;
        int j = n;
        while (i > 0 && j > 0) {
            // If current character in X[] and Y are same,
            // then current character is part of LCS
            if (first.charAt(i - 1) == second.charAt(j - 1)) {
                // Put current character in result
                lcs[index - 1] = first.charAt(i - 1);

                // reduce values of i, j and index
                i--;
                j--;
                index--;
            }

            // If not same, then find the larger of two and
            // go in the direction of larger value
            else if (dp[i - 1][j] > dp[i][j - 1])
                i--;
            else
                j--;
        }

        // Print the lcs
        System.out.print("LCS of " + first + " and " + second
                + " is "+ String.valueOf(lcs));

    }

    // driver program
    public static void main(String[] args) {
        String X = "ACBEF";
        String Y = "ABCDAF";
        int m = X.length();
        int n = Y.length();
        printLCS(X, Y, m, n);
    }


}
