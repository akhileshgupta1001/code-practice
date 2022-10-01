package com.dsa.geeksforgeek.dyanmic.programing;

public class EggDropping {

    //https://www.geeksforgeeks.org/egg-dropping-puzzle-dp-11/
    //Minimum number of trials in worst
    //case with 2 eggs and 10 floors is 4
    // formula res(f,e) = Min(max (res(x-1,e-1),res (f-x,e))+1;
     //                              break ,   Don't break
    //Time : flor(2)*egg
    //space 0(fe)
    public static int getMinimumDrop(int egg, int flor){
        int[][] dp = new int[flor+1][egg+1];

        for(int i = 1; i <= egg ;i++){
            dp[1][i] = 1;
            dp[0][i] = 0;
        }

        for(int j = 1; j <= flor; j++){
            dp[j][1] = j;
        }

        for(int i = 2; i <= flor; i++){
            for(int j = 2; j <= egg; j++){
                dp[i][j] =Integer.MAX_VALUE;
                for(int x = 1; x <= i; x++){
                    dp[i][j] = Math.min(dp[i][j], 1 + Math.max(dp[x-1][j-1], dp[i-x][j]));
                }
            }
        }

        return dp[flor][egg];
    }

    public static void main(String[] args) {
        System.out.println(getMinimumDrop(2,10));
    }
}
