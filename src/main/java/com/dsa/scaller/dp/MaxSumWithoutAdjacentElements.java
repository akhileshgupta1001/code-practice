package com.dsa.scaller.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Q4. Max Sum Without Adjacent Elements
//Solved
//feature icon
//Using hints is now penalty free
//Use Hint
//Problem Description
//Given a 2 x N grid of integers, A, your task is to choose numbers from the grid such that sum of these numbers is maximized.
//However, you cannot choose two numbers that are adjacent horizontally, vertically, or diagonally.
//
//Return the maximum possible sum.
//
//Note: You are allowed to choose more than 2 numbers from the grid.
//
//
//Problem Constraints
//1 <= N <= 20000
//1 <= A[i] <= 2000
//
//
//Input Format
//The first and the only argument of input contains a 2d matrix, A.
//
//
//Output Format
//Return an integer, representing the maximum possible sum.
//
//
//Example Input
//Input 1:
//
// A = [
//        [1]
//        [2]
//     ]
//Input 2:
//
// A = [
//        [1, 2, 3, 4]
//        [2, 3, 4, 5]
//     ]
//
//
//Example Output
//Output 1:
//
// 2
//Output 2:
//
// 8
//
//
//Example Explanation
//Explanation 1:
//
// We will choose 2 (From 2nd row 1st column).
//Explanation 2:
//
// We will choose 3 (From 2nd row 2nd column) and 5 (From 2nd row 4th column).



public class MaxSumWithoutAdjacentElements {
    ArrayList<Integer> maxData(ArrayList<ArrayList<Integer>> A) {
        ArrayList<Integer> subAns = new ArrayList<>();
        for (int i = 0; i < 1; i++) {
            for (int j = i; j < A.get(0).size(); j++) {
                subAns.add(Math.max(A.get(i).get(j), A.get(i + 1).get(j)));
            }
        }
        System.out.println(subAns);
        return subAns;
    }

    public int adjacent(ArrayList<ArrayList<Integer>> A) {
        ArrayList<Integer> subAns = maxData(A);
        int ans = 0;
        for (int i = 0; i < subAns.size(); i++) {
            int sum = 0;
            ArrayList<Integer> data = new ArrayList<>();
            for (int j = i; j < subAns.size(); j = j + 2) {
                if (j < subAns.size()) {
                    data.add(subAns.get(j));
                    sum = sum + subAns.get(j);
                }
            }
            System.out.println("List" + data + "  ,Sum =" + sum);
            ans = Math.max(ans, sum);
        }
        return ans;
    }

    public int adjacentSum(ArrayList<Integer> maxValue, int currentIndex, int[] dp) {
        if (currentIndex == 0) return maxValue.get(0);
        if (currentIndex == 1) return Math.max(maxValue.get(0), maxValue.get(1));

        if (dp[currentIndex] != 0) {
            return dp[currentIndex];
        }
        dp[currentIndex] = Math.max(adjacentSum(maxValue, currentIndex - 1, dp), maxValue.get(currentIndex) + adjacentSum(maxValue, currentIndex - 2, dp));

        return dp[currentIndex];
    }

    // Iterative
    public int maxsum(ArrayList<Integer> a) {
        int n = a.size();
        int[] dp = new int[n];
        if (n == 1) {
            return a.get(0);
        }
        dp[0] = a.get(0);
        dp[1] = Math.max(a.get(0), a.get(1));
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(a.get(i) + dp[i - 2], dp[i - 1]); // main logic
        }
        return dp[n - 1];
    }

    //With Carry forword
    public int maxsum3(ArrayList<Integer> a) {
        int n = a.size();
        if (n == 1) {
            return a.get(0);
        }
        int x = a.get(0);
        int y = Math.max(a.get(0), a.get(1));
        int z = y; //[[2,68],[13,4]] for if 2 el only max of 2 is the answer
        for (int i = 2; i < n; i++) {
            z = Math.max(a.get(i) + x, y); // main logic
            x = y;
            y = z;
        }
        return z;
    }

    public static void main(String[] args) {
        List<Integer> a1 = Arrays.asList(16, 5, 54, 55, 36, 82, 61, 77, 66, 61);
        List<Integer> b1 = Arrays.asList(1, 30, 36, 70, 9, 37, 1, 11, 68, 14);
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();
        input.add(new ArrayList<>(a1));
        input.add(new ArrayList<>(b1));
        MaxSumWithoutAdjacentElements maxSumWithoutAdjacentElements = new MaxSumWithoutAdjacentElements();
        //maxSumWithoutAdjacentElements.adjacent(input);

        ArrayList<Integer> subAns = maxSumWithoutAdjacentElements.maxData(input);

        System.out.println(maxSumWithoutAdjacentElements.adjacentSum(subAns, subAns.size() - 1, new int[subAns.size()]));
    }

}
