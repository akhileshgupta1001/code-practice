package com.dsa.geeksforgeek.tree;

public class TreeTest {
    Tree root;

    public static void main(String[] args) {

        TreeTest tree = new TreeTest();
        tree.root = new Tree(1);
        tree.root.left = new Tree(2);
        tree.root.right = new Tree(3);
        tree.root.left.left = new Tree(4);
        tree.root.left.right = new Tree(5);
        // LevelOrder.levelOrderTraversal(tree.root);
        //LevelOrder.levelOrderTraversalLineByLine(tree.root);
        //LevelOrder.levelOrderTraversalLineByLine2(tree.root);
        // System.out.println(Size.getSize(tree.root));
        //  System.out.println(MaximumNode.getMax(tree.root));
       // PrintLeftView.leftView(tree.root, 1);
       // PrintLeftView.leftViewUsingItertaive(tree.root, 1);
        System.out.println(ChildrenSumProperty.isChildrenSumProperty(tree.root));
        System.out.println(CheckBalanceTree.isBalanceTree(tree.root));
    }
}
