package com.dsa.scaller.linkedlist;

public class RemoveDuplicatesfromSortedList {
    //Problem Description
    //Given a sorted linked list, delete all duplicates such that each element appears only once.
    //
    //
    //
    //Problem Constraints
    //0 <= length of linked list <= 106
    //
    //
    //
    //Input Format
    //First argument is the head pointer of the linked list.
    //
    //
    //
    //Output Format
    //Return the head pointer of the linked list after removing all duplicates.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // 1->1->2
    //Input 2:
    //
    // 1->1->2->3->3
    //
    //
    //Example Output
    //Output 1:
    //
    // 1->2
    //Output 2:
    //
    // 1->2->3
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // Each element appear only once in 1->2.

    public ListNode deleteDuplicates(ListNode A) {
        ListNode current = A;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return A;
    }
}
