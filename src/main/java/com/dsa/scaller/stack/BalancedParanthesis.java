package com.dsa.scaller.stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BalancedParanthesis {
    //Problem Description
    //Given an expression string A, examine whether the pairs and the orders of “{“,”}”, ”(“,”)”, ”[“,”]” are correct in A.
    //
    //Refer to the examples for more clarity.
    //
    //
    //
    //Problem Constraints
    //1 <= |A| <= 100
    //
    //
    //
    //Input Format
    //The first and the only argument of input contains the string A having the parenthesis sequence.
    //
    //
    //
    //Output Format
    //Return 0 if the parenthesis sequence is not balanced.
    //
    //Return 1 if the parenthesis sequence is balanced.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = {([])}
    //Input 2:
    //
    // A = (){
    //Input 3:
    //
    // A = ()[]
    //
    //
    //Example Output
    //Output 1:
    //
    // 1
    //Output 2:
    //
    // 0
    //Output 3:
    //
    // 1
    //
    //
    //Example Explanation
    //You can clearly see that the first and third case contain valid paranthesis.
    //
    //In the second case, there is no closing bracket for {, thus the paranthesis sequence is invalid.


    public int solve(String A) {
        //{([])}
        int len = A.length();
        if (len % 2 != 0) return 0;
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(')', '(');
        map.put(']', '[');
        Stack<Character> stack = new Stack<>();
        stack.add(A.charAt(0));
        for (int i = 1; i < len; i++) {
            char data = A.charAt(i);
            if (map.containsKey(data)) {
                char top = stack.isEmpty() == true ? '!' : stack.peek();
                if (top != map.get(data)) {
                    return 0;
                } else {
                    stack.pop();
                }
            } else {
                stack.push(data);
            }
        }
        return stack.isEmpty() == true ? 1 : 0;
    }
}
