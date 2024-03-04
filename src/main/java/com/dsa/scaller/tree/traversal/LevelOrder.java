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
        Scanner sc = new Scanner(System.in);
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

    public static void main(String[] args) {
        // Create a sample binary tree
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(6);
        root2.right = new TreeNode(2);
        root2.right.left = new TreeNode(3);

        LevelOrder levelOrder = new LevelOrder();

        // Using solve method
        ArrayList<ArrayList<Integer>> result1 = levelOrder.solve2(root1);
        ArrayList<ArrayList<Integer>> result2 = levelOrder.solve2(root2);

        // Print the results
        System.out.println("Level Order Traversal 1:");
        for (ArrayList<Integer> row : result1) {
            System.out.println(row);
        }

        System.out.println("Level Order Traversal 2:");
        for (ArrayList<Integer> row : result2) {
            System.out.println(row);
        }

        // Using solve2 method
        ArrayList<ArrayList<Integer>> result3 = levelOrder.solve2(root1);
        ArrayList<ArrayList<Integer>> result4 = levelOrder.solve2(root2);

        // Print the results
        System.out.println("Level Order Traversal 1 (solve2):");
        for (ArrayList<Integer> row : result3) {
            System.out.println(row);
        }

        System.out.println("Level Order Traversal 2 (solve2):");
        for (ArrayList<Integer> row : result4) {
            System.out.println(row);
        }
    }
}
