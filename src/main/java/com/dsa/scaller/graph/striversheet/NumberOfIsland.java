package com.dsa.scaller.graph.striversheet;

//Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
//
//An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
//
//
//
//Example 1:
//
//Input: grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//Output: 1
//Example 2:
//
//Input: grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//Output: 3
//
//
//Constraints:
//
//m == grid.length
//n == grid[i].length
//1 <= m, n <= 300
//grid[i][j] is '0' or '1'.

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIsland {
    class Pair {
        int row, col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        int ans = 0;
        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    ans++;
                    bfs(i, j, visited, grid);
                }
            }
        }
        return ans;
    }

    void bfs(int row, int col, boolean[][] visited, char[][] grid) {
        int[] dRow = {-1, 0, 1, 0}; // Define the change in row for 4-directional traversal
        int[] dCol = {0, 1, 0, -1}; // Define the change in column for 4-directional traversal

        visited[row][col] = true;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(row, col));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            for (int i = 0; i < 4; i++) {
                int r = pair.row + dRow[i];
                int c = pair.col + dCol[i];
                if (r >= 0 && r < visited.length && c >= 0 && c < visited[0].length && !visited[r][c] && grid[r][c] == '1') {
                    visited[r][c] = true;
                    queue.add(new Pair(r, c));
                }
            }
        }
    }
    public static void main(String[] args) {
        // Define the input grid
        char[][] grid1 = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };

        char[][] grid2 = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        // Create an instance of the Solution class
        NumberOfIsland solution = new NumberOfIsland();

        // Test case 1
        int numIslands1 = solution.numIslands(grid1);
        System.out.println("Number of islands in grid1: " + numIslands1); // Expected output: 1

        // Test case 2
        int numIslands2 = solution.numIslands(grid2);
        System.out.println("Number of islands in grid2: " + numIslands2); // Expected output: 3
    }
}

