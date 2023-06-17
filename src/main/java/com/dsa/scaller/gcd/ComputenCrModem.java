package com.dsa.scaller.gcd;

public class ComputenCrModem {
    //Problem Description
    //Given three integers A, B, and C, where A represents n, B represents r, and C represents m, find and return the value of nCr % m where nCr % m = (n!/((n-r)!*r!))% m.
    //
    //x! means factorial of x i.e. x! = 1 * 2 * 3... * x.
    //
    //
    //
    //Problem Constraints
    //1 <= A * B <= 106
    //
    //1 <= B <= A
    //
    //1 <= C <= 106
    //
    //
    //
    //Input Format
    //The first argument given is integer A ( = n).
    //The second argument given is integer B ( = r).
    //The third argument given is integer C ( = m).
    //
    //
    //Output Format
    //Return the value of nCr % m.
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
    // The value of 5C2 % 11 is 10.
    //Explanation 2:
    //
    // The value of 6C2 % 13 is 2.

    /*
    static int factorial(long n, long m) {
        long product = 1;
        for (int i = 2; i <= n; i++) product = (product * i % m) % m;
        return (int) product;
    }

    public static int solve(int A, int B, int C) {
        int nf = factorial(A,C);
        int nfr = factorial(A - B,C);
        int rf = factorial(B,C);

        return (nf / ((nfr * rf))) % C;
    }
    */

    public static  int solve(int A, int B, int C){
        int[][] cobmbination = new int[A+1][B+1];

        for(int i=0;i< cobmbination.length;i++){
            for(int j=0;j<cobmbination[0].length;j++) {

                if (i < j) {
                    cobmbination[i][j] = 0;
                } else if (j == 0) {
                    cobmbination[i][j] = 1;
                } else {
                    cobmbination[i][j] = (cobmbination[i - 1][j - 1] + cobmbination[i - 1][j]) % C;
                }
            }
        }

        return cobmbination[A][B];

    }

    public static void main(String[] args) {
        System.out.println(solve(38,5,81));
    }
}
