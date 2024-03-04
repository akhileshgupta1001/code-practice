package com.dsa.scaller.linkedlist;

import java.util.ArrayList;

public class    KReverseLL {
    //Problem Description
    //Given a singly linked list A and an integer B, reverse the nodes of the list B at a time and return the modified linked list.
    //
    //
    //
    //Problem Constraints
    //1 <= |A| <= 103
    //
    //B always divides A
    //
    //
    //
    //Input Format
    //The first argument of input contains a pointer to the head of the linked list.
    //
    //The second arugment of input contains the integer, B.
    //
    //
    //
    //Output Format
    //Return a pointer to the head of the modified linked list.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = [1, 2, 3, 4, 5, 6]
    // B = 2
    //Input 2:
    //
    // A = [1, 2, 3, 4, 5, 6]
    // B = 3
    //
    //
    //Example Output
    //Output 1:
    //
    // [2, 1, 4, 3, 6, 5]
    //Output 2:
    //
    // [3, 2, 1, 6, 5, 4]
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // For the first example, the list can be reversed in groups of 2.
    //    [[1, 2], [3, 4], [5, 6]]
    // After reversing the K-linked list
    //    [[2, 1], [4, 3], [6, 5]]
    //Explanation 2:
    //
    // For the second example, the list can be reversed in groups of 3.
    //    [[1, 2, 3], [4, 5, 6]]
    // After reversing the K-linked list
    //    [[3, 2, 1], [6, 5, 4]]

    public ListNode reverseList(ListNode A, int B) {
        ListNode pre = null;
        ListNode current = A;
        ListNode next = null;
        int count = 0;
        while (current != null && count < B) {
            next = current.next;
            current.next = pre;
            pre = current;
            current = next;
            count++;
        }

        if (next != null) {
            ListNode resetHead = reverseList(next, count);
            A.next = resetHead;
        }
        return pre;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);  list.add(3);
        list.add(4);
        list.add(5);


        System.out.println(list.subList(1, list.size()));

    }
}
