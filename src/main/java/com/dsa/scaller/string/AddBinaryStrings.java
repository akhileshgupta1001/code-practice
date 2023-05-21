package com.dsa.scaller.string;

public class AddBinaryStrings {
    //Problem Description
    //Given two binary strings A and B. Return their sum (also a binary string).
    //
    //
    //Problem Constraints
    //1 <= length of A <= 105
    //
    //1 <= length of B <= 105
    //
    //A and B are binary strings
    //
    //
    //
    //Input Format
    //The two argument A and B are binary strings.
    //
    //
    //
    //Output Format
    //Return a binary string denoting the sum of A and B
    //
    //
    //
    //Example Input
    //Input 1:
    //A = "100"
    //B = "11"
    //Input 2:
    //A = "110"
    //B = "10"
    //
    //
    //Example Output
    //Output 1:
    //"111"
    //Output 2:
    //"1000"
    //
    //
    //Example Explanation
    //For Input 1:
    //The sum of 100 and 11 is 111.
    //For Input 2:
    //
    //The sum of 110 and 10 is 1000.

    public String addBinary(String A, String B) {
        String ans = "";
        int cary = 0;
        int sum = 0;
        int i = A.length() - 1;
        int j = B.length() - 1;
        while (i >= 0 || j >= 0 || cary > 0) {
            sum = 0;
            if (i >= 0) {
                if (A.charAt(i) == '1') {
                    sum = sum + 1;
                }
            }
            if (j >= 0) {
                if (B.charAt(j) == '1') {
                    sum = sum + 1;
                }
            }

            sum = sum + cary;
            cary = sum / 2;
            sum = sum % 2;
            if (sum == 1) {
                ans = '1' + ans;
            } else {
                ans = '0' + ans;
            }
            i--;
            j--;

        }
        return ans;
    }
}
