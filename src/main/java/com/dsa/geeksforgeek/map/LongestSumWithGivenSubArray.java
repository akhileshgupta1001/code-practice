package com.dsa.geeksforgeek.map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LongestSumWithGivenSubArray {

    public static int maxLength(int[] arr, int sum) {

        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int currentSum = 0;
            for (int j = i; j < arr.length; j++) {
                currentSum = currentSum + arr[j];
                if (sum == currentSum)
                    res = Math.max(res, j - i + 1);
            }
        }
        return res;
    }

    public static int maxLengthSumArray(int[] arr, int sum) {

        Map<Integer, Integer> indexArrayMap = new LinkedHashMap<>();
        int res = 0;
        int preSum = 0;
        for (int i = 0; i < arr.length; i++) {
            preSum += arr[i];
            if (preSum == sum) {
                res = i + 1;
            }
            if (indexArrayMap.containsKey(preSum - sum) == false) {
                indexArrayMap.put(arr[i], i);
            }
            if (indexArrayMap.containsKey(preSum - sum)) {
                res = Math.max(res, i - indexArrayMap.get(preSum - sum));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 4};
    //    System.out.println(maxLength(arr, 5));
        System.out.println(maxLengthSumArray(arr, 5));

    }
}
