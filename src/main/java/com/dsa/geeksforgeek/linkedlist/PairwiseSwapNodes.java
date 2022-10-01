package com.dsa.geeksforgeek.linkedlist;

public class PairwiseSwapNodes {

    //nput : 1->2->3->4->5->6->NULL
    //Output : 2->1->4->3->6->5->NULL
    //
    //Input : 1->2->3->4->5->NULL
    //Output : 2->1->4->3->5->NULL
    //
    //Input : 1->NULL
    //Output : 1->NULL

    //https://www.geeksforgeeks.org/pairwise-swap-elements-of-a-given-linked-list/

    public static Node pairwiseSwap(Node head){
        Node current = head;

        while (current != null && current.next != null){
           // Step -1
            int temp = current.data;
            current.data = current.next.data;
            current.next.data= temp;
            // Step-2
            current = current.next.next;
        }

        return head;
    }

}
