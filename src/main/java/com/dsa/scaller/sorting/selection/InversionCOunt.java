package com.dsa.scaller.sorting.selection;

import java.util.ArrayList;
import java.util.Arrays;

public class InversionCOunt {
//Given an array of integers A. If i < j and A[i] > A[j], then the pair (i, j) is called an inversion of A. Find the total number of inversions of A modulo (109 + 7).
//
//
//
//Problem Constraints
//1 <= length of the array <= 105
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
//Return the number of inversions of A modulo (109 + 7).
//
//
//
//Example Input
//Input 1:
//
//A = [1, 3, 2]
//Input 2:
//
//A = [3, 4, 1, 2]
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
//Explanation 1:
//
//The pair (1, 2) is an inversion as 1 < 2 and A[1] > A[2]
//Explanation 2:
//
//The pair (0, 2) is an inversion as 0 < 2 and A[0] > A[2]
//The pair (0, 3) is an inversion as 0 < 3 and A[0] > A[3]
//The pair (1, 2) is an inversion as 1 < 2 and A[1] > A[2]
//The pair (1, 3) is an inversion as 1 < 3 and A[1] > A[3]

    public static int merge(ArrayList<Integer> A, ArrayList<Integer> B) {
        int inversionCount = 0;
        int a = A.size();
        int b = B.size();
        ArrayList<Integer> ans = new ArrayList<>();
        int i = 0;
        int j = 0;

        for (int k = 0; k < (a + b); k++) {
            if (i == a) {
                ans.set(k, B.get(j));
                j++;
                inversionCount++;
                inversionCount = inversionCount % 1000000007;
            } else if (j == b || A.get(i) <= B.get(j)) {
                // ans[k] = A[i];
                ans.set(k, A.get(j));
                i++;
                inversionCount++;
                inversionCount = inversionCount % 1000000007;
            } else if (A.get(i) > B.get(j)) {
                //ans[k] = B[j];
                ans.set(k, B.get(j));
                j++;
                inversionCount++;
                inversionCount = inversionCount % 1000000007;
            }
        }

        return inversionCount;
    }

    public static int sort(ArrayList<Integer> A, int start, int end, int ans) {
        if (start == end) return 0;
        int mid = (start + end) / 2;
        int first = sort(A, start, mid, ans) % 1000000007;
        int second = sort(A, mid + 1, end, ans) % 1000000007;
        int third = merge(new ArrayList(A.subList(start, mid)), new ArrayList(A.subList(mid, end))) % 1000000007;
        return third;
    }

    public static int solve(ArrayList<Integer> A) {
        return sort(A, 0, A.size() - 1, 0);
    }

    public static void main(String[] args) {
        System.out.println(solve(new ArrayList<>(Arrays.asList(45,10,15,25,50))));
    }
}
