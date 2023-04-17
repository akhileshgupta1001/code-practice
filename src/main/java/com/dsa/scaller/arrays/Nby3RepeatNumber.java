package com.dsa.scaller.arrays;

// Google
public class Nby3RepeatNumber {
    //Problem Description
    //You're given a read-only array of N integers. Find out if any integer occurs more than N/3 times in the array in linear time and constant additional space.
    //If so, return the integer. If not, return -1.
    //
    //If there are multiple solutions, return any one.
    //
    //Note: Read-only array means that the input array should not be modified in the process of solving the problem
    //
    //
    //
    //Problem Constraints
    //1 <= N <= 7*105
    //1 <= A[i] <= 109
    //
    //
    //Input Format
    //The only argument is an integer array A.
    //
    //
    //Output Format
    //Return an integer.
    //
    //
    //Example Input
    //Input 1:
    //[1 2 3 1 1]
    //Input 2:
    //[1 2 3]
    //
    //
    //Example Output
    //Output 1:
    //1
    //Output 2:
    //-1
    //
    //
    //Example Explanation
    //Explanation 1:
    //1 occurs 3 times which is more than 5/3 times.
    //Explanation 2:
    //No element occurs more than 3 / 3 = 1 times in the array.
    public int repeatedNumber(int[] A) {
        int n = A.length;
        int element1 = 0;
        int element2 = 0;
        int c1 = 0;
        int c2 = 0;

        for (int i = 0; i < n; i++) {
            if (element1 == A[i]) {
                c1++;
            } else if (element2 == A[i]) {
                c2++;
            } else if (c1 == 0) {
                c1 = 1;
                element1 = A[i];
            } else if (c2 == 0) {
                c2 = 1;
                element2 = A[i];
            } else {
                c1--;
                c2--;
            }
        }

        c1 = 0;
        c2 = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] == element1) {
                c1++;
            } else if (A[i] == element2) {
                c2++;
            }
        }
        if (c1 > n / 3) return element1;
        if (c2 > n / 3) return element2;

        return -1;
    }
}
