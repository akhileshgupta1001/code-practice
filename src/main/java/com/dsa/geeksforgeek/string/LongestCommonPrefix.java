package com.dsa.geeksforgeek.string;

import java.util.Arrays;

public class LongestCommonPrefix {
    //Input: strs = ["flower","flow","flight"]
    //Output: "fl"

    //Input: strs = ["dog","racecar","car"]
    //Output: ""
    //Explanation: There is no common prefix among the input strings.

    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length==0) return "";
        int i=1;
        String pre = strs[0];

        while (i<strs.length){
            while (strs[i].indexOf(pre) !=0){
                pre = pre.substring(0,pre.length()-1);
            }
            i++;
        }

        return pre;

    }

    public static String longestCommonPrefix2(String[] strs) {
        if(strs == null || strs.length==0) return "";

        Arrays.sort(strs);

        StringBuilder sb = new StringBuilder();

        char[] first = strs[0].toCharArray();
        char[] last = strs[strs.length-1].toCharArray();
        String result ="";

        for(int i=0;i< first.length;i++){
            if(first[i]==last[i]){
            result = result+first[i];
            }else {
                return result;
            }
        }

        return result;

    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix2(new String[] {"flower","flow","flight"}));
    }

}
