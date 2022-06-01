package com.dsa.geeksforgeek.linkedlist;

import java.util.HashSet;

public class DetectLoop {

    public static boolean isLoopExist(Node head) {

        Node temp = new Node();
        Node current = head;
        while (current != null) {

            if (current.next == null)
                return false;
            if (current.next == temp)
                return true;

            Node current_next = current.next;
            current.next = temp;
            current = current_next;
        }
        return false;
    }

    public static boolean isLoopExists(Node head) {
        HashSet<Node> set = new HashSet<>();
        for (Node current = head; current != null; current = current.next) {
            if (set.contains(current))
                return true;
            set.add(current);
        }
        return false;
    }

    //floyd detection
    public static boolean isLoop(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }

    public static void detectAndRemoveLoop(Node head) {
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }
        if (slow != fast)
            return;

        slow = head;
        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = null;

    }
}
