package com.dsa.scaller.linkedlist;

import java.util.*;

public class LRU {

    //Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.
    //
    //get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
    //set(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least recently used item before inserting the new item.
    //The LRUCache will be initialized with an integer corresponding to its capacity. Capacity indicates the maximum number of unique keys it can hold at a time.
    //
    //Definition of "least recently used" : An access to an item is defined as a get or a set operation of the item. "Least recently used" item is the one with the oldest access time.
    //
    //NOTE: If you are using any global variables, make sure to clear them in the constructor.
    //
    //Example :
    //
    //Input :
    //         capacity = 2
    //         set(1, 10)
    //         set(5, 12)
    //         get(5)        returns 12
    //         get(1)        returns 10
    //         get(10)       returns -1
    //         set(6, 14)    this pushes out key = 5 as LRU is full.
    //         get(5)        returns -1
    //Expected Output
    //Enter your input as per the following guideline:
    //There are 1 lines in the input
    //
    //Line 1 ( Corresponds to arg 1 ) : The line starts with a pair of number numOperations, capacity. capacity is the number your constructor is initialized with.
    //Then numOperation operations follow.
    //Each operation is either :
    // * G  : This corresponds to a function call get()
    // * S   : This corresponds to a function call set(num1, num2)
    //Note that the function calls are made in order.


    class Node {
        int key, value;
        Node pre, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
            pre = null;
            next = null;
        }
    }

    int capacity;
    Map<Integer, Node> map;
    Node head, tail;

    public LRU(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.pre = head;
    }

    private void addFront(Node node) {
        Node nbr = head.next;
        node.next = nbr;
        node.pre = head;
        nbr.pre = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        if (node == null) {
            return;
        }

        Node preNbr = node.pre;
        Node nxtNbr = node.next;

        if (preNbr != null) {
            preNbr.next = nxtNbr;
        }

        if (nxtNbr != null) {
            nxtNbr.pre = preNbr;
        }

        node.next = node.pre = null;
    }

    private void moveToFirst(Node node) {
        removeNode(node);
        addFront(node);
    }

    public int get(int key) {
        Node current = map.get(key);

        if (current == null) {
            return -1;
        } else {
            moveToFirst(current);
            return current.value;
        }
    }

    public void set(int key, int value) {
        Node current = map.get(key);

        if (current == null) {
            Node node = new Node(key, value);

            if (capacity == map.size()) {
                Node lru = tail.pre;
                map.remove(lru.key);
                removeNode(lru);
            }

            map.put(key, node);
            addFront(node);
        } else {
            current.value = value;
            map.put(key, current);
            moveToFirst(current);
        }
    }
}
