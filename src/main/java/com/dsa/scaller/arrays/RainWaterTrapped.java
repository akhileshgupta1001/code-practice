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
}
