package com.dsa.scaller.tree.traversal;

import java.util.*;

public class BottomView {
    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Pair<Node, Integer>> q = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        q.add(new Pair<>(root, 0));

        while (!q.isEmpty()) {
            Pair<Node, Integer> p = q.poll();
            Node node = p.getKey();
            Integer line = p.getValue();
            map.put(line, node.data);

            if (node.left != null) {
                q.add(new Pair<>(node.left, line - 1));
            }
            if (node.right != null) {
                q.add(new Pair<>(node.right, line + 1));
            }
        }

        for (Map.Entry<Integer, Integer> m : map.entrySet()) {
            ans.add(m.getValue());
        }

        return ans;
    }

    // Definition for the Node class.
    public static class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    // Custom Pair class
    public static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }
}
