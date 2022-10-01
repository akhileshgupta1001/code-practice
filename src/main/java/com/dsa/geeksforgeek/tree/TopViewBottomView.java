package com.dsa.geeksforgeek.tree;

import com.dsa.geeksforgeek.linkedlist.Node;

import java.util.*;
import java.util.stream.Collectors;

//https://www.geeksforgeeks.org/print-nodes-top-view-binary-tree/
public class TopViewBottomView {
    Tree root;
    class Pair{
        int hd;
        Tree node ;

        public Pair(int hd, Tree node) {
            this.hd = hd;
            this.node = node;
        }
    }

    public List<Integer> topView(Tree node){
        Queue<Pair> queue = new LinkedList<>();
       // hd, value
        Map<Integer,Integer> map = new TreeMap<>();
        queue.add(new Pair(0,node));

        while (!queue.isEmpty()){
               Pair pair=queue.poll();
            if(!map.containsKey(pair.hd)){
                map.put(pair.hd,pair.node.key);
            }

            if(pair.node.left != null) queue.add(new Pair(pair.hd-1,pair.node.left));
            if(pair.node.right != null) queue.add(new Pair(pair.hd+1,pair.node.right));
        }
        return map.entrySet().stream().map( data -> data.getValue()).collect(Collectors.toList());
    }

    public List<Integer> bottomView(Tree node){
        Queue<Pair> queue = new LinkedList<>();
        // hd, value
        Map<Integer,Integer> map = new TreeMap<>();
        queue.add(new Pair(0,node));

        while (!queue.isEmpty()){
            Pair pair=queue.poll();
            map.put(pair.hd,pair.node.key);

            if(pair.node.left != null) queue.add(new Pair(pair.hd-1,pair.node.left));
            if(pair.node.right != null) queue.add(new Pair(pair.hd+1,pair.node.right));
        }
        return map.entrySet().stream().map( data -> data.getValue()).collect(Collectors.toList());
    }

    public static void main(String[] args) {
        TopViewBottomView tree = new TopViewBottomView();
        tree.root = new Tree(1);
        tree.root.left = new Tree(2);
        tree.root.right = new Tree(3);
        tree.root.left.right = new Tree(4);
        tree.root.left.right.right = new Tree(5);
        tree.root.left.right.right.right = new Tree(6);
        System.out.println(
                "Following are nodes in top view of Binary Tree");
        System.out.println(tree.topView(tree.root));
    }
}
