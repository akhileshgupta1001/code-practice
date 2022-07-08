package com.dsa.geeksforgeek.tree.bst;

import com.dsa.geeksforgeek.tree.Tree;

public class Floor {
    public static Tree getFlorValue(Tree root, int key) {
        Tree result = null;

        while (root != null) {
            if (root.key == key)
                return root;
            else if (root.key > key)
                root = root.left;
            else {
                result = root;
                root = root.right;
            }
        }
        return result;
    }
}
