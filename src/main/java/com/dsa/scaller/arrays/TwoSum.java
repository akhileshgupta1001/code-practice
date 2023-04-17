package com.dsa.scaller.arrays;

import java.util.LinkedHashMap;
import java.util.Map;

public class TwoSum {
    //Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    //
    //You may assume that each input would have exactly one solution, and you may not use the same element twice.
    //
    //You can return the answer in any order.
    //
    //
    //
    //Example 1:
    //
    //Input: nums = [2,7,11,15], target = 9
    //Output: [0,1]
    //Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
    //Example 2:
    //
    //Input: nums = [3,2,4], target = 6
    //Output: [1,2]
    //Example 3:
    //
    //Input: nums = [3,3], target = 6
    //Output: [0,1]
    //
    //
    //Constraints:
    //
    //2 <= nums.length <= 104
    //-109 <= nums[i] <= 109
    //-109 <= target <= 109
    //Only one valid answer exists.
    //
    //
    //Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
    //Accepted
    //9.4M
    //Submissions
    //18.9M
    //Acceptance Rate
    //49.7%
    //Seen this question in a real interview before?
    //1/4
    //Yes
    //No
    //Discussion (418)
    //Similar Questions
    //Related Topics
    public int[] twoSumBruteforce(int[] nums, int target){
        for(int i=0;i<nums.length;i++){

            for(int j=i+1;j<nums.length;j++){

                if((nums[i]+nums[j])==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{};
    }
    public int[] twoSum(int[] nums, int target) {

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
}
