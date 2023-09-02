package com.dsa.scaller.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Permutation {
    static void permutationOfString(String A, boolean[] isVisited, char[] ans, int index) {

        if (index == A.length()) {
            System.out.println(String.valueOf(ans));
            return;
        }

        for (int i = 0; i < A.length(); i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                ans[index] = A.charAt(i);
                permutationOfString(A, isVisited, ans, index + 1);
                isVisited[i] = false;
            }
        }
    }

    //Problem Description
    //Given an integer array A of size N denoting collection of numbers , return all possible permutations.
    //
    //NOTE:
    //
    //No two entries in the permutation sequence should be the same.
    //For the purpose of this problem, assume that all the numbers in the collection are unique.
    //Return the answer in any order
    //WARNING: DO NOT USE LIBRARY FUNCTION FOR GENERATING PERMUTATIONS.
    //Example : next_permutations in C++ / itertools.permutations in python.
    //If you do, we will disqualify your submission retroactively and give you penalty points.
    //
    //
    //Problem Constraints
    //1 <= N <= 9
    //
    //
    //
    //Input Format
    //Only argument is an integer array A of size N.
    //
    //
    //
    //Output Format
    //Return a 2-D array denoting all possible permutation of the array.
    //
    //
    //
    //Example Input
    //A = [1, 2, 3]
    //
    //
    //Example Output
    //[ [1, 2, 3]
    //  [1, 3, 2]
    //  [2, 1, 3]
    //  [2, 3, 1]
    //  [3, 1, 2]
    //  [3, 2, 1] ]
    //
    //
    //Example Explanation
    //All the possible permutation of array [1, 2, 3].

    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    public void permuteOfNumber(ArrayList<Integer> A, ArrayList<Integer> subAns, boolean isVisited[], int index) {
        if (index == subAns.size()) {
            //System.out.println("Sub Ans : "+subAns);
            ans.add(new ArrayList<>(subAns));
            return;
        }

        for (int i = 0; i < A.size(); i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                subAns.set(index, A.get(i));
                permuteOfNumber(A, subAns, isVisited, index + 1);
                isVisited[i] = false;

            }
        }
    }

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<Integer> subAns = new ArrayList<>();

        for (int i = 0; i < A.size(); i++) {
            subAns.add(-1);
        }

        boolean[] isVisited = new boolean[subAns.size()];

        permuteOfNumber(A, subAns, isVisited, 0);

        return ans;
    }

    public static void main(String[] args) {
        permutationOfString("ABC",new boolean[3],new char[3],0);

        ArrayList<Integer> ans = new ArrayList<>();

        System.out.println(ans);
    }

}
