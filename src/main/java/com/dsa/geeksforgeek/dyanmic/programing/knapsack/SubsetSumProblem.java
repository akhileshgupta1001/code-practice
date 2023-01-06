package com.dsa.geeksforgeek.dyanmic.programing.knapsack;

public class SubsetSumProblem {

    //Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
    //Output: True
    //There is a subset (4, 5) with sum 9.
    //
    //Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 30
    //Output: False
    //There is no subset that add up to 30.

    //

    // Complexity Analysis: The above solution may try all subsets of given set in worst case. Therefore time complexity of the above solution is exponential. The problem is in-fact NP-Complete (There is no known polynomial time solution for this problem).
    static boolean isSubsetSum(int set[], int n, int sum) {

        if (sum == 0) return true;
        if (n == 0) return false;

        // If last element is greater than
        // sum, then ignore it
        if (set[n - 1] > sum)
            return isSubsetSum(set, n - 1, sum);

        /* else, check if sum can be obtained
        by any of the following
            (a) including the last element
            (b) excluding the last element */
        return isSubsetSum(set, n - 1, sum)
                || isSubsetSum(set, n - 1, sum - set[n - 1]);

    }

//Time Complexity: O(sum*n), where sum is the ‘target sum’ and ‘n’ is the size of array.
//Auxiliary Space: O(sum*n), as the size of 2-D array is sum*n. + O(n) for recursive stack space
    static boolean isSubsetSumProblem(int set[], int n, int sum) {

        boolean[][] subset = new boolean[sum + 1][n + 1];

        for (int i = 0; i <= n; i++)
            subset[0][i] = true;

        for (int j = 1; j <= sum; j++)
            subset[j][0] = false;

        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                subset[i][j] = subset[i][j - 1];
                if (i >= set[j - 1])
                    subset[i][j]
                            = subset[i][j]
                            || subset[i - set[j - 1]][j - 1];
            }
        }
        return subset[sum][n];
    }


        /* Driver code */
        public static void main (String args[])
        {
            int set[] = {3, 34, 4, 12, 5, 2};
            int sum = 9;
            int n = set.length;
            if (isSubsetSumProblem(set, n, sum) == true)
                System.out.println("Found a subset"
                        + " with given sum");
            else
                System.out.println("No subset with"
                        + " given sum");
        }


    }
