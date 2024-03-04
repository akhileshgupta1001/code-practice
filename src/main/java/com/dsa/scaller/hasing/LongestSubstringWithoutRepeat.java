package com.dsa.scaller.hasing;

import java.util.HashMap;
import java.util.Map;

// Amazon

public class LongestSubstringWithoutRepeat {

    //Problem Description
    //Given a string A, find the length of the longest substring without repeating characters.
    //
    //Note: Users are expected to solve in O(N) time complexity.
    //
    //
    //
    //Problem Constraints
    //1 <= size(A) <= 106
    //
    //String consists of lowerCase,upperCase characters and digits are also present in the string A.
    //
    //
    //
    //Input Format
    //Single Argument representing string A.
    //
    //
    //
    //Output Format
    //Return an integer denoting the maximum possible length of substring without repeating characters.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = "abcabcbb"
    //Input 2:
    //
    // A = "AaaA"
    //
    //
    //Example Output
    //Output 1:
    //
    // 3
    //Output 2:
    //
    // 2
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // Substring "abc" is the longest substring without repeating characters in string A.
    //Explanation 2:
    //
    // Substring "Aa" or "aA" is the longest substring without repeating characters in string A.

    public int lengthOfLongestSubstring(String A) {
        if (A == null) return 0;
        if (A.length() == 1) return 1;
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        int i = -1;
        int j = -1;

        while (true) {
            boolean flag1 = false;
            boolean flag2 = false;

            // aquire
            while (i < A.length() - 1) {
                flag1 = true;
                i++;
                char data = A.charAt(i);
                map.put(data, map.getOrDefault(data, 0) + 1);
                if (map.get(data) == 2) {
                    break;
                } else {
                    ans = Math.max(ans, i - j);
                }
            }

            // release;
            while (j < i) {
                flag2 = true;
                j++;
                char data = A.charAt(j);
                map.put(data, map.get(data) - 1);
                if (map.get(data) == 1) {
                    break;
                }
            }

            if (flag1 == false && flag2 == false) {
                break;
            }
        }
        return ans;

    }
}
