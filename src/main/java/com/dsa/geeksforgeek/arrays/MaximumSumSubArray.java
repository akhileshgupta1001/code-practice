package com.dsa.geeksforgeek.arrays;

import java.util.Arrays;

public class MaximumSumSubArray {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total= nums1.length+nums2.length;
        int[] arr= new int[total];
        for(int i=0;i<nums1.length;i++){
            arr[i]=nums1[i];
        }

        int len= nums1.length;
        for(int i=len;i<total;i++){
            arr[i]=nums2[i-len];
        }
        Arrays.sort(arr);
        Arrays.stream(arr).forEach(System.out::println);
        int mid = total/2;
        double res=0;
        if(total%2==0){
            res = (arr[mid-1]+arr[mid])/2;
        }else{
            res = arr[mid];
        }
        return res;
    }
    public static int getMaximumSumSubArray(int[] arr){
        Arrays.stream(arr).forEach(System.out::println);
        int result =arr[0];
        int maxEnding = result;
        for(int i =1;i<arr.length;i++){
           maxEnding = Math.max(maxEnding+arr[i],arr[i]);
           result = Math.max(maxEnding,result);
        }
        System.out.println("Result : "+ result);
        return result;
    }

    public static int getMaxSumSubArray(int[] arr){
        int maxSum = Integer.MIN_VALUE;
        int sum =0;
        for(int i=0;i<arr.length;i++){
            sum = sum+ arr[i];
            if(sum>maxSum){
                maxSum = sum;
            }
            if(sum<0){
                sum=0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
       // getMaximumSumSubArray(new int[]{2,3,-2,4});
        System.out.println(getMaxSumSubArray(new int[]{2,-4,-2,6,-1}));

       // System.out.println(findMedianSortedArrays(new int[]{1,2},new int[]{3,4}));
    }
}
