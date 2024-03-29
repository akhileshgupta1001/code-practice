package com.dsa.scaller.binarysearch;

public class SquareRootofInteger {
    //Problem Description
    //Given an integer A. Compute and return the square root of A.
    //If A is not a perfect square, return floor(sqrt(A)).
    //
    //The value of A can cross the range of Integer.
    //
    //NOTE:
    //   Do not use the sqrt function from the standard library.
    //   Users are expected to solve this in O(log(A)) time.
    //
    //
    //Problem Constraints
    //0 <= A <= 1010
    //
    //
    //Input Format
    //The first and only argument given is the integer A.
    //
    //
    //Output Format
    //Return floor(sqrt(A))
    //
    //
    //Example Input
    //Input 1:
    //
    // 11
    //Input 2:
    //
    // 9
    //
    //
    //Example Output
    //Output 1:
    //
    // 3
    //Output 2:
    //
    // 3
    //
    //
    //Example Explanation
    //Explanation 1:
    //When A = 11 , square root of A = 3.316. It is not a perfect square so we return the floor which is 3.
    //Explanatino 2:
    //When A = 9 which is a perfect square of 3, so we return 3.


    public int sqrt(int A) {
        long low = 1;
        long high = A;
        long N = A;

        if (A == 0 || A == 1) return A;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            long midSqr = mid * mid;
            if (midSqr <= N && ((mid + 1) * (mid + 1)) > N) {
                return (int) mid;
            }
            if (midSqr > N) high = mid - 1;
            else low = mid + 1;
        }

        return 1;
    }
}
