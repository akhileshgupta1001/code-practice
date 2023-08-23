package com.dsa.scaller.heap;

import com.dsa.scaller.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

//Problem Description
//Given a list containing head pointers of N sorted linked lists.
//Merge these given sorted linked lists and return them as one sorted list.
//
//
//
//Problem Constraints
//1 <= total number of elements in given linked lists <= 100000
//
//
//
//Input Format
//The first and only argument is a list containing N head pointers.
//
//
//
//Output Format
//Return a pointer to the head of the sorted linked list after merging all the given linked lists.
//
//
//
//Example Input
//Input 1:
//
// 1 -> 10 -> 20
// 4 -> 11 -> 13
// 3 -> 8 -> 9
//Input 2:
//
// 10 -> 12
// 13
// 5 -> 6
//
//
//Example Output
//Output 1:
//
// 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20
//Output 2:
//
// 5 -> 6 -> 10 -> 12 ->13
//
//
//Example Explanation
//Explanation 1:
//
// The resulting sorted Linked List formed after merging is 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20.
//Explanation 2:
//
// The resulting sorted Linked List formed after merging is 5 -> 6 -> 10 -> 12 ->13.

public class MergeKSortedLists {

    // n2
    public ListNode mergeKLists(ArrayList<ListNode> a) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < a.size(); i++) {
            ListNode node = a.get(i);
            while (node != null) {
                queue.add(node.val);
                node = node.next;
            }

        }
        ListNode head = new ListNode(queue.poll());
        while (!queue.isEmpty()) {
            Integer data = queue.poll();
            addToTail(head, data);
        }
        return head;
    }

    public static ListNode addToTail(ListNode head, int val) {
        ListNode newNode = new ListNode(val);

        if (head == null) {
            return newNode;
        }

        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;

        return head;
    }

    public ListNode mergeKLists2(ArrayList<ListNode> a) {
        // Create a min-heap with custom comparator to order nodes by their values
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));

        // Initialize the heap with the first nodes from all linked lists
        for (ListNode node : a) {
            if (node != null) {
                minHeap.add(node);
            }
        }

        // Initialize a dummy node to create the merged sorted linked list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        // Merge the linked lists using the min-heap
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll(); // Extract the smallest node
            current.next = node; // Add the node to the merged list
            current = current.next;

            if (node.next != null) {
                minHeap.add(node.next); // Offer the next node into the heap
            }
        }

        return dummy.next; // Return the head of the merged list
    }

    public static void main(String[] args) {
        ArrayList<ListNode> lists1 = new ArrayList<>();
        ListNode list1a = new ListNode(1);
        list1a.next = new ListNode(10);
        list1a.next.next = new ListNode(20);
        lists1.add(list1a);

        ListNode list1b = new ListNode(4);
        list1b.next = new ListNode(11);
        list1b.next.next = new ListNode(13);
        lists1.add(list1b);

        ListNode list1c = new ListNode(3);
        list1c.next = new ListNode(8);
        list1c.next.next = new ListNode(9);
        lists1.add(list1c);

        System.out.println(lists1);

        List<ListNode> lists2 = new ArrayList<>();
        ListNode list2a = new ListNode(10);
        list2a.next = new ListNode(12);
        lists2.add(list2a);

        ListNode list2b = new ListNode(13);
        lists2.add(list2b);

        ListNode list2c = new ListNode(5);
        list2c.next = new ListNode(6);
        lists2.add(list2c);

        MergeKSortedLists solution = new MergeKSortedLists();

        ListNode mergedList1 = solution.mergeKLists(lists1);
        System.out.println("Merged Linked List 1:");
        printLinkedList(mergedList1);

    }

    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}
