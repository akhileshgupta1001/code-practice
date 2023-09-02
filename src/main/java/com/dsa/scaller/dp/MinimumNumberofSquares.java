package com.dsa.scaller.dp;

import java.util.Arrays;

//Problem Description
//Given an integer A. Return minimum count of numbers, sum of whose squares is equal to A.
//
//
//
//Problem Constraints
//1 <= A <= 105
//
//
//
//Input Format
//First and only argument is an integer A.
//
//
//
//Output Format
//Return an integer denoting the minimum count.
//
//
//
//Example Input
//Input 1:
//
// A = 6
//Input 2:
//
// A = 5
//
//
//Example Output
//Output 1:
//
// 3
//Output 2:
//
// 2
//
//
//Example Explanation
//Explanation 1:
//
// Possible combinations are : (12 + 12 + 12 + 12 + 12 + 12) and (12 + 12 + 22).
// Minimum count of numbers, sum of whose squares is 6 is 3.
//Explanation 2:
//
// We can represent 5 using only 2 numbers i.e. 12 + 22 = 5



public class MinimumNumberofSquares {

    public static int countMinSquares(int A) {
        if (A == 1) return 1;
        int[] ans = new int[A + 1];
        //Arrays.fill(ans,1);
        int n = A;

        for (int i = 1; i <= n; i++) {
            ans[i] = i;
            for (int x = 1; x * x <= i; x++) {
                System.out.println("i== "+i+" , Ans[i] : "+ans[i]+" , ans[i-x2] : "+ ans[i - x * x]);
                ans[i] = Math.min(ans[i], 1 + ans[i - x * x]);
            }
        }
        return ans[n];
    }

    public static void main(String[] args) {
        System.out.println(countMinSquares(12));
    }
}
