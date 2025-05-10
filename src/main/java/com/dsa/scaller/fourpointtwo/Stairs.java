package com.dsa.scaller.fourpointtwo;

import java.util.Arrays;

//https://www.scaler.com/academy/mentee-dashboard/class/366671/assignment/problems/30?navref=cl_tt_lst_sl
public class Stairs {
    //Problem Description
    //
    //You are climbing a staircase and it takes A steps to reach the top.
    //
    //
    //Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
    //
    //Return the number of distinct ways modulo 1000000007
    //
    //
    //
    //Problem Constraints
    //
    //1 <= A <= 105
    //
    //
    //
    //Input Format
    //
    //The first and the only argument contains an integer A, the number of steps.
    //
    //
    //
    //Output Format
    //
    //Return an integer, representing the number of ways to reach the top.
    //
    //
    //
    //Example Input
    //
    //Input 1:
    //
    // A = 2
    //Input 2:
    //
    // A = 3
    //
    //
    //Example Output
    //
    //Output 1:
    //
    // 2
    //Output 2:
    //
    // 3
    //
    //
    //Example Explanation
    //
    //Explanation 1:
    //
    // Distinct ways to reach top: [1, 1], [2].
    //Explanation 2:
    //
    // Distinct ways to reach top: [1 1 1], [1 2], [2 1].
    //
    //
    //
    //Expected Output
    //Provide sample input and click run to see the correct output for the provided input. Use this to improve your problem understanding and test edge cases

    public int climbStairs(int A) {
       return numberOfClimb(A);
    }

    private int numberOfClimb(int numberOfSteps) {
        int mod = (int)1e9+7; // define it
        // Base case -->
        // to reach 0th stair...we need only 0 step
        // to reach 1st stair...we need only 1 step [ jump of 1 ]
        // to reach 2nd stair...we need only 2 ways [ jump of 1-> jump of 1, jump of 2 ]
        if(numberOfSteps<=2){
            return numberOfSteps;
        }
        int ans =(numberOfClimb(numberOfSteps-1)+numberOfClimb(numberOfSteps-2)) % mod;
        return ans % mod;
    }

    private int numberOfClimb(int numberOfSteps, int[] dp) {
        int
                mod =
                (int) 1e9 + 7; // define it
        // Base case -->
        // to reach 0th stair...we need only 0 step
        // to reach 1st stair...we need only 1 step [ jump of 1 ]
        // to reach 2nd stair...we need only 2 ways [ jump of 1-> jump of 1, jump of 2 ]
        if (numberOfSteps <= 2) {
            dp[numberOfSteps] =
                    numberOfSteps;
            return numberOfSteps;
        }
        if (dp[numberOfSteps] != -1) {
            return dp[numberOfSteps];
        }
        dp[numberOfSteps] =
                (numberOfClimb(numberOfSteps - 1, dp) + numberOfClimb(numberOfSteps - 2, dp)) % mod;
        return dp[numberOfSteps] % mod;
    }

    public static void main(String[] args) {
        Stairs stairs= new Stairs();
        //System.out.print(stairs.climbStairs(3));
        int n = 3;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
      int ans = stairs.numberOfClimb(3,dp);
        System.out.print("Stairs : "+Arrays.toString(dp));
    }
}
