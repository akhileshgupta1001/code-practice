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
    public static void main(String[] args) {
        int[] arr = new int[]{8, 7, 8, 6, 8, 6, 6, 6, 6};
        // index=3 , 6
        System.out.println(majorityElement(arr));
    }
}
