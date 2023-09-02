package com.dsa.scaller.backtracking;

import java.util.ArrayList;

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
        char num = A[row][col];

        for (int i = 0; i < size; i++) {
            if (i != col && A[row][i] == num) {
                return false;
            }

            if (i != row && A[i][col] == num) {
                return false;
            }
        }

        int sqrt = (int) Math.sqrt(size);
        int subgridRowStart = row - row % sqrt;
        int subgridColStart = col - col % sqrt;
        for (int i = 0; i < sqrt; i++) {
            for (int j = 0; j < sqrt; j++) {
                if (A[subgridRowStart + i][subgridColStart + j] == num) {
                    return false;
                }
            }
        }

        return true;
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

        solver.solveSudoku(convertToCharArray(board));

        // Print the solution
        for (ArrayList<Character> row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
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
}
