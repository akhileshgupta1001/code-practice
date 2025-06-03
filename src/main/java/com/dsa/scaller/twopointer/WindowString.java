package main.java.com.dsa.scaller.twopointer;

import java.util.HashMap;
import java.util.Map;

//Problem Description
//
//Given a string A and a string B, find the window with minimum length in A, which will contain all the characters in B in linear time complexity.
//Note that when the count of a character c in B is x, then the count of c in the minimum window in A should be at least x.
//
//Note:
//
//If there is no such window in A that covers all characters in B, return the empty string.
//If there are multiple such windows, return the first occurring minimum window ( with minimum start index and length )
//
//
//
//Problem Constraints
//
//1 <= size(A), size(B) <= 106
//
//
//
//Input Format
//
//The first argument is a string A.
//The second argument is a string B.
//
//
//
//Output Format
//
//Return a string denoting the minimum window.
//
//
//
//Example Input
//
//Input 1:
//
// A = "ADOBECODEBANC"
// B = "ABC"
//Input 2:
//
// A = "Aa91b"
// B = "ab"
//
//
//
//Example Output
//
//Output 1:
//
// "BANC"
//Output 2:
//
// "a91b"
//
//
//Example Explanation
//
//Explanation 1:
//
// "BANC" is a substring of A which contains all characters of B.
//Explanation 2:
//
// "a91b" is the substring of A which contains all characters of B.
public class WindowString {
    public String minWindow(String A, String B) {
        if (A == null || B == null || A.length() < B.length()) return "";

        int[] freqMap = new int[256];

        // Build frequency map from string B (target)
        for (char c : B.toCharArray()) {
            freqMap[c]++;
        }

        int left = 0, right = 0;
        int minLength = Integer.MAX_VALUE;
        int startIndex = -1;
        int count = 0; // total characters matched so far

        while (right < A.length()) {
            char rChar = A.charAt(right);

            // If rChar is still needed (freq > 0), count it
            if (freqMap[rChar] > 0) {
                count++;
            }

            // Decrease frequency whether needed or extra
            freqMap[rChar]--;
            right++;

            // If all characters matched
            while (count == B.length()) {
                // Update smallest window
                if (right - left < minLength) {
                    minLength = right - left;
                    startIndex = left;
                }

                // Try to shrink from the left
                char lChar = A.charAt(left);
                freqMap[lChar]++;

                // If that char was part of B and needed again
                if (freqMap[lChar] > 0) {
                    count--;
                }
                left++;
            }
        }

        return startIndex == -1 ? "" : A.substring(startIndex, startIndex + minLength);
    }}