package com.dsa.geeksforgeek.dyanmic.programing;

public class EditDistance {
    //https://leetcode.com/problems/edit-distance/
    /*
    Input: word1 = "horse", word2 = "ros"
Output: 3
Explanation:
horse -> rorse (replace 'h' with 'r')
rorse -> rose (remove 'r')
rose -> ros (remove 'e')
     */
    public static int minDistance(String word1, String word2, int m, int n) {
        if(m ==0) return n;
        if(n==0) return m;

        if(word1.charAt(m-1)==word2.charAt(n-1))
            return minDistance(word1,word2,m-1,n-1);
        else
            return 1+ Math.min(Math.min(minDistance(word1,word2,m-1,n),
                    minDistance(word1,word2,m,n-1)),minDistance(word1,word2,m-1,n-1));

    }
    public static int minDistance(String word1, String word2) {

        return minDistance(word1,word2,word1.length(),word2.length());
    }

    public static int minDistanceUisngDp(String word1, String word2) {
        int m=word1.length();
        int n= word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++){
           dp[i][0]=i;
        }
        for(int i=0;i<=n;i++){
            dp[0][i]=i;
        }

        for(int i =1;i<=m;i++){
            for(int j=1;j<=n;j++) {

                if (word1.charAt(i- 1) == word2.charAt(j- 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1],
                            dp[i-1][j-1]));
            }
        }
        return dp[m][n];
    }


    public static void main(String[] args) {
        System.out.println(minDistanceUisngDp("horse","ros"));
    }
}
