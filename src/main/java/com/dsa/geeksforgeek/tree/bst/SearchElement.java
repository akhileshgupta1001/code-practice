package com.dsa.geeksforgeek.tree.bst;

import com.dsa.geeksforgeek.tree.Tree;

import java.util.List;

public class SearchElement {

    public static boolean search(Tree root, int key) {

        if (root == null) return false;
        while (root != null) {
            if (root.key == key) return true;
            else if (root.key < key) return search(root.right, key);
            else return search(root.left, key);
        }
        return false;
    }
}
