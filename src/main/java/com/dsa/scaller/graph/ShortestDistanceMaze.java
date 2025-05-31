package main.java.com.dsa.scaller.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//Problem Description
//
//Given a matrix of integers A of size N x M describing a maze. The maze consists of empty locations and walls.
//
//1 represents a wall in a matrix and 0 represents an empty location in a wall.
//
//There is a ball trapped in a maze. The ball can go through empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall (maze boundary is also considered as a wall). When the ball stops, it could choose the next direction.
//
//Given two array of integers of size B and C of size 2 denoting the starting and destination position of the ball.
//
//Find the shortest distance for the ball to stop at the destination. The distance is defined by the number of empty spaces traveled by the ball from the starting position (excluded) to the destination (included). If the ball cannot stop at the destination, return -1.
//
//
//
//Problem Constraints
//
//2 <= N, M <= 100
//
//0 <= A[i] <= 1
//
//0 <= B[i][0], C[i][0] < N
//
//0 <= B[i][1], C[i][1] < M
//
//
//
//Input Format
//
//The first argument given is the integer matrix A.
//
//The second argument given is an array of integer B.
//
//The third argument if an array of integer C.
//
//
//
//Output Format
//
//Return a single integer, the minimum distance required to reach destination
//
//
//
//Example Input
//
//Input 1:
//
//
//A = [ [0, 0],
//      [0, 0] ]
//B = [0, 0]
//C = [0, 1]
//
//
//Input 2:
//
//A = [ [0, 1],
//      [1, 0] ]
//B = [0, 0]
//C = [1, 1]
//
//
//
//
//
//
//
//
//
//
//
//
//Example Output
//
//Output 1:
//
//
// 1
//
//
//Output 2:
//
// -1
//
//
//
//
//
//
//
//
//
//
//
//
//Example Explanation
//
//Explanation 1:
//
// Go directly from start to destination in distance 1.
//Explanation 2:
//
// It is impossible to reach the destination from (0, 0) to (1, 1) as there are walls at (1, 0) and (0, 1)
public class ShortestDistanceMaze {

    // Custom class to hold distance and current coordinates
    class Pair {
        int dist; // distance traveled so far
        int row;  // current row position
        int col;  // current column position

        Pair(int dist, int row, int col) {
            this.dist = dist;
            this.row = row;
            this.col = col;
        }
    }

    // Main function to solve the problem
    public int solve(int[][] A, int[] B, int[] C) {
        int row = A.length;        // total number of rows in the maze
        int col = A[0].length;     // total number of columns in the maze

        // Array to store the minimum distance to each cell from the start
        int[][] ans = new int[row][col];
        for (int[] a : ans) Arrays.fill(a, Integer.MAX_VALUE); // Initialize all distances to MAX

        // BFS queue to process each position in the maze
        Queue<Pair> queue = new LinkedList<>();

        // Add starting position to the queue
        queue.add(new Pair(0, B[0], B[1]));
        ans[B[0]][B[1]] = 0; // Distance to the starting point is 0

        // Directions for up, right, down, and left movements
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};

        // Start BFS traversal
        while (!queue.isEmpty()) {
            // Get the current position from the queue
            Pair current = queue.poll();

            // Try moving in all four directions
            for (int i = 0; i < 4; i++) {
                int r = current.row;
                int c = current.col;
                int steps = 0;

                // Roll in the chosen direction until hitting a wall or boundary
                while (r + dRow[i] >= 0 && r + dRow[i] < row &&
                        c + dCol[i] >= 0 && c + dCol[i] < col &&
                        A[r + dRow[i]][c + dCol[i]] == 0) {
                    r += dRow[i];  // keep rolling in the row direction
                    c += dCol[i];  // keep rolling in the column direction
                    steps++;       // count number of steps taken
                }

                // If this path is shorter than the previously recorded one, update it
                if (current.dist + steps < ans[r][c]) {
                    ans[r][c] = current.dist + steps;  // update distance
                    queue.add(new Pair(ans[r][c], r, c)); // add new position to queue
                }
            }
        }

        // If destination is unreachable, return -1
        return ans[C[0]][C[1]] == Integer.MAX_VALUE ? -1 : ans[C[0]][C[1]];
    }
}
