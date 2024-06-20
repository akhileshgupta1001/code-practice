package com.dsa.scaller.stack;

import com.machine.coding.parkinglot.model.Status;

import javax.print.DocFlavor;
import java.sql.SQLOutput;
import java.util.Collections;
import java.util.Stack;

//Given an encoded string, return its decoded string.
//
//The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
//
//You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there will not be input like 3a or 2[4].
//
//The test cases are generated so that the length of the output will never exceed 105.
//
//
//
//Example 1:
//
//Input: s = "3[a]2[bc]"
//Output: "aaabcbc"
//Example 2:
//
//Input: s = "3[a2[c]]"
//Output: "accaccacc"
//Example 3:
//
//Input: s = "2[abc]3[cd]ef"
//Output: "abcabccdcdcdef"
//
//
//Constraints:
//
//1 <= s.length <= 30
//s consists of lowercase English letters, digits, and square brackets '[]'.
//s is guaranteed to be a valid input.
//All the integers in s are in the range [1, 300].
public class DecodeString {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char currentChar = s.charAt(i);
            if(currentChar !=']'){
                stack.add(currentChar);
            }else{
                //step 1:
                //if you find a closing ] then
                //retrieve the string it encapsulates
                StringBuilder subAns = new StringBuilder();
                while(!stack.isEmpty() && Character.isLetter(stack.peek())){
                    subAns.append(stack.peek());
                    stack.pop();
                }
                if(subAns.toString().length()>1)
                    subAns.reverse();

                if(stack.peek()=='['){
                    stack.pop();
                }

                //step 2:
                //after that get the number of
                // times it should repeat from stack

                if(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    int actualValue = Character.getNumericValue(stack.peek());
                    stack.pop();
                    for(int j=0;j<actualValue;j++){
                        sb.append(subAns);
                    }
                }


            }
        }
        while(!stack.isEmpty()){
            sb.append(stack.peek());
            stack.pop();
        }
        System.out.println("Ans : "+ sb);
        return sb.toString();
    }

    public String decodeString2(String s) {

        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray())
        {
            if(c != ']')
                stack.push(c); //push everything but ]

            else
            {
                //step 1:
                //if you find a closing ] then
                //retrieve the string it encapsulates

                StringBuilder sb = new StringBuilder();
                while(!stack.isEmpty() && Character.isLetter(stack.peek())){
                    sb.insert(0, stack.pop());
                    System.out.println("SB : "+sb);
                }


                String sub = sb.toString(); //this is the string contained in [ ]
                System.out.println("String sub = "+sub);
                stack.pop(); //Discard the '[';


                //step 2:
                //after that get the number of
                // times it should repeat from stack

                sb = new StringBuilder();
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    sb.insert(0, stack.pop());
                    System.out.println("SB : "+sb);
                }


                int count = Integer.valueOf(sb.toString()); //this is the number


                //step 3:
                //repeat the string within the [ ] count
                //number of times and push it back into stack

                while(count > 0)
                {
                    for(char ch : sub.toCharArray())
                        stack.push(ch);
                    count--;
                }
            }
        }

        //final fetching and returning the value in stack
        StringBuilder retv = new StringBuilder();
        while(!stack.isEmpty()){
            retv.insert(0, stack.pop());
            System.out.println("SB : "+retv);
        }


        System.out.println("Ans : "+retv);
        return retv.toString();
    }

    public String decodeString3(String s) {
        Stack<Integer> numbStack = new Stack<>();
        Stack<String> charStack = new Stack<>();
        int k =0;

        for(int i =0;i<s.length();i++){
            char currentChar = s.charAt(i);
            if(Character.isDigit(currentChar)){
                // numbStack.push(currentChar);
                k=(k*10)+(currentChar-'0');
            }else if(currentChar != ']'){
                if(currentChar == '[') {
                    numbStack.push(k);
                    k=0;
                }
                charStack.push(String.valueOf(currentChar));
            }else {
                StringBuilder sb = new StringBuilder();

                while(!charStack.isEmpty() && !charStack.peek().equals("[")){
                    sb.append(charStack.pop());

                }
                sb.reverse();
                //pop [
                charStack.pop();

                // Get data from num stack
                int currentNumber = numbStack.pop();
                String subAns= sb.toString();
                sb= new StringBuilder();
                for(int j=0;j<currentNumber;j++){
                    sb.append(subAns);
                }
                charStack.push(sb.toString());
            }
        }
        Collections.reverse(charStack);
        StringBuilder sb = new StringBuilder();
        while (!charStack.isEmpty()){
            sb.append(charStack.pop());
        }
        return sb.toString();

    }
    public static void main(String[] args) {
        DecodeString decodeString = new DecodeString();
        decodeString.decodeString3("3[z]2[2[y]pq4[2[jk]e1[f]]]ef");
       // decodeString.decodeString("3[a]2[bc]");
        //decodeString.decodeString("2[abc]3[cd]ef");
    }
}
