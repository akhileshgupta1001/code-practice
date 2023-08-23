package com.dsa.scaller.tree;

import java.util.*;

//Problem Description
//Given a binary tree,
//
//Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
//
//Initially, all next pointers are set to NULL.
//
//Assume perfect binary tree.
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
//Return the head of the binary tree after the changes are made.
//
//
//
//Example Input
//Input 1:
//
//
//     1
//    /  \
//   2    3
//Input 2:
//
//
//        1
//       /  \
//      2    5
//     / \  / \
//    3  4  6  7
//
//
//Example Output
//Output 1:
//
//
//        1 -> NULL
//       /  \
//      2 -> 3 -> NULL
//Output 2:
//
//
//         1 -> NULL
//       /  \
//      2 -> 5 -> NULL
//     / \  / \
//    3->4->6->7 -> NULL
//
//
//Example Explanation
//Explanation 1:
//
//Next pointers are set as given in the output.
//Explanation 2:
//
//Next pointers are set as given in the output.

class TreeLinkNode {
    public int val;
    public TreeLinkNode left;
    public TreeLinkNode right;
    public TreeLinkNode next;

    public TreeLinkNode(int x) {
        val = x;
        left = null;
        right = null;
        next = null;
    }

    @Override
    public String toString() {
        return "TreeLinkNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                ", next=" + next +
                '}';
    }
}

public class NextPointerBinaryTree {

    // T. C -> O(n)
    // S.C -> (h)
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return; // If the root is null, there's nothing to connect
        }

        Queue<TreeLinkNode> queue = new LinkedList<>(); // Create a queue for level-order traversal
        queue.offer(root); // Add the root node to the queue

        while (!queue.isEmpty()) { // Process each level of the tree
            int levelSize = queue.size(); // Get the number of nodes in the current level

            TreeLinkNode prev = null; // Pointer to the previous node in the current level

            for (int i = 0; i < levelSize; i++) { // Process each node in the current level
                TreeLinkNode current = queue.poll(); // Get the current node from the queue

                if (prev != null) {
                    prev.next = current; // Connect the previous node to the current node
                }
                prev = current; // Update the previous pointer

                if (current.left != null) {
                    queue.offer(current.left); // Add the left child to the queue
                }
                if (current.right != null) {
                    queue.offer(current.right); // Add the right child to the queue
                }
            }
        }
    }

    public void connect2(TreeLinkNode root) {
        TreeLinkNode current = root;
        TreeLinkNode first = root;

        while (first != null) {
            TreeLinkNode prev = null;
            current = first;
            first = null;

            while (current != null) {
                // For left
                if (current.left != null) {
                    // This is first left node
                    if (prev == null) {
                        prev = current.left;
                        first = prev;
                    } else {
                        prev.next = current.left;
                        prev = prev.next;
                    }
                }

                if (current.right != null) {
                    if (prev == null) {
                        prev = current.right;
                        first = prev;
                    } else {
                        prev.next = current.right;
                        prev = prev.next;
                    }
                }

                current = current.next; // Update the current pointer
            }
        }
    }
}
