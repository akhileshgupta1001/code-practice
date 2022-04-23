package com.dsa.geeksforgeek.arrays;

public class MaxLengthEvenOddSubArray {
    //{5,10,20,6,3,8}

    public static int maxLengthSubArray(int[] arr) {

        int res = 1;
        for (int i = 0; i < arr.length; i++) {
            int current = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if ((arr[j] % 2 == 0 && arr[j - 1] % 2 != 0)
                        || (arr[j] % 2 != 0 && arr[j - 1] == 0)) {
                    current++;
                } else
                    break;
            }
            res = Math.max(current, res);
        }
        return res;
    }

    public static int maxLength(int[] arr) {
        int res = 1;
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if ((arr[i] % 2 == 0 && arr[i - 1] % 2 != 0)
                    || (arr[i] % 2 != 0 && arr[i - 1] % 2 == 0)) {
                count++;
                res = Math.max(res, count);
            } else {
                count = 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{5, 10, 20, 6, 3, 8};
        //System.out.println(maxLengthSubArray(arr));
        System.out.println(maxLength(arr));
    }
}
