package com.dsa.geeksforgeek.arrays;

import java.util.*;

public class ThreeSum {
    List<List<Integer>> result = new ArrayList<>();

    void twoSumSorted(int low, int high, int[] nums, int target) {
        int a1 = nums[low - 1];
        while (low < high) { //search space
            if (nums[low] + nums[high] > target) {
                high--;
            } else if (nums[low] + nums[high] < target) {
                low++;
            } else {
                List<Integer> list = new ArrayList();
                list.add(a1);
                list.add(nums[low]);
                list.add(nums[high]);
                result.add(list);
                //duplicate b
                while (low < high && nums[low] == nums[low + 1]) low++;
                //duplicate c
                while (low < high && nums[high] == nums[high - 1]) high--;

                low++;
                high--;
            }
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        // b+c = 0-a;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSumSorted(i + 1, nums.length - 1, nums, 0 - nums[i]);
            }
        }
        return result;
    }

    public  List<List<Integer>> threeSum2(int[] nums) {
        Set<List<Integer>> res  = new HashSet<>();
        if(nums.length==0) return new ArrayList<>(res);
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2;i++){
            int j =i+1;
            int  k = nums.length-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum==0) res.add(Arrays.asList(nums[i],nums[j++],nums[k--]));
                else if ( sum >0) k--;
                else if (sum<0) j++;
            }

        }
        return new ArrayList<>(res);

    }

    public static List<List<Integer>> threeSumByBetterApproach(int[] nums,int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for(int i=0;i< nums.length;i++){

            if(i==0 ||( nums[i] != nums[i-1])){
                int j = i+1;
                int k = nums.length-1;
                int tar = target-nums[i];
                while (j<k){
                    if(nums[j]+nums[k]==tar){
                     list.add(Arrays.asList(nums[i],nums[j],nums[k]));
                     while (j<k && nums[j] == nums[j+1]) j++;
                     while (j<k && nums[k]==nums[k-1]) k--;
                     j++;
                     k--;
                    }else if(nums[j]+nums[k]<tar){
                        j++;
                    }else {
                        k--;
                    }
                }

            }
        }
    return list;
    }




    public static void main(String[] args) {
        //Input: nums = [-1,0,1,2,-1,-4]
        //Output: [[-1,-1,2],[-1,0,1]]
        //Explanation:
        //nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
        //nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
        //nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
        //The distinct triplets are [-1,0,1] and [-1,-1,2].
        //Notice that the order of the output and the order of the triplets does not matter.
        System.out.println(threeSumByBetterApproach(new int[]{-1,0,1,2,-1,-4},0));
    }
}
