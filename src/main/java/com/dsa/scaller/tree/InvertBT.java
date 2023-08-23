package com.dsa.scaller.tree;

public class InvertBT {
    //Invert the Binary Tree
    //Solved
    //feature icon
    //Using hints is now penalty free
    //Use Hint
    //Problem Description
    //Given a binary tree A, invert the binary tree and return it.
    //
    //Inverting refers to making the left child the right child and vice versa.
    //
    //
    //
    //Problem Constraints
    //1 <= size of tree <= 100000
    //
    //
    //
    //Input Format
    //First and only argument is the head of the tree A.
    //
    //
    //
    //Output Format
    //Return the head of the inverted tree.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //
    //     1
    //   /   \
    //  2     3
    //Input 2:
    //
    //
    //     1
    //   /   \
    //  2     3
    // / \   / \
    //4   5 6   7
    //
    //
    //Example Output
    //Output 1:
    //
    //
    //     1
    //   /   \
    //  3     2
    //Output 2:
    //
    //
    //     1
    //   /   \
    //  3     2
    // / \   / \
    //7   6 5   4
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    //Tree has been inverted.
    //Explanation 2:
    //
    //Tree has been inverted.
    //
    //
    //
    //Expected Output
    //Provide sample input and click run to see the correct output for the provided input. Use this to improve your problem understanding and test edge cases
    //Arg 1: A Binary Tree, -1 signifies a NULL child, For e.g 6 9 4 -1 -1 8 -1 -1 3 -1 -1
    //tree-icon

    public TreeNode invertTree(TreeNode A) {
        if (A == null) return A;

        TreeNode current = A.left;
        A.left = invertTree(A.right);
        A.right = invertTree(current);
        return A;
    }
}
