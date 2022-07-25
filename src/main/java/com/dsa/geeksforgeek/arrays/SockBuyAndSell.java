package com.dsa.geeksforgeek.arrays;

public class SockBuyAndSell {

    //i/p {1,5,3,8,12}
    // o/p :13

    //{30,20,10}
    //o/p 0

    //{10,20,30}
    //o/p 20

    //{1,5,3,1,2,8}
    //11
    public static int maxProfitStock(int[] arr, int start, int end) {

        if (end <= start)
            return 0;

        int profit = 0;
        for (int i = start; i < end; i++) {
            for (int j = i + 1; j <= end; j++) {
                if (arr[j] > arr[i]) {
                    int currentProfit = arr[j] - arr[i]
                            + maxProfitStock(arr, start, i - 1)
                            + maxProfitStock(arr, j + 1, end);
                    profit = Math.max(currentProfit, profit);
                }
            }
        }
        return profit;
    }

    //Eficient solution
    public static int maxProfitBuySellStock(int[] arr, int start, int end) {

        System.out.println(arr.length);
        int profit = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                profit = profit + (arr[i] - arr[i - 1]);
            }
        }
       int min= Integer.MIN_VALUE;
        return profit;
    }


    public static void main(String[] args) {
         //int[] arr = new int[]{1, 5, 3, 8, 12};
        //int[] arr = new int[]{30,20,10};
        //int[] arr = new int[]{10, 20, 30};
         int arr[] = new int[]{7,1,5,3,6,4};
      //  System.out.println(maxProfitBuySellStock(arr, 0, arr.length - 1));
        System.out.println(maxProfitStock(new int[]{1,2},0,1));
    }

    public static int maxProfit(int[] prices) {
        int min = prices[0];
        int sizeArr = prices.length;
        int index=0;
        for(int i=1;i<sizeArr;i++){
            if(prices[i]<min){
                min = prices[i];
                index = i;
            }
        }

        if(prices[sizeArr-1]==min || (index==sizeArr-1))
            return 0;

        int max = min;
        int i= index+1;
        for(int j=i;j<sizeArr;j++){
            if(prices[j]>max){
                max = prices[j];
            }
        }
        return (max-min);
    }

}
