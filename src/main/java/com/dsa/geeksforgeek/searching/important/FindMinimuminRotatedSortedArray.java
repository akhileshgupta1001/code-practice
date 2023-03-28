package com.dsa.geeksforgeek.searching.important;

public class FindMinimuminRotatedSortedArray {
    public int findMin(int[] nums) {
        int s = 0;
        int e = nums.length -1;
        while(s < e){
            int m= s+ (e - s)/2;
            if(nums[m]>nums[e]) {
                s = m+1;
            }
            else e = m;
        }
        return nums[s];
    }

//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/description/
// Including Duplicate

        public int findMin2(int[] nums) {
            int low = 0;
            int end = nums.length-1;

            while(low<end){
                int mid = low + (end-low)/2;
                if(nums[mid]>nums[end]){
                    low = mid+1;
                }else if(nums[mid]<nums[end]){
                    end = mid ;
                }else{
                    end--;
                }
            }
            return nums[low];
        }

}
