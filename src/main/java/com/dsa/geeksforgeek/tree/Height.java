package com.dsa.geeksforgeek.tree;

public class Height {

    public static int getHeight(Tree tree) {

        if (tree == null)
            return 0;
        return Math.max(getHeight(tree.left), getHeight(tree.right)) + 1;
    }
}
