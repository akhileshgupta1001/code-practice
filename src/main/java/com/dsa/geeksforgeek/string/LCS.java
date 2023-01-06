package com.dsa.geeksforgeek.string;

import java.util.Arrays;

public class LCS {

    // using recursion
    public static int getLCS(String s1, String s2, int m,int n){
        if(m==0||n==0) return 0;

        if(s1.charAt(m-1)==s2.charAt(n-1))
            return 1+ getLCS(s1,s2,m-1,n-1);
        else
            return Math.max(getLCS(s1,s2,m-1,n),getLCS(s1,s2,m,n-1));
    }

    //using dp
    public static int getLCS(String s1, String s2, int m,int n,int[][] arr){

        if(arr[m][n] !=-1){
            return arr[m][n];
        }
        if(m==0||n==0) return 0;

        if(s1.charAt(m-1)==s2.charAt(n-1))
            arr[m][n]=1+ getLCS(s1,s2,m-1,n-1,arr);
        else
            arr[m][n]= Math.max(getLCS(s1,s2,m-1,n,arr),getLCS(s1,s2,m,n-1,arr));

        return arr[m][n];
    }
    public static void main(String[] args) {
        String s1="ABCDE";
        String s2="AXE";
                int m=s1.length();
        int n = s2.length();
        int[][] arr = new int[m+1][n+1];
        Arrays.stream(arr).forEach(a->Arrays.fill(a,-1));
        System.out.println(getLCS(s1,s2,m,n,arr));
        // System.out.println(getLCS("ABCDE","ABCDE",4,4));
    }
}
