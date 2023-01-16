package com.dsa.geeksforgeek.linkedlist;

public class PrintNthFromLastNode {
    //1-2-3-4-5-6
    //n=2
    //o/p5

    public static void printNthFromLastNode(Node head, int position) {
        int length = 0;
        Node current = head;
        while (current != null) {
            current = current.next;
            length++;
        }
        if (length < position)
            return;

        current = head;
        for (int index = 0; index < (length - position); index++) {
            current = current.next;
        }
        System.out.println("Data : " + current.data);
    }

    public static void main(String args[])
    {
        Node head=new Node(10);
        head.next=new Node(20);
        head.next.next=new Node(30);
        head.next.next.next=new Node(40);
        head.next.next.next.next=new Node(50);
      //  printlist(head);
        System.out.print("Nth node from end of Linked List: ");
        printNthFromLastNode(head,2);

    }
}
