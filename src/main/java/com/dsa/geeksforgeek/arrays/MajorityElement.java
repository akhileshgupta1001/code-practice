package com.dsa.geeksforgeek.arrays;

public class MajorityElement {
    // n/2> greater

    public static int majorityElement(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int count = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == arr[j])
                    count++;
            }
            if (count > arr.length / 2)
                return i;
        }
        return -1;
    }

    //maurice , voting algo
    public static int getMajority(int[] arr){
        int count =1;
        int majorityIndex=0;
        for(int i=1;i<arr.length;i++){
            if(arr[majorityIndex]==arr[i]){
                count++;
            }else {
                count--;
            }
            if(count==0){
                majorityIndex = i;
                count=1;
            }
        }
        count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[majorityIndex]==arr[i]){
                count++;
            }
        }
        if(count>arr.length/2)
            return arr[majorityIndex];
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = new int[]{8, 7, 8, 6, 8, 6, 6, 6, 6};
        // index=3 , 6
        System.out.println(getMajority(arr));
    }
}
