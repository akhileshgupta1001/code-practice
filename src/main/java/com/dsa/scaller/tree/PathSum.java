package com.dsa.scaller.tree;

public class PathSum {
    //Problem Description
    //Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
    //
    //
    //
    //Problem Constraints
    //1 <= number of nodes <= 105
    //
    //-100000 <= B, value of nodes <= 100000
    //
    //
    //
    //Input Format
    //First argument is a root node of the binary tree, A.
    //
    //Second argument is an integer B denoting the sum.
    //
    //
    //
    //Output Format
    //Return 1, if there exist root-to-leaf path such that adding up all the values along the path equals the given sum. Else, return 0.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // Tree:    5
    //         / \
    //        4   8
    //       /   / \
    //      11  13  4
    //     /  \      \
    //    7    2      1
    //
    // B = 22
    //Input 2:
    //
    // Tree:    5
    //         / \
    //        4   8
    //       /   / \
    //     -11 -13  4
    //
    // B = -1
    //
    //
    //Example Output
    //Output 1:
    //
    // 1
    //Output 2:
    //
    // 0
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // There exist a root-to-leaf path 5 -> 4 -> 11 -> 2 which has sum 22. So, return 1.
    //Explanation 2:
    //
    // There is no path which has sum -1.
    //
    //
    //
    //Expected Output
    //Provide sample input and click run to see the correct output for the provided input. Use this to improve your problem understanding and test edge cases
    //Arg 1: A Binary Tree, -1 signifies a NULL child, For e.g 6 9 4 -1 -1 8 -1 -1 3 -1 -1
    //tree-icon

    boolean checkPathSum(TreeNode A, int B) {
        if (A == null) return false;

        if (A.left == null && A.right == null) {
            return (B == A.val ? true : false);
        }
        return checkPathSum(A.left, B - A.val) || checkPathSum(A.right, B - A.val);
    }

    public int hasPathSum(TreeNode A, int B) {
        boolean ans = checkPathSum(A, B);
        return ans == true ? 1 : 0;
    }
}
