package com.dsa.scaller.dp;

//Problem Description
//Given a rod of length N units and an array A of size N denotes prices that contains prices of all pieces of size 1 to N.
//
//Find and return the maximum value that can be obtained by cutting up the rod and selling the pieces.
//
//
//
//Problem Constraints
//1 <= N <= 1000
//
//0 <= A[i] <= 106
//
//
//
//Input Format
//First and only argument is an integer array A of size N.
//
//
//
//Output Format
//Return an integer denoting the maximum value that can be obtained by cutting up the rod and selling the pieces.
//
//
//
//Example Input
//Input 1:
//
// A = [3, 4, 1, 6, 2]
//Input 2:
//
// A = [1, 5, 2, 5, 6]
//
//
//Example Output
//Output 1:
//
// 15
//Output 2:
//
// 11
//
//
//Example Explanation
//Explanation 1:
//
// Cut the rod of length 5 into 5 rods of length (1, 1, 1, 1, 1) and sell them for (3 + 3 + 3 + 3 + 3) = 15.
//Explanation 2:
//
// Cut the rod of length 5 into 3 rods of length (2, 2, 1) and sell them for (5 + 5 + 1) = 11.

public class CuttingRod {
    public int solve(int[] A) {
        int N = A.length; // Get the length of the input array A, representing prices for rod pieces.
        int[] lengthOfRod = new int[N]; // Create an array to represent the lengths of rod pieces.

        // Fill the lengthOfRod array with values from 1 to N to represent the lengths of the rod pieces.
        for (int i = 0; i < N; i++) {
            lengthOfRod[i] = i + 1;
        }

        int[][] dp = new int[N + 1][N + 1]; // Create a 2D array for dynamic programming.

        // Nested loops to calculate the maximum value for each combination of rod length and available lengths.
        for (int i = 0; i <= N; i++) {
            for (int length = 0; length <= N; length++) {
                if (i == 0 || length == 0) {
                    dp[i][length] = 0; // Initialize the base case values to 0.
                } else if (lengthOfRod[i - 1] > length) {
                    dp[i][length] = dp[i - 1][length]; // If the current rod piece is too long, skip it.
                } else {
                    // Calculate the maximum value by either including or excluding the current rod piece.
                    dp[i][length] = Math.max(A[i - 1] + dp[i][length - lengthOfRod[i - 1]], dp[i - 1][length]);
                }
            }
        }

        return dp[N][N]; // Return the maximum value that can be obtained by cutting the rod.
    }
}
