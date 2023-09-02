package com.dsa.scaller.backtracking;

import java.util.ArrayList;

public class LetterPhone {
    //Problem Description
    //Given a digit string A, return all possible letter combinations that the number could represent.
    //
    //A mapping of digit to letters (just like on the telephone buttons) is given below.
    //
    //
    //
    //The digit 0 maps to 0 itself. The digit 1 maps to 1 itself.
    //
    //NOTE: Make sure the returned strings are lexicographically sorted.
    //
    //
    //
    //Problem Constraints
    //1 <= |A| <= 10
    //
    //
    //
    //Input Format
    //The only argument is a digit string A.
    //
    //
    //
    //Output Format
    //Return a string array denoting the possible letter combinations.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = "23"
    //Input 2:
    //
    // A = "012"
    //
    //
    //Example Output
    //Output 1:
    //
    // ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
    //Output 2:
    //
    // ["01a", "01b", "01c"]
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // There are 9 possible letter combinations.
    //Explanation 2:
    //
    // Only 3 possible letter combinations.
    //
    //
    //
    //Expected Output
    //Provide sample input and click run to see the correct output for the provided input. Use this to improve your problem understanding and test edge cases

    ArrayList<String> ans = new ArrayList<>();
    public static String[] keypad = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public ArrayList<String> letterCombinations(String A) {

        letterPhone(A, "", 0);
        return ans;
    }

    private void letterPhone(String A, String output, int index) {
        if (index == A.length()) {
            ans.add(output);
            return;
        }

        char current = A.charAt(index);
        String mapping = keypad[current - '0'];
        for (int i = 0; i < mapping.length(); i++) {
            letterPhone(A, output + mapping.charAt(i), index + 1);
        }
    }


}
