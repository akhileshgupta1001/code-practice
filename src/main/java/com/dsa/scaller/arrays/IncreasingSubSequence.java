package com.dsa.scaller.arrays;

public class IncreasingSubSequence {
    public static int solve(int[] A) {

        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            int currentAns = 1;
            for (int j = i + 1; j < A.length; j++) {
                if (A[j-1] < A[j]) {
                    currentAns++;
                    ans = Math.max(currentAns, ans);
                   // System.out.println(A[i]+"   : "+A[j]+" , ans : "+ans);

                } else {
                    break;
                }
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(solve(new int[]{16,3,3,6,7,8,17,13,7}));
    }
}
