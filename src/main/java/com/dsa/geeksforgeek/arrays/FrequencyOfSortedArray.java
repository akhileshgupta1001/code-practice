package com.dsa.geeksforgeek.arrays;

public class FrequencyOfSortedArray {

    //{10,10,10,25,30,30}
    //10 : 3
    //25: 1
    //30: 2

    public static void frequencyCount(int[] arr) {
        int count = 1;
        for (int i = 0; i < arr.length; i++) {
            if ((i + 1) < arr.length && arr[i] == arr[i + 1])
                count++;
            else {
                System.out.println(arr[i] + " : " + count);
                count = 1;
            }
        }
    }

    public static void main(String[] args) {
        //  frequencyCount(new int[]{10, 10, 10, 25, 30, 30});
        //frequencyCount(new int[]{10, 10, 10, 10});
        frequencyCount(new int[]{10, 20, 30, 40, 50, 60});
        frequencyCount(new int[]{10, 20, 30, 40, 50, 60});


    }
}
