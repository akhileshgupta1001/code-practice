package com.dsa.geeksforgeek.dyanmic.programing.knapsack;

public class CountSubsetOfGivenSum {

    //Input: arr[] = {1, 2, 3, 3}, X = 6
    //Output: 3
    //All the possible subsets are {1, 2, 3},
    //{1, 2, 3} and {3, 3}
    //
    //Input: arr[] = {1, 1, 1, 1}, X = 1
    //Output: 4

    public static int getCountSubsetOfGivenSum(int[] arr, int sum) {
        int[][] dp = new int[sum + 1][arr.length + 1];
        for (int i = 0; i <= arr.length; i++) {
            dp[0][i] = 1;
        }

        for (int j = 1; j <= sum; j++) {
            dp[j][0] = 0;
        }
        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= arr.length; j++) {
                if (arr[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                else {
                    dp[i][j] = dp[i - 1][j] +
                            dp[i - 1][j - arr[i - 1]];
                }
            }
        }
        return dp[sum][arr.length];
    }

    public static void main(String[] args) {
        System.out.println(getCountSubsetOfGivenSum(new int[]{1, 2, 3, 3}, 6));
    }
}
