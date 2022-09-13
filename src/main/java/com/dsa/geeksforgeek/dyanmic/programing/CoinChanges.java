package com.dsa.geeksforgeek.dyanmic.programing;

public class CoinChanges {

    //https://leetcode.com/problems/coin-change-2/
    /*
    Input: amount = 5, coins = [1,2,5]
Output: 4
Explanation: there are four ways to make up the amount:
5=5
5=2+2+1
5=2+1+1+1
5=1+1+1+1+1
     */
    public static int change(int amount, int[] coins, int n) {

        if(amount==0) return 1;
        if(n==0) return 0;
        int result = change(amount,coins,n-1);
        if(coins[n-1]<=amount)
            result = result+ change(amount-coins[n-1],coins,n);

        return result;
    }

    public static int changeByIterative(int amount, int[] coins, int n) {

        int[][] dp = new int[amount+1][n+1];
        for(int i=0;i<=n;i++){
            dp[0][i]=1;
        }

        for(int i=1;i<=amount;i++){
            dp[i][0]=0;
        }

        for(int i=1;i<=amount;i++){
            for(int j=1;j<=n;j++){
                dp[i][j] = dp[i][j-1];
                if(coins[j-1]<=i)
                    dp[i][j]= dp[i][j]+dp[i-coins[j-1]][j];
            }
        }
        return dp[amount][n];

    }





    public static void main(String[] args) {
       // System.out.println(change(5,new int[]{1,2,5},3));
        System.out.println(changeByIterative(5,new int[]{1,2,5},3));

    }
}
