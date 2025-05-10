package com.dsa.scaller.twopointer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

///First negative integer in every window of size k
//https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1
public class FirstNegativeNumber {
    //Difficulty: MediumAccuracy: 48.61%Submissions: 152K+Points: 4
    //Given an array A[] of size N and a positive integer K, find the first negative integer for each and every window(contiguous subarray) of size K.
    //
    //
    //
    //Example 1:
    //
    //Input :
    //N = 5
    //A[] = {-8, 2, 3, -6, 10}
    //K = 2
    //Output :
    //-8 0 -6 -6
    //Explanation :
    //First negative integer for each window of size k
    //{-8, 2} = -8
    //{2, 3} = 0 (does not contain a negative integer)
    //{3, -6} = -6
    //{-6, 10} = -6
    //
    //Example 2:
    //Input :
    //N = 8
    //A[] = {12, -1, -7, 8, -15, 30, 16, 28}
    //K = 3
    //Output :
    //-1 -1 -7 -15 -15 0
    //
    //
    //Your Task:
    //You don't need to read input or print anything. Your task is to complete the function printFirstNegativeInteger() which takes the array A[], its size N and an integer K as inputs and returns the first negative number in every window of size K starting from the first till the end. If a window does not contain a negative integer , then return 0 for that window.
    //
    //
    //Expected Time Complexity: O(N)
    //Expected Auxiliary Space: O(K)
    //
    //Constraints:
    //1 <= N <= 105
    //-105 <= A[i] <= 105
    //1 <= K <= N
    //

    //A[] = {-8, 2, 3, -6, 10}
    //K = 2
    public static long[] printFirstNegativeInteger(long A[], int N, int K) {
        List<Long> ans = new ArrayList<>();
        Queue<Long> negatives = new LinkedList<>();
        int left = 0, right = 0;

        while (right < N) {
            // Add the current element to the negatives queue if it's negative
            if (A[right] < 0) {
                negatives.add(A[right]);
            }
            System.out.println("Negativenumbers = "+negatives+"    ,  right = "+right+" , left = "+left+ " , (right - left + 1 < K) = "+(right - left + 1 < K));
            // If the window size is smaller than K, just move the right pointer
            if (right - left + 1 < K) {
                right++;
            }
            // When the window size hits K
            else if (right - left + 1 == K) {
                // If there are any negatives in the queue, the first one is the answer for this window
                if (!negatives.isEmpty()) {
                    ans.add(negatives.peek());
                } else {
                    ans.add(0L);  // If no negatives, add 0
                }

                // Move the left pointer to shrink the window and update the negatives queue if necessary
                if (!negatives.isEmpty() && negatives.peek() == A[left]) {
                    negatives.poll();
                }
                left++;
                right++;
            }
        }

        // Convert the result list to an array
        long[] result = new long[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }


    public static void main(String[] args) {
       long[] arr= new long[]{-8 ,2 ,3 ,-6 ,10};
        printFirstNegativeInteger(arr, arr.length, 2);
        //48 974 5 -59 -451
       // arr= new long[]{48, 974, 5, -59, -451};
        //printFirstNegativeInteger(arr, arr.length, 3);
    }
}
