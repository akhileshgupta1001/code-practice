package com.dsa.scaller.hasing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class CountPairSum {
    //Problem Description
    //You are given an array A of N integers and an integer B. Count the number of pairs (i,j) such that A[i] + A[j] = B and i ≠ j. Since the answer can be very large, return the remainder after dividing the count with 109+7.
    //
    //Note - The pair (i,j) is same as the pair (j,i) and we need to count it only once.
    //
    //
    //Problem Constraints
    //1 <= N <= 105
    //1 <= A[i] <= 109
    //1 <= B <= 109
    //
    //
    //Input Format
    //First argument A is an array of integers and second argument B is an integer.
    //
    //
    //Output Format
    //Return an integer.
    //
    //
    //Example Input
    //Input 1:
    //
    //A = [3, 5, 1, 2]
    //B = 8
    //Input 2:
    //
    //A = [1, 2, 1, 2]
    //B = 3
    //
    //
    //Example Output
    //Output 1:
    //
    //1
    //Output 2:
    //
    //4
    //
    //
    //Example Explanation
    //Example 1:
    //
    //The only pair is (1, 2) which gives sum 8
    //Example 2:
    //
    //The pair which gives sum as 3 are (1, 2), (1, 4), (2, 3) and (3, 4).

    public static int solve(ArrayList<Integer> A, int B) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < A.size(); i++) {

            int data = A.get(i);
            int b = B - data;
            if (map.containsKey(b)) {
                ans = ans + map.get(b);
            }
            if (map.containsKey(data)) {
                map.put(data, map.get(data) + 1);
            } else {
                map.put(data, 1);
            }
        }
        return ans % 1000000007;
    }


    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<>(Arrays.asList(1, 1, 16, 16, 7, 7, 16, 4, 19)), 5));
    }
}
