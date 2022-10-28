package com.dsa.geeksforgeek.string;

public class FirstLeftRepeatingCharacter {
    public static int leftMostCharacter(String str){
        int characterCount = 256;
        char[] arr = new char[characterCount];
        for (int i=0;i<str.length();i++){
            arr[str.charAt(i)]++;
        }
        for(int i=0;i<str.length();i++){
            if(arr[str.charAt(i)]>1)
                return i;
        }

        return -1;
    }
    public static void main(String[] args) {
       // System.out.println(leftMostCharacter("abccbd"));
        System.out.println(leftMostCharacter("loveleetcode"));
    }
}
