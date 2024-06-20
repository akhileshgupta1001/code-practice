package com.dsa.scaller.arrays;

import java.util.List;

public class RainWaterTrapped {
    //Problem Description
    //Given a vector A of non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
    //
    //
    //
    //Problem Constraints
    //1 <= |A| <= 100000
    //
    //
    //
    //Input Format
    //First and only argument is the vector A
    //
    //
    //
    //Output Format
    //Return one integer, the answer to the question
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //A = [0, 1, 0, 2]
    //Input 2:
    //
    //A = [1, 2]
    //
    //
    //Example Output
    //Output 1:
    //
    //1
    //Output 2:
    //
    //0
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    //1 unit is trapped on top of the 3rd element.
    //Explanation 2:
    //
    //No water is trapped.

    // lmax []
    // rmax[]
    // ans = Min()-Height[i];


    public int trap(final List<Integer> A) {
        int[] rightMax = new int[A.size()];
        int n = A.size();
        rightMax[n - 1] = A.get(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], A.get(i));
        }

        int leftMax = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            leftMax = Math.max(leftMax, A.get(i));
            ans = ans + Math.min(rightMax[i], leftMax) - A.get(i);
        }
        return ans;
    }

    public int trap(final int[] heights) {
        // Initialize left and right pointers to the beginning and end of the heights array.
        int leftIndex = 0;
        int rightIndex = heights.length - 1;

        // Move the left pointer until it finds a bar higher than the next one or until it reaches the right pointer.
        while (leftIndex < rightIndex && heights[leftIndex] <= heights[leftIndex + 1]) leftIndex++;
        // Move the right pointer until it finds a bar higher than the previous one or until it reaches the left pointer.
        while (leftIndex < rightIndex && heights[rightIndex] <= heights[rightIndex - 1]) rightIndex--;

        // Initialize the variable to hold the total amount of water trapped.
        int waterTrapped = 0;

        // Iterate until the left pointer surpasses the right pointer.
        while (leftIndex < rightIndex) {
            // Get the heights of the bars at the left and right pointers.
            int leftHeight = heights[leftIndex];
            int rightHeight = heights[rightIndex];

            // If the left bar is lower or equal to the right one, calculate the trapped water on the left side.
            if (leftHeight <= rightHeight) {
                // Move the left pointer until a higher bar is found and accumulate trapped water.
                while (leftIndex < rightIndex && leftHeight >= heights[leftIndex]) {
                    waterTrapped += leftHeight - heights[leftIndex];
                    leftIndex++;
                }
            }
            // If the right bar is lower than the left one, calculate the trapped water on the right side.
            else {
                // Move the right pointer until a higher bar is found and accumulate trapped water.
                while (leftIndex < rightIndex && rightHeight >= heights[rightIndex]) {
                    waterTrapped += rightHeight - heights[rightIndex];
                    rightIndex--;
                }
            }
        }
        // Return the total amount of water trapped between the bars.
        return waterTrapped;
    }
}
