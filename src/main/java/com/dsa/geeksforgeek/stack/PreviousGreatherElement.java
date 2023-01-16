package com.dsa.geeksforgeek.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class PreviousGreatherElement {

    // int[] arr = new  int[]{13 , 7, 6 , 12 };
    public static List<Integer> getPreviousEJustGreaterlement(int[] arr){
        List<Integer> list = new ArrayList<>();
        list.add(-1);
        int j=0;
        for(int i=1;i<arr.length;i++){
             j=i;
             while(j>0){
                 if(arr[j-1]>arr[i]){
                     list.add(arr[j-1]);
                     break;
                 }
                 j--;
             }
        }
        System.out.println("Result : "+list);
        return list;
    }

    //Complexity Analysis:
    //Time Complexity: O(n). It seems more than O(n) at first look. If we take a closer look, we can observe that every element of array is added and removed from stack at most once. So there are total 2n operations at most. Assuming that a stack operation takes O(1) time, we can say that the time complexity is O(n).
    //Auxiliary Space: O(n) in worst case when all elements are sorted in decreasing order.
    public static List getPreviousGreatherElement(int[] arr){
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        System.out.println(Arrays.toString(result));
        return Arrays.asList(result);
    }
    public static void main(String[] args) {
        int[] arr = new  int[]{13 , 7, 6 , 12 };
        getPreviousEJustGreaterlement(arr);
    // getPreviousGreatherElement(new int[]{10, 4, 2, 20, 40, 12, 30});
    }
}
