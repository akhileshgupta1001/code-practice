package com.dsa.scaller.binarysearch;

import java.util.List;

public class MedianArray {
    //Problem Description
    //There are two sorted arrays A and B of sizes N and M respectively.
    //
    //Find the median of the two sorted arrays ( The median of the array formed by merging both the arrays ).
    //
    //NOTE:
    //
    //The overall run time complexity should be O(log(m+n)).
    //IF the number of elements in the merged array is even, then the median is the average of (n/2)th and (n/2+1)th element. For example, if the array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5.
    //
    //
    //Problem Constraints
    //1 <= N + M <= 2*106
    //
    //
    //
    //Input Format
    //The first argument is an integer array A of size N.
    //The second argument is an integer array B of size M.
    //
    //
    //
    //Output Format
    //Return a decimal value denoting the median of two sorted arrays.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = [1, 4, 5]
    // B = [2, 3]
    //Input 2:
    //
    // A = [1, 2, 3]
    // B = [4]
    //
    //
    //Example Output
    //Output 1:
    //
    // 3.0
    //Output 2:
    //
    // 2.5
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // The median of both the sorted arrays will be 3.0.
    //Explanation 2:
    //
    // The median of both the sorted arrays will be (2+3)/2 = 2.5.

    public double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        if (b.size() < a.size()) return findMedianSortedArrays(b, a);
        int n1 = a.size();
        int n2 = b.size();

        int low = 0;
        int high = n1;
        while (low <= high) {
            int count1 = low + (high - low) / 2;
            int count2 = (n1 + n2 + 1) / 2 - count1;

            int left1 = count1 == 0 ? Integer.MIN_VALUE : a.get(count1 - 1);
            int left2 = count2 == 0 ? Integer.MIN_VALUE : b.get(count2 - 1);

            int right1 = count1 == n1 ? Integer.MAX_VALUE : a.get(count1);
            int right2 = count2 == n2 ? Integer.MAX_VALUE : b.get(count2);

            if (left1 <= right2 && left2 <= right1) {
                if ((n1 + n2) % 2 == 0) {
                    return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
                } else {
                    return Math.max(left1, left2);
                }
            } else if (left1 > right2) {
                high = count1 - 1;
            } else {
                low = count1 + 1;
            }

        }
        return 0.0;
    }
}
