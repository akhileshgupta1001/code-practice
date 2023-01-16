package com.dsa.geeksforgeek.linkedlist;

public class ReverseLL {

    public static Node reverseLL(Node head) {
        return getNode(head);
    }

    private static Node getNode(Node head) {
        Node current = head;
        Node prev = null;

        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
