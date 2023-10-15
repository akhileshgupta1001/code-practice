package com.dsa.scaller.binarysearch;

import java.util.Collections;
import java.util.List;

//Problem Description
//Farmer John has built a new long barn with N stalls. Given an array of integers A of size N where each element of the array represents the location of the stall and an integer B which represents the number of cows.
//
//His cows don't like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from hurting each other, John wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?
//
//
//
//Problem Constraints
//2 <= N <= 100000
//0 <= A[i] <= 109
//2 <= B <= N
//
//
//
//Input Format
//The first argument given is the integer array A.
//The second argument given is the integer B.
//
//
//
//Output Format
//Return the largest minimum distance possible among the cows.
//
//
//
//Example Input
//Input 1:
//
//A = [1, 2, 3, 4, 5]
//B = 3
//Input 2:
//
//A = [1, 2]
//B = 2
//
//
//Example Output
//Output 1:
//
// 2
//Output 2:
//
// 1
//
//
//Example Explanation
//Explanation 1:
//
// John can assign the stalls at location 1, 3 and 5 to the 3 cows respectively. So the minimum distance will be 2.
//Explanation 2:
//
// The minimum distance will be 1.

public class AggressiveCows {
    // Function to check if it's possible to place 'k' cows with a minimum distance 'mid' in the stalls.
    public boolean isPossible(List<Integer> stalls, int k, int mid, int n) {
        int cowCount = 1;
        int lastPos = stalls.get(0);

        // Iterate through the stalls to check if cows can be placed with the given minimum distance.
        for (int i = 0; i < n; i++) {
            if (stalls.get(i) - lastPos >= mid) {
                cowCount++;
                if (cowCount == k) {
                    return true;
                }
                lastPos = stalls.get(i);
            }
        }
        return false;
    }

    // Main function to find the maximum minimum distance for 'k' cows in the stalls.
    public int aggressiveCows(List<Integer> stalls, int k) {
        Collections.sort(stalls); // Sort the stalls in ascending order.
        int s = 0; // Initialize the lower bound of the search range.
        int n = stalls.size(); // Get the total number of stalls.
        int e = stalls.get(n - 1); // Initialize the upper bound of the search range.
        int ans = -1; // Initialize the answer to -1.
        int mid = s + (e - s) / 2; // Calculate the initial midpoint.

        // Perform binary search to find the maximum minimum distance.
        while (s <= e) {
            if (isPossible(stalls, k, mid, n)) {
                ans = mid; // Update the answer with the current midpoint.
                s = mid + 1; // Adjust the lower bound of the range.
            } else {
                e = mid - 1; // Adjust the upper bound of the range.
            }
            mid = s + (e - s) / 2; // Calculate the next midpoint.
        }
        return ans; // Return the maximum minimum distance.
    }
}
