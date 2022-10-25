package com.dsa.geeksforgeek.heap;

import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Stack;

//https://www.geeksforgeeks.org/nearly-sorted-algorithm/
//Input : arr[] = {6, 5, 3, 2, 8, 10, 9}
//            k = 3
//Output : arr[] = {2, 3, 5, 6, 8, 9, 10}
//
//Input : arr[] = {10, 9, 8, 7, 4, 70, 60, 50}
//         k = 4
//Output : arr[] = {4, 7, 8, 9, 10, 50, 60, 70}
//Time Complexity: O(k) + O((m) * log(k)) ,  where m = n – k
//Auxiliary Space: O(k)
public class KSortedArray {

    public static int[] kSortedArray(int [] arr, int k ){
        Stack<Character> stack = new Stack<>();

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i=0;i<k+1;i++){
            priorityQueue.add(arr[i]);
        }
        int index =0;
        for(int i=k+1;i<arr.length;i++){
            int min = priorityQueue.poll();
            arr[index++] = min;
            priorityQueue.add(arr[i]);
        }
        Iterator<Integer> itr = priorityQueue.iterator();;
        while (itr.hasNext()) {
            arr[index++] = priorityQueue.peek();
            priorityQueue.poll();
        }
        Arrays.stream(arr).forEach(System.out::println);
        return arr;

    }

    public static void main(String[] args) {
        int k = 3;
        int arr[] = { 2, 6, 3, 12, 56, 8 };
        kSortedArray(arr, k);

    }
}
