package com.dsa.geeksforgeek.dyanmic.programing;

public class SubsetProblem {

    //Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
    //Output: True
    //There is a subset (4, 5) with sum 9.
    //
    //Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 30
    //Output: False
    //There is no subset that add up to 30.

    //https://www.geeksforgeeks.org/subset-sum-problem-dp-25/

    public static int getCountSubSet(int[] arr,int sum, int size){

        if(size==0)
            return sum==0?1:0;

        return getCountSubSet(arr,sum,size-1)+ getCountSubSet(arr,sum-arr[size-1],size-1);
    }

    public static void main(String[] args) {
        int[] arr = new int []{3, 34, 4, 12, 5, 2};
        System.out.println(getCountSubSet(arr,11,arr.length));
    }
}
