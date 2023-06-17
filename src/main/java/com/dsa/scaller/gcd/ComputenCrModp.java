package com.dsa.scaller.gcd;

public class ComputenCrModp {
    //Problem Description
    //Given three integers A, B, and C, where A represents n, B represents r, and C represents p and p is a prime number greater than equal to n, find and return the value of nCr % p where nCr % p = (n! / ((n-r)! * r!)) % p.
    //
    //x! means factorial of x i.e. x! = 1 * 2 * 3... * x.
    //
    //NOTE: For this problem, we are considering 1 as a prime.
    //
    //
    //
    //Problem Constraints
    //1 <= A <= 106
    //1 <= B <= A
    //A <= C <= 109+7
    //
    //
    //Input Format
    //The first argument given is the integer A ( = n).
    //The second argument given is the integer B ( = r).
    //The third argument given is the integer C ( = p).
    //
    //
    //
    //Output Format
    //Return the value of nCr % p.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = 5
    // B = 2
    // C = 13
    //Input 2:
    //
    // A = 6
    // B = 2
    // C = 13
    //
    //
    //Example Output
    //Output 1:
    //
    // 10
    //Output 2:
    //
    // 2
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // nCr( n=5 and r=2) = 10.
    // p=13. Therefore, nCr%p = 10.

    static int factorial(long n, long m) {
        long product = 1;
        for (int i = 2; i <= n; i++) product = (product * i % m) % m;
        return (int) product;

    }

    // a power(b) % P
    static int fastPower(long num, long power, long prime) {
        if (power == 0) return 1;
        long x = fastPower(num, power / 2, prime);
        long sqr = (x * x) % prime;
        if (power % 2 == 0) {
            return (int) sqr;
        } else {
            return (int) ((sqr * num) % prime);
        }
    }

    public static int solve(int A, int B, int C) {
        if (A == B && B == C) return 0;
        //int prime =(int) 1e9+7;
        long nf = factorial(A, C);
        long rf = factorial(B, C);
        long nrf = factorial(A - B, C);
        long firstPower = fastPower(rf, C - 2, C);
        long secondPower = fastPower(nrf, C - 2, C);
        // if(firstPower==0|| secondPower==0) return 1;
        return (int) (nf % C * firstPower % C * secondPower % C) % C;
    }

    public static void main(String[] args) {
        System.out.println(solve(1, 1, 1));
    }

}
