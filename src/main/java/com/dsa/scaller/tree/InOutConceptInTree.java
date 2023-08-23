package com.dsa.scaller.tree;

import java.util.HashMap;
import java.util.Map;

public class InOutConceptInTree {
    HashMap<Integer, Integer> in;
    // hm.get(key)
    // type of key?
    HashMap<Integer, Integer> out;
    public int count;

    public void helper(TreeNode A) {
        /*
         * This function will populate the in and out HashMaps with the in and out
         * times of each node in the tree.
         */
        if (A == null) {
            return;
        }
        in.put(A.val, count);
        count++;
        helper(A.left);
        helper(A.right);
        out.put(A.val, count);
        count++;
    }

    private boolean isAncestor(int X, int Y) {
        /*
         * This function will return true if X is an ancestor of Y, false otherwise.
         */
        return in.get(X) <= in.get(Y) && out.get(X) >= out.get(Y);
    }

    private int utility(TreeNode node, int B, int C) {
        while (node != null) {
            if (node.left != null) {
                // if B and C are both in the left subtree, then the LCA is in the left
                if (isAncestor(node.left.val, B) && isAncestor(node.left.val, C)) {
                    node = node.left;
                    continue;
                }
            }
            if (node.right != null) {
                // if B and C are both in the right subtree, then the LCA is in the right
                if (isAncestor(node.right.val, B) && isAncestor(node.right.val, C)) {
                    node = node.right;
                    continue;
                }
            }
            // if B and C are in different subtrees, then the LCA is the current node
            if (isAncestor(node.val, B) && isAncestor(node.val, C)) {
                return node.val;
            }
        }
        return -1; // This should never be reached.
    }

    public int lca(TreeNode A, int B, int C) {
        this.in = new HashMap<>();
        this.out = new HashMap<>();
        this.count = 0;
        helper(A);
        try {
            return utility(A, B, C);
        } catch (Exception e) {
            return -1;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        InOutConceptInTree inOutConceptInTree = new InOutConceptInTree();
        inOutConceptInTree.helper(root);

        System.out.println(inOutConceptInTree.in);
        System.out.println(inOutConceptInTree.out);
    }

}
