package com.dsa.scaller.dp;

public class UnboundedKnapsack {
    public int solve(int A, int[] value, int[] weight) {
        int W = A + 1; // Initialize the size of the dynamic programming array 'dp' to (A + 1)
        int[] dp = new int[W]; // Create an array 'dp' to store the maximum value achievable for each weight from 0 to A
        int n = value.length; // Get the number of items
        for(int i=0;i<=W;i++){
            for(int j=0;j<n;j++){
                if (i>=weight[j]){
                    dp[i] = Math.max(dp[i], dp[i - weight[j]] + value[j]);
                }
            }
        }
        return dp[A]; // Return the maximum value achievable for the given total weight 'A'
    }
    public int solve2(int A, int[] value, int[] weight) {
        int n = value.length;
        int[][] dp = new int[n+1][A+1];
        int ans =  knapsackRecursive(A, value.length,value, weight, dp);;
        System.out.println("Ans = "+ans);
        return ans;
    }

    private int knapsackRecursive(int W,  int n,int[] value, int[] weight, int[][] dp) {
        // Base case: If there are no items left or no weight left, return 0
        if (n == 0 || W == 0) {
            return 0;
        }

        if(dp[n][W] !=0){
            return dp[n][W];
        }

        // If the weight of the current item is greater than the remaining weight 'A',
        // skip this item and move to the next item
        if (W>= weight[n-1]) {
            dp[n][W] = Math.max(knapsackRecursive(W,n-1,value,weight,dp),value[n-1]+knapsackRecursive(W-weight[n-1],n,value,weight,dp));
        }else{
            dp[n][W] = knapsackRecursive(W,n-1,value,weight,dp);
        }

       return dp[n][W];
    }
    public static void main(String[] args) {
        int[] weight = {3,4,7};
        int[] happ ={2,3,5};
        int[] dp = new int[8+1];

        int[] weight1 = {6,7};
        int[] happ1 ={5,5};
        int[] dp1 = new int[10+1];

        UnboundedKnapsack unboundedKnapsack = new UnboundedKnapsack();
        unboundedKnapsack.solve2(11,happ1,weight1);
       // unboundedKnapsack.sol
    }
}
