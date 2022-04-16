package com.dsa.geeksforgeek.recursuion;

public class SubsetOfSum {

    //int[] ={10,20,15}
    //sum =25
    public static int subsetSum(int[] arr, int n, int sum) {
        if (n == 0)
            return sum == 0 ? 1 : 0;

        return subsetSum(arr, n - 1, sum) + subsetSum(arr, n - 1, sum - arr[n - 1]);
    }

    public static void main(String[] args) {
      System.out.println(subsetSum(new int[]{10,20,15},3,0));
    }
}
