package com.dsa.scaller.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Subset {
    //Problem Description
    //Given a set of distinct integers A, return all possible subsets.
    //
    //NOTE:
    //
    //Elements in a subset must be in non-descending order.
    //The solution set must not contain duplicate subsets.
    //Also, the subsets should be sorted in ascending ( lexicographic ) order.
    //The list is not necessarily sorted.
    //
    //
    //Problem Constraints
    //1 <= |A| <= 16
    //INTMIN <= A[i] <= INTMAX
    //
    //
    //Input Format
    //First and only argument of input contains a single integer array A.
    //
    //
    //
    //Output Format
    //Return a vector of vectors denoting the answer.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //A = [1]
    //Input 2:
    //
    //A = [1, 2, 3]
    //
    //
    //Example Output
    //Output 1:
    //
    //[
    //    []
    //    [1]
    //]
    //Output 2:
    //
    //[
    // []
    // [1]
    // [1, 2]
    // [1, 2, 3]
    // [1, 3]
    // [2]
    // [2, 3]
    // [3]
    //]
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // You can see that these are all possible subsets.
    //Explanation 2:
    //
    //You can see that these are all possible subsets.

    ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

    public void subsets(ArrayList<Integer> A, ArrayList<Integer> subAns, int index) {
        ArrayList<Integer> sum = new ArrayList<>() ;
        // subAns.addAll(subAns);
        sum.addAll(subAns);
        if (index == A.size()) {
            ans.add(new ArrayList<>(subAns));
            return;
        }

        //do step
        subAns.add(A.get(index));
        subsets(A, subAns, index + 1);//increment by pos+1

        //undo step
        subAns.remove(subAns.size() - 1);//remove the last taken element and remove it for not consider case
        subsets(A, subAns, index + 1);//increment by pos+1  (we are done with removing elemnt then same )
    }

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        Collections.sort(A);
        subsets(A, new ArrayList<>(), 0);

        ans.sort((x, y) -> {
            for (int i = 0; i < Math.min(x.size(), y.size()); i++) {
                if (x.get(i) != y.get(i)) {
                    return x.get(i) - y.get(i);
                }
            }
            return x.size() - y.size();
        });
        return ans;
    }

    public static void main(String[] args) {
        Subset subset = new Subset();

        // Example Input
        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(2);
        A.add(3);

        // Generate subsets
        ArrayList<ArrayList<Integer>> result = subset.subsets(A);

        // Print the result
        System.out.println(result);
    }

}
