package com.dsa.scaller.sorting.RadixNCount;

import java.util.ArrayList;

public class LargestNumber {
    public static String largestNumber(final int[] A) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            ArrayList<Integer> data = new ArrayList<>();
            list.add(data);
        }
        System.out.println("Before modifying data : "+ list);


        for (int i = 0; i < A.length; i++) {
            int digit = (A[i]) % 10;
            ArrayList<Integer> data = new ArrayList<>();
            data.add(A[i]);
            list.set(digit,data);
        }
        System.out.println("After modifying data : "+ list);

        String ans = "";

        for (int i = 9; i >=0; i--) {
            for (int j = 0; j < list.get(i).size(); j++) {
                ans = ans + list.get(i).get(j);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(largestNumber(new int[]{8,89}));
    }
}
