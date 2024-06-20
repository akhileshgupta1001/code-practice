package com.dsa.scaller.hasing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class DistinctNumbersinWindow {
    //Problem Description
    //You are given an array of N integers, A1, A2 ,..., AN and an integer B. Return the of count of distinct numbers in all windows of size B.
    //
    //Formally, return an array of size N-B+1 where i'th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.
    //
    //NOTE: if B > N, return an empty array.
    //
    //
    //
    //Input Format
    //First argument is an integer array A
    //Second argument is an integer B.
    //
    //
    //
    //Output Format
    //Return an integer array.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = [1, 2, 1, 3, 4, 3]
    // B = 3
    //Input 2:
    //
    // A = [1, 1, 2, 2]
    // B = 1
    //
    //
    //Example Output
    //Output 1:
    //
    // [2, 3, 3, 2]
    //Output 2:
    //
    // [1, 1, 1, 1]
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // A=[1, 2, 1, 3, 4, 3] and B = 3
    // All windows of size B are
    // [1, 2, 1]
    // [2, 1, 3]
    // [1, 3, 4]
    // [3, 4, 3]
    // So, we return an array [2, 3, 3, 2].
    //Explanation 2:
    //
    // Window size is 1, so the output array is [1, 1, 1, 1].
    public static ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < B; i++) {
            int data = A.get(i);
            if (map.containsKey(data)) {
                map.put(data, map.get(data) + 1);
            } else {
                map.put(data, 1);
            }
        }
        ans.add(map.size());
        System.out.println("Map " + map+" , ans:  "+ans);
        int start = 1;
        int end = B;



        while (end < A.size()) {
            // Remove first index and add to next index;
            int data = A.get(start - 1);
            map.put(data, map.get(data) - 1);
            if (map.get(data) == 0) {
                map.remove(data);
            }
            // add
            int nextData = A.get(end);
            if (map.containsKey(nextData)) {
                map.put(nextData, map.get(nextData) + 1);
            } else {
                map.put(nextData, 1);
            }
            ans.add(map.size());
            System.out.println("start and end ["+start+","+end+"] ,Map " + map+" , ans:  "+ans);
            start++;
            end++;
        }

        return ans;
    }

    public static void main(String[] args) {
     dNums(new ArrayList<>(Arrays.asList(1,2,1,3,4,3)),3);
    }
}
