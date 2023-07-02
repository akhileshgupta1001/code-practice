package com.dsa.scaller.binarysearch;

public class MagicalNumber {
    //Problem Description
    //You are given three positive integers, A, B, and C.
    //
    //Any positive integer is magical if divisible by either B or C.
    //
    //Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.
    //
    //Note: Ensure to prevent integer overflow while calculating.
    //
    //
    //
    //Problem Constraints
    //1 <= A <= 109
    //
    //2 <= B, C <= 40000
    //
    //
    //
    //Input Format
    //The first argument given is an integer A.
    //
    //The second argument given is an integer B.
    //
    //The third argument given is an integer C.
    //
    //
    //
    //Output Format
    //Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = 1
    // B = 2
    // C = 3
    //Input 2:
    //
    // A = 4
    // B = 2
    // C = 3
    //
    //
    //Example Output
    //Output 1:
    //
    // 2
    //Output 2:
    //
    // 6
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // 1st magical number is 2.
    //Explanation 2:
    //
    // First four magical numbers are 2, 3, 4, 6 so the 4th magical number is 6.

    int gcd (int a, int b){
        if(a==0) return b;

        return gcd(b%a,a);
    }
    public int solve(int A, int B, int C) {
        long lcm = (B * C) / gcd(B, C);
        long l = Math.min(B, C);
        long r = (A * lcm);
        long mod = (long) 1e9 + 7;

        while (l < r) {
            long mid = l + (r - l) / 2;
            long count = mid / B + mid / C - mid / lcm;

            if (count >= A)
                r = mid;
            else
                l = mid + 1;
        }

        return (int) (l % mod);
    }
}
