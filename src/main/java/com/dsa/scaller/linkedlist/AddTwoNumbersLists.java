package com.dsa.scaller.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class AddTwoNumbersLists {
    //Problem Description
    //You are given two linked lists, A and B, representing two non-negative numbers.
    //
    //The digits are stored in reverse order, and each of their nodes contains a single digit.
    //
    //Add the two numbers and return it as a linked list.
    //
    //
    //
    //Problem Constraints
    //1 <= |A|, |B| <= 105
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
    //Return a pointer to the head of the required linked list.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //
    // A = [2, 4, 3]
    // B = [5, 6, 4]
    //Input 2:
    //
    //
    // A = [9, 9]
    // B = [1]
    //
    //
    //Example Output
    //Output 1:
    //
    //
    // [7, 0, 8]
    //Output 2:
    //
    //
    // [0, 0, 1]
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // A = 342 and B = 465. A + B = 807.
    //Explanation 2:
    //
    // A = 99 and B = 1. A + B = 100.

    public int count(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        int carry = 0;
        int countA = count(A);
        int countB = count(B);
        int sum = 0;
        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;

        while (A != null || B != null || carry != 0) {
            int val1 = (A == null) ? 0 : A.val;
            int val2 = (B == null) ? 0 : B.val;

            sum = val1 + val2 + carry;

            // calculate the node value and carry
            int node_value = sum % 10;
            carry = sum / 10;

            // create and insert node_value to the resultant LL
            tail.next = new ListNode(node_value);
            tail = tail.next;

            // increment pointer of l1 and l2
            A = (A != null) ? A.next : null;
            B = (B != null) ? B.next : null;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {

    }
}
