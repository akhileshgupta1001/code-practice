package com.dsa.geeksforgeek.linkedlist;

public class ReverseKthGroup {

    //10 20 25 30 35 40
    //25 20 10 40 35 30
    // O (k)
    public static Node reverseKthGroup(Node head, int index) {

        Node current = head;
        Node prev = null;
        Node next = null;
        int count = 0;
        while (current != null && index > count) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }
        if (next != null) {
            Node resetHead = reverseKthGroup(next, index);
            head.next = resetHead;
        }
        return prev;
    }

    public static Node reverseKGroup(Node head, int index) {

        Node current = head;
        Node prevFirst = null;
        boolean isFirstPass = true;
        while (current != null) {
            Node first = current;
            Node prev = null;
            int count = 0;
            while (current != null && count < index) {
                Node next = current.next;
                current.next = prev;
                prev = current;
                current = next;
                count++;
            }
            if (isFirstPass) {
                head = prev;
                isFirstPass = false;
            } else {
                prevFirst.next = prev;
            }
            prevFirst = first;
        }
        return head;
    }
}
