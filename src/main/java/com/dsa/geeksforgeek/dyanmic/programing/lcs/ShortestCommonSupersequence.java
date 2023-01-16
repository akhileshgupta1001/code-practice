package com.dsa.geeksforgeek.dyanmic.programing.lcs;

public class ShortestCommonSupersequence {
    //Input:   str1 = "geek",  str2 = "eke"
    //Output: 5
    //Explanation:
    //String "geeke" has both string "geek"
    //and "eke" as subsequences.
    //
    //Input:   str1 = "AGGTAB",  str2 = "GXTXAYB"
    //Output:  9
    //Explanation:
    //String "AGXGTXAYB" has both string
    //"AGGTAB" and "GXTXAYB" as subsequences.

    // Logic => String 1 + String 2 - LCS => Output

    public static int getLCS(String s1, String s2, int m, int n ){
        int[][] dp = new int[m+1][n+1];

        for(int i =0;i<=m;i++){
            for(int j =0;j<=n;j++){
                if(i==0|| j==0){
                   dp[i][j] =0;
                }else if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j] = 1+ getLCS(s1,s2,m-1,n-1);
                }else{
                    dp[i][j] = Math.max(getLCS(s1,s2,m-1,n),getLCS(s1,s2,m,n-1));
                }
            }
        }
        return dp[m][n];
    }

    public static int getShortestCommonSupersequnce(String s1, String s2){
         return s1.length()+s2.length()-getLCS(s1,s2,s1.length(),s2.length());
    }

    public static void main(String[] args) {
        System.out.println(getShortestCommonSupersequnce("geek","eke"));
    }



}
