package com.dsa.scaller.stack;

import java.util.Stack;

public class RemovingStarsFromString {
    public String removeStars(String s) {
        Stack<Character>
                stack = new Stack<>();
        int n = s.length();
        int currentIndex=0;
        while(n>0){
            char currentChar = s.charAt(currentIndex);
            currentIndex++;
            n--;
            while(!stack.isEmpty() && (currentChar=='*')){
                stack.pop();
                currentChar='#';
            }
            //char top = !stack.isEmpty()?stack.peek():currentChar;
            if(currentChar!='*' && currentChar!='#')
            stack.push(currentChar);
        }
        System.out.println("Ans : "+stack);
        return "";

    }

    public static void main(String[] args) {
        RemovingStarsFromString removingStarsFromString= new RemovingStarsFromString();
        removingStarsFromString.removeStars("leet**cod*e");
    }
}
