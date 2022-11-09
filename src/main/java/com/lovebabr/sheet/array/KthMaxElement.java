package com.lovebabr.sheet.array;

import java.util.*;
import java.util.stream.Collectors;

public class KthMaxElement {
    //https://practice.geeksforgeeks.org/problems/kth-smallest-element/0
    //https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/

    public static int getKthMaxElement(int[] arr, int k) {
        Arrays.sort(arr);
        return arr[k - 1];
    }

    public static int getKthMaxElement2(int[] arr, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            priorityQueue.add(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (priorityQueue.peek() > arr[i]) {
                priorityQueue.poll();
                priorityQueue.add(arr[i]);
            }
        }
        //System.out.println(priorityQueue);
        System.out.println(priorityQueue.peek());
        return priorityQueue.peek();
    }

    public static void main(String[] args) {
        int arr[] = {7, 10, 4, 3, 20, 15};
        getKthMaxElement2(arr, 3);
    }
}
