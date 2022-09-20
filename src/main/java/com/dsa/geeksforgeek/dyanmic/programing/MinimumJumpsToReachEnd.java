package com.dsa.geeksforgeek.dyanmic.programing;

//https://leetcode.com/problems/jump-game-ii/submissions/
public class MinimumJumpsToReachEnd {
    //Time complexity: O(n^n).
    //There are maximum n possible ways to move from a element. So maximum number of steps can be N^N so the upperbound of time complexity is O(n^n)
    //Auxiliary Space: O(1).
    //There is no space required (if recursive stack space is ignored).
    public static int jump(int[] nums, int start,int size) {

        if(size==start) return 0;
        if(nums[start]==0) return Integer.MAX_VALUE;

        int res = Integer.MAX_VALUE;
        for(int i=start+1;i<=size && i<= start+nums[start];i++){


                int subResult = jump(nums,i,size);
                if(subResult != Integer.MAX_VALUE  && subResult+1<res){
                    res = subResult+1;

            }
        }
        return res;
    }

    public static int jumpUsingDP(int[] nums,int size) {

        int[] dp = new int[size];
        dp[0]=0;

        int i,j;
        for(i=1;i<size;i++){
            dp[i]= Integer.MAX_VALUE;
            for(j=0;j<i;j++){
                if(j+nums[j] >=i && dp[j] != Integer.MAX_VALUE){
                    dp[i]=Math.min(dp[i],dp[j]+1);
                    break;
                }
            }
        }

        return dp[size-1];
    }
    public static int jump(int[] nums) {

        //return jump(nums,0,nums.length-1);
       // return minJumps(nums,0,nums.length-1);
        return jumpUsingDP(nums,nums.length);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{ 1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
        System.out.println(jump(arr));
    }
}
