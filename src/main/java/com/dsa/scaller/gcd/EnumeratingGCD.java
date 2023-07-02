package com.dsa.scaller.gcd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class EnumeratingGCD {
    //Problem Description
    //You are given a number A and a number B. Greatest Common Divisor (GCD) of all numbers between A and B inclusive is taken (GCD(A, A+1, A+2 ... B)).
    //As this problem looks a bit easy, it is given that numbers A and B can be in the range of 10100.
    //
    //You have to return the value of GCD found.
    //
    //The greatest common divisor of 2 numbers, A and B, is the largest number, D that divides both A and B perfectly.
    //
    //
    //
    //Problem Constraints
    //1 <= A <= B <= 10100
    //
    //
    //
    //Input Format
    //First argument is a string denoting A.
    //
    //Second argument is a string denoting B.
    //
    //
    //
    //Output Format
    //Return a string which contains the digits of the integer which represents the GCD. The returned string should not have any leading zeroes.
    //
    //
    //
    //Example Input
    //A = "1"
    //B = "3"
    //
    //
    //Example Output
    //1
    //
    //
    //Example Explanation
    //Greatest divisor that divides both 1 and 3 is 1.

    public String solve(String A, String B) {
        //Collections.swap(new);
        if (A.equals(B)) return A;
        else return "1";
    }

    public static int[] solve2(int[] A) {
        int[] frequency= new int [10];

        for(int i=0;i<A.length;i++){
            frequency[A[i]]++;
        }
        int k =0;
        for(int d=0;d < frequency.length;d++){
            for(int j= 1; j <= frequency[d];j++){
                A[k]=d;
             k++;
            }
            }
        Arrays.stream(A).forEach(System.out::println);
        return A;
    }

    public static void main(String[] args) {
        solve2(new int[]{1,3,6,8,2,1});
    }
}
