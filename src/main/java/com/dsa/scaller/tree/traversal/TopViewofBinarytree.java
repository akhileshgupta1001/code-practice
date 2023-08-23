package com.dsa.scaller.tree.traversal;

import com.dsa.scaller.tree.TreeNode;

import java.util.*;

public class TopViewofBinarytree {

    //Problem Description
    //Given a binary tree of integers denoted by root A. Return an array of integers representing the top view of the Binary tree.
    //
    //The top view of a Binary Tree is a set of nodes visible when the tree is visited from the top.
    //
    //Return the nodes in any order.
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
    //Return an array, representing the top view of the binary tree.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //
    //            1
    //          /   \
    //         2    3
    //        / \  / \
    //       4   5 6  7
    //      /
    //     8
    //Input 2:
    //
    //
    //            1
    //           /  \
    //          2    3
    //           \
    //            4
    //             \
    //              5
    //
    //
    //Example Output
    //Output 1:
    //
    // [1, 2, 4, 8, 3, 7]
    //Output 2:
    //
    // [1, 2, 3]
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    //Top view is described.
    //Explanation 2:
    //
    //Top view is described.
    //
    //
    //
    //Expected Output
    //Provide sample input and click run to see the correct output for the provided input. Use this to improve your problem understanding and test edge cases
    //Arg 1: A Binary Tree, -1 signifies a NULL child, For e.g 6 9 4 -1 -1 8 -1 -1 3 -1 -1
    //tree-icon

    public ArrayList<Integer> solve(TreeNode A) {
        Queue<Pair> queue = new LinkedList<>();
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Integer> subAns;
        queue.add(new Pair(A, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int currentDistance = pair.dis;
            TreeNode currentNode = pair.node;
            int currentNodeValue = currentNode.val;
            subAns = new ArrayList<>();
            if (map.containsKey(currentDistance)) {
                subAns = map.get(currentDistance);
                subAns.add(currentNodeValue);
            } else {
                subAns.add(currentNodeValue);
            }
            map.put(currentDistance, subAns);

            if (currentNode.left != null) {
                queue.add(new Pair(currentNode.left, currentDistance - 1));
            }

            if (currentNode.right != null) {
                queue.add(new Pair(currentNode.right, currentDistance + 1));
            }
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int x : map.keySet()) {
            if (min > x) {
                min = Math.min(min, x);
            }

            if (max < x) {
                max = Math.max(max, x);
            }
        }

        for (int i = min; i <= max; i++) {
            ans.add(map.get(i).get(0));
        }
        return ans;
    }
}
