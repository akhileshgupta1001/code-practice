package com.dsa.geeksforgeek.linkedlist;

import java.util.HashSet;

//https://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/
public class IntersectionLL {
    static int getIntersection(Node head1, Node head2)
    {
        HashSet<Node> s=new HashSet<>();
        Node curr=head1;
        while(curr!=null){
            s.add(curr);
            curr=curr.next;
        }
        curr=head2;
        while(curr!=null){
            if(s.contains(curr))
                return curr.data;
            curr=curr.next;
        }
        return -1;
    }

    static  int getCount(Node node)
    {
        Node current = node;
        int count = 0;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }

    static int getIntesectionNode(int d, Node node1, Node node2)
    {
        int i;
        Node current1 = node1;
        Node current2 = node2;
        for (i = 0; i < d; i++) {
            if (current1 == null) {
                return -1;
            }
            current1 = current1.next;
        }
        while (current1 != null && current2 != null) {
            if (current1.data == current2.data) {
                return current1.data;
            }
            current1 = current1.next;
            current2 = current2.next;
        }

        return -1;
    }

    static int  getNode(Node head1, Node head2) {
        int c1 = getCount(head1);
        int c2 = getCount(head2);
        int d;

        if (c1 > c2) {
            d = c1 - c2;
            return getIntesectionNode(d, head1, head2);
        }
        else {
            d = c2 - c1;
            return getIntesectionNode(d, head2, head1);
        }
    }


    public static void main(String[] args) {
        Node newNode;

        Node head1 = new Node(10);

        Node head2 = new Node(3);

        newNode = new Node(6);
        head2.next = newNode;

        newNode = new Node(9);
        head2.next.next = newNode;

        newNode = new Node(15);
        head1.next = newNode;
        head2.next.next.next = newNode;

        newNode = new Node(30);
        head1.next.next = newNode;

        head1.next.next.next = null;

     //   System.out.print(getIntersection(head1, head2));
        System.out.print(getNode(head1, head2));
    }
}
