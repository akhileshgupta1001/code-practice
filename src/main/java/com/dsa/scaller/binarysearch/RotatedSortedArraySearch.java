package com.dsa.scaller.binarysearch;

public class RotatedSortedArraySearch {
    //Problem Description
    //Given a sorted array of integers A of size N and an integer B,
    //where array A is rotated at some pivot unknown beforehand.
    //
    //For example, the array [0, 1, 2, 4, 5, 6, 7] might become [4, 5, 6, 7, 0, 1, 2].
    //
    //Your task is to search for the target value B in the array. If found, return its index; otherwise, return -1.
    //
    //You can assume that no duplicates exist in the array.
    //
    //NOTE: You are expected to solve this problem with a time complexity of O(log(N)).
    //
    //
    //Problem Constraints
    //1 <= N <= 1000000
    //1 <= A[i] <= 109
    //All elements in A are Distinct.
    //
    //
    //Input Format
    //The First argument given is the integer array A.
    //The Second argument given is the integer B.
    //
    //
    //Output Format
    //Return index of B in array A, otherwise return -1
    //
    //
    //Example Input
    //Input 1:
    //
    //A = [4, 5, 6, 7, 0, 1, 2, 3]
    //B = 4
    //Input 2:
    //
    //A : [ 9, 10, 3, 5, 6, 8 ]
    //B : 5
    //
    //
    //Example Output
    //Output 1:
    //
    // 0
    //Output 2:
    //
    // 3
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    //Target 4 is found at index 0 in A.
    //Explanation 2:
    //
    //Target 5 is found at index 3 in A.

    // This solution is work when element is not duplicate here
    public int search(final int[] A, int B) {
        // This method searches for an integer 'B' in a rotated (circularly shifted) sorted array 'A'.
        // It returns the index of 'B' in 'A' or -1 if 'B' is not found.

        int low = 0;
        int high = A.length - 1;

        // Initialize 'low' to the start of the array and 'high' to the end of the array.

        while (low <= high) {
            // Start a binary search within the current range.

            int mid = low + (high - low) / 2;
            // Calculate the middle index within the current range.

            if (A[mid] == B)
                return mid;
            // If the middle element is equal to 'B', we have found 'B', so return its index.

            // Right half sorted
            if (A[mid] <= A[high]) {
                // Check if the right half of the current range is sorted.

                if (B > A[mid] && B <= A[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
                // If 'B' is within the sorted right half, update 'low' accordingly,
                // otherwise, update 'high' to search in the left half.
            } else {
                // Left half sorted (since the right half is not sorted).

                if (B >= A[low] && B < A[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
                // If 'B' is within the sorted left half, update 'high' to search in the left half,
                // otherwise, update 'low' to search in the right half.
            }
        }

        // If the loop exits without finding 'B', return -1 to indicate that 'B' is not in the array.

        return -1;
    }


    public int binarySearch(int[] arr, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) return mid;
            else if (target > arr[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public int pivotElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    public int search2(int[] nums, int target) {
        int n = nums.length - 1;
        if (n == 0 && nums[0] == target) return n;
        else if (n == 0 && nums[0] != target) return -1;

        int pivot = pivotElement(nums);

        if (nums[pivot] == target) {
            return pivot;

        } else if (target >= nums[pivot] && target <= nums[n]) {
            return binarySearch(nums, pivot, n, target);
        } else {
            return binarySearch(nums, 0, pivot - 1, target);
        }

    }


    public static boolean searchDuplicate(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (nums[mid] == target) {
                return true;
            }

            // Handle duplicate values by adjusting low and high
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
            } else if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        searchDuplicate(new int[]{3, 5, 1}, 3);
    }

}

