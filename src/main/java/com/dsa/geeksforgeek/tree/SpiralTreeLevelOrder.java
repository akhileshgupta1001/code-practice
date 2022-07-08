package com.dsa.geeksforgeek.tree;

import java.util.*;

public class SpiralTreeLevelOrder {
    Tree root;

    public static void spiralTree(Tree root) {
        Queue<Tree> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        queue.add(root);
        Boolean isReverse = false;

        while (!queue.isEmpty()) {

            int count = queue.size();
            for (int i = 0; i < count; i++) {
                Tree current = queue.poll();
                if (isReverse)
                    stack.add(current.key);
                else
                    System.out.print(current.key+" ");

                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);
            }

            if (isReverse) {
                while (!stack.isEmpty()) {
                    System.out.print(stack.pop() + " ");
                }
            }
            isReverse = !isReverse;
           // System.out.println();
        }
    }

    public static void main(String[] args) {
        SpiralTreeLevelOrder tree = new SpiralTreeLevelOrder();
        tree.root = new Tree(1);
        tree.root.left = new Tree(2);
        tree.root.right = new Tree(3);
        tree.root.left.left = new Tree(7);
        tree.root.left.right = new Tree(6);
        tree.root.right.left = new Tree(5);
        tree.root.right.right = new Tree(4);
       // tree.spiralTree(tree.root);

        int[] arr = new int[]{1,2,3,4,4,4,4};
       ;
    }
}
