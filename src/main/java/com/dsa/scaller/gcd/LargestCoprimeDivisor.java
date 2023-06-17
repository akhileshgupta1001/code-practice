package com.dsa.scaller.gcd;

public class LargestCoprimeDivisor {
    //Problem Description
    //
    //You are given two positive numbers A and B . You need to find the maximum valued integer X such that:
    //
    //X divides A i.e. A % X = 0
    //X and B are co-prime i.e. gcd(X, B) = 1
    //
    //
    //Problem Constraints
    //
    //1 <= A, B <= 109
    //
    //
    //
    //Input Format
    //
    //First argument is an integer A.
    //Second argument is an integer B.
    //
    //
    //
    //Output Format
    //
    //Return an integer maximum value of X as descibed above.
    //
    //
    //
    //Example Input
    //
    //Input 1:
    //
    // A = 30
    // B = 12
    //Input 2:
    //
    // A = 5
    // B = 10
    //
    //
    //Example Output
    //
    //Output 1:
    //
    // 5
    //Output 2:
    //
    // 1
    //
    //
    //Example Explanation
    //
    //Explanation 1:
    //
    // All divisors of A are (1, 2, 3, 5, 6, 10, 15, 30).
    // The maximum value is 5 such that A%5 == 0 and gcd(5,12) = 1
    //Explanation 2:
    //
    // 1 is the only value such that A%5 == 0 and gcd(1,10) = 1

    public static int gcd(int a, int b) {
        if (a == 0) return b;

        return gcd(b % a, a);
    }

    // Not optimised
    public static int cpFact(int A, int B) {
        int ans = 1;
        for (int i = 1; i <= A; i++) {
            if (A % i == 0) {
                int gcd = gcd(i, B);
                if (gcd == 1) {
                    ans = Math.max(ans, i);
                    System.out.println("ans : "+ans+" ,  i:  "+i);
                }

            }
        }
        return ans;
    }
    public static int cptFact2(int A, int B){
        while(gcd(A,B) !=1){
           A= A/gcd(A,B);
        }
        System.out.println("Ans : "+A);
        return A;
    }

    public static void main(String[] args) {
        // cpFact(30,12);
        cptFact2(2,3);
    }

}
