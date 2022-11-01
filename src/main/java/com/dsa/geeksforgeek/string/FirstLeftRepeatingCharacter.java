package com.dsa.geeksforgeek.string;

import java.util.Arrays;

public class FirstLeftRepeatingCharacter {

    static final int CHAR = 256;

    public static int leftMost(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) return i;
            }
        }
        return -1;
    }

    public static int leftMostCharacter(String str) {
        int characterCount = 256;
        char[] arr = new char[characterCount];
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (arr[str.charAt(i)] > 1)
                return i;
        }

        return -1;
    }


    public static int leftMostEfficient1(String str) {
        int[] fIndex = new int[CHAR];
        Arrays.fill(fIndex, -1);
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < str.length(); i++) {
            int fi = fIndex[str.charAt(i)];
            if (fi == -1)
                fIndex[str.charAt(i)] = i;
            else
                res = Math.min(res, fi);
        }

        return (res == Integer.MAX_VALUE) ? -1 : res;
    }

    public static int leftMostEfficient2(String str) {
        boolean[] visited = new boolean[CHAR];
        int res = -1;
        for (int i = str.length() - 1; i >= 0; i--) {
            if (visited[str.charAt(i)])
                res = i;
            else
                visited[str.charAt(i)] = true;
        }
        return res;
    }

    public static void main(String[] args) {
        // System.out.println(leftMostCharacter("abccbd"));
        System.out.println(leftMostCharacter("loveleetcode"));
    }
}
