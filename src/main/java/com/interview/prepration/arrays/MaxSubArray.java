package com.interview.prepration.arrays;

import java.util.Arrays;
import java.util.List;

public class MaxSubArray {

	/*
	 * Input 1:
    A = [1, 2, 3, 4, -10]

Output 1:
    10

Explanation 1:
    The subarray [1, 2, 3, 4] has the maximum possible sum of 10.

Input 2:
    A = [-2, 1, -3, 4, -1, 2, 1, -5, 4]

Output 2:
    6

Explanation 2:
    The subarray [4,-1,2,1] has the maximum possible sum of 6.
	 */
	
	 public static int maxSubArray(final List<Integer> A) {
		 int startIndex=0;
		 int ans = Integer.MIN_VALUE;
		 for(int i=0;i<A.size();i++) {
			 startIndex = Math.max(0,startIndex );
			 startIndex+=A.get(i);
			 ans=Math.max(ans,startIndex);
		 }
		return ans;
	    
	 }
	 
		public static void main(String[] args) {
			List<Integer> array = Arrays.asList(1, 2, 3, 4, -10);
			List<Integer> array2 = Arrays.asList(-2, 1, -3, 4, -1, 2, 1, -5, 4);
			//System.out.println(maxSubArray(array));
			System.out.println(maxSubArray(array2));

		
	 }
}
