package com.dsa.geeksforgeek.linkedlist;

public class RemoveDuplicatesFromSorted {

    public static Node node(Node head){
        Node current = head;
        if(current== null) return head;

        while (current != null && current.next != null){
            if(current.data== current.next.data)
                current= current.next.next;
            else
            current = current.next;
        }

        return head;
    }
}
