package com.dsa.geeksforgeek.linkedlist;

public class DoublyLinkedListOperation {

    public static DoublyNode insertBeign(DoublyNode head, int data) {
        DoublyNode newNode = new DoublyNode(data);
        newNode.next = head;
        if (head != null)
            head.prev = newNode;
        head = newNode;
        return head;
    }

    public static void printNode(DoublyNode head) {
        DoublyNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static DoublyNode insertEnd(DoublyNode head, int data) {

        DoublyNode newNode = new DoublyNode(data);
        if (head == null)
            return newNode;
        DoublyNode current = head;
        while (current.next != null)
            current = current.next;
        current.next = newNode;
        newNode.prev = current;
        return head;
    }

    public static DoublyNode reverse(DoublyNode head) {

        if (head == null || head.next == null) return head;

        DoublyNode prev = null, current = head;

        while (current != null) {
            prev = current.prev;
            current.prev = current.next;
            current.next = prev;
            current = current.prev;
        }
        return prev.prev;
    }

    public static DoublyNode deleteFisrtNode(DoublyNode head) {
        if (head == null || head.next == null)
            return null;
        else {
            head = head.next;
            head.prev = null;
            return head;
        }
    }

    public static DoublyNode deleteLastNode(DoublyNode head) {
        if (head == null || head.next == null)
            return null;
        DoublyNode current = head;
        while (current.next.next != null)
            current = current.next;

        current.prev.next = null;
        return head;
    }


    public static void main(String[] args) {
        DoublyNode head = null;
        head = insertBeign(head, 30);
        head = insertBeign(head, 20);
        head = insertBeign(head, 10);
        head = insertEnd(head, 40);
        head = insertEnd(head, 50);

        printNode(head);
        //head = reverse(head);
        System.out.println();
        head = deleteFisrtNode(head);
        printNode(head);
    }
}

