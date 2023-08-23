package com.dsa.scaller.tree;

public class CheckBSTOneChild {
    //Problem Description
    //
    //Given preorder traversal of a binary tree, check if it is possible that it is also a preorder traversal of a Binary Search Tree (BST), where each internal node (non-leaf nodes) have exactly one child.
    //
    //
    //
    //Problem Constraints
    //
    //1 <= number of nodes <= 100000
    //
    //
    //
    //Input Format
    //
    //First and only argument is an integer array denoting the preorder traversal of binary tree.
    //
    //
    //
    //Output Format
    //
    //Return a string "YES" if true else "NO".
    //
    //
    //
    //Example Input
    //
    //Input 1:
    //
    // A : [4, 10, 5, 8]
    //Input 2:
    //
    // A : [1, 5, 6, 4]
    //
    //
    //Example Output
    //
    //Output 1:
    //
    // "YES"
    //Output 2:
    //
    // "NO"
    //
    //
    //Example Explanation
    //
    //Explanation 1:
    //
    // The possible BST is:
    //            4
    //             \
    //             10
    //             /
    //             5
    //              \
    //              8
    //Explanation 2:
    //
    // There is no possible BST which have the above preorder traversal.


    public String solve(int[] A) {

        int n = A.length;
        int min = Math.min(A[n - 1], A[n - 2]); // Initialize min
        int max = Math.max(A[n - 1], A[n - 2]); // Initialize max

        for (int i = n - 1; i >= 0; i--) {

            if (A[i] < max && A[i] > min) return "NO"; // Check BST violation

            if (A[i] <= min) min = A[i]; // Update min

            if (A[i] >= max) max = A[i]; // Update max

        }
        return "YES";
    }
}
