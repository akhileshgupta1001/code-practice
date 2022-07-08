package com.dsa.geeksforgeek.tree.bst;

import com.dsa.geeksforgeek.tree.Tree;

public class CeilValue {
    public static int getCeilValue(Tree root, int key) {

        if (root == null) return -1;

        if (root.key == key) return key;
        else if (root.key < key) return getCeilValue(root.right, key);
        int ceilValue = getCeilValue(root.left, key);
        return (ceilValue >= key) ? ceilValue : root.key;
    }
}
