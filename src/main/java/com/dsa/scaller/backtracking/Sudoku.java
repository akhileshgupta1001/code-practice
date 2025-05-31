package com.dsa.scaller.backtracking;

import java.util.ArrayList;
import java.util.HashSet;

public class Sudoku {

    public void solveSudoku(char[][] A) {
        int size = A.length;
        suduko(A, size, 0, 0);
    }

    private boolean suduko(char[][] A, int size, int row, int col) {
        if (row == size) {
            return true;
        }

        if (col == size) {
            return suduko(A, size, row + 1, 0);
        }

        if (A[row][col] != '.') {
            return suduko(A, size, row, col + 1);
        }

        for (char c = '1'; c <= Character.forDigit(size, 10); c++) {
            A[row][col] = c;
            if (isValid(A, size, row, col) && suduko(A, size, row, col + 1)) {
                return true;
            }
            A[row][col] = '.';
        }
        return false;
    }

    private boolean isValid(char[][] A, int size, int row, int col) {
        char
                num =
                A[row][col];

        for (int
             i =
             0; i < size; i++) {
            if (i != col && A[row][i] == num) {
                return false;
            }

            if (i != row && A[i][col] == num) {
                return false;
            }
        }

        int
                sqrt =
                (int) Math.sqrt(size);
        int
                subgridRowStart =
                row - row % sqrt;
        int
                subgridColStart =
                col - col % sqrt;
        for (int
             i =
             0; i < sqrt; i++) {
            for (int
                 j =
                 0; j < sqrt; j++) {
                if (A[subgridRowStart + i][subgridColStart + j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    private static char[][] convertToCharArray(ArrayList<ArrayList<Character>> list) {
        char[][] arr = new char[list.size()][list.get(0).size()];
        for (int i = 0; i < list.size(); i++) {
            ArrayList<Character> rowList = list.get(i);
            for (int j = 0; j < rowList.size(); j++) {
                arr[i][j] = rowList.get(j);
            }
        }
        return arr;
    }
    public static void main(String[] args) {
        Sudoku solver = new Sudoku();

        // Example Input
        ArrayList<ArrayList<Character>> board = new ArrayList<>();
        String[] input = {
                "53..7....",
                "6..195...",
                ".98....6.",
                "8...6...3",
                "4..8.3..1",
                "7...2...6",
                ".6....28.",
                "...419..5",
                "....8..79"
        };

        for (String row : input) {
            ArrayList<Character> rowList = new ArrayList<>();
            for (char c : row.toCharArray()) {
                rowList.add(c);
            }
            board.add(rowList);
        }

       // solver.solveSudoku(convertToCharArray(board));
        solver.solveSudoku2(convertToCharArray(board));

        // Print the solution
        for (ArrayList<Character> row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }

    }


    // Solution 2


    public void solveSudoku2(char[][] board) {
        // Initialize constraint-tracking sets for rows, columns, and 3x3 blocks
        HashSet<Integer>[] rowSets = new HashSet[9];
        HashSet<Integer>[] colSets = new HashSet[9];
        HashSet<Integer>[] blockSets = new HashSet[9];

        // Create a new HashSet for each row, column, and block
        for (int index = 0; index < 9; index++) {
            rowSets[index] = new HashSet<>();
            colSets[index] = new HashSet<>();
            blockSets[index] = new HashSet<>();
        }

        // Fill the sets with existing numbers on the board
        for (int rowIndex = 0; rowIndex < 9; rowIndex++) {
            for (int colIndex = 0; colIndex < 9; colIndex++) {
                if (board[rowIndex][colIndex] != '.') {
                    int value = board[rowIndex][colIndex] - '0';
                    int blockIndex = (rowIndex / 3) * 3 + (colIndex / 3);
                    rowSets[rowIndex].add(value);
                    colSets[colIndex].add(value);
                    blockSets[blockIndex].add(value);
                }
            }
        }

        // Start recursive backtracking
        solve(board, 0, 0, rowSets, colSets, blockSets);
    }

    private boolean solve(char[][] board,
                          int rowIndex,
                          int colIndex,
                          HashSet<Integer>[] rowSets,
                          HashSet<Integer>[] colSets,
                          HashSet<Integer>[] blockSets) {

        // Fix: If end of board is reached, Sudoku is solved
        if (rowIndex == 9) {
            return true;
        }

        // If end of column is reached, move to next row
        if (colIndex == 9) {
            return solve(board, rowIndex + 1, 0, rowSets, colSets, blockSets);
        }

        int blockIndex = (rowIndex / 3) * 3 + (colIndex / 3);

        // If cell is already filled, move to next column
        if (board[rowIndex][colIndex] != '.') {
            return solve(board, rowIndex, colIndex + 1, rowSets, colSets, blockSets);
        }

        // Try numbers 1 to 9
        for (int number = 1; number <= 9; number++) {
            if (rowSets[rowIndex].contains(number) ||
                    colSets[colIndex].contains(number) ||
                    blockSets[blockIndex].contains(number)) {
                continue;
            }

            // Tentatively place the number
            board[rowIndex][colIndex] = (char) (number + '0');
            rowSets[rowIndex].add(number);
            colSets[colIndex].add(number);
            blockSets[blockIndex].add(number);

            // Recurse
            if (solve(board, rowIndex, colIndex + 1, rowSets, colSets, blockSets)) {
                return true;
            }

            // Backtrack
            board[rowIndex][colIndex] = '.';
            rowSets[rowIndex].remove(number);
            colSets[colIndex].remove(number);
            blockSets[blockIndex].remove(number);
        }

        return false;
    }
}
