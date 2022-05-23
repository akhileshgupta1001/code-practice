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
}
