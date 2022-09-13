package com.dsa.geeksforgeek.dyanmic.programing;

import java.util.Arrays;

public class MinimumCoinChange {

    //{7,5,1}  num =18 , ans =4 (7+5*2+1)
//https://leetcode.com/problems/coin-change/submissions/
    public static void getMinimumCoin(int number,int[] arr){
        int[] dp = new int[number+1];
        Arrays.fill(dp,-1);
        dp[0]=0;

        System.out.println(minCoin(number,arr,dp));
    }

    public static int minCoin(int number,int[] arr,int[] dp){
        if(number==0) return 0;
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(number-arr[i]>=0){
                int subAns=0 ;
                    if(dp[number-arr[i]] !=-1){
                  subAns = dp[number-arr[i]];
                }else{
                subAns     = minCoin(number-arr[i],arr,dp);
                }
                if(subAns != Integer.MAX_VALUE && subAns+1<ans){
                    ans = subAns+1;
                }
            }
        }
        return dp[number] = ans;
    }

    public static void main(String[] args) {
        getMinimumCoin(18,new int[]{7,5,1});
    }
}
