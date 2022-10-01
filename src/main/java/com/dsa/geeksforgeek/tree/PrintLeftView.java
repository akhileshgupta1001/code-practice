package com.dsa.geeksforgeek.tree;

import java.util.LinkedList;
import java.util.Queue;

public class PrintLeftView {
    static int maxLevel = 0;

    public static void leftView(Tree tree, int level) {
        if (tree == null)
            return;
        // level have no value
        if (maxLevel < level) {
            System.out.print(tree.key + " ");
            maxLevel = level;
        }
        leftView(tree.left, level + 1);
        leftView(tree.right, level + 1);
    }

    public static void rightView(Tree tree, int level) {
        if (tree == null)
            return;
        // level have no value
        if (maxLevel < level) {
            System.out.print(tree.key + " ");
            maxLevel = level;
        }
        leftView(tree.right, level + 1);
        leftView(tree.left, level + 1);

    }

    public static void leftViewUsingItertaive(Tree tree, int level) {
        if (tree == null) return;
        Queue<Tree> queue = new LinkedList<>();
        queue.add(tree);
        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                Tree current = queue.poll();
                if (i == 0)
                    System.out.print(current.key + " ");
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
        }
    }
}
