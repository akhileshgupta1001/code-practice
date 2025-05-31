package com.dsa.scaller.dp;

import java.util.Stack;

public class LIS {
    //Problem Description
    //Find the longest increasing subsequence of a given array of integers, A.
    //
    //In other words, find a subsequence of array in which the subsequence's elements are in strictly increasing order, and in which the subsequence is as long as possible.
    //
    //In this case, return the length of the longest increasing subsequence.
    //
    //
    //
    //Problem Constraints
    //1 <= length(A) <= 2500
    //0 <= A[i] <= 2500
    //
    //
    //
    //Input Format
    //The first and the only argument is an integer array A.
    //
    //
    //
    //Output Format
    //Return an integer representing the length of the longest increasing subsequence.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = [1, 2, 1, 5]
    //Input 2:
    //
    // A = [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]
    //
    //
    //Example Output
    //Output 1:
    //
    // 3
    //Output 2:
    //
    // 6
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // The longest increasing subsequence: [1, 2, 5]
    //Explanation 2:
    //
    // The possible longest increasing subsequences: [0, 2, 6, 9, 13, 15] or [0, 4, 6, 9, 11, 15] or [0, 4, 6, 9, 13, 15]

    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int lis(final int[] A) {
        int[] len = new int[A.length];
        int[] prev = new int[A.length];
        int n = A.length;

        for (int i = 0; i < n; i++) {
            len[i] = 1;
            prev[i] = -1;

            for (int j = 0; j < i; j++) {
                if (A[j] < A[i] && len[j] >= len[i]) {
                    len[i] = len[j] + 1;
                    prev[i] = j;
                }
            }
        }

        int maxLength = 0;
        int endIndex = 0;

        for (int i = 0; i < n; i++) {
            if (len[i] > maxLength) {
                maxLength = len[i];
                endIndex = i;
            }
        }

        Stack<Integer> stack = new Stack<>();

        while (endIndex != -1) {
            stack.add(A[endIndex]);
            endIndex = prev[endIndex];
        }

        return maxLength;
    }

    public int lis2(final int[] A) {
        int ans = Integer.MIN_VALUE;
        int n = A.length;
        int[] lis = new int[n];

        for(int i=0;i<n ;i++){
            lis[i]=1;
            for(int j=0;j<i;j++){
                if(A[i]>A[j]){
                    lis[i] = Math.max(lis[i],lis[j]+1);
                }
            }
            ans = Math.max(ans , lis[i]);
        }
        return ans;
    }
}
