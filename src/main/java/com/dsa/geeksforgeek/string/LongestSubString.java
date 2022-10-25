package com.dsa.geeksforgeek.string;

import java.util.Arrays;

public class LongestSubString {

    public static boolean isDistinctString(String str, int star, int end) {
        boolean visted[] = new boolean[256];

        for (int i = star; i <= end; i++) {
            if (visted[str.charAt(i)] == true)
                return false;

            visted[str.charAt(i)] = true;
        }
        return true;
    }

    // n3
    public static int longestSubStringCount(String str) {

        int result = 0;

        for (int i = 0; i < str.length(); i++) {
            for (int j = i; j < str.length(); i++) {

                if (isDistinctString(str, i, j)) {
                    result = Math.max(result, j - i + 1);
                }
            }
        }
        return result;
    }

    // n2
    public static int lsc(String s) {
        int res = 0;


        for (int i = 0; i < s.length(); i++) {
            boolean isVistedArray[] = new boolean[256];
            for (int j = i; j < s.length(); j++) {

                if (isVistedArray[s.charAt(j)] == true)
                    break;
                else {
                    res = Math.max(res, j - i + 1);
                    isVistedArray[s.charAt(j)] = true;
                }
            }
        }
        return res;
    }

    public static int longestUniqueSubString(String s) {
        int[] lastIndex = new int[256];
        Arrays.fill(lastIndex, -1);
        int res = 0, i = 0;
        for (int j = 0; j < s.length(); j++) {
            i = Math.max(i, lastIndex[s.charAt(j)] + 1);
            res = Math.max(res, j - i + 1);
            lastIndex[s.charAt(j)] = j;
        }
        return res;
    }

    public static void main(String[] args) {
        // System.out.println(longestSubStringCount("abcad"));
        System.out.println(longestUniqueSubString("babad"));
    }
}
