package com.dsa.scaller.string;

public class ReverseString {
    static public String solve(String A) {
        char[] ch = A.toCharArray();
        int start =0;
        int end = ch.length-1;
        while(start<end){
            char temp = ch[start];
            ch[start] = ch[end];
            ch[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(ch);
    }

    public static void main(String[] args) {
        System.out.println(solve("scaler"));
    }
}
