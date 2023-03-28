package com.dsa.geeksforgeek.arrays;

import java.util.LinkedHashMap;
import java.util.Map;

public class TwoSum {

    //https://leetcode.com/problems/two-sum/description/
    public static int[] twoSum(int[] nums, int target) {
        /*
        for(int i=0;i<nums.length;i++){

            for(int j=i+1;j<nums.length;j++){

                if((nums[i]+nums[j])==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
        */
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int secondNumber = target - nums[i];
            if (map.containsKey(secondNumber)) {
                int firstIndex = map.get(secondNumber);
                int secondIndex = i;
                return new int[]{firstIndex, secondIndex};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        System.out.println(twoSum(new int[]{2,7,11,15},9));
    }
}
