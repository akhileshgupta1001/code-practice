package com.dsa.geeksforgeek.tree;

public class ChildrenSumProperty {

    public static boolean isChildrenSumProperty(Tree root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;
        int sum = 0;
        if (root.left != null) {
            sum = sum + root.left.key;
        }
        if (root.right != null) {
            sum = sum + root.right.key;
        }
        return (root.key == sum
                && isChildrenSumProperty(root.left)
                && isChildrenSumProperty(root.right));

    }
}
