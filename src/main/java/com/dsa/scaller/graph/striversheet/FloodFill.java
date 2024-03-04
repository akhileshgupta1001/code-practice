package com.dsa.scaller.graph.striversheet;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    class Pair { // Define the Pair class for storing row and column indices
        int row, col; // Declare row and col variables for Pair

        Pair(int row, int col) { // Constructor for Pair class
            this.row = row; // Initialize row
            this.col = col; // Initialize col
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) { // Method to perform flood fill
        int row = image.length; // Get the number of rows in the image
        int col = image[0].length; // Get the number of columns in the image
        boolean[][] visited = new boolean[row][col]; // Create a visited array to keep track of visited pixels
        Queue<Pair> queue = new LinkedList<>(); // Create a queue for BFS traversal
        queue.add(new Pair(sr, sc)); // Add the starting pixel to the queue
        int startCol = image[sr][sc]; // Store the color of the starting pixel

        int[] dRow = {-1, 0, 1, 0}; // Define the change in row for 4-directional traversal
        int[] dCol = {0, 1, 0, -1}; // Define the change in column for 4-directional traversal

        while (!queue.isEmpty()) { // Perform BFS traversal until the queue is empty
            Pair pair = queue.poll(); // Retrieve and remove the pixel from the front of the queue
            image[pair.row][pair.col] = color; // Change the color of the pixel to the new color
            for (int i = 0; i < 4; i++) { // Iterate through the 4-directional neighbors of the current pixel
                int r = pair.row + dRow[i]; // Compute the row index of the neighbor
                int c = pair.col + dCol[i]; // Compute the column index of the neighbor
                if (r >= 0 && r < row && c >= 0 && c < col // Check if the neighbor is within bounds
                        && visited[r][c] == false && image[r][c] == startCol) { // Check if the neighbor is not visited and has the same color as the starting pixel
                    visited[r][c] = true; // Mark the neighbor as visited
                    queue.add(new Pair(r, c)); // Add the neighbor to the queue for further processing
                }
            }
        }
        return image; // Return the modified image after flood fill
    }

    public static void main(String[] args) { // Main method
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}}; // Define the input image array
        int sr = 1, sc = 1, color = 2; // Define the starting row, starting column, and new color
        FloodFill solution = new FloodFill(); // Create an instance of the Solution class
        int[][] result = solution.floodFill(image, sr, sc, color); // Perform flood fill and store the result

        //System.out.println(Arrays.toString(result));

        // Print the modified image
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
