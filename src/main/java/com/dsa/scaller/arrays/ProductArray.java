package com.dsa.scaller.arrays;

import java.util.ArrayList;

public class ProductArray {
    //Given an array of integers A, find and return the product array of the same size where the ith element of the product array will be equal to the product of all the elements divided by the ith element of the array.
    //
    //Note: It is always possible to form the product array with integer (32 bit) values. Solve it without using the division operator.
    //
    //
    //Input Format
    //
    //The only argument given is the integer array A.
    //Output Format
    //
    //Return the product array.
    //Constraints
    //
    //2 <= length of the array <= 1000
    //1 <= A[i] <= 10
    //For Example
    //
    //Input 1:
    //    A = [1, 2, 3, 4, 5]
    //Output 1:
    //    [120, 60, 40, 30, 24]
    //
    //Input 2:
    //    A = [5, 1, 10, 1]
    //Output 2:
    //    [10, 50, 5, 50]


    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        int n = A.size();
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = A.get(0);
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * A.get(i);
        }
        suffix[n - 1] = A.get(n - 1);

        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * A.get(i);
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                ans.add(suffix[i + 1]);
            } else if (i == n - 1) {
                ans.add(prefix[i - 1]);
            } else {
                ans.add(prefix[i - 1] * suffix[i + 1]);
            }
        }
        return ans;
    }
}
