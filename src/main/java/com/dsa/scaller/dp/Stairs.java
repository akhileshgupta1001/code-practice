package com.dsa.scaller.dp;

//Problem Description
//You are climbing a staircase and it takes A steps to reach the top.
//
//Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
//
//Return the number of distinct ways modulo 1000000007
//
//
//
//Problem Constraints
//1 <= A <= 105
//
//
//
//Input Format
//The first and the only argument contains an integer A, the number of steps.
//
//
//
//Output Format
//Return an integer, representing the number of ways to reach the top.
//
//
//
//Example Input
//Input 1:
//
// A = 2
//Input 2:
//
// A = 3
//
//
//Example Output
//Output 1:
//
// 2
//Output 2:
//
// 3
//
//
//Example Explanation
//Explanation 1:
//
// Distinct ways to reach top: [1, 1], [2].
//Explanation 2:
//
// Distinct ways to reach top: [1 1 1], [1 2], [2 1].

public class Stairs {
    int[] fab;
    int mod = (int) (1e9 + 7);

    public int fabonic(int n) {
        if (n == 0 || n == 1) return 1;

        if (fab[n] > 0) {
            return fab[n] % mod;
        }

        fab[n] = (fabonic(n - 1) % mod + fabonic(n - 2) % mod) % mod;

        return fab[n];
    }

    public int climbStairs(int A) {

        fab = new int[A + 1];
        fab[0] = 0;
        fab[1] = 1;
        int result = fabonic(A);
        // System.out.println(result);
        return result % mod;
    }


    public static void main(String[] args) {
        int[][] my2DArray = {
                {1,0}
        };
        System.out.println(my2DArray.length+" "+my2DArray[0].length);
        Stairs stairs = new Stairs();
        stairs.climbStairs(5);
    }
}
