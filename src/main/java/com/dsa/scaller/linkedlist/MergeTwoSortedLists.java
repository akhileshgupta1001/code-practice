package com.dsa.scaller.linkedlist;

public class MergeTwoSortedLists {

    //Problem Description
    //Merge two sorted linked lists, A and B, and return it as a new list.
    //
    //The new list should be made by splicing together the nodes of the first two lists and should also be sorted.
    //
    //
    //
    //Problem Constraints
    //0 <= |A|, |B| <= 105
    //
    //
    //
    //Input Format
    //The first argument of input contains a pointer to the head of linked list A.
    //
    //The second argument of input contains a pointer to the head of linked list B.
    //
    //
    //
    //Output Format
    //Return a pointer to the head of the merged linked list.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = 5 -> 8 -> 20
    // B = 4 -> 11 -> 15
    //Input 2:
    //
    // A = 1 -> 2 -> 3
    // B = Null
    //
    //
    //Example Output
    //Output 1:
    //
    // 4 -> 5 -> 8 -> 11 -> 15 -> 20
    //Output 2:
    //
    // 1 -> 2 -> 3
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // Merging A and B will result in 4 -> 5 -> 8 -> 11 -> 15 -> 20
    //Explanation 2:
    //
    // We don't need to merge as B is empty.


    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode h1 = A;
        ListNode h2 = B;
        ListNode head = new ListNode(-1);

        if (h1 == null) return h2;
        if (h2 == null) return h1;

        if (h1.val <= h2.val) {
            head = h1;
            h1 = h1.next;
        } else {
            head = h2;
            h2 = h2.next;
        }
        ListNode temp = head;
        while (h1 != null && h2 != null) {
            if (h1.val <= h2.val) {
                temp.next = h1;
                h1 = h1.next;
            } else {
                temp.next = h2;
                h2 = h2.next;
            }
            temp = temp.next;
        }
        if (h1 == null) temp.next = h2;
        else temp.next = h1;

        return head;
    }
}
