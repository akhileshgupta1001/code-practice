package com.dsa.geeksforgeek.map;

public class IntersectionArray {

    public static void intersectionArray(int[] m, int[] n) {
        int[] maxArray = m.length > n.length ? m : n;
        int[] minArray = m.length > n.length ? n : m;

        for (int i = 0; i < maxArray.length; i++) {
            boolean isPresent = false;
            for (int j = 0; j < i; j++) {
                if (maxArray[i] == minArray[j]) {
                    isPresent = true;
                    break;
                }
            }
            if (isPresent)
                continue;
            for (int j = 0; j < minArray.length; j++) {
                if (maxArray[i] == minArray[j]) {
                    System.out.println(minArray[j]);
                    break;
                }
            }

        }
    }

    public static void main(String[] args) {
        int[] arr1 = {10, 20, 10, 30, 20};
        int[] arr2 = {20, 10, 10, 40};
        intersectionArray(arr1, arr2);
    }
}
