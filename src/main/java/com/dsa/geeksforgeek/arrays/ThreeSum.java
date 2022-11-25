package com.dsa.geeksforgeek.arrays;

import java.util.*;

public class ThreeSum {
    List<List<Integer>> result = new ArrayList<>();

    void twoSumSorted(int i, int j, int[] nums, int target) {
        int a1 = nums[i - 1];
        while (i < j) { //search space
            if (nums[i] + nums[j] > target) {
                j--;
            } else if (nums[i] + nums[j] < target) {
                i++;
            } else {
                List<Integer> list = new ArrayList();
                list.add(a1);
                list.add(nums[i]);
                list.add(nums[j]);
                result.add(list);
                //duplicate b
                while (i < j && nums[i] == nums[i + 1]) i++;
                //duplicate c
                while (i < j && nums[j] == nums[j - 1]) j--;

                i++;
                j--;
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

    public static void main(String[] args) {
        //Input: nums = [-1,0,1,2,-1,-4]
        //Output: [[-1,-1,2],[-1,0,1]]
        //Explanation:
        //nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
        //nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
        //nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
        //The distinct triplets are [-1,0,1] and [-1,-1,2].
        //Notice that the order of the output and the order of the triplets does not matter.

    }
}
