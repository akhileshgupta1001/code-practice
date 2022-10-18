package com.dsa.geeksforgeek.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreviousGreaterElement {

    // 20 ,30, 10,5,15
    //30
    // 0(n)
    public static List<Integer> getPreviousGreaterElement(int[] arr){
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack();
         stack.add(arr[0]);
         list.add(-1);
        for(int i =1;i<arr.length;i++){

            while (!stack.isEmpty() && stack.peek()<= arr[i]){
              stack.pop();
            }
            list.add(stack.isEmpty()?-1:stack.peek());
            stack.add(arr[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(getPreviousGreaterElement(new int[]{20 ,30, 10,5,15}));
    }

}
