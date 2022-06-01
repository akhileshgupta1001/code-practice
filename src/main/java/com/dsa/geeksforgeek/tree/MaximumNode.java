package com.dsa.geeksforgeek.tree;

public class MaximumNode {
    public static int getMax(Tree root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        } else {
            return Math.max(root.key, Math.max(getMax(root.left), getMax(root.right)));
        }
    }
}
