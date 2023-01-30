package com.dsa.geeksforgeek.heap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

//https://www.geeksforgeeks.org/nearly-sorted-algorithm/
public class NearlySorted {

    //Given an array of N elements, where each element is at most K away from its target position, devise an algorithm that sorts in O(N log K) time.
    //
    //Examples:
    //
    //Input: arr[] = {6, 5, 3, 2, 8, 10, 9}, K = 3
    //Output: arr[] = {2, 3, 5, 6, 8, 9, 10}
    //
    //Input: arr[] = {10, 9, 8, 7, 4, 70, 60, 50}, k = 4
    //Output: arr[] = {4, 7, 8, 9, 10, 50, 60, 70}

    //Time Complexity: O(K) + O(m * log(k)) ,  where M = N – K
    //Auxiliary Space: O(K)
    public static List<Integer> getNearlySortedElement(int[] arr, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            priorityQueue.add(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {

            if (priorityQueue.peek() < arr[i]) {
                result.add(priorityQueue.poll());
                priorityQueue.add(arr[i]);
            }
        }
        Iterator<Integer> iterator = priorityQueue.iterator();

        while (iterator.hasNext()) {
            result.add(priorityQueue.poll());
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(getNearlySortedElement(new int[]{6, 5, 3, 2, 8, 10, 9}, 3));
    }
}
