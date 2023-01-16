package com.dsa.geeksforgeek.stack;

import java.util.Stack;

public class AreaOfHistorgram {
    //This code uses a stack to keep track of the indices of the histogram bars. It iterates through the array of bars and for every new bar,
    // it checks the top of the stack. If the current bar is taller than the bar on the top of the stack,
    // it pushes the index of the current bar onto the stack.
    // If the current bar is shorter than the bar on the top of the stack,
    // it pops the top of the stack and calculates the area of the rectangle that it represents. The maximum area is kept track of and returned at the end.
    //This approach has a time complexity of O(n) and space complexity of O(n)
    public static int findMaxArea(int[] histogram) {
        Stack<Integer> stack = new Stack<>(); // stack to keep track of the indices of the histogram bars
        int maxArea = 0; // variable to keep track of the maximum area
        int i = 0; // iterator for iterating through the histogram array
        // iterate through the histogram array
        while (i < histogram.length) {
            if (stack.isEmpty() || histogram[stack.peek()] <= histogram[i]) {
                stack.push(i++); // push the current index onto the stack if the stack is empty or the current bar is taller than the bar on the top of the stack
            } else {
                int top = stack.pop(); // if the current bar is shorter than the bar on the top of the stack, pop the top of the stack
                int area = histogram[top] * (stack.isEmpty() ? i : i - stack.peek() - 1); // calculate the area of the rectangle represented by the popped bar
                maxArea = Math.max(maxArea, area); // update the maximum area if the current area is greater
            }
        }
        // check for any remaining bars on the stack
        while (!stack.isEmpty()) {
            int top = stack.pop(); // pop the top of the stack
            int area = histogram[top] * (stack.isEmpty() ? i : i - stack.peek() - 1); // calculate the area of the rectangle represented by the popped bar
            maxArea = Math.max(maxArea, area); // update the maximum area if the current area is greater
        }
        return maxArea; // return the maximum area
    }

    //Dry Run:
    //Let's dry run the above code with histogram = {6, 2, 5, 4, 5, 1, 6}
    //
    //The first element of the histogram is 6 and stack is empty so we push 6 into stack.
    //The next element of the histogram is 2 which is less than 6 so we pop 6 and calculate the area of rectangle = height of 6*(current index - stack top -1) = 6*(1-0-1) = 0. Since this area is 0 which is less than maxArea = 0, maxArea is not updated.
    //The next element of the histogram is 5 which is greater than 2 so we push 5 into the stack.
    //The next element of the histogram is 4 which is less than 5 so we pop 5 and calculate the area of rectangle = height of 5*(current index - stack top -1) = 5*(3-1-1) = 8. Since this area is greater than maxArea = 0, maxArea is updated to 8.
    //The next element of the histogram is 5 which is greater than 4 so we push 5 into the stack.
    //The next element of the histogram is 1

    public static void main(String[] args) {
        int[] histogram = {6, 2, 5, 4, 5, 1, 6};
        System.out.println("Max area of histogram: " + findMaxArea(histogram));
    }
}
