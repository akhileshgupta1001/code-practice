package com.dsa.scaller.linkedlist;

public class PalindromeList {
    //Problem Description
    //Given a singly linked list A, determine if it's a palindrome. Return 1 or 0, denoting if it's a palindrome or not, respectively.
    //
    //
    //
    //Problem Constraints
    //1 <= |A| <= 105
    //
    //
    //
    //Input Format
    //The first and the only argument of input contains a pointer to the head of the given linked list.
    //
    //
    //
    //Output Format
    //Return 0, if the linked list is not a palindrome.
    //
    //Return 1, if the linked list is a palindrome.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //A = [1, 2, 2, 1]
    //Input 2:
    //
    //A = [1, 3, 2]
    //
    //
    //Example Output
    //Output 1:
    //
    // 1
    //Output 2:
    //
    // 0
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // The first linked list is a palindrome as [1, 2, 2, 1] is equal to its reversed form.
    //Explanation 2:
    //
    // The second linked list is not a palindrom as [1, 3, 2] is not equal to [2, 3, 1].

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    private int getCount(ListNode head) {
        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public int lPalin(ListNode A) {
        int count = getCount(A);
        int mid = count / 2;

        ListNode current = A;
        // ListNode prev = null;

        // Traverse to the middle node
        for (int i = 0; i < mid; i++) {
            // prev = current;
            current = current.next;
        }

        // If the count is odd, move to the next node
        if (count % 2 == 1) {
            current = current.next;
        }

        // Reverse the second half of the linked list
        ListNode reversed = reverse(current);

        // Compare the first half with the reversed second half
        ListNode firstHalf = A;
        while (reversed != null) {
            if (firstHalf.val != reversed.val) {
                return 0;
            }
            firstHalf = firstHalf.next;
            reversed = reversed.next;
        }

        return 1;
    }
}
