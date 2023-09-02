package com.dsa.scaller.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class AllUniquePermutations {
    //Problem Description
    //Given an array A of size N denoting collection of numbers that might contain duplicates, return all possible unique permutations.
    //
    //NOTE: No 2 entries in the permutation sequence should be the same.
    //
    //WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS.
    //Example : next_permutations in C++ / itertools.permutations in python.
    //If you do, we will disqualify your submission retroactively and give you penalty points.
    //
    //
    //Problem Constraints
    //1 <= |A| <= 9
    //
    //0 <= A[i] <= 10
    //
    //
    //
    //Input Format
    //Only argument is an integer array A of size N.
    //
    //
    //
    //Output Format
    //Return a 2-D array denoting all possible unique permutation of the array.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //A = [1, 1, 2]
    //Input 2:
    //
    //A = [1, 2]
    //
    //
    //Example Output
    //Output 1:
    //
    //[ [1,1,2]
    //  [1,2,1]
    //  [2,1,1] ]
    //Output 2:
    //
    //[ [1, 2]
    //  [2, 1] ]
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // All the possible unique permutation of array [1, 1, 2].
    //Explanation 2:
    //
    // All the possible unique permutation of array [1, 2].

    ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

    HashMap<Integer, Integer> frequencyCount(ArrayList<Integer> A) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (Integer data : A) {
            if (map.containsKey(data)) {
                map.put(data, map.get(data) + 1);
            } else {
                map.put(data, 1);
            }
        }
        return map;
    }

    public void permuteOfNumber(HashMap<Integer, Integer> frequencyCount, ArrayList<Integer> subAns, int index, int size) {

        if (index >=size) {
            System.out.println(subAns);
            ans.add(new ArrayList<>(subAns));
            return;
        }

        for (Integer keys : frequencyCount.keySet()) {
            if (frequencyCount.get(keys) > 0) {
                frequencyCount.put(keys, frequencyCount.get(keys) - 1);
                subAns.add(keys);
                permuteOfNumber(frequencyCount, subAns, index + 1, size);
                frequencyCount.put(keys, frequencyCount.get(keys) + 1);
                subAns.remove(subAns.size()-1);
            }
        }
    }


    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        HashMap<Integer, Integer> frequencyCount = frequencyCount(A);
        permuteOfNumber(frequencyCount, new ArrayList<>(), 0, A.size());
        return ans;
    }

    public static void main(String[] args) {
        AllUniquePermutations allUniquePermutations = new AllUniquePermutations();
        allUniquePermutations.permute(new ArrayList<>(Arrays.asList(1,1,2)));
    }

}
