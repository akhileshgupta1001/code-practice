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

        rMax[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            rMax[i] = Math.max(arr[i], rMax[i + 1]);
        }

        for (int i = 0; i < arr.length; i++) {
            res = res + (Math.min(lMax[i], rMax[i]) - arr[i]);
        }
        return res;
    }

    public static int getCalculativeWater(int[] arr) {
        int res = 0;
        for (int i = 1; i < arr.length - 1; i++) {

            int lmax = arr[i];
            for (int j = 0; j < i; j++) {
                lmax = Math.max(lmax, arr[j]);
            }
            int rMax = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                rMax = Math.max(rMax, arr[j]);
            }

            res = res + (Math.min(lmax, rMax) - arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        //5,0,6,2,3
        // 6

        // {3,0,1,2,5}
        //6
        int[] arr = new int[]{5, 0, 6, 2, 3};
        int[] arr2 = new int[]{3, 0, 1, 2, 5};
        System.out.println(getWatter(arr2));

       // System.out.println(getCalculativeWater(arr2));
    }
}
