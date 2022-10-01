package com.dsa.geeksforgeek.dyanmic.programing;

//Longest Increasing Subsequence
public class LIS {

    //https://leetcode.com/problems/longest-increasing-subsequence/

    /*
    Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Input: nums = [0,1,0,3,2,3]
Output: 4

Input: nums = [7,7,7,7,7,7,7]
Output: 1
     */
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int lis[] = new int[n];

        lis[0] = 1;
        for (int i = 1; i < n; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++)
                if (nums[i] > nums[j])
                    lis[i] = Math.max(lis[i], lis[j] + 1);
        }

        int res = lis[0];

        for (int i = 0; i < n; i++) {
            res = Math.max(lis[i], res);
        }

        return res;
    }


    // nlogn
    public static int getLIC(int[] nums) {
        int n = nums.length;
        int lis[] = new int[n];
        // put first element default
        lis[0] = nums[0];
        int len = 1;
        for(int i=1;i<n;i++){
            // if lis element is lower then insert
            if(nums[i]>lis[len-1]){
                lis[len] =nums[i];
                len++;
            }else{
                // find the celi element
                int celi= celiIndex(lis,0,len-1,nums[i]);
                lis[celi] = nums[i];
            }
        }
        return len;
    }

    private static int celiIndex(int[] lis, int start, int end, int num) {
        while (end>start){
            int middle = start+ (end-start)/2;
            if(lis[middle]>=num){
                end = middle;
            }else {
                start = middle+1;
            }
        }

        return end;
    }

    public static void main(String[] args) {
        System.out.println(getLIC(new int[]{5,10,3,6,7,8}));
    }

}
