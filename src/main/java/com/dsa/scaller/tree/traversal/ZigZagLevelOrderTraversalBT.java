package com.dsa.scaller.tree.traversal;

import com.dsa.scaller.tree.TreeNode;

import java.util.*;

public class ZigZagLevelOrderTraversalBT {
    //Problem Description
    //Given a binary tree, return the zigzag level order traversal of its nodes values. (ie, from left to right, then right to left for the next level and alternate between).
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
    //Return a 2D integer array denoting the zigzag level order traversal of the given binary tree.
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
    //   [20, 9],
    //   [15, 7]
    // ]
    //Output 2:
    //
    // [
    //   [1]
    //   [2, 6]
    //   [3]
    // ]
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // Return the 2D array. Each row denotes the zigzag traversal of each level.
    //
    //
    //
    //Expected Output
    //Provide sample input and click run to see the correct output for the provided input. Use this to improve your problem understanding and test edge cases

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
       // Stack<TreeNode> stack = new Stack<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (A == null)
            return ans;

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(A);
        TreeNode last = A;
        ArrayList<Integer> subAns = new ArrayList<>();
        int i=0;
        while (!queue.isEmpty()) {
            TreeNode current = queue.pop();
            subAns.add(current.val);

            if(current.left != null)
                queue.add(current.left);

            if(current.right != null)
                queue.add(current.right);

            while(current == last && !queue.isEmpty()){
                if(i%2 !=0)
                Collections.reverse(subAns);

                i++;
                ans.add(subAns);
              //  subAns.clear();
                subAns = new ArrayList<Integer>();
                last = queue.getLast();
              //  System.out.println(ans);
            }
        }
        ans.add(subAns);
        return ans;

    }

    public static void main(String[] args) {
        // Constructing the example binary tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        ZigZagLevelOrderTraversalBT solution = new ZigZagLevelOrderTraversalBT();
        ArrayList<ArrayList<Integer>> result = solution.zigzagLevelOrder(root);

        // Printing the zigzag level order traversal
        int i=0;
        for (ArrayList<Integer> level : result) {
            System.out.println(level);
        }
    }
}
