package com.dsa.scaller.linkedlist;

public class ReorderList {
    // Problem Description
    //Given a singly linked list A
    //
    // A: A0 → A1 → … → An-1 → An
    //reorder it to:
    //
    // A0 → An → A1 → An-1 → A2 → An-2 → …
    //You must do this in-place without altering the nodes' values.
    //
    //
    //
    //Problem Constraints
    //1 <= |A| <= 106
    //
    //
    //
    //Input Format
    //The first and the only argument of input contains a pointer to the head of the linked list A.
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
    // A = [1, 2, 3, 4, 5]
    //Input 2:
    //
    // A = [1, 2, 3, 4]
    //
    //
    //Example Output
    //Output 1:
    //
    // [1, 5, 2, 4, 3]
    //Output 2:
    //
    // [1, 4, 2, 3]
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // The array will be arranged to [A0, An, A1, An-1, A2].
    //Explanation 2:
    //
    // The array will be arranged to [A0, An, A1, An-1, A2].
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

    public ListNode reverse(ListNode head){
        ListNode prev= null;
        ListNode current = head;
        ListNode next = null;
        while(current != null){
            next = current.next;
            current.next =prev;
            prev=current;
            current=next;
        }
        head = prev;
        return head;
    }
    public ListNode merge(ListNode A, ListNode B){
        ListNode a=A;
        ListNode b = B ;
        ListNode head=a;

        while(a != null && b != null){
            ListNode temp= a.next;
            a.next=b;
            b=b.next;
            a.next.next=temp;
            a= temp;
        }
        return head;
    }
    public ListNode reorderList(ListNode A) {
        if(A== null || A.next ==null) return A;
        ListNode mid = getMiddle(A);
        ListNode secondHalf = mid.next;
        mid.next= null;
        secondHalf = reverse(secondHalf);
        return merge(A,secondHalf);
    }
}
