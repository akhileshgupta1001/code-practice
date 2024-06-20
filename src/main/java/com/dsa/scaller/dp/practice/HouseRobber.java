package com.dsa.scaller.dp.practice;

import java.util.Arrays;

//https://leetcode.com/problems/house-robber/description/
public class HouseRobber {

    //Example 1:
    //
    //Input: nums = [1,2,3,1]
    //Output: 4
    //Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
    //Total amount you can rob = 1 + 3 = 4.
    //Example 2:
    //
    //Input: nums = [2,7,9,3,1]
    //Output: 12
    //Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
    //Total amount you can rob = 2 + 9 + 1 = 12.


        public int maxRob(int[] nums, int n , int[] dp){
            if(n<0) return 0;
            if(n==0) return nums[n];
            if(dp[n] !=-1){
                return dp[n];
            }
            int notPicked = maxRob(nums,n-1,dp);
            System.out.println("notPicked : "+notPicked+ " , n : "+n);
            int picked=  maxRob(nums,n-2,dp)+nums[n];
         //   System.out.println("Picked :"+ picked+" , n-2 = "+(n-2)+" , notPicked : "+notPicked+" , (n-1 ) = "+(n-1));
            System.out.println("picked : "+picked+ " , n : "+n);

            return dp[n]= Math.max(picked,notPicked);
        }
        public int rob(int[] nums) {
            int n =nums.length;
            int[] dp = new int[n];
            Arrays.fill(dp,-1);
            return maxRob(nums,n-1,dp);
        }


    public static void main(String[] args) {
        HouseRobber houseRobber = new HouseRobber();
        houseRobber.rob(new int[]{1,2,3,1});
    }
}
