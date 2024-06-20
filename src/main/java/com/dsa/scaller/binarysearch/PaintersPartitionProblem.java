package com.dsa.scaller.binarysearch;

import java.util.ArrayList;

public class PaintersPartitionProblem {
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

    // This method calculates the  minimum time taken by a painter to paint boards.
    int minimumTimeTakenByPainter(int A[], int T, int X) {
        int remainingTime = X; // Initialize remaining time with the total available time.
        int count = 0; // Initialize the count of painted boards.

        for (int i = 0; i < A.length; i++) {
            int time = A[i] * T; // Calculate the time required to paint the current board.

            // If the time required to paint a board is greater than the available time,
            // return a large value to indicate it's not possible to paint the boards.
            if (time > X)
                return Integer.MAX_VALUE;

            if (remainingTime >= time) {
                // If there is enough time to paint the current board, subtract the time from remaining time.
                remainingTime = remainingTime - time;
            } else {
                // If there is not enough time, increment the count of painted boards and reset the remaining time.
                count++;
                remainingTime = X - time;
            }
        }
        return count; // Return the count of boards painted in the given time.
    }

    // This method finds the minimum time required for painters to complete painting boards.
    public int paint(int A, int B, int[] C) {
        int l = 0; // Initialize the left boundary for binary search.
        int r = C[0] * B; // Initialize the right boundary for binary search.

        for (int i = 1; i < C.length; i++) {
            // Calculate the maximum time needed for the painter to paint a board.
            l = Math.max(C[i] * B, C[i - 1] * B);
            r += C[i] * B;
        }

        while (l <= r) {
            int mid = l + (r - l) / 2; // Calculate the midpoint for binary search.
            int count = minimumTimeTakenByPainter(C, B, mid); // Calculate the count of boards painted at mid.
            int count1 = minimumTimeTakenByPainter(C, B, mid - 1); // Calculate the count at mid - 1.

            // If the current time allows all painters to paint the boards, return the time.
            if (count <= A && count1 < A) {
                System.out.println(" Ans = "+ mid);
                return mid;
            }

            if (count <= A) {
                // If count is less than or equal to A, update the right boundary.
                r = mid - 1;
            } else {
                // If count is greater than A, update the left boundary.
                l = mid + 1;
            }
        }

        return -1; // Return -1 if it's not possible to paint all the boards in A units of time.
    }

    // Function to calculate the minimum time required to paint boards with constraints.
    public int paintSolve(int painters, int timePerUnit, ArrayList<Integer> boardLengths) {
        long mod = 10000003; // Define the modulo value to take care of overflow.
        long low = 0; // Initialize the lower bound of the binary search range.
        long high = 0; // Initialize the upper bound of the binary search range.

        // Calculate the range of possible solutions for the minimum time.
        for (int i = 0; i < boardLengths.size(); i++) {
            high += (long)boardLengths.get(i) * timePerUnit; // Sum up the product of board length and time per unit.
        }

        long result = -1; // Initialize the result variable to store the minimum time.

        // Perform binary search to find the minimum time.
        while (low <= high) {
            long mid = (low + high) / 2; // Calculate the midpoint of the range.
            if (isPossible(boardLengths, painters, timePerUnit, mid)) {
                result = mid; // Update the result with the current midpoint.
                high = mid - 1; // Adjust the upper bound of the range.
            } else {
                low = mid + 1; // Adjust the lower bound of the range.
            }
        }

        // Calculate the final result while taking care of overflow with modulo.
        return (int)(result % mod);

    }

    // Function to check if the current time is feasible for the given number of painters.
    public boolean isPossible(ArrayList<Integer> boardLengths, int painters, int timePerUnit, long maxTime) {
        int totalPainters = 1; // Initialize the total painters to 1.
        long currentTime = 0; // Initialize the current time to 0.

        // Loop through the board lengths.
        for (int i = 0; i < boardLengths.size(); i++) {
            long boardTime = (long)boardLengths.get(i) * timePerUnit; // Calculate the time needed for the current board.
            if (boardTime > maxTime) {
                return false; // If a board can't be painted within the given time, return false.
            }

            if (currentTime + boardTime <= maxTime) {
                currentTime += boardTime; // Add the current board's time to the current time.
            } else {
                totalPainters++; // Increment the total painters as a new painter is needed.
                currentTime = boardTime; // Reset the current time for the new painter.
                if (totalPainters > painters) {
                    return false; // If the total painters exceed the given limit, return false.
                }
            }
        }

        return true; // Return true if painting is possible within the given time.
    }


    public int paint(int A, int B, ArrayList<Integer> C) {
        return paintSolve(A,B,C);
    }

    public static void main(String[] args) {
        PaintersPartitionProblem paintersPartitionProblem = new PaintersPartitionProblem();
        paintersPartitionProblem.paint(1,1000000,new int[]{1000000,100000});
    }
}
