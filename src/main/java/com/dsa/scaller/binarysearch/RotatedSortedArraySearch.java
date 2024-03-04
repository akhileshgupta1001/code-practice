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
    public int search(int[] nums, int target) {
        // Initialize the start and end pointers for the binary search.
        int start = 0;
        int end = nums.length - 1;

        // Start a while loop that continues as long as start is less than or equal to end.
        while (start <= end) {
            // Calculate the middle index.
            int mid = start + (end - start) / 2;

            // Check if the element at the middle index is equal to the target.
            if (nums[mid] == target) {
                // If it is, return the index of the target.
                return mid;
            }

            // Check if the left half of the current range is sorted (no rotation).
            if (nums[start] <= nums[mid]) {
                // If it is, check if the target is within this sorted half.
                if (nums[start] <= target && target <= nums[mid]) {
                    // If the target is within this range, update the 'end' pointer to mid - 1.
                    end = mid - 1;
                } else {
                    // If the target is not within this range, update the 'start' pointer to mid + 1.
                    start = mid + 1;
                }
            } else {
                // If the left half is not sorted, then the right half must be sorted.
                // Check if the target is within the sorted right half.
                if (nums[mid] <= target && target <= nums[end]) {
                    // If the target is within this range, update the 'start' pointer to mid + 1.
                    start = mid + 1;
                } else {
                    // If the target is not within this range, update the 'end' pointer to mid - 1.
                    end = mid - 1;
                }
            }
        }

        // If the target is not found in the array, return -1.
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
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            }

            if (nums[start] == nums[mid] && nums[mid] == nums[end]) {
                start++;
                end--;
                continue;
            }

            if (nums[start] <= nums[mid]) {
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        searchDuplicate(new int[]{3, 5, 1}, 3);
    }

}

