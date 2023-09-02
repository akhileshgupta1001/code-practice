package com.dsa.scaller.backtracking;

import java.util.ArrayList;
import java.util.HashMap;

//Problem Description
//Given an array of integers A, the array is squareful if for every pair of adjacent elements, their sum is a perfect square.
//
//Find and return the number of permutations of A that are squareful. Two permutations A1 and A2 differ if and only if there is some index i such that A1[i] != A2[i].
//
//
//
//Problem Constraints
//1 <= length of the array <= 12
//
//1 <= A[i] <= 109
//
//
//
//Input Format
//The only argument given is the integer array A.
//
//
//
//Output Format
//Return the number of permutations of A that are squareful.
//
//
//
//Example Input
//Input 1:
//
// A = [2, 2, 2]
//Input 2:
//
// A = [1, 17, 8]
//
//
//Example Output
//Output 1:
//
// 1
//Output 2:
//
// 2
//
//
//Example Explanation
//Explanation 1:
//
// Only permutation is [2, 2, 2], the sum of adjacent element is 4 and 4 and both are perfect square.
//Explanation 2:
//
// Permutation are [1, 8, 17] and [17, 8, 1].


public class NumberofSquarefulArrays {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    public HashMap<Integer, Integer> frequencyCount(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {

            if (map.containsKey(A[i])) {
                map.put(A[i], map.get(A[i]) + 1);
            } else {
                map.put(A[i], 1);
            }
        }

        return map;
    }


    public void permuteOfNumber(HashMap<Integer, Integer> frequencyCount, ArrayList<Integer> subAns, int index, int size) {

        if (index >= size) {
            ans.add(new ArrayList<>(subAns));
            return;
        }

        for (Integer keys : frequencyCount.keySet()) {
            if (frequencyCount.get(keys) > 0) {
                if (subAns.size() > 0) {
                    int isSquareful = subAns.get(subAns.size() - 1) + keys;
                    if (isPerfectSquare(isSquareful) == false) {
                        continue;
                    }
                }
                frequencyCount.put(keys, frequencyCount.get(keys) - 1);
                subAns.add(keys);
                permuteOfNumber(frequencyCount, subAns, index + 1, size);
                frequencyCount.put(keys, frequencyCount.get(keys) + 1);
                subAns.remove(subAns.size() - 1);
            }
        }

    }

    public boolean isPerfectSquare(int num) {
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }

    public int solve(int[] A) {
        // ans.clear(); // Clear the ArrayList before generating permutations for a new test case
        HashMap<Integer, Integer> frequencyCount = frequencyCount(A);
        permuteOfNumber(frequencyCount, new ArrayList<Integer>(), 0, A.length);
        int count = 0;

        if (A.length == 1) {
            count = isSquareful(new ArrayList<>(frequencyCount.keySet())) ? 1 : 0;
        } else {
            count = ans.size();
        }

        return count;
    }


    // Function to check if the permutation has squareful adjacent sums
    private boolean isSquareful(ArrayList<Integer> data) {
        if (data.size() == 1) {
            return isPerfectSquare(data.get(0));
        }
        for (int i = 1; i < data.size(); i++) {
            int sum = data.get(i - 1) + data.get(i);
            if (!isPerfectSquare(sum)) {
                return false;
            }
        }
        return true;
    }
}
