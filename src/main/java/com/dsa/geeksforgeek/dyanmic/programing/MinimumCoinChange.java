package com.dsa.geeksforgeek.dyanmic.programing;

import java.util.Arrays;

public class MinimumCoinChange {

    //{7,5,1}  num =18 , ans =4 (7+5*2+1)
//https://leetcode.com/problems/coin-change/submissions/


    //BruteForce
    //The time complexity of the above solution is exponential and space complexity is way greater than O(n)
    public static int getMinimumCoinForMakeValue(int value,int[] arr,int size){

        if(value==0) return 0;

        int result = Integer.MAX_VALUE;
        for(int i=0;i<size;i++){
            if(arr[i]<=value) {
                int subMax = getMinimumCoinForMakeValue(value - arr[i], arr, size);
                if (subMax != Integer.MAX_VALUE && subMax + 1<result) {
                    result =subMax + 1;
                }
            }
        }

        return result;

    }

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
        //getMinimumCoin(18,new int[]{7,5,1});
       int[] arr= new int[]{7,5,1};
        System.out.println(getMinimumCoinForMakeValue(18,arr,arr.length));
       // getMinimumCoin(18,arr);
    }
}
