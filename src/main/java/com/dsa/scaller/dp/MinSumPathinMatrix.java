package com.dsa.scaller.dp;

import java.util.Arrays;

public class MinSumPathinMatrix {
    //Problem Description
    //Given a M x N grid A of integers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
    //
    //Return the minimum sum of the path.
    //
    //NOTE: You can only move either down or right at any point in time.
    //
    //
    //
    //Problem Constraints
    //1 <= M, N <= 2000
    //
    //-1000 <= A[i][j] <= 1000
    //
    //
    //
    //Input Format
    //First and only argument is a 2-D grid A.
    //
    //
    //
    //Output Format
    //Return an integer denoting the minimum sum of the path.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = [
    //       [1, 3, 2]
    //       [4, 3, 1]
    //       [5, 6, 1]
    //     ]
    //Input 2:
    //
    // A = [
    //       [1, -3, 2]
    //       [2, 5, 10]
    //       [5, -5, 1]
    //     ]
    //
    //
    //Example Output
    //Output 1:
    //
    // 8
    //Output 2:
    //
    // -1
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // The path will be: 1 -> 3 -> 2 -> 1 -> 1.
    //Input 2:
    //
    // The path will be: 1 -> -3 -> 5 -> -5 -> 1.


    private int minPathSumRecursive(int[][] grid, int row, int col, int[][] memo) {
        // Base case: If we are at the top-left cell, return its value
        if (row == 0 && col == 0) {
            return grid[0][0];
        }

        // If the result for this cell is already computed, return it
        if (memo[row][col] != -1) {
            return memo[row][col];
        }

        int minPathSum;

        // Compute the minimum path sum recursively by considering two options:
        // 1. Moving from the cell above
        // 2. Moving from the cell on the left
        if (row == 0) {
            // If we are in the top row, we can only move left
            minPathSum = grid[row][col] + minPathSumRecursive(grid, row, col - 1, memo);
        } else if (col == 0) {
            // If we are in the leftmost column, we can only move up
            minPathSum = grid[row][col] + minPathSumRecursive(grid, row - 1, col, memo);
        } else {
            // Choose the minimum of the two options
            int fromAbove = minPathSumRecursive(grid, row - 1, col, memo);
            int fromLeft = minPathSumRecursive(grid, row, col - 1, memo);
            minPathSum = grid[row][col] + Math.min(fromAbove, fromLeft);
        }

        // Store the computed result in the memo table
        memo[row][col] = minPathSum;

        return minPathSum;
    }
    public int minPathSum2(int[][] A) {
        // Get the number of rows in the grid
        int n = A.length;
        // Get the number of columns in the grid
        int m = A[0].length;
        // Create a 2D array to store the minimum path sums
        int[][] dp = new int[n][m];

        // Loop through each row of the grid
        for (int i = 0; i < n; i++) {
            // Loop through each column of the grid
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    // If we are at the top-left corner, set dp[i][j] to the value of A[i][j]
                    dp[i][j] = A[i][j];
                } else if (i == 0) {
                    // If we are in the first row (but not the first column), update dp[i][j]
                    // by adding the value of A[i][j] to the path sum from the left (dp[i][j-1])
                    dp[i][j] = dp[i][j - 1] + A[i][j];
                } else if (j == 0) {
                    // If we are in the first column (but not the first row), update dp[i][j]
                    // by adding the value of A[i][j] to the path sum from above (dp[i-1][j])
                    dp[i][j] = dp[i - 1][j] + A[i][j];
                } else {
                    // If we are in any other cell, calculate the minimum path sum to reach
                    // this cell by choosing the minimum of the path sum from above (dp[i-1][j])
                    // and the path sum from the left (dp[i][j-1]), and add the value of A[i][j] to it.
                    int fromAbove = dp[i - 1][j];
                    int fromLeft = dp[i][j - 1];
                    dp[i][j] = A[i][j] + Math.min(fromAbove, fromLeft);
                }
            }
        }

        // The value in dp[n-1][m-1] contains the minimum path sum
        return dp[n - 1][m - 1];
    }

    public int minPathSum(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int[][] dp = new int[n][m];

        // Initialize the memo table with -1 to indicate uncomputed values
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return minPathSumRecursive(A,n-1,m-1,dp);
    }


    public static void main(String[] args) {
        MinSumPathinMatrix minSumPathinMatrix = new MinSumPathinMatrix();
        int[][] array = {{20, 29, 84, 4, 32, 60, 86, 8, 7, 37},
                {77, 69, 85, 83, 81, 78, 22, 45, 43, 63},
                {60, 21, 0, 94, 59, 88, 9, 54, 30, 80},
                {40, 78, 52, 58, 26, 84, 47, 0, 24, 60},
                {40, 17, 69, 5, 38, 5, 75, 59, 35, 26},
                {64, 41, 85, 22, 44, 25, 3, 63, 33, 13},
                {2, 21, 39, 51, 75, 70, 76, 57, 56, 22},
                {31, 45, 47, 100, 65, 10, 94, 96, 81, 14}};
        minSumPathinMatrix.minPathSum(array);
    }
}
