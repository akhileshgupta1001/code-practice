package com.dsa.scaller.hasing;

import java.util.Arrays;
import java.util.HashMap;

public class Frequency {
    //Problem Description
    //Given an array A. You have some integers given in the array B.
    //
    //For the i-th number, find the frequency of B[i] in the array A and return a list containing all the frequencies.
    //
    //
    //
    //Problem Constraints
    //1 <= |A| <= 105
    //
    //1 <= |B| <= 105
    //
    //1 <= A[i] <= 105
    //
    //1 <= B[i] <= 105
    //
    //
    //
    //Input Format
    //First argument A is an array of integers.
    //
    //Second argument B is an array of integers denoting the queries.
    //
    //
    //
    //Output Format
    //Return an array of integers containing frequency of the each element in B.
    //
    //
    //
    //Example Input
    //Input 1:
    //A = [1, 2, 1, 1]
    //B = [1, 2]
    //Input 2:
    //A = [2, 5, 9, 2, 8]
    //B = [3, 2]
    //
    //
    //Example Output
    //Output 1:
    //[3, 1]
    //Output 2:
    //[0, 2]
    //
    //
    //Example Explanation
    //For Input 1:
    //The frequency of 1 in the array A is 3.
    //The frequency of 2 in the array A is 1.
    //For Input 2:
    //The frequency of 3 in the array A is 0.
    //The frequency of 2 in the array A is 2.

    public static int[] solve(int[] A, int[] B) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            int data = A[i];
            if (map.containsKey(data)) {
                map.put(data, map.get(data) + 1);
            } else {
                map.put(data, 1);
            }
        }

        for (int i = 0; i < B.length; i++) {

            if (map.containsKey(B[i]))
                B[i] = (int) map.get(B[i]);
        }
       // System.out.println();
        Arrays.asList(B).stream().forEach(System.out::println);
        return B;
    }

    public static void main(String[] args) {
        solve(new int[]{6, 3, 3, 6, 7, 8, 7, 3, 7 },new int[]{10, 9, 8});
    }
}
