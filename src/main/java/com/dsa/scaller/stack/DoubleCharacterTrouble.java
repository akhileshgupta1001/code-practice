package com.dsa.scaller.stack;

import java.util.Stack;

public class DoubleCharacterTrouble {
    //Problem Description
    //You have a string, denoted as A.
    //
    //To transform the string, you should perform the following operation repeatedly:
    //Identify the first occurrence of consecutive identical pairs of characters within the string.
    //Remove this pair of identical characters from the string.
    //Repeat steps 1 and 2 until there are no more consecutive identical pairs of characters.
    //The final result will be the transformed string.
    //
    //
    //Problem Constraints
    //1 <= |A| <= 100000
    //
    //
    //
    //Input Format
    //First and only argument is string A.
    //
    //
    //
    //Output Format
    //Return the final string.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = "abccbc"
    //Input 2:
    //
    // A = "ab"
    //
    //
    //Example Output
    //Output 1:
    //
    // "ac"
    //Output 2:
    //
    // "ab"
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    //The Given string is "abccbc".
    //
    //Remove the first occurrence of consecutive identical pairs of characters "cc".
    //After removing the string will be "abbc".
    //
    //Again Removing the first occurrence of consecutive identical pairs of characters "bb".
    //After remvoing, the string will be "ac".
    //
    //Now, there is no consecutive identical pairs of characters.
    //Therefore the string after this operation will be "ac".
    //Explanation 2:
    //
    // No removals are to be done.


    public String solve(String A) {
        if (A.length() == 1) return A;
        Stack<Character> stack = new Stack<>();
        stack.push(A.charAt(0));

        for (int i = 1; i < A.length(); i++) {
            char data = A.charAt(i);

            if (!stack.isEmpty() && stack.peek() == data) {
                //  System.out.println("Pop : "+ data);
                while (!stack.isEmpty() && stack.peek() == data) {
                    stack.pop();
                }

            } else {
                stack.push(data);
            }
        }
        // System.out.println("stack : "+ stack);

        String ans = "";

        while (!stack.isEmpty()) {
            ans = String.valueOf(stack.pop()) + ans;
        }
        // System.out.println("Ans : "+ ans);
        return ans;
    }

    public String solve2(String A) {
        if(A.length()==1) return A;
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<A.length();i++){
            char data = A.charAt(i);

            if(stack.isEmpty() || stack.peek() != data){
                stack.push(data);
            }else{
                stack.pop();
            }

        }
        // System.out.println("stack : "+ stack);

        String ans ="";

        while(!stack.isEmpty()){
            ans = String.valueOf(stack.pop())+ans;
        }
        // System.out.println("Ans : "+ ans);
        return ans;
    }
}
