package com.dsa.geeksforgeek.tree;

public class Size {
    public static int getSize(Tree root) {
        if (root == null)
            return 0;
        else return 1 + getSize(root.left) + getSize(root.right);
    }
}
