package com.dsa.scaller.backtracking;

public class UniquePathsIII {
    //Problem Description
    //Given a matrix of integers A of size N x M . There are 4 types of squares in it:
    //
    //1. 1 represents the starting square.  There is exactly one starting square.
    //2. 2 represents the ending square.  There is exactly one ending square.
    //3. 0 represents empty squares we can walk over.
    //4. -1 represents obstacles that we cannot walk over.
    //Find and return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
    //
    //Note: Rows are numbered from top to bottom and columns are numbered from left to right.
    //
    //
    //
    //Problem Constraints
    //2 <= N * M <= 20
    //-1 <= A[i] <= 2
    //
    //
    //
    //Input Format
    //The first argument given is the integer matrix A.
    //
    //
    //
    //Output Format
    //Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //A = [   [1, 0, 0, 0]
    //        [0, 0, 0, 0]
    //        [0, 0, 2, -1]   ]
    //Input 2:
    //
    //A = [   [0, 1]
    //        [2, 0]    ]
    //
    //
    //Example Output
    //Output 1:
    //
    //2
    //Output 2:
    //
    //0
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    //We have the following two paths:
    //1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
    //2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
    //Explanation 1:
    //
    //There are no such paths.

    public int uniquePathsIII(int[][] A) {
        int N = A.length;
        int M = A[0].length;
        int totalEmptySquares = 0;
        int[] start = new int[2];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] == 0) {
                    totalEmptySquares++;
                } else if (A[i][j] == 1) {
                    start = new int[]{i, j};
                }
            }
        }
        A[start[0]][start[1]] = 0;
        return isPossibleMove(A, start[0], start[1], totalEmptySquares, -1);
    }

    int isPossibleMove(int[][] A, int startIndex, int endIndex, int target, int current) {
        //row < 0: This checks if the row index is negative. If it is, then the cell is outside the valid rows of the grid.
        //
        //row >= N: This checks if the row index is greater than or equal to the total number of rows N. If it is, then the cell is outside the valid rows of the grid.
        //
        //col < 0: This checks if the column index is negative. If it is, then the cell is outside the valid columns of the grid.
        //
        //col >= M: This checks if the column index is greater than or equal to the total number of columns M. If it is, then the cell is outside the valid columns of the grid.
        //
        //A[row][col] == -1: This checks if the value in the cell at (row, col) is -1, which indicates an obstacle.
        if (startIndex < 0 || startIndex > A.length - 1 || endIndex < 0 || endIndex > A[0].length - 1 || A[startIndex][endIndex] == -1) {
            return 0;
        }

        if (A[startIndex][endIndex] == 2 && current == target) {
            return 1;
        }

        int validPaths = 0;
        if (A[startIndex][endIndex] == 0) {
            A[startIndex][endIndex] = 1; // Mark as visited
            int up = isPossibleMove(A, startIndex - 1, endIndex, target, current + 1);
            int down = isPossibleMove(A, startIndex + 1, endIndex, target, current + 1);
            int left = isPossibleMove(A, startIndex, endIndex - 1, target, current + 1);
            int right = isPossibleMove(A, startIndex, endIndex + 1, target, current + 1);
            A[startIndex][endIndex] = 0; // Reset the square
            validPaths += up + down + left + right;
        }

        return validPaths;
    }


    public static void main(String[] args) {
        UniquePathsIII solution = new UniquePathsIII();

        int[][] A1 = {
                {1, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 2, -1}
        };
        System.out.println(solution.uniquePathsIII(A1));  // Output: 2

        int[][] A2 = {
                {0, 1},
                {2, 0}
        };
        // System.out.println(solution.uniquePathsIII(A2));  // Output: 0
    }
}


