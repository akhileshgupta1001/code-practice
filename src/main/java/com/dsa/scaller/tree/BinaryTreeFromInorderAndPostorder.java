package com.dsa.scaller.tree;

import java.util.HashMap;
import java.util.Map;

public class BinaryTreeFromInorderAndPostorder {
    //Problem Description
    //Given the inorder and postorder traversal of a tree, construct the binary tree.
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
    //First argument is an integer array A denoting the inorder traversal of the tree.
    //
    //Second argument is an integer array B denoting the postorder traversal of the tree.
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
    // A = [2, 1, 3]
    // B = [2, 3, 1]
    //Input 2:
    //
    // A = [6, 1, 3, 2]
    // B = [6, 3, 2, 1]
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

        // Recursive function to build the binary tree
        public TreeNode buildTree(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd, Map<Integer, Integer> inorderMap) {
            if (inStart > inEnd || postStart > postEnd) {
                return null;
            }

            // The last element in postorder is the root of the current subtree
            TreeNode node = new TreeNode(postorder[postEnd]);

            // Find the index of the root in the inorder list
            int idx = inorderMap.get(postorder[postEnd]);
            int countRight = inEnd - idx;

            // Recursively construct the right and left subtrees
            node.left = buildTree(inorder, postorder, inStart, idx - 1, postStart, postEnd - countRight - 1, inorderMap);
            node.right = buildTree(inorder, postorder, idx + 1, inEnd, postEnd - countRight, postEnd - 1, inorderMap);

            return node;
        }

        // Wrapper function to call the recursive buildTree function
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0 || inorder.length != postorder.length) {
                return null;
            }

            // Preprocess inorder list to store indices in a map for quick access
            Map<Integer, Integer> inorderMap = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                inorderMap.put(inorder[i], i);
            }

            // Call the recursive function with the full range of both lists
            return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1, inorderMap);
        }

}
