package com.dsa.scaller.arrays;

import java.util.ArrayList;

public class AddOneToNumber {
    //Problem Description
    //Given a non-negative number represented as an array of digits, add 1 to the number ( increment the number represented by the digits ).
    //
    //The digits are stored such that the most significant digit is at the head of the list.
    //
    //NOTE: Certain things are intentionally left unclear in this question which you should practice asking the interviewer. For example: for this problem, the following are some good questions to ask :
    //
    //Q: Can the input have 0's before the most significant digit. Or, in other words, is 0 1 2 3 a valid input?
    //A: For the purpose of this question, YES
    //Q: Can the output have 0's before the most significant digit? Or, in other words, is 0 1 2 4 a valid output?
    //A: For the purpose of this question, NO. Even if the input has zeroes before the most significant digit.
    //
    //
    //Problem Constraints
    //1 <= size of the array <= 1000000
    //
    //
    //
    //Input Format
    //First argument is an array of digits.
    //
    //
    //
    //Output Format
    //Return the array of digits after adding one.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //[1, 2, 3]
    //
    //
    //Example Output
    //Output 1:
    //
    //[1, 2, 4]
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    //Given vector is [1, 2, 3].
    //The returned vector should be [1, 2, 4] as 123 + 1 = 124.

    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int n = A.size();
        int ans = 0;
        int cary = 1;
        for (int i = n - 1; i >= 0; i--) {
            ans = A.get(i);
            ans = ans + cary;
            cary = 0;
            if (ans == 10) {
                ans = 0;
                cary = 1;
            }
            A.set(i, ans);
        }
        ArrayList<Integer> result = new ArrayList<>();
        if (cary == 1) result.add(1);
        for (int data : A) {
            if (data == 0 && result.size() == 0) {
                continue;
            }
            result.add(data);
        }
        return result;
    }
}