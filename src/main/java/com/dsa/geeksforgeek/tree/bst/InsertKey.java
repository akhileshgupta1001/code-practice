package com.dsa.geeksforgeek.tree.bst;

import com.dsa.geeksforgeek.tree.Tree;

public class InsertKey {

    public static Tree insertKey(Tree root, int key) {

        if (root == null) return new Tree(key);

        if (root.key < key)
            root.right = insertKey(root.right, key);
        else if (root.key > key)
            root.left = insertKey(root.left, key);

        return root;
    }

    public static Tree insertKeyIterative(Tree root, int key) {
        Tree tree = new Tree(key);
        Tree parent = null, current = root;
        while (current != null) {
            parent = current;
            if (current.key < key) {
                current = current.right;
            } else if (current.key > key) {
                current = current.left;
            } else {
                return root;
            }
        }
        if (parent == null)
            return tree;
        else if (parent.key < key)
            return parent.right = tree;
        else return parent.left = tree;

    }
}
