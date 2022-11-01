package com.dsa.geeksforgeek.stack;

import java.util.Stack;

public class LongestRectangularArea {

    //https://www.geeksforgeeks.org/largest-rectangle-under-histogram/

    // o(n2)
    public static int getLongestRectangularArea(int[] arr){
        int result =0;
        for(int i =0;i<arr.length;i++){
            int current = arr[i];
            // left
            for(int j=i-1;j>=0;j--){
                if(arr[j]>=arr[i]){
                    current = current+arr[i];
                }else {
                    break;
                }
            }
            // right
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]>=arr[i]){
                    current = current+arr[i];
                }else {
                    break;
                }
            }
            result = Math.max(result,current);
        }
        return result;
    }

    //O(n)
    // Push operation 1 == pop operation at every time
    public static int getLongestRectangularAreaUsingSatck(int[] arr){
        int result =0;
        int top ;
        int n = arr.length;
        int current = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i =0;i<arr.length;i++){

            while (!stack.isEmpty() && stack.peek()>= arr[i]){
                top = stack.peek();
                stack.pop();
                current = arr[top]*(stack.isEmpty()?i:i-stack.peek()-1);
                result = Math.max(result,current);
            }
            stack.add(i);
        }
        while (!stack.isEmpty()){
            top = stack.peek();
            stack.pop();
            current = arr[top]*(stack.isEmpty()?n:n-stack.peek()-1);
            result = Math.max(result,current);
        }
        return result;
    }



    public static void main(String[] args) {
        System.out.println(getLongestRectangularArea(new int[]{ 6, 2, 5, 4, 5, 1, 6 }));
    }
}
