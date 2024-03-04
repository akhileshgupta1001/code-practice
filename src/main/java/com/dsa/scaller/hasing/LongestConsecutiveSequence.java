package com.dsa.scaller.hasing;

import java.util.HashSet;

//Problem Description
//Given an unsorted integer array A of size N.
//
//Find the length of the longest set of consecutive elements from array A.
//
//
//
//Problem Constraints
//1 <= N <= 106
//
//-106 <= A[i] <= 106
//
//
//
//Input Format
//First argument is an integer array A of size N.
//
//
//
//Output Format
//Return an integer denoting the length of the longest set of consecutive elements from the array A.
//
//
//
//Example Input
//Input 1:
//
//A = [100, 4, 200, 1, 3, 2]
//Input 2:
//
//A = [2, 1]
//
//
//Example Output
//Output 1:
//
// 4
//Output 2:
//
// 2
//
//
//Example Explanation
//Explanation 1:
//
// The set of consecutive elements will be [1, 2, 3, 4].
//Explanation 2:
//
// The set of consecutive elements will be [1, 2].


public class LongestConsecutiveSequence {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int longestConsecutive(final int[] A) {
        // Create a HashSet to store unique integers.
        HashSet<Integer> hs = new HashSet<>();

        // Add all elements from the input array "A" to the HashSet.
        for (int i = 0; i < A.length; i++) {
            hs.add(A[i]);
        }

        // Initialize the variable "ans" to store the longest consecutive sequence length.
        int ans = 0;

        // Iterate through the unique elements in the HashSet.
        for (int x : hs) {
            // Check if "x" is the start of a consecutive sequence by looking for "x-1" in the HashSet.
            if (!hs.contains(x - 1)) {
                int currentNum = x;
                int count = 1;

                // Continue counting the consecutive sequence using a while loop.
                while (hs.contains(currentNum + 1)) {
                    currentNum++;
                    count++;
                }

                // Update "ans" with the maximum value between the current "ans" and the "count" of the current sequence.
                ans = Math.max(ans, count);
            }
        }

        // Return the length of the longest consecutive sequence found.
        return ans;
    }
}

