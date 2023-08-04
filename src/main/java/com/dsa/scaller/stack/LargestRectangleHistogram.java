package com.dsa.scaller.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class LargestRectangleHistogram {
    //Problem Description
    //Given an array of integers A.
    //
    //A represents a histogram i.e A[i] denotes the height of the ith histogram's bar. Width of each bar is 1.
    //
    //Find the area of the largest rectangle formed by the histogram.
    //
    //
    //
    //Problem Constraints
    //1 <= |A| <= 100000
    //
    //1 <= A[i] <= 10000
    //
    //
    //
    //Input Format
    //The only argument given is the integer array A.
    //
    //
    //
    //Output Format
    //Return the area of the largest rectangle in the histogram.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = [2, 1, 5, 6, 2, 3]
    //Input 2:
    //
    // A = [2]
    //
    //
    //Example Output
    //Output 1:
    //
    // 10
    //Output 2:
    //
    // 2
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    //The largest rectangle has area = 10 unit. Formed by A[3] to A[4].
    //Explanation 2:
    //
    //Largest rectangle has area 2.

    ArrayList<Integer> leftSmall(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> leftSmallIndices = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            int data = A.get(i);
            while (!stack.isEmpty() && A.get(stack.peek()) >= data) {
                stack.pop();
            }

            int current = stack.isEmpty() ? -1 : stack.peek();
            leftSmallIndices.add(current);
            stack.push(i);
        }
        System.out.println("Left small : "+ leftSmallIndices);
        return leftSmallIndices;
    }

    ArrayList<Integer> rightSmall(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> rightSmallIndices = new ArrayList<>();
        for (int i = A.size() - 1; i >= 0; i--) {
            int data = A.get(i);
            while (!stack.isEmpty() && A.get(stack.peek()) >= data) {
                stack.pop();
            }

            int current = stack.isEmpty() ? A.size() : stack.peek();
            rightSmallIndices.add(current);
            stack.push(i);
        }
        Collections.reverse(rightSmallIndices);
        System.out.println("Right small : "+ rightSmallIndices);
        return rightSmallIndices;
    }

    public int largestRectangleArea(ArrayList<Integer> A) {
        if (A.size() == 0) return 0;
        if (A.size() == 1) return A.get(0);

        int ans = Integer.MIN_VALUE;
        ArrayList<Integer> leftSmall = leftSmall(A);
        ArrayList<Integer> rightSmall = rightSmall(A);

        for (int i = 0; i < A.size(); i++) {
            int width = (rightSmall.get(i) - leftSmall.get(i) - 1);
            System.out.println(width);
            ans = Math.max(ans, A.get(i) * width);
        }

        return ans;
    }

    public static void main(String[] args) {
        LargestRectangleHistogram largestRectangleHistogram = new LargestRectangleHistogram();
        largestRectangleHistogram.largestRectangleArea(new ArrayList<>(Arrays.asList(2, 1, 5, 6, 2, 3)));
    }
}
