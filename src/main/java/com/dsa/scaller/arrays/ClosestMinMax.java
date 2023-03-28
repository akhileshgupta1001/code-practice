package com.dsa.scaller.arrays;

import java.util.ArrayList;

public class ClosestMinMax {
    //Given an array A, find the size of the smallest subarray such that it contains at least one occurrence of the maximum value of the array
    //
    //and at least one occurrence of the minimum value of the array.
    //
    //
    //
    //Problem Constraints
    //1 <= |A| <= 2000
    //
    //
    //
    //Input Format
    //First and only argument is vector A
    //
    //
    //
    //Output Format
    //Return the length of the smallest subarray which has at least one occurrence of minimum and maximum element of the array
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //A = [1, 3, 2]
    //Input 2:
    //
    //A = [2, 6, 1, 6, 9]
    //
    //
    //Example Output
    //Output 1:
    //
    // 2
    //Output 2:
    //
    // 3
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // Take the 1st and 2nd elements as they are the minimum and maximum elements respectievly.
    //Explanation 2:
    //
    // Take the last 3 elements of the array.

    public int solve(ArrayList<Integer> A) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 0; i < A.size(); i++) {
            min = Math.min(min, A.get(i));
        }
        for (int i = 0; i < A.size(); i++) {
            max = Math.max(max, A.get(i));
        }
        if (max == min) return 1;
        int ans = A.size();
        int n = A.size();
        int lastMinIndex = -1;
        int lastMaxIndex = -1;

        for (int i = 0; i < n; i++) {
            if (A.get(i) == min) {
                lastMinIndex = i;
                if (lastMaxIndex >= 0) {
                    ans = Math.min(ans, i - lastMaxIndex + 1);
                }
            } else if (A.get(i) == max) {
                lastMaxIndex = i;
                if (lastMinIndex >= 0) {
                    ans = Math.min(ans, i - lastMinIndex + 1);
                }
            }
        }

        return ans;
    }
}
