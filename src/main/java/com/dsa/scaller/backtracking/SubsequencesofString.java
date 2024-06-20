package com.dsa.scaller.backtracking;

import java.util.ArrayList;

//https://www.naukri.com/code360/problems/subsequences-of-string_985087?leftPanelTab=0&utm_source=youtube&utm_medium=affiliate&utm_campaign=love_babbar_16

import java.util.ArrayList;

public class SubsequencesofString {

    public static ArrayList<String> ans = new ArrayList<>();

    public static void subset(String str, StringBuilder subAns, int index) {
        if (index == str.length()) {
            if (subAns.length() > 0) {
                ans.add(subAns.toString());
            }
            return;
        }

        // Include the current character
        subset(str, subAns.append(str.charAt(index)), index + 1);

        // Exclude the current character
        subAns.deleteCharAt(subAns.length() - 1);
        subset(str, subAns, index + 1);
    }

    public static ArrayList<String> subsequences(String str) {
        subset(str, new StringBuilder(), 0);

        return ans;
    }

    public static void main(String[] args) {
        ArrayList<String> result = subsequences("abc");
        System.out.println(result);
    }
}
