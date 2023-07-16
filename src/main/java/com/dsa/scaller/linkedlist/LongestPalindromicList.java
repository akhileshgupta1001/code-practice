package com.dsa.scaller.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class LongestPalindromicList {
    public boolean isPalindrome(List<Integer> list) {
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            if (list.get(i) != list.get(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public int solve(ListNode A) {
        ArrayList<Integer> list = new ArrayList<>();
        while (A != null) {
            list.add(A.val);
            A = A.next;
        }

        int ans = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                int size = list.subList(i, j + 1).size();
                if (isPalindrome(list.subList(i, j + 1))) {
                    ans = Math.max(ans, size);
                }
            }
        }
        return ans;
    }

    // Count the length of the common prefix between two linked lists
    private int count(ListNode A, ListNode B) {
        int count = 0;
        while (A != null && B != null && A.val == B.val) {
            count++;
            A = A.next;
            B = B.next;
        }
        return count;
    }

    public int solve2(ListNode A) {
        if (A == null) return 0;
        if (A.next == null) return 1;

        ListNode prev = null;
        ListNode current = A;
        ListNode nextNode = null;
        int ans = 0;

        while (current != null) {
            nextNode = current.next;
            current.next = prev;

            // Find the largest linked list of even size
            int count = 2 * count(current, nextNode);
            ans = Math.max(ans, count);

            // Find the largest linked list of odd size
            count = 2 * count(current.next, nextNode) + 1;
            ans = Math.max(ans, count);

            prev = current;
            current = nextNode;
        }

        return ans;
    }
}
