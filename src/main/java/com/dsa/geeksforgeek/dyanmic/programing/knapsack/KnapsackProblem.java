package com.dsa.geeksforgeek.dyanmic.programing.knapsack;

import javax.imageio.stream.ImageInputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class KnapsackProblem {

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
       System.out.println(getMaxKnapsackProblemUsingDP(wt, val,W ,n));
        //getMaxKnapsackProblemUsingMemorization(wt,val,W,n);
    }
}
