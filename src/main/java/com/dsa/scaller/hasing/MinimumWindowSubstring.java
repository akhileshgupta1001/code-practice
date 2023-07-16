package com.dsa.scaller.hasing;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static String minWindow(String A, String B) {
        // Map to store the count of each character in B
        Map<Character, Integer> targetMap = new HashMap<>();
        for (char c : B.toCharArray()) {
            targetMap.put(c, targetMap.getOrDefault(c, 0) + 1);
        }

        int left = 0; // Left pointer of the window
        int count = 0; // Count of characters in B found in the current window
        int minLength = Integer.MAX_VALUE; // Length of the minimum window found so far
        int minStart = 0; // Start index of the minimum window found so far

        for (int right = 0; right < A.length(); right++) {
            char c = A.charAt(right);

            // Update the count of character c in the current window
            if (targetMap.containsKey(c)) {
                targetMap.put(c, targetMap.get(c) - 1);
                if (targetMap.get(c) >= 0) {
                    count++;
                }
            }

            // Try to minimize the window by moving the left pointer
            while (count == B.length()) {
                // Update the minimum window if a smaller window is found
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minStart = left;
                }

                // Move the left pointer to the right to shrink the window
                char leftChar = A.charAt(left);
                if (targetMap.containsKey(leftChar)) {
                    targetMap.put(leftChar, targetMap.get(leftChar) + 1);
                    if (targetMap.get(leftChar) > 0) {
                        count--;
                    }
                }
                left++;
            }
        }

        // Return the minimum window substring or an empty string if not found
        if (minLength == Integer.MAX_VALUE) {
            return "";
        }
        return A.substring(minStart, minStart + minLength);
    }

    public static void main(String[] args) {
        String A = "ADOBECODEBANC";
        String B = "ABC";
        System.out.println(minWindow(A, B)); // Output: "BANC"

        A = "Aa91b";
        B = "ab";
        System.out.println(minWindow(A, B)); // Output: "a91b"
    }
}
