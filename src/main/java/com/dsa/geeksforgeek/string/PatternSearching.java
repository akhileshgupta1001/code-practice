package com.dsa.geeksforgeek.string;

public class PatternSearching {
    public static void patternSearching(String txt, String pat) {

        int len1 = txt.length();
        int len2 = pat.length();

        for (int i = 0; i <= (len1 - len2); i++) {
            int j;
            for (j = 0; j < len2; j++) {
                if (pat.charAt(j) != txt.charAt(i+j)){
                    break;
                }
            }
            if (j == len2)
                System.out.print(i+" ");
        }
    }

    public static void main(String args[]) {
        String txt = "ABCABCD";
        String pat = "ABCD";
        System.out.print("All index numbers where pattern found: ");
        patternSearching(txt, pat);
    }
}
