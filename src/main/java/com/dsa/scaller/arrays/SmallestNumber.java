package com.dsa.scaller.arrays;

public class SmallestNumber {
    //https://www.geeksforgeeks.org/find-smallest-number-whose-digits-multiply-given-number-n/
    //Find the smallest number whose digits multiply to a given number n

    // T.C = 0(log2N)
    // S.C = 0(1)
    //Input:  n = 36
    //Output: p = 49
    //// Note that 4*9 = 36 and 49 is the smallest such number
    //
    //Input:  n = 100
    //Output: p = 455
    //// Note that 4*5*5 = 100 and 455 is the smallest such number
    //
    //Input: n = 1
    //Output:p = 11
    //// Note that 1*1 = 1
    //
    //Input: n = 13
    //Output: Not Possible
    public static int getSmallest(int num){
        String ans="";
        for(int div =9; div>=2;div--){
            while (num % div ==0){
                num = num/div;
                ans = div+ ans;
            }
        }
        if(num != 1){
            return -1;
        }else {
            return Integer.parseInt(ans);
        }
    }

    public static void main(String[] args) {
        System.out.println(getSmallest(100));
    }
}
