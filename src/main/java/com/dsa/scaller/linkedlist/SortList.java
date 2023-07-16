package com.dsa.scaller.linkedlist;

public class SortList {
    //Problem Description
    //Sort a linked list, A in O(n log n) time.
    //
    //
    //
    //Problem Constraints
    //0 <= |A| = 105
    //
    //
    //
    //Input Format
    //The first and the only arugment of input contains a pointer to the head of the linked list, A.
    //
    //
    //
    //Output Format
    //Return a pointer to the head of the sorted linked list.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //A = [3, 4, 2, 8]
    //Input 2:
    //
    //A = [1]
    //
    //
    //Example Output
    //Output 1:
    //
    //[2, 3, 4, 8]
    //Output 2:
    //
    //[1]
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // The sorted form of [3, 4, 2, 8] is [2, 3, 4, 8].
    //Explanation 2:
    //
    // The sorted form of [1] is [1].


    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode head = new ListNode(-1);
        ListNode temp = head;

        while (A != null && B != null) {
            if (A.val <= B.val) {
                temp.next = A;
                A = A.next;
            } else {
                temp.next = B;
                B = B.next;
            }
            temp = temp.next;
        }

        if (A != null) {
            temp.next = A;
        } else {
            temp.next = B;
        }

        return head.next;
    }

    public ListNode getMiddle(ListNode head) {
        if (head == null) return null;

        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode mid = getMiddle(head);
        ListNode secondHalf = mid.next;
        mid.next = null;
        ListNode sortedFirstHalf = sortList(head);
        ListNode sortedSecondHalf = sortList(secondHalf);
        return mergeTwoLists(sortedFirstHalf, sortedSecondHalf);
    }
}
