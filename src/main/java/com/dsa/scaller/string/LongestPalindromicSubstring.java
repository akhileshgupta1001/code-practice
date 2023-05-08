package com.dsa.scaller.string;

public class LongestPalindromicSubstring {
    //Problem Description
    //Given a string A of size N, find and return the longest palindromic substring in A.
    //
    //Substring of string A is A[i...j] where 0 <= i <= j < len(A)
    //
    //Palindrome string:
    //A string which reads the same backwards. More formally, A is palindrome if reverse(A) = A.
    //
    //Incase of conflict, return the substring which occurs first ( with the least starting index).
    //
    //
    //
    //Problem Constraints
    //1 <= N <= 6000
    //
    //
    //
    //Input Format
    //First and only argument is a string A.
    //
    //
    //
    //Output Format
    //Return a string denoting the longest palindromic substring of string A.
    //
    //
    //
    //Example Input
    //Input 1:
    //A = "aaaabaaa"
    //Input 2:
    //A = "abba
    //
    //
    //Example Output
    //Output 1:
    //"aaabaaa"
    //Output 2:
    //"abba"
    //
    //
    //Example Explanation
    //Explanation 1:
    //We can see that longest palindromic substring is of length 7 and the string is "aaabaaa".
    //Explanation 2:
    //We can see that longest palindromic substring is of length 4 and the string is "abba".

    public String expandAlgo(String s, int start, int end) {
        int n = s.length();
        while (start >= 0 && end < n && s.charAt(start) == s.charAt(end)) {
            start--;
            end++;
        }
        // hence las matching indexes = l+1 and h-1
        return s.substring(start + 1, end);
    }

    public String longestPalindrome(String A) {
        int n = A.length();
        String ans = "";
        for (int i = 0; i < n; i++) {

            //first put i as centre for odd length subarrays
            String first = expandAlgo(A, i, i);

            if (first.length() > ans.length()) {
                ans = first;
            }

            String second = expandAlgo(A, i, i + 1);

            if (second.length() > ans.length()) {
                ans = second;
            }

        }

        return ans;
    }
}
