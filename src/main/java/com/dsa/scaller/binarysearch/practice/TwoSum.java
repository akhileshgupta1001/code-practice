package com.dsa.scaller.binarysearch.practice;

public class TwoSum {
    public static  int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int high = numbers.length - 1;
        while (low >= 0 && low <= high) {
            int value = numbers[low] + numbers[high];
            System.out.println("Value : " + value);

            if (value == target) {
                return new int[]{low + 1, high + 1};
            } else if (value > target) {
                high--;
            } else {
                low++;
            }
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        twoSum(new int[]{2,7,11,15},9);
    }
}
