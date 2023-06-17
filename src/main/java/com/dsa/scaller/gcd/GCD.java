package com.dsa.scaller.gcd;

public class GCD {
    public int gcd(int A, int B) {
        if (A == 0) return B;
        return gcd(B % A, A);
    }
}
