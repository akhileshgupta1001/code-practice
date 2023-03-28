package com.dsa.geeksforgeek.stack;

import java.util.Stack;

public class ValidParentheses {
    public boolean isOpening(char c) {
        return c == '(' || c == '{' || c == '[';
    }

    public boolean isMatching(char start, char end) {
        return (start == '(' && end == ')')
                || (start == '{' && end == '}')
                || (start == '[' && end == ']');
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (isOpening(current)) {
                stack.push(current);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else if (!isMatching(stack.peek(), current)) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid("()[]{}"));
    }
}
