package com.dsa.geeksforgeek.arrays;

public class SortedArray {
    public static boolean isSortedArray(int[] arr){

        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){

                if(arr[j]<arr[i])
                    return false;
            }
        }
        return true;
    }

    public static boolean isSorted(int[] arr){
        for(int i=1;i<arr.length;i++){
            if(arr[i]<arr[i-1])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isSorted(new int[]{10,35,40,41}));
        System.out.println(isSorted(new int[]{10,5,40,41}));
        System.out.println(isSortedArray(new int[]{10,35,40,41}));
        System.out.println(isSortedArray(new int[]{10,5,40,41}));
    }
}
