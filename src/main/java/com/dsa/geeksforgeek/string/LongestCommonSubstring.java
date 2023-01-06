package com.dsa.geeksforgeek.string;

import java.util.Arrays;

//https://www.geeksforgeeks.org/longest-common-substring-dp-29/
public class LongestCommonSubstring {

    //nput : X = “GeeksforGeeks”, y = “GeeksQuiz”
    //Output : 5
    //Explanation:
    //The longest common substring is “Geeks” and is of length 5.
    //
    //Input : X = “abcdxyz”, y = “xyzabcd”
    //Output : 4
    //Explanation:
    //The longest common substring is “abcd” and is of length 4.
    //
    //Input : X = “zxabcdezy”, y = “yzabcdezx”
    //Output : 6

    public static int getLongestCommonSubstring(String s1,String s2,int m , int n , int res){


        if(m==0|| n ==0) return res;

        if(s1.charAt(m-1)==s2.charAt(n-1)){
            res =getLongestCommonSubstring(s1,s2,m-1,n-1,res+1);
        }
           res = Math.max(res,Math.max(getLongestCommonSubstring(s1,s2,m-1,n,0)
                   ,getLongestCommonSubstring(s1,s2,m,n-1,0)));
        return res ;
    }

    public static int getLongestCommonSubstring(String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        int res = -1;
        getLongestCommonSubstring(s1,s2,m,n,res);
        System.out.println("Result : "+res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(getLongestCommonSubstring("GeeksforGeeks","GeeksQuiz"));
    }
}
