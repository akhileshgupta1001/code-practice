package com.dsa.geeksforgeek.tree;

public class CheckBalanceTree {

    public static int getHeight(Tree root) {
        if (root == null) return 0;

        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    //O(n2)
    public static boolean isBalanceTree(Tree root) {
        if (root == null) return true;
        int left = getHeight(root.left);
        int right = getHeight(root.right);

        return (Math.abs(left - right) <= 1 && isBalanceTree(root.left) && isBalanceTree(root.right));
    }

    public static int isBalance(Tree root) {
        if (root == null) return 0;
        int lh = isBalance(root.left);
        if (lh == -1) return -1;
        int rh = isBalance(root.right);
        if (rh == -1) return -1;
        if (Math.abs(lh - rh) > 1) return -1;
        else return Math.max(lh, rh) + 1;

    }
}
