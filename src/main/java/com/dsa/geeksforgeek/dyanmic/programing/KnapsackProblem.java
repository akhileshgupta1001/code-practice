package com.dsa.geeksforgeek.dyanmic.programing;

import javax.imageio.stream.ImageInputStream;

public class KnapsackProblem {

    //Time Complexity: O(2n).
    //As there are redundant subproblems.
    //Auxiliary Space :O(1) + O(N).
    //As no extra data structure has been used for storing values but O(N) auxiliary stack space(ASS) has been used for recursion stack.
    public static int getMaxKnapsackProblem(int[] weight, int[] value,int maxWeight,int size){

       if(maxWeight==0|| size==0) return 0;

       if(weight[size-1]> maxWeight){
           return getMaxKnapsackProblem(weight,value,maxWeight,size-1);
       }else{
           return Math.max(getMaxKnapsackProblem(weight,value,maxWeight,size-1),
                   value[size-1]+getMaxKnapsackProblem(weight,value,maxWeight-weight[size-1],size-1));
       }
    }

    public static int getMaxKnapsackProblemUsingDP(int[] wt, int[] value,int maxBagWeight,int size){

        // value * wt
        int[][] dp = new int[size+1][maxBagWeight+1];
        // row
        for(int i=0; i<=maxBagWeight; i++)
        {
            dp[0][i] = 0;
        }

        for(int i=0; i<=size; i++)
        {
            dp[i][0] = 0;
        }
        // value
        for(int i=1;i<=size;i++){
            // weight
            for(int weight=1;weight<=maxBagWeight;weight++)
                if(wt[i-1]>weight){
                    System.out.println("Value : "+dp[i-1][weight]);
                    dp[i][weight]= dp[i-1][weight];
                }else{
                    dp[i][weight] = Math.max(value[i - 1] + dp[i - 1][weight - wt[i - 1]], dp[i - 1][weight]);
                }

            }
        return dp[size][maxBagWeight];
        }

    public static void main(String[] args) {
/*        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = val.length;*/

        int val[] = { 10, 40, 30, 50 };
        int wt[] = { 5, 4, 6, 3 };
        int W = 10;
        int n = 4;
        System.out.println(getMaxKnapsackProblemUsingDP(wt, val,W ,n));
    }
}
