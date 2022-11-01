package com.dsa.geeksforgeek.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NextGreaterElement {

    // Find the Previous Greater element from reverse
    // Reverse the number

    public static List<Integer> getNextGreaterElement(int[] arr){
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.add(arr[arr.length-1]);
        stack.add(-1);
        for(int i=arr.length-2;i>=0;i--){

            while (!stack.isEmpty() && stack.peek()<=arr[i]){
                stack.pop();
            }
            list.add(stack.isEmpty()?-1:stack.peek());
            stack.add(arr[i]);
        }
        System.out.println("Previous : "+list);
        Collections.reverse(list);
        return  list;
    }

    public static void main(String[] args) {
       // System.out.println(getNextGreaterElement(new int[]{5,15,10,8,6,12,9,18})); // [15, 18, 12, 12, 12, 18, 18]
        System.out.println(getNextGreaterElement(new int[]{13 , 7, 6 , 12 })); // [15, 18, 12, 12, 12, 18, 18]

    }

}
