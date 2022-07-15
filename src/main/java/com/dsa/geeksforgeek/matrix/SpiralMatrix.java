package com.dsa.geeksforgeek.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static List<Integer> getSpiralMatrix(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        String[] directions = new String[]{"RIGHT", "DOWN", "LEFT", "UP"};
        int index = 0;

        int rowStart = 0;
        int rowEnd = matrix.length - 1;

        int colStart = 0;
        int colEnd = matrix[0].length - 1;

        while (rowStart <= rowEnd && colStart <= colEnd) {
            switch (directions[index]) {
                case "RIGHT":
                    for (int i = colStart; i <= colEnd; i++) {
                        result.add(matrix[rowStart][i]);
                    }
                    rowStart++;
                    break;
                case "DOWN":
                    for (int i = rowStart; i <= rowEnd; i++) {
                        result.add(matrix[i][colEnd]);
                    }
                    colEnd--;
                    break;
                case "LEFT":
                    for (int i = colEnd; i >= colStart; i--) {
                        result.add(matrix[rowEnd][i]);
                    }
                    rowEnd--;
                    break;
                case "UP":
                    for (int i = rowEnd; i >= rowStart; i--) {
                        result.add(matrix[i][colStart]);
                    }
                    colStart++;
                    break;
            }
            index = (index + 1 ) % 4;
        }
        return result;
    }

    public static void main(String[] args) {
        int a[][] = {{1, 2, 3},
                {4,5, 6},
                {7,8,9}};

        System.out.println(getSpiralMatrix(a));
    }
}
