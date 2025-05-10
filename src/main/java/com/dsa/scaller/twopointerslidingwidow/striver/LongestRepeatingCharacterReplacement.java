package com.dsa.scaller.twopointerslidingwidow.striver;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/longest-repeating-character-replacement/
public class LongestRepeatingCharacterReplacement {

    public static int characterReplacement(String s, int k) {
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            Map<Character, Integer> hash = new HashMap<>();
            int maxFrequency = 0;

            for (int j = i; j < s.length(); j++) { // Start inner loop from i
                char currentChar = s.charAt(j);
                hash.put(currentChar, hash.getOrDefault(currentChar, 0) + 1);
                maxFrequency = Math.max(maxFrequency, hash.get(currentChar));

                int numberOfChanges = (j - i + 1) - maxFrequency;
                if (numberOfChanges <= k) {
                    ans = Math.max(ans, j - i + 1);
                } else {
                    System.out.println("*******************");
                    System.out.println("i = " + i + " , j = " + j + " , maxFreq = " + maxFrequency + " , numberOfChanges = " + numberOfChanges + " , ans = " + ans);
                    System.out.println("*******************");
                    break;
                }

                System.out.println("i = " + i + " , j = " + j + " , maxFreq = " + maxFrequency + " , numberOfChanges = " + numberOfChanges + " , ans = " + ans);
            }
        }

        return ans;
    }
    public static int characterReplacement2(String s, int k) {
        int ans = 0;
        int maxFrequency = 0;
        Map<Character, Integer> hash = new HashMap<>();

        int left = 0; // left pointer of the sliding window

        for (int right = 0; right < s.length(); right++) {
            // Add the current character to the hash map
            char currentChar = s.charAt(right);
            hash.put(currentChar, hash.getOrDefault(currentChar, 0) + 1);

            // Update the maximum frequency character in the current window
            maxFrequency = Math.max(maxFrequency, hash.get(currentChar));

            // Calculate the number of changes needed
            int numberOfChanges = (right - left + 1) - maxFrequency;

            // If the number of changes is greater than k, shrink the window from the left
            if (numberOfChanges > k) {
                char leftChar = s.charAt(left);
                hash.put(leftChar, hash.get(leftChar) - 1);
                left++;
            }

            // Update the answer with the maximum length of the valid window
            ans = Math.max(ans, right - left + 1);

            System.out.println("left = " + left + " , right = " + right + " , maxFreq = " + maxFrequency + " , numberOfChanges = " + numberOfChanges + " , ans = " + ans);
        }

        return ans;
    }
    public static void main(String[] args) {
       System.out.println(characterReplacement2("ABAB",2));
        //System.out.println(characterReplacement("AABABBA",1));
    }

}
