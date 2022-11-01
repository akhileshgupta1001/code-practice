package com.dsa.geeksforgeek.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreviousGreatherElement {

    public static List<Integer> getPreviousGreatherElement(int[] arr){
      List<Integer> list= new ArrayList<>();
        Stack<Integer> stack = new Stack();
        for(int i =0;i<arr.length;i++){
            while (!stack.isEmpty() && stack.peek()<=arr[i]){
             stack.pop();
            }
            int previousGreather = stack.isEmpty()?-1:stack.peek();
            list.add(previousGreather);

            stack.push(arr[i]);

        }
        System.out.println("Result : "+ list);
        return list;
    }
    public static void main(String[] args) {
        int[] arr = new  int[]{13 , 7, 6 , 12 };
        getPreviousGreatherElement(arr);
    // getPreviousGreatherElement(new int[]{10, 4, 2, 20, 40, 12, 30});
    }
}
