package com.dsa.geeksforgeek.linkedlist;

import java.util.*;
import java.lang.*;

class DoublyLLNode {
    int key;
    int value;
    DoublyLLNode pre;
    DoublyLLNode next;

    public DoublyLLNode(int key, int value)
    {
        this.key = key;
        this.value = value;
    }
}

public class LRUCache {
    private HashMap<Integer, DoublyLLNode> map;
    private int capacity, count;
    private DoublyLLNode head, tail;

    public LRUCache(int capacity)
    {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new DoublyLLNode(0, 0);
        tail = new DoublyLLNode(0, 0);
        head.next = tail;
        tail.pre = head;
        head.pre = null;
        tail.next = null;
        count = 0;
    }

    public void deleteNode(DoublyLLNode DOublyLLNode)
    {
        DOublyLLNode.pre.next = DOublyLLNode.next;
        DOublyLLNode.next.pre = DOublyLLNode.pre;
    }

    public void addToHead(DoublyLLNode DOublyLLNode)
    {
        DOublyLLNode.next = head.next;
        DOublyLLNode.next.pre = DOublyLLNode;
        DOublyLLNode.pre = head;
        head.next = DOublyLLNode;
    }

    public int get(int key)
    {
        if (map.get(key) != null) {
            DoublyLLNode DOublyLLNode = map.get(key);
            int result = DOublyLLNode.value;
            deleteNode(DOublyLLNode);
            addToHead(DOublyLLNode);
            System.out.println("Got the value : " +
                    result + " for the key: " + key);
            return result;
        }
        System.out.println("Did not get any value" +
                " for the key: " + key);
        return -1;
    }

    public void set(int key, int value)
    {
        System.out.println("Going to set the (key, "+
                "value) : (" + key + ", " + value + ")");
        if (map.get(key) != null) {
            DoublyLLNode DOublyLLNode = map.get(key);
            DOublyLLNode.value = value;
            deleteNode(DOublyLLNode);
            addToHead(DOublyLLNode);
        }
        else {
            DoublyLLNode DOublyLLNode = new DoublyLLNode(key, value);
            map.put(key, DOublyLLNode);
            if (count < capacity) {
                count++;
                addToHead(DOublyLLNode);
            }
            else {
                map.remove(tail.pre.key);
                deleteNode(tail.pre);
                addToHead(DOublyLLNode);
            }
        }
    }
}
 class TestLRUCache {
    public static void main(String[] args)
    {

        LRUCache cache = new LRUCache(2);

        // it will store a key (1) with value
        // 10 in the cache.
        cache.set(1, 10);

        // it will store a key (2) with value 20 in the cache.
        cache.set(2, 20);
        System.out.println("Value for the key: 1 is " + cache.get(1)); // returns 10

        // removing key 2 and store a key (3) with value 30 in the cache.
        cache.set(3, 30);

        System.out.println("Value for the key: 2 is " +
                cache.get(2)); // returns -1 (not found)

        // removing key 1 and store a key (4) with value 40 in the cache.
        cache.set(4, 40);
        System.out.println("Value for the key: 1 is " +
                cache.get(1)); // returns -1 (not found)
        System.out.println("Value for the key: 3 is " +
                cache.get(3)); // returns 30
        System.out.println("Value for the key: 4 is " +
                cache.get(4)); // return 40
    }
}
