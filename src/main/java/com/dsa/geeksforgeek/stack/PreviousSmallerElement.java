package com.dsa.geeksforgeek.stack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PreviousSmallerElement {

    // arr =[4,10,5,8,20,15,3,12]
    //[4, 4, 5, 8, 8, 3]

    public static List<Integer> getPreviousSmallerElement(int[] arr){
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<arr.length;i++){

            // If top element is smaller than remove the top
            while (!stack.isEmpty() && stack.peek()>= arr[i]){
                stack.pop();
            }

            // If element is greater than top element then add into result list
           /* if(!stack.isEmpty() && stack.peek()<arr[i]){
                list.add(stack.peek());
            }

*/
            int previousGreather = stack.isEmpty()?-1:stack.peek();
            list.add(previousGreather);

            stack.push(arr[i]);

            }

        System.out.println(list);
          return list;
        }

    public static void main(String[] args) {
        getPreviousSmallerElement(new int[]{4,10,5,8,20,15,3,12});
    }


}
