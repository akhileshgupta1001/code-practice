package com.dsa.scaller.tree.traversal;

import com.dsa.scaller.tree.TreeNode;

import java.util.*;

class Pair {
    int dis;
    TreeNode node;

    Pair(TreeNode node, int dis) {
        this.node = node;
        this.dis = dis;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "dis=" + dis +
                ", node=" + node +
                '}';
    }
}

public class VerticalOrdertraversal {
    //Given a binary tree, return a 2-D array with vertical order traversal of it. Go through the example and image for more details.
    //
    //
    //NOTE: If 2 Tree Nodes shares the same vertical level then the one with lesser depth will come first.
    //
    //
    //
    //Problem Constraints
    //0 <= number of nodes <= 105
    //
    //
    //
    //Input Format
    //First and only arument is a pointer to the root node of binary tree, A.
    //
    //
    //
    //Output Format
    //Return a 2D array denoting the vertical order traversal of tree as shown.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //      6
    //    /   \
    //   3     7
    //  / \     \
    // 2   5     9
    //Input 2:
    //
    //      1
    //    /   \
    //   3     7
    //  /       \
    // 2         9
    //
    //
    //Example Output
    //Output 1:
    //
    // [
    //    [2],
    //    [3],
    //    [6, 5],
    //    [7],
    //    [9]
    // ]
    //Output 2:
    //
    // [
    //    [2],
    //    [3],
    //    [1],
    //    [7],
    //    [9]
    // ]
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // First row represent the verical line 1 and so on.
    //
    //
    //
    //Expected Output
    //Provide sample input and click run to see the correct output for the provided input. Use this to improve your problem understanding and test edge cases
    //Arg 1: A Binary Tree, -1 signifies a NULL child, For e.g 6 9 4 -1 -1 8 -1 -1 3 -1 -1
    //tree-icon

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(A, 0));
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<Integer> subAns = new ArrayList<>();
        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            int currentDis = pair.dis;
            TreeNode current = pair.node;
            subAns = new ArrayList<>();
            int currentNodeValue = current.val;

            if (map.containsKey(currentDis)) {
                subAns = map.get(currentDis);
                subAns.add(currentNodeValue);
            } else {
                subAns.add(currentNodeValue);
            }
            map.put(currentDis, subAns);

            if (current.left != null) {
                queue.add(new Pair(current.left, currentDis - 1));
            }

            if (current.right != null) {
                queue.add(new Pair(current.right, currentDis + 1));
            }
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int x : map.keySet()) {
            if (max < x) {
                max = Math.max(max, x);
            }

            if (min > x) {
                min = Math.min(min, x);
            }
        }
        for (int i = min; i <= max; i++) {
            ans.add(map.get(i));
        }
        return ans;
    }

    // Helper function to create a binary tree from an array representation
    public TreeNode createTreeFromArray(int[] arr, int index) {
        if (index >= arr.length || arr[index] == -1) {
            return null;
        }
        TreeNode root = new TreeNode(arr[index]);
        root.left = createTreeFromArray(arr, 2 * index + 1);
        root.right = createTreeFromArray(arr, 2 * index + 2);
        return root;
    }

    public static void main(String[] args) {
        VerticalOrdertraversal solution = new VerticalOrdertraversal();
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        TreeNode root = solution.createTreeFromArray(arr, 0);
        ArrayList<ArrayList<Integer>> result = solution.verticalOrderTraversal(root);
        System.out.println(result);
    }


}
