package com.dsa.scaller.twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeMap;

public class ThreeSum {
    //Problem Description
    //Given an array A of N integers, find three integers in A such that the sum is closest to a given number B. Return the sum of those three integers.
    //
    //Assume that there will only be one solution.
    //
    //
    //
    //Problem Constraints
    //-108 <= B <= 108
    //1 <= N <= 104
    //-108 <= A[i] <= 108
    //
    //
    //Input Format
    //First argument is an integer array A of size N.
    //
    //Second argument is an integer B denoting the sum you need to get close to.
    //
    //
    //
    //Output Format
    //Return a single integer denoting the sum of three integers which is closest to B.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //A = [-1, 2, 1, -4]
    //B = 1
    //Input 2:
    //
    //
    //A = [1, 2, 3]
    //B = 6
    //
    //
    //Example Output
    //Output 1:
    //
    //2
    //Output 2:
    //
    //6
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)
    //Explanation 2:
    //
    // Take all elements to get exactly 6.

    public int threeSumClosest(int[] A, int B) {
        /*
        int ans= Integer.MIN_VALUE;
        for(int i=0;i<A.length;i++){
            for(int j=i+1;j<A.length;j++){
                for(int k=j+1;k<A.length;k++){
                    int  sum = A[i]+A[j]+A[k];
                    if(sum==B) return B;
                    //int diffrence = sum-B;
                     if(sum<B){
                         ans = Math.max(ans,sum);
                     }
                }
            }
        }
        return ans;
        */
        Arrays.sort(A);
        int diff = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < A.length; i++) {
            int j = i + 1;
            int k = A.length - 1;
            while (j < k) {
                int sum = A[i] + A[j] + A[k];
                ArrayList<Integer> subAns =new ArrayList<>(Arrays.asList(A[i],A[j],A[k]));
                if (Math.abs(sum - B) < diff) {
                    diff = Math.abs(sum - B);
                    ans = sum;
                } else if (sum > B) {
                    k--;
                } else if (sum < B) {
                    j++;
                } else if (sum == B) {
                    return B;
                }
            }
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        HashSet<Integer> ans2 = new HashSet<>();
        for(int data : ans2){}
        return ans;
    }



}
