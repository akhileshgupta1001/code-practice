package com.dsa.geeksforgeek.dyanmic.programing;

public class MaximumCuts {
    //https://www.geeksforgeeks.org/maximise-number-of-cuts-in-a-rod-if-it-can-be-cut-only-in-given-3-sizes/
    /*
    /Input: N = 17, A = 10, B = 11, C = 3
Output: 3
Explanation:
The maximum cut can be obtain after making 2 cut of length 3 and one cut of length 11.

Input: N = 10, A = 9, B = 7, C = 11
Output: -1
Explanation:
It is impossible to make any cut so output will be -1.
     */

    // Recursion
    // 3^n
    public static int getMiaximumCuts(int n, int A, int B , int C){

        if(n<0) return -1;
        if(n==0) return 0;

        int res = Math.max(Math.max(getMiaximumCuts(n-A,A,B,C),
                getMiaximumCuts(n-B,A,B,C)
        ), getMiaximumCuts(n-C,A,B,C));

        if(res==-1) return res;
        else return res+1;
    }

    // using dp
    public static int getMiaximumCutsUisngDp(int n, int A, int B ,int C){
        int[] dp = new int[n+1];
        dp[0]=0;

        for(int i=1;i<=n;i++){
            dp[i]=-1;

            if(i-A>=0) {
                dp[i]= Math.max(dp[i],dp[i-A]);
            }
            if(i-B>=0) {
                dp[i]= Math.max(dp[i],dp[i-B]);
            }
            if(i-C>=0) {
                dp[i]= Math.max(dp[i],dp[i-C]);
            }

            if(dp[i] !=-1) dp[i]++;
        }

        return dp[n];


    }

    public static void main(String[] args) {
        System.out.println(getMiaximumCutsUisngDp(17,10,11,3));
    }

}
