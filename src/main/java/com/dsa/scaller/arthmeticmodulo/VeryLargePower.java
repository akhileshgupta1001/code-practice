package com.dsa.scaller.arthmeticmodulo;

public class VeryLargePower {
//Problem Description
//Given two Integers A, B. You have to calculate (A ^ (B!)) % (1e9 + 7).
//
//"^" means power,
//"%" means mod, and
//"!" means factorial.
//
//Note: Ensure to handle integer overflow when performing the calculations.
//
//
//Problem Constraints
//1 <= A, B <= 5e5
//
//
//
//Input Format
//First argument is the integer A
//
//Second argument is the integer B
//
//
//
//Output Format
//Return one integer, the answer to the problem
//
//
//
//Example Input
//Input 1:
//
//A = 1
//B = 1
//Input 2:
//
//A = 2
//B = 2
//
//
//Example Output
//Output 1:
//
//1
//Output 2:
//
//4
//
//
//Example Explanation
//Explanation 1:
//
// 1! = 1. Hence 1^1 = 1.
//Explanation 2:
//
// 2! = 2. Hence 2^2 = 4.

    public static int fact(int B) {
        if (B < 2) return 1;
        int p = (int) 1e9 + 6;
        long ans = fact(B - 1);
        return (int) ((ans * B) % p);
    }

    public static int power(int A, int B, int m) {
        if (B == 0) return 1;
        long x = power(A, B / 2, m) % m;
        long result = (x * x) % m;

        if (B % 2 != 0)
            result = (result * A) % m;

        return (int) result;
    }

    public static int solve(int A, int B) {
        int fact = fact(B);
        System.out.println(fact);
        int mod = (int) 1e9 + 7;
        return power(A, fact, mod);
    }

    public static void main(String[] args) {
        System.out.println(solve(2, 27));
    }
}
