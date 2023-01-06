package com.dsa.geeksforgeek.string;

import java.util.Arrays;

public class LongestPalindromicSubstring {
    public static String longestPalindromeByBruteForce(String s) {
        int n = s.length();
        if (n == 0)
            return "";

        if (n ==1)
            return s;

        String result = "";
        for (int i = 0; i < n - 1; i++) {
            for (int j = i+1; j <= n - i; j++) {
                if (isPalindrome(s.substring(i, j))) {
                    if (result.length() < j)
                        result = s.substring(i, j);
                }
            }
        }
        return result;
    }

    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }



    public static int getLCS(String a, String b , int m, int n, int[][] arr){
        if(arr[m][n] != -1){ return arr[m][n];}
        if(m==0|| n==0) return 0;

        if(a.charAt(m-1)==b.charAt(n-1))
            arr[m][n] = 1+ getLCS(a,b,m-1,n-1,arr);
        else
            arr[m][n] = Math.max(getLCS(a,b,m-1,n,arr),getLCS(a,b,m,n-1,arr));

        return arr[m][n];
    }
    public static int lpsByLCS(String str){
        String rev = new StringBuffer(str).reverse().toString();
        System.out.println("Str : "+str +" , rev : "+rev);
        int[][] arr = new int[str.length()+1][str.length()+1];
        Arrays.stream(arr).forEach( data-> Arrays.fill(data,-1));

        return getLCS(str,rev,str.length(),str.length(),arr);

    }

    public static int expandLength(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }

    public static String longestPalindrome(String s) {

        int start = 0;
        int end = 0;


        for (int i = 0; i < s.length(); i++) {
            int len1 = expandLength(s, i, i + 1);
            int len2 = expandLength(s, i, i);
            int len = Math.max(len1, len2);
            if (end - start < len) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        //  Input: s = "babad"
        // Output: "bab"
        // Explanation: "aba" is also a valid answer.
        System.out.println(lpsByLCS("babad"));
    }
}
