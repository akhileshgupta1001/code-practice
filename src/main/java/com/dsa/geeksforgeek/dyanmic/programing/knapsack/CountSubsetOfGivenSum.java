package com.dsa.geeksforgeek.dyanmic.programing.knapsack;

public class CountSubsetOfGivenSum {

    //Input: arr[] = {1, 2, 3, 3}, X = 6
    //Output: 3
    //All the possible subsets are {1, 2, 3},
    //{1, 2, 3} and {3, 3}
    //
    //Input: arr[] = {1, 1, 1, 1}, X = 1
    //Output: 4

    public static int getCountSubsetOfGivenSum(int[] arr, int sum) {
        int tab[][] = new int[arr.length + 1][sum + 1];

        // Initializing the first value of matrix
        tab[0][0] = 1;

        for (int i = 1; i <= sum; i++)
            tab[0][i] = 0;

        for (int i = 1; i <= arr.length; i++) {
            for (int j = 0; j <= sum; j++) {
                // If the value is greater than the sum
                if (arr[i - 1] > j)
                    tab[i][j] = tab[i - 1][j];

                else {
                    tab[i][j] = tab[i - 1][j] +
                            tab[i - 1][j - arr[i - 1]];
                }
            }
        }
        return tab[arr.length][sum];
    }


    public static void main(String[] args) {
        System.out.println(getCountSubsetOfGivenSum(new int[]{1, 2, 3, 3}, 6));
    }
}
