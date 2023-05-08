package com.dsa.scaller.arrays;

public class Test {
    public int countFactor(int num) {
        int ans = 0;
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                if (num % i == i) {
                    ans++;
                } else {
                    ans = ans + 2;
                }
            }
        }
        return ans;
    }

    public int[] solve(int[] A, int[][] B) {
        int[] ans = new int[B.length];

        for (int i = 0; i < B.length; i++) {
            int row = B[i][0];
            int col = B[i][1];
            int count = 0;
            for (int j = row; j <= col; j++) {
                int factor = countFactor(A[j]);
                System.out.println("Factor "+A[j]+ " is : "+ factor);
                if (factor > 2) {
                    count++;
                }
            }

            ans[i] = count;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {7,4,6,2,6};
        int[][] queries= {{0,2},{2,4},{1,4}};
        Test test = new Test();
        test.solve(arr,queries);
    }
}
