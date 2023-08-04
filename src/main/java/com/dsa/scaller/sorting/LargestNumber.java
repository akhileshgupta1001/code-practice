package com.dsa.scaller.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {
    //Problem Description
    //Given an array A of non-negative integers, arrange them such that they form the largest number.
    //
    //Note: The result may be very large, so you need to return a string instead of an integer.
    //
    //
    //
    //Problem Constraints
    //1 <= len(A) <= 100000
    //0 <= A[i] <= 2*109
    //
    //
    //
    //Input Format
    //The first argument is an array of integers.
    //
    //
    //
    //Output Format
    //Return a string representing the largest number.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = [3, 30, 34, 5, 9]
    //Input 2:
    //
    // A = [2, 3, 9, 0]
    //
    //
    //Example Output
    //Output 1:
    //
    // "9534330"
    //Output 2:
    //
    // "9320"
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    //Reorder the numbers to [9, 5, 34, 3, 30] to form the largest number.
    //Explanation 2:
    //
    //Reorder the numbers to [9, 3, 2, 0] to form the largest number 9320.

    public static String largestNumber(final List<Integer> A) {
        String[] arr = new String[A.size()];

        for (int i = 0; i < A.size(); i++) {
            arr[i] = String.valueOf(A.get(i));
        }


        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }
        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }

    static int power(int number, int power , int mod){
        if(power==0) return 1;

        long x = power(number,power/2,mod);
        x= (x * x) % mod;
        if(power%2==0){
            return (int) x;
        }else{
            return (int)(x * number)%mod;
        }
    }
    public  static   int solve(int[] A) {
        Arrays.sort(A);
        int ans =0;
        int n= A.length;

        int mod = (int) 1000000007;


        for(int i=0;i<A.length;i++){

            int powerCal = (power(2,i,mod) % mod -power(2,n-1-i,mod) % mod) % mod;
                 ans+=  ((A[i] %mod) * powerCal % mod)%mod;


        }

        return ans;
    }

    public static void main(String[] args) {

        System.out.println(largestNumber(Arrays.asList(10,2)));
    }
}
