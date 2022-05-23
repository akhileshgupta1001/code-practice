package com.dsa.geeksforgeek.map;

public class LongestSubArrayWithEqualZeros1s {
    //i/p{1,0,1,1,1,0,0}
    // 6

    public static int sum(int[] arr) {
        int c0 = 0, c1 = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
                c0++;
            else
                c1++;
            if (c0 == c1) {
                sum = Math.max(sum, c0 + c1);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sum(new int[]{1, 0, 1, 1, 1, 0, 0}));
    }
}
