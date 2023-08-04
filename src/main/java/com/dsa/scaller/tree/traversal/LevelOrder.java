package com.dsa.scaller.tree.traversal;

import com.dsa.scaller.tree.TreeNode;

import java.util.*;

public class LevelOrder {
    //Problem Description
    //Given a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
    //
    //
    //
    //Problem Constraints
    //1 <= number of nodes <= 105
    //
    //
    //
    //Input Format
    //First and only argument is root node of the binary tree, A.
    //
    //
    //
    //Output Format
    //Return a 2D integer array denoting the level order traversal of the given binary tree.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //    3
    //   / \
    //  9  20
    //    /  \
    //   15   7
    //Input 2:
    //
    //   1
    //  / \
    // 6   2
    //    /
    //   3
    //
    //
    //Example Output
    //Output 1:
    //
    // [
    //   [3],
    //   [9, 20],
    //   [15, 7]
    // ]
    //Output 2:
    //
    // [
    //   [1]
    //   [6, 2]
    //   [3]
    // ]
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // Return the 2D array. Each row denotes the traversal of each level.

    public ArrayList<ArrayList<Integer>> solve(TreeNode A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (A == null)
            return ans;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(A);
        TreeNode last = A;

        while (!queue.isEmpty()) {
            int data = queue.size();
            ArrayList<Integer> subAns = new ArrayList<>();
            for (int i = 0; i < data; i++) {
                TreeNode current = queue.poll();
                subAns.add(current.val);
                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }
            }
            ans.add(subAns);

        }
        return ans;
    }

    public ArrayList<ArrayList<Integer>> solve2(TreeNode A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (A == null)
            return ans;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(A);
        TreeNode last = A;
        ArrayList<Integer> subAns = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            subAns.add(current.val);

            if(current.left != null)
                queue.add(current.left);

            if(current.right != null)
                queue.add(current.right);

            while(current == last && !queue.isEmpty()){
                ans.add(subAns);
                subAns = new ArrayList<Integer>();
                last = queue.getLast();
            }
        }
        ans.add(subAns);
        return ans;
    }
}
