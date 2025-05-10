package com.dsa.scaller.twopointerslidingwidow.striver;

import java.util.HashMap;
import java.util.Map;

//Given a string s, find the length of the longest
//substring
// without repeating characters.
//
//
//
//Example 1:
//
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
//Example 2:
//
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
//Example 3:
//
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

public class LongestSubstringWithoutRepetingCharacter {

        public int lengthOfLongestSubstring1(String s) {
            int left =0;
            int right =0;
            int n = s.length();
            int ans =0;
            Map<Character,Integer> map = new HashMap<>();
            while(right<n){
                char currentChar = s.charAt(right);

                if(map.containsKey(currentChar)){
                    left = Math.max(map.get(currentChar)+1,left);
                }

                ans = Math.max(ans,right-left+1);
                map.put(currentChar,right);
                right++;
            }
            return ans;
        }


    public static String lengthOfLongestSubstring(String s) {
        int left = 0;
        int right = 0;
        int n = s.length();
        int maxLength = 0;
        int start = 0;
        Map<Character, Integer>
                map = new HashMap<>();

        while (right < n) {
            char currentChar = s.charAt(right);

            if (map.containsKey(currentChar)) {
                left = Math.max(map.get(currentChar) + 1, left);
                System.out.println("Already present over the map right = "+right+" , left = "+left+" , start = "+start+" , right char "+currentChar+" , left char = "+s.charAt(left)+" , maxLength = "+s.substring(start, start + maxLength) + " , map : "+map);



            }

            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                start = left;
                System.out.println("right = "+right+" , left = "+left+" , start = "+start+" , right char "+currentChar+" , left char = "+s.charAt(left)+" , maxLength = "+s.substring(start, start + maxLength)+ " , map : "+map);
            }

            map.put(currentChar, right);
            right++;
        }

        return s.substring(start, start + maxLength);
    }

    public static void main(String[] args) {
        System.out.println("abcabcdbb");
        System.out.println(lengthOfLongestSubstring("abcabcdbb"));
    }

}
