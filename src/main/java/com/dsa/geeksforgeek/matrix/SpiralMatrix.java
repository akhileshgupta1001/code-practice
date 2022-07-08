package com.dsa.geeksforgeek.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static List<Integer> getSpiralMatrix(int[][] arr) {
        int direction = 0;
        // 0 (Left->right)
        // 1 (top -> bottom)
        // 2 (right -> left )
        // 3 (Bottom -> top)


        int top = 0;
        int bottom = arr.length - 1;
        int left = 0;
        int right = arr.length - 1;
        int index = 0;

        List<Integer> list = new ArrayList<>();

        while (top <= bottom && left <= right) {

            if (direction == 0)
                for (index = left; index <= right; index++) {
                    list.add(arr[top][index]);
                }
            top++;
            direction++;
            if (direction == 1)
                for (index = top; index <= bottom; index++) {
                    list.add(arr[index][right]);
                }
            direction++;
            right--;
            if (direction == 2)
                for (index = right; index >= left; index--) {
                    list.add(arr[bottom][index]);
                }
            bottom--;
            direction++;
            if (direction == 3)
                for (index = bottom; index >= top; index--) {
                    list.add(arr[index][left]);
                }
            left++;
            direction = (direction + 1) % 4;
        }
        return list;
    }

    public static void main(String[] args) {
        int a[][] = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        System.out.println(getSpiralMatrix(a));
    }
}
