package com.dsa.geeksforgeek.linkedlist;

import java.util.ArrayDeque;
import java.util.Deque;
class Node1{
    char data;
    Node1 next;
    Node1(char x){
        data=x;
        next=null;
    }
}
public class Palindrome {

    static boolean isPalindrome(Node1 head){
        Deque<Character> stack=new ArrayDeque<Character>();
        for(Node1 curr=head;curr!=null;curr=curr.next)
            stack.push(curr.data);
        for(Node1 curr=head;curr!=null;curr=curr.next){
            if(stack.pop()!=curr.data)
                return false;
        }
        return true;
    }

    static Node1 reverseList(Node1 head){
        if(head==null||head.next==null)return head;
        Node1 rest_head=reverseList(head.next);
        Node1 rest_tail=head.next;
        rest_tail.next=head;
        head.next=null;
        return rest_head;
    }

    static boolean isPalindrome2(Node1 head){
        if(head==null) return true;
        Node1 slow=head,fast=head;
        while(fast.next != null && fast.next.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node1 rev=reverseList(slow.next);
        Node1 curr=head;
        while(rev!=null){
            if(rev.data!=curr.data)
                return false;
            rev=rev.next;
            curr=curr.next;
        }
        return true;
    }

    public static void main(String args[])
    {
        Node1 head=new Node1('g');
        head.next=new Node1('f');
        head.next.next=new Node1('g');
        if(isPalindrome2(head))
            System.out.print("Yes");
        else
            System.out.print("No");

    }
}
