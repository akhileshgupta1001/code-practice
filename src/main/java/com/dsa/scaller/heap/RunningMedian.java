package com.dsa.scaller.heap;


import java.util.*;

public class RunningMedian {

    public ArrayList<Integer> solve(ArrayList<Integer> A) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < A.size(); i++) {

            int data = A.get(i);
            if (maxHeap.isEmpty()) {
                maxHeap.add(data);
                ans.add(data);
                continue;
            }
            if (data <= maxHeap.peek()) {
                maxHeap.add(data);
                if ((maxHeap.size() - minHeap.size()) > 1) {
                    minHeap.add(maxHeap.poll());
                    ans.add(maxHeap.peek());
                    //System.out.println("ans : " + ans);
                }else{
                    ans.add(maxHeap.peek());
                    System.out.println("ans : " + ans);
                }
            } else {
                minHeap.add(data);
                if ((maxHeap.size() - minHeap.size()) < 0) {
                    maxHeap.add(minHeap.poll());
                    ans.add(minHeap.peek());
                    System.out.println("ans : " + ans);
                }else{
                    ans.add(maxHeap.peek());
                    System.out.println("ans : " + ans);
                }
            }
        }
        System.out.println("Data : " + ans);
        return ans;
    }

    public static void main(String[] args) {
        RunningMedian median = new RunningMedian();
        median.solve(new ArrayList<>(Arrays.asList(59, 64, 10, 39)));
    }
}
