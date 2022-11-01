package com.dsa.geeksforgeek.string;

public class Subsequence {
    // s1 ="ABCDEF"
    // s2 ="ADE"
    // true;

    public static boolean isSubSequence(String s1,String s2){
        if(s1.length()<s2.length()) return false;

        int j=0;
        for (int i=0;i<s1.length()&& j<s2.length();i++){
            if(s1.charAt(i)==s2.charAt(j)) {
             j++;
            }
        }
        return j==s2.length();
    }

    public static boolean isSubSequence(String s1,String s2,int fistLength, int secondLength){
       if(fistLength==0) return true;

       if(secondLength==0) return false;

       if(s1.charAt(fistLength-1) == s2.charAt(secondLength-1))
          return isSubSequence(s1,s2,fistLength-1,secondLength-1);
       else
           return  isSubSequence(s1,s2,fistLength-1,secondLength);
    }

    public static void main(String[] args) {
        String firstString ="ABCDEF";
        String secondString ="AEF";

       // System.out.println(isSubSequence(firstString,secondString));
        System.out.println(isSubSequence(firstString,secondString,firstString.length(),secondString.length()));

    }
}
