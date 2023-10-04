package com.dsa.scaller.graph;

import java.util.LinkedList;
import java.util.Queue;

class Cell {
    int row;
    int col;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
public class RottenOranges {

    // Function to calculate the minimum time to rot all oranges
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<Cell> queue = new LinkedList<>();

        // Step 1: Find the rotten oranges and add their positions to the queue
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 2) {
                    queue.add(new Cell(row, col));
                }
            }
        }

        int minutes = 0;

        // Step 2: Perform BFS traversal to rot the fresh oranges
        int[][] directions = {
                {-1, 0}, // Up: Move one row up (decrement row), but stay in the same column (no change in column)
                {1, 0},  // Down: Move one row down (increment row), but stay in the same column (no change in column)
                {0, -1}, // Left: Stay in the same row (no change in row), but move one column to the left (decrement column)
                {0, 1}   // Right: Stay in the same row (no change in row), but move one column to the right (increment column)
        };
        while (!queue.isEmpty()) {
            int size = queue.size();
            minutes++;

            // Process all oranges at the current minute
            for (int i = 0; i < size; i++) {
                Cell cell = queue.poll();
                int row = cell.row;
                int col = cell.col;

                // Loop through the four directions
                for (int[] direction : directions) {
                    int newRow = row + direction[0]; // Calculate the new row coordinate
                    int newCol = col + direction[1]; // Calculate the new column coordinate

                    // Check if the new coordinates are within bounds and if the cell is a fresh orange
                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1) {
                        grid[newRow][newCol] = 2; // Mark the adjacent orange as rotten
                        queue.add(new Cell(newRow, newCol)); // Add the new rotten orange to the queue
                    }
                }
            }
        }

            // Step 3: Check if any fresh oranges are left
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    if (grid[row][col] == 1) {
                        return -1; // Some fresh oranges are unreachable
                    }
                }
            }

        // Return the minimum number of minutes taken to rot all fresh oranges
        return minutes > 0 ? minutes - 1 : 0; // Subtract 1 because we start at minute 0
    }
}
