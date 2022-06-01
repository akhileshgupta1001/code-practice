package com.dsa.geeksforgeek.linkedlist;

public class LinkedListOperation {
    public static Node insertBeign(Node head, int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
        return head;
    }

    public static Node insertEnd(Node head, int data) {

        Node newNode = new Node(data);
        if (head == null)
            return newNode;
        Node current = head;
        while (current.next != null)
            current = current.next;
        current.next = newNode;
        return head;
    }

    public static void printNode(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static Node deleteFisrtNode(Node head) {
        if (head == null)
            return null;
        else
            return head.next;
    }

    public static Node deleteLastNode(Node head) {
        if (head == null || head.next == null)
            return null;
        Node current = head;
        while (current.next.next != null)
            current = current.next;

        current.next = null;
        return head;
    }

    public static Node insertNodeAtIndex(Node head, int position, int data) {

        Node newNode = new Node(data);
        if (position == 0) {
            newNode.next = head;
            head = newNode;
            return head;
        }
        Node currentNode = head;
        for (int i = 0; i < position - 1 && currentNode != null; i++) {
            currentNode = currentNode.next;
        }
        if (currentNode == null)
            return head;

        newNode.next = currentNode.next;
        currentNode.next = newNode;
        return head;
    }

    public static void main(String[] args) {
        Node head = null;
        //head = insertBeign(head, 30);
        //head = insertBeign(head, 20);
        head = insertBeign(head, 17);
        head = insertEnd(head, 15);
        head = insertEnd(head, 8);
        head = insertEnd(head, 12);
        head = insertEnd(head, 10);
        head = insertEnd(head, 5);
        head = insertEnd(head, 4);


        // head = deleteFisrtNode(head);
        // head = deleteLastNode(head);
        //head = insertNodeAtIndex(head, 0, 10);
        //head = insertNodeAtIndex(head, 2, 25);
        //head = insertNodeAtIndex(head, 5, 40);

        //printNode(head);
        System.out.println();
        // head= ReverseLL.reverseLL(head);
        //head = ReverseKthGroup.reverseKGroup(head, 3);
        head = EvenOddSeperation.evenOddSeperation(head);
        printNode(head);
        // PrintNthFromLastNode.printNthFromLastNode(head, 2);
    }
}
