package com.dsa.scaller.tree.LCA;

import com.dsa.scaller.tree.TreeNode;

public class KthSmallestElementInBST {

    //Problem Description
    //Given a binary search tree represented by root A, write a function to find the Bth smallest element in the tree.
    //
    //
    //
    //Problem Constraints
    //1 <= Number of nodes in binary tree <= 100000
    //
    //0 <= node values <= 10^9
    //
    //
    //
    //Input Format
    //First and only argument is head of the binary tree A.
    //
    //
    //
    //Output Format
    //Return an integer, representing the Bth element.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //
    //            2
    //          /   \
    //         1    3
    //B = 2
    //Input 2:
    //
    //
    //            3
    //           /
    //          2
    //         /
    //        1
    //B = 1
    //
    //
    //
    //Example Output
    //Output 1:
    //
    // 2
    //Output 2:
    //
    // 1
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    //2nd element is 2.
    //Explanation 2:
    //
    //1st element is 1.
    //
    //
    //
    //Expected Output
    //Provide sample input and click run to see the correct output for the provided input. Use this to improve your problem understanding and test edge cases
    //Arg 1: A Binary Tree, -1 signifies a NULL child, For e.g 6 9 4 -1 -1 8 -1 -1 3 -1 -1
    //tree-icon

    static int k = 0;
    public int kthsmallest(TreeNode A, int B) {
        k = B;
        return find(A);
    }
    public static int find(TreeNode root) {
        if (root == null)
            return -1;
        // We do an inorder traversal here.
        int k1 = find(root.left);
        if (k == 0)
            return k1; // left subtree has k or more elements.
        k--;
        if (k == 0)
            return root.val; // root is the kth element.
        return find(root.right); // answer lies in the right node.
    }
}
