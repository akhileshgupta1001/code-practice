package com.dsa.scaller.linkedlist;

import java.util.*;

public class PainterPartitionProblem {
    //Problem Description
    //Given 2 integers A and B and an array of integers C of size N. Element C[i] represents the length of ith board.
    //You have to paint all N boards [C0, C1, C2, C3 … CN-1]. There are A painters available and each of them takes B units of time to paint 1 unit of the board.
    //
    //Calculate and return the minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of the board.
    //NOTE:
    //1. 2 painters cannot share a board to paint. That is to say, a board cannot be painted partially by one painter, and partially by another.
    //2. A painter will only paint contiguous boards. This means a configuration where painter 1 paints boards 1 and 3 but not 2 is invalid.
    //
    //Return the ans % 10000003.
    //
    //
    //
    //Problem Constraints
    //1 <= A <= 1000
    //1 <= B <= 106
    //1 <= N <= 105
    //1 <= C[i] <= 106
    //
    //
    //
    //Input Format
    //The first argument given is the integer A.
    //The second argument given is the integer B.
    //The third argument given is the integer array C.
    //
    //
    //
    //Output Format
    //Return minimum time required to paint all boards under the constraints that any painter will only paint contiguous sections of board % 10000003.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = 2
    // B = 5
    // C = [1, 10]
    //Input 2:
    //
    // A = 10
    // B = 1
    // C = [1, 8, 11, 3]
    //
    //
    //Example Output
    //Output 1:
    //
    // 50
    //Output 2:
    //
    // 11
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // Possibility 1:- One painter paints both blocks, time taken = 55 units.
    // Possibility 2:- Painter 1 paints block 1, painter 2 paints block 2, time take = max(5, 50) = 50
    // There are no other distinct ways to paint boards.
    // ans = 50 % 10000003
    //Explanation 2:
    //
    // Each block is painted by a painter so, Painter 1 paints block 1, painter 2 paints block 2, painter 3 paints block 3
    // and painter 4 paints block 4, time taken = max(1, 8, 11, 3) = 11
    // ans = 11 % 10000003
    public long minimumPainter(ArrayList<Integer> C, long B, long totalTime) {
        long count = 1;
        long rTime = totalTime;
        long mod = 10000003;

        for (int i = 0; i < C.size(); i++) {
            long time = (long) (C.get(i) * B);
            if (time > totalTime) {
                return Integer.MAX_VALUE;
            }
            if (rTime >= time) {
                rTime = (rTime - time);
            } else {
                count++;
                rTime = (totalTime - time);
            }
        }
        return count;
    }

    public int paint(int A, int B, ArrayList<Integer> C) {
        long l = 0;
        long r = 0;
        long mod = 10000003;

        for (int i = 0; i < C.size(); i++) {
            l = Math.max(l, C.get(i));
            r = r + C.get(i);
        }
        l = l * B;
        r = r * B;
        // System.out.println("l : "+l+" , r : "+r);
        while (l <= r) {
            long mid = l + (r - l) / 2;
            long count = minimumPainter(C, B, mid);
            long count1 = minimumPainter(C, B, mid - 1);
            // System.out.println("Count : "+count);
            //System.out.println("Count 1 : "+count1 + ", Painter :"+A);

            //if(count==Integer.MAX_VALUE) return -1;
            //if(count1==Integer.MAX_VALUE) return -1;
            if (count <= A && count1 > A) {
                return (int) (mid % mod);
            }
            List<Integer> list = new LinkedList<>();
            if (count <= A) r = mid - 1;
            else l = mid + 1;
        }

        return -1;
    }
}
