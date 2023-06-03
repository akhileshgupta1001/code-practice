package com.dsa.scaller.arthmeticmodulo;

public class PrimeModuloInverse {

    //Problem Description
    //Given two integers A and B. Find the value of A-1 mod B where B is a prime number and gcd(A, B) = 1.
    //
    //A-1 mod B is also known as modular multiplicative inverse of A under modulo B.
    //
    //
    //
    //Problem Constraints
    //1 <= A <= 109
    //1<= B <= 109
    //B is a prime number
    //
    //
    //
    //Input Format
    //First argument is an integer A.
    //Second argument is an integer B.
    //
    //
    //
    //Output Format
    //Return an integer denoting the modulor inverse
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = 3
    // B = 5
    //Input 2:
    //
    // A = 6
    // B = 23
    //
    //
    //Example Output
    //Output 1:
    //
    // 2
    //Output 2:
    //
    // 4
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // Let's say A-1 mod B = X, then (A * X) % B = 1.
    // 3 * 2 = 6, 6 % 5 = 1.
    //Explanation 2:
    //
    // Similarly, (6 * 4) % 23 = 1.
    //
    //
    //
    //Expected Output
    //Provide sample input and click run to see the correct output for the provided input. Use this to improve your problem understanding and test edge cases
    //Arg 1: A single Integer, For e.g 9
    //Enter Input Here
    //Arg 2: A single Integer, For e.g 9
    //Enter Input Here
    //Run

    int power(int A, int B, int power) {
        if (power == 0) return 1;
        int x = power(A, B, power / 2);
        if (power % 2 == 0) return ((x * x) % B);
        else {
            return ((((x * x) % B) * A) % B);
        }
    }

    public int solve(int A, int B) {
        ////by fermats theorum
        // a^-1 mod p ==> a^p-2 mod p
        int power = B - 2;
        return power(A, B, power);
    }
}
