package com.dsa.geeksforgeek.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

    public static int[] previousSmallerElement(int[] arr){
        int[] prevSmaller = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<arr.length;i++){
            // If top element is smaller than remove the top
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            // If element is greater than top element then add into result list
            int previousGreather = stack.isEmpty()?-1: stack.peek();
            prevSmaller[i]=previousGreather;
            stack.push(i);
        }
        return prevSmaller;
    }
    public static int[] nextSmallerElement(int[] arr){
        int[] prevSmaller = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        //stack.push(-1);
        for(int i = arr.length - 1; i >= 0; i--){
            while (!stack.isEmpty() && arr[stack.peek()]>=arr[i]){
                stack.pop();
            }
            int current = stack.isEmpty()?-1: stack.peek();
            prevSmaller[i] = current;
            stack.add(i);
        }
        return prevSmaller;
    }

    public static int getMaxAreaOfHistogram(int[] arr){
        int n = arr.length;
        int[] prevSmaller = previousSmallerElement(arr);
        int[] nextSmaller = nextSmallerElement(arr);
        System.out.println("*******PrevSmaller************");
        for(int i=0;i<prevSmaller.length;i++){
            System.out.print(prevSmaller[i]+" ");
        }
        System.out.println();
        System.out.println("*******nextSmaller************");
        for(int i=0;i<nextSmaller.length;i++){
            System.out.print(nextSmaller[i]+" ");
        }
        System.out.println();

        int maxArea = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            int length = arr[i];
            if(nextSmaller[i] == -1) {
                nextSmaller[i] = n;
            }
            int width = (nextSmaller[i]-prevSmaller[i]-1);
            int area = length * width;
            maxArea = Math.max(area,maxArea);
        }
        return maxArea;
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
      //  System.out.println(getLongestRectangularArea(new int[]{ 6, 2, 5, 4, 5, 1, 6 }));
       // System.out.println(getMaxAreaOfHistogram(new int[]{ 6, 2, 5, 4, 5, 1, 6 }));
       //int[] arr = {2,1,5,6,2,3};
        System.out.println(getMaxAreaOfHistogram(new int[]{2,1,2}));

    }
}
