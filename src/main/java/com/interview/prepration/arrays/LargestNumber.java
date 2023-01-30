package com.interview.prepration.arrays;

import java.util.Arrays;

public class LargestNumber {

    public static String getLargestNumber(int[] nums){
        String[] arr = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);

        Arrays.sort(arr,(a,b)->(b+a).compareTo(a+b));
        StringBuilder sb = new StringBuilder();
        for(String s: arr){
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        //int[] arr = new int[]{10,2};
        int[] arr = new int[]{54,546,548,60};
        System.out.println(getLargestNumber(arr));
    }
}
