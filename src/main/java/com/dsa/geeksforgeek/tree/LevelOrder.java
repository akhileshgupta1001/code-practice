package com.dsa.geeksforgeek.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {

    public static void levelOrderTraversal(Tree tree) {

        if (tree == null)
            return;

        Queue<Tree> queue = new LinkedList<>();
        queue.add(tree);
        while (!queue.isEmpty()) {
            Tree current = queue.poll();
            System.out.print(current.key + " ");
            if (current.left != null)
                queue.add(current.left);

            if (current.right != null)
                queue.add(current.right);

        }
    }

    public static void levelOrderTraversalLineByLine(Tree tree) {

        if (tree == null)
            return;

        Queue<Tree> queue = new LinkedList<>();
        queue.add(tree);
        queue.add(null);
        while (queue.size() > 1) {
            Tree current = queue.poll();
            if (current == null) {
                System.out.println();
                queue.add(null);
                continue;
            }
            System.out.print(current.key + " ");
            if (current.left != null)
                queue.add(current.left);

            if (current.right != null)
                queue.add(current.right);

        }
    }

    public static void levelOrderTraversalLineByLine2(Tree tree) {

        if (tree == null)
            return;

        Queue<Tree> queue = new LinkedList<>();
        queue.add(tree);
        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                Tree current = queue.poll();
                System.out.print(current.key + " ");
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }
            System.out.println();

        }
    }
}
