package com.dsa.geeksforgeek.recursuion;

public class Palindrome {

    static boolean isPalindrome(String str, int start, int end) {
        if (start >= end)
            return true;
        return (str.charAt(start) == str.charAt(end)
                && isPalindrome(str, start + 1, end - 1));
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("aba", 0, 2));
    }
}
