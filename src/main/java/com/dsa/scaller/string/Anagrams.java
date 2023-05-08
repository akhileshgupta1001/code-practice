package com.dsa.scaller.string;

public class Anagrams {
    //Problem Description
    //You are given two lowercase strings A and B each of length N. Return 1 if they are anagrams to each other and 0 if not.
    //
    //Note : Two strings A and B are called anagrams to each other if A can be formed after rearranging the letters of B.
    //
    //
    //Problem Constraints
    //1 <= N <= 105
    //A and B are lowercase strings
    //
    //
    //Input Format
    //Both arguments A and B are a string.
    //
    //
    //Output Format
    //Return 1 if they are anagrams and 0 if not
    //
    //
    //Example Input
    //Input 1:
    //A = "cat"
    //B = "bat"
    //Input 2:
    //A = "secure"
    //B = "rescue"
    //
    //
    //Example Output
    //Output 1:
    //0
    //Output 2:
    //1
    //
    //
    //Example Explanation
    //For Input 1:
    //The words cannot be rearranged to form the same word. So, they are not anagrams.
    //For Input 2:
    //They are an anagram.

    public int solve(String A, String B) {
        A = A.trim();
        B = B.trim();
        if (A.length() != B.length()) return 0;


       /*
        for(int i =0;i<A.length();i++){
            char ch = A.charAt(i);
            if(B.indexOf(ch)==-1) return 0;
        }

        return 1;
        */
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for (int i = 0; i < A.length(); i++) {
            arr1[A.charAt(i) - 'a']++;
        }
        for (int i = 0; i < B.length(); i++) {
            arr2[B.charAt(i) - 'a']++;
        }

        // int k =0;
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) return 0;
        }

        return 1;
    }
}
