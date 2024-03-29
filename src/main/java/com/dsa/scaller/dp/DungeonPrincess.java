package com.dsa.scaller.dp;

public class DungeonPrincess {
    //Problem Description
    //The demons had captured the princess and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.
    //
    //The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.
    //
    //Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).
    //
    //In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
    //
    //Given a 2D array of integers A of size M x N. Find and return the knight's minimum initial health so that he is able to rescue the princess.
    //
    //
    //
    //Problem Constraints
    //1 <= M, N <= 500
    //
    //-100 <= A[i] <= 100
    //
    //
    //
    //Input Format
    //First and only argument is a 2D integer array A denoting the grid of size M x N.
    //
    //
    //
    //Output Format
    //Return an integer denoting the knight's minimum initial health so that he is able to rescue the princess.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = [
    //       [-2, -3, 3],
    //       [-5, -10, 1],
    //       [10, 30, -5]
    //     ]
    //Input 2:
    //
    // A = [
    //       [1, -1, 0],
    //       [-1, 1, -1],
    //       [1, 0, -1]
    //     ]
    //
    //
    //Example Output
    //Output 1:
    //
    // 7
    //Output 2:
    //
    // 1
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // Initially knight is at A[0][0].
    // If he takes the path RIGHT -> RIGHT -> DOWN -> DOWN, the minimum health required will be 7.
    // At (0,0) he looses 2 health, so health becomes 5.
    // At (0,1) he looses 3 health, so health becomes 2.
    // At (0,2) he gains 3 health, so health becomes 5.
    // At (1,2) he gains 1 health, so health becomes 6.
    // At (2,2) he looses 5 health, so health becomes 1.
    // At any point, the health point doesn't drop to 0 or below. So he can rescue the princess with minimum health 7.
    //
    //Explanation 2:
    //
    // Take the path DOWN -> DOWN ->RIGHT -> RIGHT, the minimum health required will be 1.


    public int calculateMinimumHP(int[][] A) {
        int[][] ans = new int [A.length][A[0].length];

        int n = A.length;
        int m = A[0].length;
        int x=Integer.MIN_VALUE;

        for(int i=n-1 ;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if((i==n-1) && (j==m-1)){
                    ans[i][j] = Math.max(1-A[i][j],1);
                }else if(i==n-1){
                    x= ans[i][j+1];
                } else if(j==m-1){
                    x = ans[i+1][j];
                }else{
                    x = Math.min(ans[i][j+1],ans[i+1][j]);
                }
                if((i==n-1) && (j==m-1))
                    continue;
                else
                    ans[i][j] = Math.max(x-A[i][j],1);
            }
        }
        return ans[0][0];
    }

    public int calculateMinimumHP2(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int[][] memo = new int[n][m]; // Create a memoization array to store computed results

        return calculateMinimumHPRecursion(A, 0, 0, memo); // Start the recursion from the top-left corner (0, 0)
    }

    private int calculateMinimumHPRecursion(int[][] A, int i, int j, int[][] memo) {
        int n = A.length;
        int m = A[0].length;

        if (i == n - 1 && j == m - 1) {
            // If we are at the bottom-right corner, return the minimum HP needed to reach here
            // Ensure that the HP is at least 1 to stay alive
            return Math.max(1 - A[i][j], 1);
        }

        if (memo[i][j] != 0) {
            // If the result for this cell is already computed, return it from memo
            return memo[i][j];
        }

        int x;

        if (i == n - 1) {
            // If we are at the last row, we can only move right
            x = calculateMinimumHPRecursion(A, i, j + 1, memo);
        } else if (j == m - 1) {
            // If we are at the last column, we can only move down
            x = calculateMinimumHPRecursion(A, i + 1, j, memo);
        } else {
            // If not at the last row or column, consider both right and down movements
            int right = calculateMinimumHPRecursion(A, i, j + 1, memo);
            int down = calculateMinimumHPRecursion(A, i + 1, j, memo);
            x = Math.min(right, down); // Choose the minimum HP needed among right and down movements
        }

        memo[i][j] = Math.max(x - A[i][j], 1); // Store the result in memo and ensure HP is at least 1
        return memo[i][j];
    }


    public static void main(String[] args) {
        int[][] matrix = {
                {-100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100},
                {-100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100},
                {-100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100},
                {-100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100},
                {-100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100},
                {-100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100},
                {-100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100},
                {-100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100},
                {-100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100},
                {-100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100},
                {-100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100},
                {-100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100},
                {-100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100},
                {-100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100},
                {-100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100},
                {-100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100},
                {-100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100},
                {-100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100},
                {-100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100},
                {-100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100, -100}
        };

   DungeonPrincess dungeonPrincess = new DungeonPrincess();
   dungeonPrincess.calculateMinimumHP(matrix);
        }
}
