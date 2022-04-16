package com.dsa.geeksforgeek.arrays;

public class RemoveDuplicatesFromStartedArray {
    public static int uniqueElement(int[] arr){
        int result=1;
        for(int i=1;i<arr.length;i++){

            if(arr[i] != arr[result-1]){
                arr[result]= arr[i];
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(uniqueElement(new int[]{10,35,40,41}));
        System.out.println(uniqueElement(new int[]{10,35,35,40,41,41,42}));

    }
}
