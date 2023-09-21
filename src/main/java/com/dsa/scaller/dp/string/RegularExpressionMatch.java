package com.dsa.scaller.dp.string;

//Problem Description
//Implement wildcard pattern matching with support for ' ? ' and ' * ' for strings A and B.
//
//' ? ' : Matches any single character.
//' * ' : Matches any sequence of characters (including the empty sequence).
//The matching should cover the entire input string (not partial).
//
//
//
//Problem Constraints
//1 <= length(A), length(B) <= 104
//
//
//
//Input Format
//The first argument of input contains a string A.
//The second argument of input contains a string B.
//
//
//
//Output Format
//Return 1 if the patterns match else return 0.
//
//
//
//Example Input
//Input 1:
//
// A = "aaa"
// B = "a*"
//Input 2:
//
// A = "acz"
// B = "a?a"
//
//
//Example Output
//Output 1:
//
// 1
//Output 2:
//
// 0
//
//
//Example Explanation
//Explanation 1:
//
// Since '*' matches any sequence of characters. Last two 'a' in string A will be match by '*'.
// So, the pattern matches we return 1.
//Explanation 2:
//
// '?' matches any single character. First two character in string A will be match.
// But the last character i.e 'z' != 'a'. Return 0.


public class RegularExpressionMatch {

    // The main function that checks if string A matches the pattern B.
    public int isMatch(final String A, final String B, int n, int m, boolean[][] dp) {
        // Loop through the characters of both strings A and B, along with a dynamic programming array dp.

        // Outer loop iterates over the characters of string A.
        for (int i = 0; i <= n; i++) {
            // Inner loop iterates over the characters of string B.
            for (int j = 0; j <= m; j++) {
                // Base case: When both strings are empty, they match.
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                }
                // If string A is empty, and we encounter '*', check the previous value in dp.
                else if (i == 0) {
                    dp[i][j] = (B.charAt(j - 1) == '*') && dp[i][j - 1];
                }
                // If string B is empty, there is no match unless string A is also empty.
                else if (j == 0) {
                    dp[i][j] = false;
                }
                // General case: Both strings are non-empty.
                else {
                    // If the current characters match or B has a '?', check the previous diagonal value in dp.
                    if (A.charAt(i - 1) == B.charAt(j - 1) || B.charAt(j - 1) == '?') {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                    // If B has '*', it can either represent an empty string or one or more characters in A.
                    else if (B.charAt(j - 1) == '*') {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                    }
                    // If characters don't match and B is not '*', there is no match.
                    else {
                        dp[i][j] = false;
                    }
                }
            }
        }
        // Return 1 if there is a match, 0 otherwise.
        return dp[n][m] ? 1 : 0;
    }

    // Wrapper function to initialize dp array and call the main isMatch function.
    public int isMatch(final String A, final String B) {
        int n = A.length();
        int m = B.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        return isMatch(A, B, n, m, dp);
    }
}