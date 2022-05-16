package com.dsa.geeksforgeek.map;

public class CountDistinctElement {

    public static int countDistinctElement(int arr[]) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            boolean isElementPresent = false;
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    isElementPresent = true;
                    break;
                }
            }
            if (!isElementPresent)
                res++;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 10, 30, 20, 50};
        System.out.println(countDistinctElement(arr));
    }
}
