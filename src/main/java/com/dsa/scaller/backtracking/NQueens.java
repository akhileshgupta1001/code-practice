package com.dsa.scaller.backtracking;

import java.util.ArrayList;

import java.util.ArrayList;

public class NQueens {
    //Problem Description
    //The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
    //
    //
    //
    //Given an integer A, return all distinct solutions to the n-queens puzzle.
    //
    //Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
    //The final list should be generated in such a way that the indices of the queens in each list should be in reverse lexicographical order.
    //
    //
    //Problem Constraints
    //1 <= A <= 10
    //
    //
    //
    //Input Format
    //First argument is an integer n denoting the size of chessboard
    //
    //
    //
    //Output Format
    //Return an array consisting of all distinct solutions in which each element is a 2d char array representing a unique solution.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //A = 4
    //Input 2:
    //
    //A = 1
    //
    //
    //Example Output
    //Output 1:
    //
    //[
    // [".Q..",  // Solution 1
    //  "...Q",
    //  "Q...",
    //  "..Q."],
    //
    // ["..Q.",  // Solution 2
    //  "Q...",
    //  "...Q",
    //  ".Q.."]
    //]
    //Output 1:
    //
    //[
    // [Q]
    //]
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    //There exist only two distinct solutions to the 4-queens puzzle:
    //Explanation 1:
    //
    //There exist only one distinct solutions to the 1-queens puzzle:

    public ArrayList<ArrayList<String>> solveNQueens(int A) {
        ArrayList<ArrayList<String>> ans = new ArrayList<>();

        int[] columns = new int[A]; // columns[i] represents the column for queen in row i
        // Start solving the N-Queens problem
        nQueen(0, columns, ans);
        return ans;
    }

    // Recursive function to find N-Queens solutions
    private void nQueen(int row, int[] columns, ArrayList<ArrayList<String>> ans) {
        // Base case: All queens are placed, a solution is found
        if (row == columns.length) {
            ans.add(constructSolution(columns));
            return;
        }

        // Try placing the queen in each column of the current row
        for (int col = 0; col < columns.length; col++) {
            if (isValid(columns, row, col)) {
                columns[row] = col; // Place queen in current row and column
                nQueen(row + 1, columns, ans); // Recur for the next row
                columns[row] = -1; // Backtrack: Reset column position
            }
        }
    }

    // Check if it's valid to place a queen in the given row and column
    private boolean isValid(int[] columns, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (columns[i] == col
                    || Math.abs(i - row) == Math.abs(columns[i] - col)
                    || Math.abs(i + columns[i]) == Math.abs(row + col)) {
                return false; // Same column or diagonal attack
            }
        }
        return true;
    }

    // Construct a solution based on the column positions
    private ArrayList<String> constructSolution(int[] columns) {
        ArrayList<String> solution = new ArrayList<>();
        for (int col : columns) {
            StringBuilder rowString = new StringBuilder();
            for (int j = 0; j < columns.length; j++) {
                if (j == col) {
                    rowString.append('Q');
                } else {
                    rowString.append('.');
                }
            }
            solution.add(rowString.toString());
        }
        return solution;
    }

    public static void main(String[] args) {
        NQueens solver = new NQueens();
        int A = 4;
        ArrayList<ArrayList<String>> solutions = solver.solveNQueens(A);

        // Print the solutions
        for (ArrayList<String> solution : solutions) {
            for (String row : solution) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
