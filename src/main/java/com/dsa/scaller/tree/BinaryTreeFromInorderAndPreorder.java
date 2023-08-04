package com.dsa.scaller.tree;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromInorderAndPreorder {
    //Problem Description
    //Given preorder and inorder traversal of a tree, construct the binary tree.
    //
    //NOTE: You may assume that duplicates do not exist in the tree.
    //
    //
    //
    //Problem Constraints
    //1 <= number of nodes <= 105
    //
    //
    //
    //Input Format
    //First argument is an integer array A denoting the preorder traversal of the tree.
    //
    //Second argument is an integer array B denoting the inorder traversal of the tree.
    //
    //
    //
    //Output Format
    //Return the root node of the binary tree.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = [1, 2, 3]
    // B = [2, 1, 3]
    //Input 2:
    //
    // A = [1, 6, 2, 3]
    // B = [6, 1, 3, 2]
    //
    //
    //Example Output
    //Output 1:
    //
    //   1
    //  / \
    // 2   3
    //Output 2:
    //
    //   1
    //  / \
    // 6   2
    //    /
    //   3
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // Create the binary tree and return the root node of the tree.


    public TreeNode buildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd, Map<Integer, Integer> inorderMap) {
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // The first element in preorder is the root of the current subtree
        TreeNode node = new TreeNode(preorder[preStart]);

        // Find the index of the root in the inorder list
        int idx = inorderMap.get(preorder[preStart]);
        int countLeft = idx - inStart;

        // Recursively construct the left and right subtrees
        node.left = buildTree(preorder, inorder, preStart + 1, preStart + countLeft, inStart, idx - 1, inorderMap);
        node.right = buildTree(preorder, inorder, preStart + countLeft + 1, preEnd, idx + 1, inEnd, inorderMap);

        return node;
    }

    // Wrapper function to call the recursive buildTree function
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder == null || preorder == null || inorder.length == 0 || preorder.length == 0 || inorder.length != preorder.length) {
            return null;
        }

        // Preprocess inorder list to store indices in a map for quick access
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        // Call the recursive function with the full range of both lists
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, inorderMap);
    }
}
