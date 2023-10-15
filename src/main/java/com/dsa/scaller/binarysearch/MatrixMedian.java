package com.dsa.scaller.binarysearch;

public class MatrixMedian {
    public static int countSmallerThanMid(int[] A, int smallerThanMid, int n) {
        int l = 0, h = n - 1;
        int count =0;
        while (l <= h) {
            int md = (l + h) >> 1;
            if (A[md] <= smallerThanMid) {
                l = md + 1;
                count = md+1;
            } else {
                h = md - 1;
            }
        }
        return count;
    }

    public static int findMedian(int[][] A, int row, int col) {
        int low = 1;
      //  int high = Integer.MAX_VALUE;// or maxElementOnMatrix
        int high = 8;
        int n = row;
        int m = col;
        while (low <= high) {
            int mid = (low + high) >> 1;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                cnt += countSmallerThanMid(A[i], mid, col);
               System.out.println("low = "+low+" , high = "+high+" , mid= "+mid+" , i= "+i+" , count = "+cnt+ " , col = "+col);
            }
            if (cnt <= (n * m) / 2)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }

    public static void main(String args[]) {
        int row = 2, col = 3;
        int[][] arr = {{1, 4,7},
                {2,6,8}};
        System.out.println("The median of the row-wise sorted matrix is: " +
                findMedian(arr, row, col));

    }
}
