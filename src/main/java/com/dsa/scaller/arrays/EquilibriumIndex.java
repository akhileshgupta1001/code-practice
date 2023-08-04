package com.dsa.scaller.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class EquilibriumIndex {
    //You are given an array A of integers of size N.
    //
    //Your task is to find the equilibrium index of the given array
    //
    //The equilibrium index of an array is an index such that the sum of elements at lower indexes is equal to the sum of elements at higher indexes.
    //
    //If there are no elements that are at lower indexes or at higher indexes, then the corresponding sum of elements is considered as 0.
    //
    //Note:
    //
    //Array indexing starts from 0.
    //If there is no equilibrium index then return -1.
    //If there are more than one equilibrium indexes then return the minimum index.

    //Example Input
    //Input 1:
    //A = [-7, 1, 5, 2, -4, 3, 0]
    //Input 2:
    //
    //A = [1, 2, 3]
    //
    //
    //Example Output
    //Output 1:
    //3
    //Output 2:
    //
    //-1
    //
    //
    //Example Explanation
    //Explanation 1:
    //i   Sum of elements at lower indexes    Sum of elements at higher indexes
    //0                   0                                   7
    //1                  -7                                   6
    //2                  -6                                   1
    //3                  -1                                  -1
    //4                   1                                   3
    //5                  -3                                   0
    //6                   0                                   0
    //
    //3 is an equilibrium index, because:
    //A[0] + A[1] + A[2] = A[4] + A[5] + A[6]
    //Explanation 1:
    //
    //i   Sum of elements at lower indexes    Sum of elements at higher indexes
    //0                   0                                   5
    //1                   1                                   3
    //2                   3                                   0
    //Thus, there is no such index.

    public static int solve(ArrayList<Integer> A) {
        int n = A.size();
        ArrayList<Long> prefix = new ArrayList<>();
        prefix.add((long) A.get(0));
        for (int i = 1; i < n; i++) {
            prefix.add((long) prefix.get(i - 1) + A.get(i));
        }


        int ans = -1;
        for (int i = 0; i < A.size(); i++) {
            if (i == 0 && prefix.get(n - 1) - prefix.get(i) == 0) {
                ans = i;
                break;
            }
            if (i != 0 && prefix.get(i - 1) == prefix.get(n - 1) - prefix.get(i)) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    public static int solve2(ArrayList<Integer> A) {
        int n = A.size();
        long[] prefixSum = new long[n];
        prefixSum[0] = A.get(0);
        // Calculate prefix sum
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + A.get(i);
        }

        int ans = -1;
        long lsum;
        long rsum;
        for (int i = 0; i < n; i++) {
            // lsum = prefixSum[i-1];
            ;
            if (i == 0) {
                lsum = 0;
            } else {
                lsum = prefixSum[i - 1];
            }
            rsum = prefixSum[n - 1] - prefixSum[i];
            if (lsum == rsum) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    public static int pivotIndex(int[] nums) {
        int n = nums.length;

        int[] lsum = new int[n];
        int[] rsum = new int[n];
        lsum[0]=0;
        for (int i = 1; i < n; i++) {
            lsum[i] = lsum[i - 1] + nums[i-1];
        }
        for (int i = 0; i < lsum.length; i++) {
            System.out.print(lsum[i]+ " ");
        }
        System.out.println();
        rsum[n-1]=0;
        for(int i=n-2;i>=0;i--){
            rsum[i]= rsum[i+1]+nums[i+1];
        }

        for (int i = 0; i < rsum.length; i++) {
            System.out.print(rsum[i]+" ");
        }
        System.out.println();
        int i = 0;
        while (n > 0) {
            if (lsum[i] == rsum[i]) {
                return i;
            }
            i++;
            n--;
        }
        return -1;
    }

    public static void main(String[] args) {
      //  System.out.println(pivotIndex(new int[]{1,7,3,6,5,6}));
        //System.out.println(pivotIndex(new int[]{-3,2,4,-1}));
        System.out.println(pivotIndex(new int[]{7, 1, 5, 2, -4, 3, 0}));
        //System.out.println(solve(new ArrayList<>(Arrays.asList(7, 1, 5, 2, -4, 3, 0))));
    }

}
