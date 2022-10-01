package com.dsa.geeksforgeek.dyanmic.programing;

import java.util.Arrays;
import java.util.stream.Collectors;

public class OptimalGameStatergy {

    //https://www.geeksforgeeks.org/optimal-strategy-for-a-game-dp-31/

    public static int getMaxOptimalStategry(int[] arr, int start, int end , int sum ){

        if(end==start+1)
            return Math.max(arr[start],arr[end]);
        else
            return Math.max( sum- getMaxOptimalStategry(arr,start+1,end,sum-arr[start]),
                    sum- getMaxOptimalStategry(arr,start,end-1,sum-arr[end]));
    }

    public static int getMaxValue(int[] arr){
        int start=0;
        int end = arr.length-1;
        int sum = Arrays.stream(arr).sum();
       return getMaxOptimalStategry(arr,0,end,sum);
    }


    public static int getMaxOptimalStategry2(int[] arr, int start, int end ){

        if(end==start+1)
            return Math.max(arr[start],arr[end]);
        else
            return Math.max( arr[start]+
                    Math.min(getMaxOptimalStategry2(arr,start+2,end),
                            getMaxOptimalStategry2(arr,start+1,end-1)),
                    arr[end]+Math.min(getMaxOptimalStategry2(arr,start+1,end-1),
                            getMaxOptimalStategry2(arr,start,end-2)));

    }
    public static void main(String[] args) {
   //5, 3, 7, 10 : The user collects maximum value as 15(10 + 5)
        //8, 15, 3, 7 : The user collects maximum value as 22(7 + 15)
        int[] arr = new int[]{5, 3, 7, 10};
        int[] arr2 = new int[]{8, 15, 3, 7};
        System.out.println(getMaxOptimalStategry2(arr2,0,3));
    }
}
