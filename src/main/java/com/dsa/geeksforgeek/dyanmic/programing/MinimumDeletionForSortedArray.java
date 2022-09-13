package com.dsa.geeksforgeek.dyanmic.programing;

public class MinimumDeletionForSortedArray {

    // sol => numberOfArray-LIS
    //[5,10,3,6,7,8]

    public static int getCeliIndex(int[] nums, int start,int end,int target){
        while (end > start) {
            int middle = start + (end - start) / 2;
            if (nums[middle] >= target) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }
        return end;
        }

        public static int getMinimumDeletion(int[] nums){
        int n = nums.length;
        int[] lis = new int[n];
        lis[0]=nums[0];
        int len =1;
        for(int i =1;i<nums.length;i++){
            if(nums[i]>lis[len-1]){
                lis[len]=nums[i];
                len++;
            }else{
                int celi = getCeliIndex(lis,0,len-1,nums[i]);
                lis[celi] = nums[i];
            }
        }
        return n-len;
        }

    public static void main(String[] args) {
        System.out.println(getMinimumDeletion(new int[]{5,10,3,6,7,8}));
    }

}
