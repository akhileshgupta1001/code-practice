package com.dsa.scaller.dp.practice;
//https://www.naukri.com/code360/problems/minimal-cost_8180930?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTabValue=PROBLEM


import java.util.Arrays;

public class MinimalCost {

    //Sample Input 1:
    //4 2
    //10 40 30 10
    //Sample Output 1:
    //40
    //Explanation of sample output 1:
    //For ‘n’ = 4, 'k' = 2, height = {10, 40, 30, 10}
    //
    //Answer is 40.
    //
    //Initially, we are present at stone 1 having height 10. We can reach stone 3 as ‘k’ is 2. So, cost incurred is |10-30| = 20.
    //
    //Now, we are present at stone 3, we can reach stone 4 as ‘k’ is 2. So, cost incurred is |30-10| = 20. So, the total cost is 40. We can show any other path will lead to greater cost.
    //Sample Input 2:
    //5 3
    //10 40 50 20 60
    //Sample Output 2:
    //50
    //Constraints:
    //1 <= n <= 10^4
    //1 <= k <= 100
    //1 <= height[i] <= 10^4
    //Time Limit: 1 sec


    public static int minimumCost(int n, int k, int[] height, int[] dp) {
        if (n < 0 || n == 0) return 0;

        if (dp[n] != Integer.MAX_VALUE) return dp[n];

        int
                ans =
                Integer.MAX_VALUE;

        for (int
             i =
             1; i <= k; i++) {
            if (n - i >= 0) {
                int
                        jump =
                        minimumCost(n - i, k, height, dp) + Math.abs(height[n] - height[n - i]);
                ans =
                        Math.min(ans, jump);
            }

        }
        return
                dp[n] =
                        ans;
    }

    public static int minimizeCost(int n, int k, int[] height) {
        if (n <= 0) return 0; // Base case for recursion termination
        if (n == 1) return 0;

        int[]
                dp =
                new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        return minimumCost(n - 1, k, height, dp);
    }

    public static void main(String[] args) {
        minimizeCost(4, 2, new int[]{10, 40, 30, 10});
    }

}
