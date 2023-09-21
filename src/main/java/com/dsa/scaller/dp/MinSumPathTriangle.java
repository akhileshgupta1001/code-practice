package com.dsa.scaller.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinSumPathTriangle {

    //Problem Description
    //Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
    //
    //Adjacent numbers for jth column of ith row is jth and (j+1)th column of (i + 1)th row
    //
    //
    //
    //Problem Constraints
    //|A| <= 1000
    //
    //A[i] <= 1000
    //
    //
    //
    //Input Format
    //First and only argument is the vector of vector A defining the given triangle
    //
    //
    //
    //Output Format
    //Return the minimum sum
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //
    //A = [
    //         [2],
    //        [3, 4],
    //       [6, 5, 7],
    //      [4, 1, 8, 3]
    //    ]
    //Input 2:
    //
    // A = [ [1] ]
    //
    //
    //Example Output
    //Output 1:
    //
    // 11
    //Output 2:
    //
    // 1
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
    //Explanation 2:
    //
    // Only 2 can be collected.



    public int minimumTotal(ArrayList<ArrayList<Integer>> A) {
        int n = A.size();
        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            int colSize = A.get(i).size();
            for (int j = 0; j < colSize; j++) {
                if (i == n - 1) {
                    // If we're in the last row, initialize dp with the values from A
                    dp[i][j] = A.get(i).get(j);
                } else {
                    int below = dp[i + 1][j];
                    int diagonalBelow = dp[i + 1][j + 1];
                    System.out.println("Below : "+below+" , diagonal Below "+diagonalBelow+ " , current : "+A.get(i).get(j) );

                    dp[i][j] = A.get(i).get(j) + Math.min(below, diagonalBelow);
                }
            }
        }

        return dp[0][0];
    }




    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(2);
        List<Integer> list2 = Arrays.asList(3, 4);
        List<Integer> list3 = Arrays.asList(6, 5, 7);
        List<Integer> list4 = Arrays.asList(4, 1, 8, 3);
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        al.add(new ArrayList<>(list1));
        al.add(new ArrayList<>(list2));
        al.add(new ArrayList<>(list3));
        al.add(new ArrayList<>(list4));
        MinSumPathTriangle minSumPathTriangle = new MinSumPathTriangle();
        minSumPathTriangle.minimumTotal(al);

    }
}
