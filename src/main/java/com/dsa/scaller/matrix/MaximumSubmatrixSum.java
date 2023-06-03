package com.dsa.scaller.matrix;

import java.util.ArrayList;

public class MaximumSubmatrixSum {
    //Problem Description
    //Given a row-wise and column-wise sorted matrix A of size N * M.
    //Return the maximum non-empty submatrix sum of this matrix.
    //
    //
    //Problem Constraints
    //1 <= N, M <= 1000
    //-109 <= A[i][j] <= 109
    //
    //
    //Input Format
    //The first argument is a 2D integer array A.
    //
    //
    //Output Format
    //Return a single integer that is the maximum non-empty submatrix sum of this matrix.
    //
    //
    //Example Input
    //Input 1:-
    //    -5 -4 -3
    //A = -1  2  3
    //     2  2  4
    //Input 2:-
    //    1 2 3
    //A = 4 5 6
    //    7 8 9
    //
    //
    //Example Output
    //Output 1:-
    //12
    //Output 2:-
    //45
    //
    //
    //Example Explanation
    //Expanation 1:-
    //The submatrix with max sum is
    //-1 2 3
    // 2 2 4
    // Sum is 12.
    //Explanation 2:-
    //The largest submatrix with max sum is
    //1 2 3
    //4 5 6
    //7 8 9
    //The sum is 45.

    public Long solve(ArrayList<ArrayList<Integer>> A) {
        Long ans = 0L;
        //Long maxAns =0L;
        int row = A.size();
        int col = A.get(0).size();
        long[][] suffixSum = new long[row][col];
        suffixSum[row - 1][col - 1] = (long) A.get(row - 1).get(col - 1);
        ans = suffixSum[row - 1][col - 1];

        // Row
        for (int j = col - 2; j >= 0; j--) {
            suffixSum[row - 1][j] = ((long) A.get(row - 1).get(j) + suffixSum[row - 1][j + 1]);
            ans = Math.max(ans, suffixSum[row - 1][j]);
        }
        // col
        for (int j = row - 2; j >= 0; j--) {
            suffixSum[j][col - 1] = ((long) A.get(j).get(col - 1) + suffixSum[j + 1][col - 1]);
            ans = Math.max(ans, suffixSum[j][col - 1]);
        }

        for (int i = A.size() - 2; i >= 0; i--) {
            for (int j = A.get(0).size() - 2; j >= 0; j--) {
                suffixSum[i][j] = suffixSum[i][j + 1] + suffixSum[i + 1][j] - suffixSum[i + 1][j + 1] + (long) A.get(i).get(j);
                ans = Math.max(ans, suffixSum[i][j]);
            }
        }

        return ans;
    }

    public static void main(String[] args) {

    }

    //[[-83,-73,-70,-61],[-56,-48,-13,4],[38,48,71,71]]
}
