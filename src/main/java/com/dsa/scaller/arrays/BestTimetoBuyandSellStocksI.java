package com.dsa.scaller.arrays;

import java.util.Arrays;
import java.util.List;

public class BestTimetoBuyandSellStocksI {
    //Problem Description
    //Say you have an array, A, for which the ith element is the price of a given stock on day i.
    //If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
    //
    //Return the maximum possible profit
    //Problem Constraints
    //0 <= len(A) <= 7e5
    //1 <= A[i] <= 1e7
    //
    //
    //
    //Input Format
    //The first and the only argument is an array of integers, A.
    //
    //
    //Output Format
    //Return an integer, representing the maximum possible profit.
    //
    //
    //Example Input
    //Input 1:
    //A = [1, 2]
    //Input 2:
    //
    //A = [1, 4, 5, 2, 4]
    //
    //
    //Example Output
    //Output 1:
    //1
    //Output 2:
    //
    //4
    //
    //
    //Example Explanation
    //Explanation 1:
    //Buy the stock on day 0, and sell it on day 1.
    //Explanation 2:
    //
    //Buy the stock on day 0, and sell it on day 2.

    public static int maxProfit(final List<Integer> A) {
        if (A.size() == 0) return 0;
        int mxSoFar = 0;
        int minSoFar = A.get(0);
        int n = A.size();
        for (int i = 1; i < n; i++) {
            minSoFar = Math.min(minSoFar, A.get(i));
            int profit = A.get(i) - minSoFar;
            mxSoFar = Math.max(profit, mxSoFar);
        }
        System.out.println("Max Profit : "+mxSoFar);
        return mxSoFar;

    }

    //maxProfit(new int[]{7,1,5,3,6,4});
    public static int maxProfit(int[] prices) {
        int buy=Integer.MAX_VALUE,sell=0;
        for(int i=0;i<prices.length;i++){
            buy=Math.min(buy,prices[i]);
            System.out.println("i = "+i+" , Buy : "+buy+ " , current price = "+prices[i]+" ,  profit = "+(prices[i]-buy)+" ,  sell = "+Math.max(sell,prices[i]-buy));
            sell=Math.max(sell,prices[i]-buy);
        }
        return sell;
    }

    public static int maxProfit2(final List<Integer> A) {
        if (A.size() == 0) return 0;
        int mxSoFar = 0;
        int minSoFar = A.get(0);
        int n = A.size();
        for (int i = 0; i < n; i++) {
            System.out.println("i = "+i +" ,MinPrice : Math.min ( "+minSoFar+ " , "+A.get(i)+" ) = "+Math.min(minSoFar, A.get(i)));
            minSoFar = Math.min(minSoFar, A.get(i));
            int profit = A.get(i) - minSoFar;
            System.out.println("i = "+i +" ,Max Profit  : Math.max ( "+profit+ " , "+mxSoFar+" ) = "+Math.max(profit, mxSoFar)+" , Profit : "+profit);
            mxSoFar = Math.max(profit, mxSoFar);
            System.out.println("\n\n");
        }
        System.out.println("Max Profit : "+mxSoFar);
        return mxSoFar;

    }

    public static void main(String[] args) {
      //maxProfit2(Arrays.asList(1, 4, 5, 2, 4));
        maxProfit(new int[]{7,1,5,3,6,4});
    }
}
