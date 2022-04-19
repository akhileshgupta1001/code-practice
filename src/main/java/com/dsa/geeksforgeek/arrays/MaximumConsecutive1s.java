package com.dsa.geeksforgeek.arrays;

public class MaximumConsecutive1s {

    //input {0,1,1,0,1,0}
    //2
    public static int getMaxConsecutiveOnesInArray(int[] arr) {
        int res = 0;
        int currentCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                currentCount = 0;
            } else {
                currentCount++;
                res = Math.max(res, currentCount);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(getMaxConsecutiveOnesInArray(new int[]{0,1,0,1,0,1,0}));
    }
}
