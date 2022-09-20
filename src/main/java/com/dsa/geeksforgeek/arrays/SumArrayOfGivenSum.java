package com.dsa.geeksforgeek.arrays;

import java.util.HashMap;
import java.util.Map;

public class SumArrayOfGivenSum {
    //{10,15,-5,15,-10,5}
    // sum =5
    // find the subArray of given sum of start and end index

    public static void getSubArraySum(int[] arr, int target){

        // currentsum , index
        Map<Integer,Integer> map = new HashMap<>();
        int currentSum =0;
        int startIndex=0;
        int endIndex=-1;

        for(int i=0;i<arr.length;i++){
           currentSum = currentSum+arr[i];

           if(currentSum-target==0){
               startIndex =0;
               endIndex=i;
               break;
           }
           if(map.containsKey(currentSum-target)){
               startIndex = map.get(currentSum-target)+1;
               endIndex=i;
               break;
           }
           map.put(currentSum,i);
        }

        if(endIndex==-1)
            System.out.println("Target Element not found");
        else
            System.out.println("Sub array occurs between : "+startIndex+ " to : "+endIndex);
    }

    public static boolean isGivenSumExist(int [] arr, int sum){
        int startIndex=0,endIndex =0,currentSum=0;
        for(endIndex=0;endIndex<arr.length;endIndex++){
            currentSum = currentSum+ arr[endIndex];
            while(currentSum>sum && startIndex<endIndex) {
                currentSum = currentSum-arr[startIndex];
                startIndex++;
            }
            if(currentSum==sum){
                return true;
            }
        }

        return false;


    }

    public static void main(String[] args) {
        System.out.println(isGivenSumExist(new int[]{10,15,-5,15,-10,5},5));
    }
}
