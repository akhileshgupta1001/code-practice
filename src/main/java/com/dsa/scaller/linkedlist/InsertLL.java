package com.dsa.scaller.linkedlist;

public class InsertLL {

    //Problem Description
    //You are given A which is the head of a linked list. Also given is the value B and position C. Complete the function that should insert a new node with the said value at the given position.
    //
    //Notes:
    //
    //In case the position is more than length of linked list, simply insert the new node at the tail only.
    //In case the pos is 0, simply insert the new node at head only.
    //Follow 0-based indexing for the node numbering.
    //
    //
    //Problem Constraints
    //1 <= size of linked list <= 105
    //
    //1 <= value of nodes <= 109
    //
    //1 <= B <= 109
    //
    //0 <= C <= 105
    //
    //
    //
    //Input Format
    //The first argument A is the head of a linked list.
    //
    //The second argument B is an integer which denotes the value of the new node
    //
    //The third argument C is an integer which denotes the position of the new node
    //
    //
    //
    //Output Format
    //Return the head of the linked list
    //
    //
    //Example Input
    //Input 1:
    //A = 1 -> 2
    //B = 3
    //C = 0
    //Input 2:
    //A = 1 -> 2
    //B = 3
    //C = 1
    //
    //
    //Example Output
    //Output 1:
    //3 -> 1 -> 2
    //Output 2:
    //1 -> 3 -> 2
    //
    //
    //Example Explanation
    //For Input 1:
    //The new node is add to the head of the linked list
    //For Input 2:
    //The new node is added after the first node of the linked list

    public static ListNode addTail(ListNode head,int data){
        ListNode newNode = new ListNode(data);
        if(head==null){
            return newNode;
        }else {
            ListNode temp= head;
            while (temp.next !=null){
                temp= temp.next;
            }
            temp.next= newNode;
            newNode=temp;
        }
        return head;

    }
    public static int count(ListNode head) {
        ListNode temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public static ListNode solve(ListNode A, int B, int C) {
        ListNode n = new ListNode(B);
        if (C <= 0){
            n.next = A;
            return n;
        }

        int i = 0;
        ListNode temp = A;
        while (i < C-1 && temp.next != null){
            i += 1;
            temp = temp.next;
        }

        n.next = temp.next;
        temp.next = n;
        return A;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(6);
        addTail(listNode1,3);
        addTail(listNode1,3);
        addTail(listNode1,6);
        addTail(listNode1,7);
        addTail(listNode1,8);
        addTail(listNode1,7);
        addTail(listNode1,3);
        addTail(listNode1,7);
        System.out.println(solve(listNode1,3,9));
    }
}
