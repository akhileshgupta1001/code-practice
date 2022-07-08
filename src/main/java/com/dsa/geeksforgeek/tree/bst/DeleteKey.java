package com.dsa.geeksforgeek.tree.bst;

import com.dsa.geeksforgeek.tree.Tree;

public class DeleteKey {

    public Tree deleteKey(Tree root, int key) {
        if (root == null) return null;
        if (root.key > key)
            root.left = deleteKey(root.left, key);
        else if (root.key < key)
            root.right = deleteKey(root.right, key);
        else {
            // check left is null return right and vice-versa
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            else {
                Tree tree = getSuccesor(root);
                root.key = tree.key;
                root.right = deleteKey(root.right, key);
            }
        }
        return root;
    }

    private Tree getSuccesor(Tree root) {
        Tree current = root.right;
        while (current != null && current.left != null)
            current = current.left;
        return current;
    }
}
