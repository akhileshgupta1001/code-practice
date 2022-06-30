package com.dsa.geeksforgeek.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidth {

    public static int maxWidth(Tree root) {

        if (root == null) return 0;
        Queue<Tree> trees = new LinkedList<>();
        trees.add(root);
        int res = 0;
        while (!trees.isEmpty()) {
            int count = trees.size();
            res = Math.max(count, res);
            for (int i = 0; i < count; i++) {
                Tree current = trees.poll();
                if (current.left != null)
                    trees.add(current.left);
                if (current.right != null)
                    trees.add(current.right);
            }
        }
        return res;
    }
}
