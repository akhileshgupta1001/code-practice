package com.dsa.geeksforgeek.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StockSpanProblem {
    //nput: N = 7, price[] = [100 80 60 70 60 75 85]
    //Output: 1 1 1 2 1 4 6
    //Explanation: Traversing the given input span for 100 will be 1, 80 is smaller than 100 so the span is 1, 60 is smaller than 80 so the span is 1, 70 is greater than 60 so the span is 2 and so on. Hence the output will be 1 1 1 2 1 4 6.
    //
    //Input: N = 6, price[] = [10 4 5 90 120 80]
    //Output:1 1 2 4 5 1
    //Explanation: Traversing the given input span for 10 will be 1, 4 is smaller than 10 so the span will be 1, 5 is greater than 4 so the span will be 2 and so on. Hence, the output will be 1 1 2 4 5 1.

    public static List<Integer> getStockSpanProblem(int[] arr) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        int j = 0;
        for (int i = 1; i < arr.length; i++) {
            int count = 1;
            j = i;
            while (j > 0 && arr[i] > arr[j - 1]) {
                count++;
                j--;
            }
            list.add(count);
        }
        System.out.println("Result : " + list);
        return list;
    }

    //Time Complexity: O(N). It seems more than O(N) at first look. If we take a closer look, we can observe that every element of the array is added and removed from the stack at most once.
    //Auxiliary Space: O(N) in the worst case when all elements are sorted in decreasing order.
    public static void printStockSpanProblem(int[] prices) {

        int[] spans = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] <= prices[i]) {
                stack.pop();
            }

            spans[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());
            stack.push(i);
        }
        System.out.println(Arrays.toString(spans));
    }


    public static void main(String[] args) {
        // int[] arr = new int[] {100, 80 ,60 ,70, 60 ,75 ,85};
        int[] arr = new int[]{10, 4, 5, 90, 120, 80};
        printStockSpanProblem(arr);
    }

}
