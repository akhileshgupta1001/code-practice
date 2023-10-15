package com.dsa.scaller.binarysearch;

import java.util.Arrays;
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


        public static double findMedianSortedArrays(final List<Integer> nums1, final List<Integer> nums2) {
            // Check if the second list is shorter than the first, if so, swap them to ensure nums1 is always the shorter one.
            if (nums2.size() < nums1.size()) return findMedianSortedArrays(nums2, nums1);

            // Get the lengths of the two input lists.
            int len1 = nums1.size();
            int len2 = nums2.size();

            // Initialize the search range for binary search on nums1.
            int low = 0;
            int high = len1;

            // Binary search loop to find the correct partition point in nums1.
            while (low <= high) {
                // Calculate the partition points in both nums1 and nums2.
                int partition1 = low + (high - low) / 2;
                int partition2 = (len1 + len2 + 1) / 2 - partition1;

                // Calculate the elements on the left and right of the partitions.
                int maxLeft1 = partition1 == 0 ? Integer.MIN_VALUE : nums1.get(partition1 - 1);
                int maxLeft2 = partition2 == 0 ? Integer.MIN_VALUE : nums2.get(partition2 - 1);
                int minRight1 = partition1 == len1 ? Integer.MAX_VALUE : nums1.get(partition1);
                int minRight2 = partition2 == len2 ? Integer.MAX_VALUE : nums2.get(partition2);

                // Check if the partitions are in the correct position.
                if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                    // If the total number of elements is even, return the average of the maximum left and minimum right elements.
                    if ((len1 + len2) % 2 == 0) {
                        return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                    } else {
                        // If the total number of elements is odd, return the maximum element on the left.
                        return Math.max(maxLeft1, maxLeft2);
                    }
                } else if (maxLeft1 > minRight2) {
                    // If the partitions are not in the correct position, adjust the search range.
                    high = partition1 - 1;
                } else {
                    low = partition1 + 1;
                }
            }

            // If no solution is found, return 0.0.
            return 0.0;
        }

    public static void main(String[] args) {
        findMedianSortedArrays(Arrays.asList(1,4,5),Arrays.asList(2,3));
    }

}
