package com.dsa.scaller.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class RangeSumQuery {
    //You are given an integer array A of length N.
    //You are also given a 2D integer array B with dimensions M x 2, where each row denotes a [L, R] query.
    //For each query, you have to find the sum of all elements from L to R indices in A (0 - indexed).
    //More formally, find A[L] + A[L + 1] + A[L + 2] +... + A[R - 1] + A[R] for each query

    //Input 1:
    //A = [1, 2, 3, 4, 5]
    //B = [[0, 3], [1, 2]]
    //Input 2:
    //
    //A = [2, 2, 2]
    //B = [[0, 0], [1, 2]]

    //Output 1:
    //[10, 5]
    //Output 2:
    //
    //[2, 4]

    public static ArrayList<Long> rangeSum(ArrayList<Integer> A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<Long> arr = new ArrayList<>();
        for (int i = 0; i < A.size(); i++) {
            arr.add((long) A.get(i));
        }
        for (int i = 1; i < arr.size(); i++) {
            arr.set(i, arr.get(i - 1) + arr.get(i));
        }

        ArrayList<Long> ans = new ArrayList<>();

        for (int i = 0; i < B.size(); i++) {
            ArrayList<Integer> sunList = B.get(i);
            long sum = 0l;
            int first = sunList.get(0);
            int second = sunList.get(1);
           /*
            for(int j=first;j<second;j++){
                sum = sum + A.get(j);
            }
            */
            if (first == 0) {
                sum = arr.get(second);
            } else {
                sum = arr.get(second) - arr.get(first - 1);
            }
            ans.add(sum);
        }
        return ans;
    }

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add(0);
        list.add(3);

        ArrayList list1 = new ArrayList();
        list1.add(1);
        list1.add(2);

        ArrayList firstList = new ArrayList();
        firstList.add(1);
        firstList.add(2);
        firstList.add(3);
        firstList.add(4);
        firstList.add(5);
        ArrayList second = new ArrayList();
        second.add(list);
        second.add(list1);
        System.out.println(rangeSum(firstList, second));
    }
}
