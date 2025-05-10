package com.dsa.scaller.twopointer;

import java.util.Arrays;

//https://www.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1

//Given a word pat and a text txt. Return the count of the occurrences of anagrams of the word in the text.
//
//Example 1:
//
//Input:
//txt = forxxorfxdofr
//pat = for
//Output: 3
//Explanation: for, orf and ofr appears
//in the txt, hence answer is 3.
//Example 2:
//
//Input:
//txt = aabaabaa
//pat = aaba
//Output: 4
//Explanation: aaba is present 4 times
//in txt.
//Your Task:
//Complete the function search() which takes two strings pat, txt, as input parameters and returns an integer denoting the answer.
//You don't need to print answer or take inputs.
//
//Expected Time Complexity: O(N)
//Expected Auxiliary Space: O(26) or O(256)

public class CountOccurencesAnagrams {
    static int search(String pat, String txt) {
        char[] orginal = pat.toCharArray();
        Arrays.sort(orginal);
        pat = String.valueOf(pat);
        int ans =0;
        // code here
        int txtCount = txt.length();
        int patCount = pat.length();
        for(int i=0;i<=txtCount-patCount;i++){

            String str = txt.substring(i,i+patCount);
            System.out.println("Str : "+str);
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            str = String.valueOf(arr);
            if(str.equals(pat)){
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        search("for","forxxorfxdofr");
    }
}

