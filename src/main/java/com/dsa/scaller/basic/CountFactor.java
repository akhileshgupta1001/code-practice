package com.dsa.scaller.basic;

public class CountFactor {
    //Given an integer A, you need to find the count of it's factors.
    //
    //Factor of a number is the number which divides it perfectly leaving no remainder.
    //
    //Example : 1, 2, 3, 6 are factors of 6
    public static int solve(int A) {
        int ans = 0;
        for (int i = 1; i * i <= A; i++) {
            if (A % i == 0) {
                if (A / i == i) {
                    ans++;
                } else {
                    ans = ans + 2;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(solve(6));
    }
}
