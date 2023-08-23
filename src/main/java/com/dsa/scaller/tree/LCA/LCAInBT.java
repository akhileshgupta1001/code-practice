package com.dsa.scaller.tree.LCA;

import com.dsa.scaller.tree.TreeNode;

public class LCAInBT {
    //Problem Description
    //Find the lowest common ancestor in an unordered binary tree A, given two values, B and C, in the tree.
    //
    //Lowest common ancestor: the lowest common ancestor (LCA) of two nodes and w in a tree or directed acyclic graph (DAG) is the lowest (i.e., deepest) node that has both v and w as descendants.
    //
    //
    //
    //Problem Constraints
    //1 <= size of tree <= 100000
    //
    //1 <= B, C <= 109
    //
    //
    //
    //Input Format
    //First argument is head of tree A.
    //
    //Second argument is integer B.
    //
    //Third argument is integer C.
    //
    //
    //
    //Output Format
    //Return the LCA.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //
    //      1
    //     /  \
    //    2    3
    //B = 2
    //C = 3
    //Input 2:
    //
    //      1
    //     /  \
    //    2    3
    //   / \
    //  4   5
    //B = 4
    //C = 5
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
    // LCA is 1.
    //Explanation 2:
    //
    // LCA is 2.
    //
    //
    //
    //Expected Output
    //Provide sample input and click run to see the correct output for the provided input. Use this to improve your problem understanding and test edge cases
    //Arg 1: A Binary Tree, -1 signifies a NULL child, For e.g 6 9 4 -1 -1 8 -1 -1 3 -1 -1
    //tree-icon


    public int isExist(TreeNode A, int B) {
        if (A == null) return -1;
        if (A.val == B) return 1;
        int left = isExist(A.left, B);
        int right = isExist(A.right, B);

        return (left == 1 || right == 1) ? 1 : -1;
    }

    public int findLCA(TreeNode A, int B, int C) {
        if (A == null) return -1;

        if (A.val == B || A.val == C) {
            return A.val;
        }

        int left = findLCA(A.left, B, C);
        int right = findLCA(A.right, B, C);

        if (left != -1 && right != -1) {
            return A.val;
        } else if (left != -1) {
            return left;
        } else {
            return right;
        }
    }

    public int lca(TreeNode A, int B, int C) {
        int b = isExist(A, B);
        int c = isExist(A, C);
        if (b == -1 || c == -1) return -1;
        return findLCA(A, B, C);
    }


}
