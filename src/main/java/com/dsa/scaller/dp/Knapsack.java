package com.dsa.scaller.dp;

import java.util.Arrays;

//Problem Description
//Given two integer arrays A and B of size N each which represent values and weights associated with N items respectively.
//
//Also given an integer C which represents knapsack capacity.
//
//Find out the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.
//
//NOTE:
//
//You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
//
//
//Problem Constraints
//1 <= N <= 103
//
//1 <= C <= 103
//
//1 <= A[i], B[i] <= 103
//
//
//
//Input Format
//First argument is an integer array A of size N denoting the values on N items.
//
//Second argument is an integer array B of size N denoting the weights on N items.
//
//Third argument is an integer C denoting the knapsack capacity.
//
//
//
//Output Format
//Return a single integer denoting the maximum value subset of A such that sum of the weights of this subset is smaller than or equal to C.
//
//
//
//Example Input
//Input 1:
//
// A = [60, 100, 120]
// B = [10, 20, 30]
// C = 50
//Input 2:
//
// A = [10, 20, 30, 40]
// B = [12, 13, 15, 19]
// C = 10
//
//
//Example Output
//Output 1:
//
// 220
//Output 2:
//
// 0
//
//
//Example Explanation
//Explanation 1:
//
// Taking items with weight 20 and 30 will give us the maximum value i.e 100 + 120 = 220
//Explanation 2:
//
// Knapsack capacity is 10 but each item has weight greater than 10 so no items can be considered in the knapsack therefore answer is 0.
//
//
//
//Expected Output
//Provide sample input and click run to see the correct output for the provided input. Use this to improve your problem understanding and test edge cases

public class Knapsack {



    //Time Complexity: O(2pwer(n)) .
    //As there are redundant subproblems.
    //Auxiliary Space :O(1) + O(N).
    //As no extra data structure has been used for storing values but O(N) auxiliary stack space(ASS) has been used for recursion stack.
    public static int getMaxKnapsackProblem(int[] weight, int[] value,int maxWeight,int size){

        if(maxWeight==0|| size==0) return 0;

        if(weight[size-1]> maxWeight){
            return getMaxKnapsackProblem(weight,value,maxWeight,size-1);
        }else{
            return Math.max(
                    // Not consider the weight
                    getMaxKnapsackProblem(weight,value,maxWeight,size-1),
                    // consider the weight
                    value[size-1]+getMaxKnapsackProblem(weight,value,maxWeight-weight[size-1],size-1));
        }
    }


    //Time Complexity: O(N * W). As redundant calculations of states are avoided.
    //Auxiliary Space: O(N * W) + O(N). The use of a 2D array data structure for storing intermediate states and O(N) auxiliary stack space(ASS) has been used for recursion stack
    public static int getMaxKnapsackProblemUsingMemorization(int[] weight, int[] value,int[][] dp,int maxWeight,int size){
         Arrays.stream(dp).forEach(data-> Arrays.fill(data,-1));
        if(maxWeight==0|| size==0) return 0;
        if(dp[size][maxWeight] != -1) return dp[size][maxWeight];

        if(weight[size-1]>maxWeight){
            dp[size][maxWeight]= getMaxKnapsackProblemUsingMemorization(weight,value,dp,maxWeight,size-1);
        }else {
            dp[size][maxWeight] = Math.max(value[size-1]+getMaxKnapsackProblemUsingMemorization(weight,value,dp,
                            maxWeight-weight[size-1],size-1),
                    getMaxKnapsackProblemUsingMemorization(weight,value,dp,maxWeight,size-1));
        }

        return dp[size][maxWeight];
    }


    public static void getMaxKnapsackProblemUsingMemorization(int[] weight, int[] value,int maxWeight,int size) {
        int[][] dp = new int[size+1][maxWeight+1];
        Arrays.stream(dp).forEach(data-> Arrays.fill(data,-1));
        System.out.println("Max weight :" +
                getMaxKnapsackProblemUsingMemorization(weight,value,dp,maxWeight,size));
    }





    //Time Complexity: O(N * W). where ‘N’ is the number of elements and ‘W’ is capacity.
    //Auxiliary Space: O(N * W). The use of a 2-D array of size ‘N*W’.
    public static int getMaxKnapsackProblemUsingDP(int[] wt, int[] value,int maxBagWeight,int size){

        // value * wt
        int[][] dp = new int[size+1][maxBagWeight+1];
        // row
       /* for(int i=0; i<=maxBagWeight; i++) {
            dp[0][i] = 0;
        }

        for(int i=0; i<=size; i++) {
            dp[i][0] = 0;
        }*/
        // value
        for(int i=0;i<=size;i++){
            // weight
            for(int weight=0;weight<=maxBagWeight;weight++)
                if(i==0|| weight==0) dp[i][weight]=0;
                else if(wt[i-1]>weight){
                    // System.out.println("Value : "+dp[i-1][weight]);
                    // Pick from the store item
                    dp[i][weight]= dp[i-1][weight];
                }else{
                    dp[i][weight] = Math.max(

                            // consider the weight  (Value + ActualWeight-weight)
                            value[i - 1] + dp[i - 1][weight - wt[i - 1]],
                            // Ignore the item
                            dp[i - 1][weight]);
                }

        }
        return dp[size][maxBagWeight];
    }

    public static void main(String[] args) {
/*        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = val.length;
        // out ->90*/

        int val[] = { 10, 40, 30, 50 };
        int wt[] = { 5, 4, 6, 3 };
        int W = 10;
        int n = 4;
       // System.out.println(getMaxKnapsackProblemUsingDP(wt, val,W ,n));
        System.out.println(solve(val, wt,W));

       getMaxKnapsackProblemUsingMemorization(wt,val,W,n);
    }

    public static int knapsack(int[] value, int[] weight, int[][] dp, int W, int size){
        if(size==0 || W==0){
            return 0;
        }
        if(dp[size][W] != -1) return dp[size][W];
        int val = knapsack(value,weight,dp,W,size-1);
        if(W>=weight[size]){
            val = Math.max(val,value[size]+knapsack(value,weight,dp,W-weight[size],size));
        }
        return  dp[size][W]= val;
    }
    public static int solve(int[] A, int[] B, int C) {
        int[][] dp = new int[A.length+1][C+1];
        Arrays.stream(dp).forEach(data-> Arrays.fill(data,-1));

        return knapsack(A,B,dp,C,A.length);
    }
}
