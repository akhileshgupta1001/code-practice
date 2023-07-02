package com.dsa.scaller.twopointer;

import java.util.HashMap;
import java.util.Map;

public class PairsWithGivenSum {
    //Problem Description
    //Given a sorted array of integers (not necessarily distinct) A and an integer B, find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.
    //
    //Since the number of such pairs can be very large, return number of such pairs modulo (109 + 7).
    //
    //
    //
    //Problem Constraints
    //1 <= |A| <= 100000
    //
    //1 <= A[i] <= 10^9
    //
    //1 <= B <= 10^9
    //
    //
    //
    //Input Format
    //The first argument given is the integer array A.
    //
    //The second argument given is integer B.
    //
    //
    //
    //Output Format
    //Return the number of pairs for which sum is equal to B modulo (10^9+7).
    //
    //
    //
    //Example Input
    //Input 1:
    //
    //A = [1, 1, 1]
    //B = 2
    //Input 2:
    //
    //A = [1, 5, 7, 10]
    //B = 8
    //
    //
    //Example Output
    //Output 1:
    //
    // 3
    //Output 2:
    //
    // 1
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // The pairs of A[i] and A[j] which sum up to 2 are (0, 1), (0, 2) and (1, 2).
    // There are 3 pairs.
    //Explanation 2:
    //
    // There is only one pair, such that i = 0, and j = 2 sums up to 8.
    //
    //
    //
    //Expected Output
    //Provide sample input and click run to see the correct output for the provided input. Use this to improve your problem understanding and test edge cases

    public static int solve2(int[]A, int B){

        int ans=0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<A.length;i++){
            int sum = B=A[i];
            if(map.containsKey(A[i])){
                ans += map.get(sum);
            }
            map.put(A[i], map.getOrDefault(A[i], 0) + 1);
        }

       return ans;

    }

    public static int solve(int[] A, int B) {
        int n= A.length;
        int i=0;
        int j= n-1;
        int mod = (int) 1e9+7;
        long ans =0;
        while(j>i){
            if((A[i]+A[j])==B){
                if(A[i]==A[j]){
                    int count = j - i + 1;
                    ans += (1l* count * (count - 1)) / 2 % mod;
                    ans %=mod;
                    break;
                }
                int counti=0;

                for(int x=i ;x<j;x++){
                    if(A[x]==A[i]) counti++;
                    else break;
                }
                int countj = 0;
                for (int y = j; y >= i; y--) {
                    if (A[y] == A[j]) countj++;
                    else break;
                }
                ans +=  ((long)counti * countj) % mod;
                ans %= mod;
                i = i+counti;
                j= j-countj;
            }
            else if(A[i]+A[j]<B){
                i++;
            }else{
                j--;
            }
        }
        return (int) ans ;
    }

    public static void main(String[] args) {
        System.out.println(solve2(new int[]{1,2,6,6,7,9,9},13));
    }
}
