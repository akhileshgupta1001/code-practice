package com.dsa.scaller.tree.traversal;

import com.dsa.scaller.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class RightViewBinarytree {
    public static ArrayList<Integer> rightViewBinaryTree(TreeNode A) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        ArrayList<Integer> ans = new ArrayList<>();
        if (A == null) return ans;

        TreeNode last = A;
        queue.add(A);

        while (!queue.isEmpty()) {
            TreeNode data = queue.poll();

            if (data.left != null) queue.add(data.left);

            if (data.right != null) queue.add(data.right);

            if (data == last) {
                ans.add(data.val);
                if (!queue.isEmpty()) {
                    last = queue.getLast();
                }
            }
        }
        System.out.println(ans);
        return ans;
    }
}
