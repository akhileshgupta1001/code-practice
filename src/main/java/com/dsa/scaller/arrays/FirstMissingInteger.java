package com.dsa.scaller.arrays;

import java.util.ArrayList;
import java.util.Collections;

public class FirstMissingInteger {
    //Problem Description
    //Given an unsorted integer array, A of size N. Find the first missing positive integer.
    //
    //Note: Your algorithm should run in O(n) time and use constant space.
    //
    //
    //
    //Problem Constraints
    //1 <= N <= 1000000
    //
    //-109 <= A[i] <= 109
    //
    //
    //
    //Input Format
    //First argument is an integer array A.
    //
    //
    //
    //Output Format
    //Return an integer denoting the first missing positive integer.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //[1, 2, 0]
    //Input 2:
    //
    //[3, 4, -1, 1]
    //Input 3:
    //
    //[-8, -7, -6]
    //
    //
    //Example Output
    //Output 1:
    //
    //3
    //Output 2:
    //
    //2
    //Output 3:
    //
    //1
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    //A = [1, 2, 0]
    //First positive integer missing from the array is 3.

    public int firstMissingPositive(ArrayList<Integer> A) {

        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) > 0 && A.get(i) <= A.size()) {
                int pos = A.get(i) - 1;
                if (A.get(i) != A.get(pos)) {
                    Collections.swap(A, pos, i);
                    i--;
                }
            }
        }
       // Collections.reverse(new ArrayList<>(),0,5);
        for (int i = 0; i < A.size(); i++) {
            if (A.get(i) != i + 1) {
                return i + 1;
            }
        }
        return A.size() + 1;
    }

}
