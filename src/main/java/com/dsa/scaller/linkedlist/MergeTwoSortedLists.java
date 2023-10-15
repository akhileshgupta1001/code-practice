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
        ListNode h1 = A; // Initialize a pointer h1 to the head of the first list
        ListNode h2 = B; // Initialize a pointer h2 to the head of the second list
        ListNode head = new ListNode(-1); // Create a dummy node to serve as the head of the merged list

        if (h1 == null) return h2; // If the first list is empty, return the second list
        if (h2 == null) return h1; // If the second list is empty, return the first list

        if (h1.val <= h2.val) { // Compare the values of the heads of the two lists
            head = h1; // Set the head of the merged list to the smaller value node
            h1 = h1.next; // Move h1 to the next node in the first list
        } else {
            head = h2; // Set the head of the merged list to the smaller value node
            h2 = h2.next; // Move h2 to the next node in the second list
        }
        ListNode temp = head; // Create a temporary pointer to keep track of the current node in the merged list

        while (h1 != null && h2 != null) {
            if (h1.val <= h2.val) {
                temp.next = h1; // Connect the current node in the merged list to the smaller value node from the first list
                h1 = h1.next; // Move h1 to the next node in the first list
            } else {
                temp.next = h2; // Connect the current node in the merged list to the smaller value node from the second list
                h2 = h2.next; // Move h2 to the next node in the second list
            }
            temp = temp.next; // Move the temporary pointer to the newly added node in the merged list
        }

        // After the loop, one of the lists may have remaining nodes
        if (h1 == null)
            temp.next = h2; // If the first list is exhausted, connect the merged list to the remaining nodes of the second list
        else
            temp.next = h1; // If the second list is exhausted, connect the merged list to the remaining nodes of the first list

        return head; // Return the head of the merged list
    }
}