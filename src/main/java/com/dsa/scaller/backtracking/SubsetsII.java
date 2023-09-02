package com.dsa.scaller.backtracking;

//Problem Description
//Given a collection of integers denoted by array A of size N that might contain duplicates, return all possible subsets.
//
//NOTE:
//
//Elements in a subset must be in non-descending order.
//The solution set must not contain duplicate subsets.
//The subsets must be sorted lexicographically.
//
//
//Problem Constraints
//0 <= N <= 16
//
//
//
//Input Format
//Only argument is an integer array A of size N.
//
//
//
//Output Format
//Return a 2-D vector denoting all the possible subsets.
//
//
//
//Example Input
//Input 1:
//
// A = [1, 2, 2]
//Input 2:
//
// A = [1, 1]
//
//
//Example Output
//Output 1:
//
// [
//    [],
//    [1],
//    [1, 2],
//    [1, 2, 2],
//    [2],
//    [2, 2]
// ]
//Output 2:
//
// [
//    [],
//    [1],
//    [1, 1]
// ]
//
//
//Example Explanation
//Explanation 1:
//
//All the subsets of the array [1, 2, 2] in lexicographically sorted order.

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SubsetsII {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    public void subSet(ArrayList<Integer> A, ArrayList<Integer> subAns, int index) {
        if (index == A.size()) {
            ans.add(new ArrayList<>(subAns));
            return;
        }

        subAns.add(A.get(index));
        subSet(A, subAns, index + 1);
        subAns.remove(subAns.size() - 1);
        subSet(A, subAns, index + 1);
    }

    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {

        subSet(A, new ArrayList<Integer>(), 0);
        for (ArrayList<Integer> subset : ans) {
            Collections.sort(subset);
        }


        ans.sort(new Comparator<ArrayList<Integer>>() {
            @Override
            public int compare(ArrayList<Integer> x, ArrayList<Integer> y) {
                int minSize = Math.min(x.size(), y.size());

                for (int i = 0; i < minSize; i++) {
                    int cmp = x.get(i).compareTo(y.get(i));
                    if (cmp != 0) {
                        return cmp;
                    }
                }

                return Integer.compare(x.size(), y.size());
            }
        });
        // Remove duplicate subsets
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> prev = null;

        for (ArrayList<Integer> subset : ans) {
            if (!subset.equals(prev)) {
                result.add(subset);
                prev = subset;
            }
        }
        ans = result;
        return ans;
    }
}
