package com.dsa.scaller.tree;

import com.dsa.scaller.tree.traversal.RightViewBinarytree;

import java.util.*;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }

    public static void main(String[] args) {
        // Given binary tree: 6 9 4 -1 -1 8 -1 -1 3 -1 -1

        // Construct the binary tree
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(9);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(3);

        // Perform any operations on the tree if needed
        // ...

        RightViewBinarytree.rightViewBinaryTree(root);

        // Call the solve() function with the binary tree as an argument
        Solution solution = new Solution();
        solution.solve(root);
        // ArrayList<ArrayList<Integer>> result = solution.solve(root);

        // Print the result if needed
        //   System.out.println(result);
    }

}

class Solution {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    public void solve(TreeNode A) {
        if (A == null)
            return;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(A);
        TreeNode last = A;
       ArrayList<Integer> subAns = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode data = queue.poll();
            subAns.add(data.val);
            //System.out.print(data.val);
            if (data.left != null)
                queue.add(data.left);
            if (data.right != null)
                queue.add(data.right);

            if (data == last && !queue.isEmpty()) {
              //  System.out.println();
               ans.add(subAns);
               subAns = new ArrayList<>();// Print a newline after processing each level
                last = queue.getLast();
            }

        }
        ans.add(subAns);
        System.out.println("Manin ans: "+ ans);
    }
}
