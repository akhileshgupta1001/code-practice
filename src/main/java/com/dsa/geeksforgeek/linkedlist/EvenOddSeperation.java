package com.dsa.geeksforgeek.linkedlist;

public class EvenOddSeperation {

    //17 -> 15->8->12->10->5->4
    //8->12->10->4->17->15->5
    public static Node evenOddSeperation(Node head) {
        Node evenStart, evenEnd, oddStart, oddEnd;
        evenStart = evenEnd = oddStart = oddEnd = null;
        Node current = head;
        while (current != null) {


            int nodeData = current.data;
            if (nodeData % 2 == 0) {
                if (evenStart == null) {
                    evenStart = current;
                    evenEnd = evenStart;
                } else {
                    evenEnd.next = current;
                    evenEnd = evenEnd.next;
                }
            } else {
                if (oddStart == null) {
                    oddStart = current;
                    oddEnd = oddStart;
                } else {
                    oddEnd.next = current;
                    oddEnd = oddEnd.next;
                }
            }
            current = current.next;
        }

        if (oddStart == null || evenStart == null)
            return head;
        evenEnd.next = oddStart;
        oddEnd.next = null;
        return evenStart;
    }
}
