package com.dsa.scaller.dp.string;

import java.util.Arrays;

//https://www.scaler.com/academy/mentee-dashboard/class/82005/assignment/problems/4438/?navref=cl_pb_nv_tb
public class LongestCommonSubsequence {
    //Problem Description
    //Given two strings A and B. Find the longest common subsequence ( A sequence which does not need to be contiguous), which is common in both the strings.
    //
    //You need to return the length of such longest common subsequence.
    //
    //
    //
    //Problem Constraints
    //1 <= Length of A, B <= 1005
    //
    //
    //
    //Input Format
    //First argument is a string A.
    //Second argument is a string B.
    //
    //
    //
    //Output Format
    //Return an integer denoting the length of the longest common subsequence.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = "abbcdgf"
    // B = "bbadcgf"
    //Input 2:
    //
    // A = "aaaaaa"
    // B = "ababab"
    //
    //
    //Example Output
    //Output 1:
    //
    // 5
    //Output 2:
    //
    // 3
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // The longest common subsequence is "bbcgf", which has a length of 5.
    //Explanation 2:
    //
    // The longest common subsequence is "aaa", which has a length of 3.
    //
    //
    //
    //Expected Output
    //Provide sample input and click run to see the correct output for the provided input. Use this to improve your problem understanding and test edge cases


    // using recursion
    //Time complexity of the above naive recursive approach is O(2^n) in worst case and worst case happens when all characters of X and Y mismatch i.e., length of LCS is 0.
    public static int getLCS(String s1, String s2, int m, int n) {
        if (m == 0 || n == 0) return 0;

        if (s1.charAt(m - 1) == s2.charAt(n - 1))
            return 1 + getLCS(s1, s2, m - 1, n - 1);
        else
            return Math.max(getLCS(s1, s2, m - 1, n), getLCS(s1, s2, m, n - 1));
    }

    //using dp
    //Time Complexity : O(m*n) ignoring recursion stack space
    //Auxiliary Space: O(m*n)
    public static int getLCS(String s1, String s2, int m, int n, int[][] arr) {

        if (arr[m][n] != -1) {
            return arr[m][n];
        }
        if (m == 0 || n == 0) return 0;

        if (s1.charAt(m - 1) == s2.charAt(n - 1))
            arr[m][n] = 1 + getLCS(s1, s2, m - 1, n - 1, arr);
        else
            arr[m][n] = Math.max(getLCS(s1, s2, m - 1, n, arr), getLCS(s1, s2, m, n - 1, arr));

        return arr[m][n];
    }

    //Time Complexity of the above implementation is O(mn) which is much better than the worst-case time complexity of Naive Recursive implementation
    public static int getLCS(char[] X, char[] Y, int m, int n) {
        int L[][] = new int[m + 1][n + 1];

    /* Following steps build L[m+1][n+1] in bottom up fashion. Note
        that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (X[i - 1] == Y[j - 1])
                    L[i][j] = L[i - 1][j - 1] + 1;
                else
                    L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
            }
        }
        return L[m][n];
    }

    public static void main(String[] args) {
        String s1 = "ABCDE";
        String s2 = "AXE";
        int m = s1.length();
        int n = s2.length();
        int[][] arr = new int[m + 1][n + 1];
        Arrays.stream(arr).forEach(a -> Arrays.fill(a, -1));
        System.out.println(getLCS(s1, s2, m, n, arr));
        // System.out.println(getLCS("ABCDE","ABCDE",4,4));
    }
}
