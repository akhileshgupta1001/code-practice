package com.dsa.geeksforgeek.tree;

public class TreeToDublyLL {

    static Tree prev = null;

    public static Tree treeToDublyLL(Tree root) {

        if (root == null) return root;

        Tree head = treeToDublyLL(root.left);
        if (prev == null) {
            head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        treeToDublyLL(root.right);
        return head;
    }

    static void printList(Tree node) {
        while (node != null) {
            System.out.print(node.key + " ");
            node = node.right;
        }
    }

    Tree root;

    public static void main(String[] args) {
        TreeToDublyLL tree = new TreeToDublyLL();
        tree.root = new Tree(10);
        tree.root.left = new Tree(12);
        tree.root.right = new Tree(15);
        tree.root.left.left = new Tree(25);
        tree.root.left.right = new Tree(30);
        tree.root.right.left = new Tree(36);
        TreeToDublyLL.printList(TreeToDublyLL.treeToDublyLL(tree.root));
    }
}
