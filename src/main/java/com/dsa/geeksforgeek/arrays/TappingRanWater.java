package com.dsa.geeksforgeek.arrays;

public class TappingRanWater {
    public static int getWatter(int[] arr) {
        int res = 0;
        int[] rMax = new int[arr.length];
        int[] lMax = new int[arr.length];
        lMax[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            lMax[i] = Math.max(arr[i], lMax[i - 1]);
        }

        rMax[arr.length- 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            rMax[i] = Math.max(arr[i], rMax[i + 1]);
        }

        for (int i = 0; i < arr.length; i++) {
            res = res + (Math.min(lMax[i], rMax[i]) - arr[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        //5,0,6,2,3
        // 6
        int[] arr = new int[]{5, 0, 6, 2, 3};
        System.out.println(getWatter(arr));
    }
}
