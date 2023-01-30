package com.dsa.geeksforgeek.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

//https://www.geeksforgeeks.org/kth-smallest-largest-element-in-unsorted-array/
public class KthSmallest {
    //Input: arr[] = {7, 10, 4, 3, 20, 15}, K = 3
    //Output: 7
    //
    //Input: arr[] = {7, 10, 4, 3, 20, 15}, K = 4
    //Output: 10
    //

    public static int getKthSmallestElement(int[] arr, int k ){

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i =0;i<k;i++){
            queue.add(arr[i]);
        }

        for(int i =k;i<arr.length;i++){

            if(queue.peek()>arr[i]){
                queue.poll();
                queue.add(arr[i]);
            }
        }

        return queue.peek();
    }

    public static void main(String[] args) {

        System.out.println(getKthSmallestElement(new int[]{7, 10, 4, 3, 20, 15},3));
    }
}
