package com.dsa.scaller.graph;

import java.util.*;


// Define a class to represent an edge with its destination and cost
class Edge implements Comparable<Edge> {
    int to;
    int cost;

    // Constructor for creating an edge
    public Edge(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }

    // Override compareTo method to compare edges by their cost
    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.cost, other.cost);
    }
}

// Create a class for solving the problem using Prim's algorithm
public class PrismAlgo {

    // Method to find the minimal cost of connecting all islands
    public int findMSTCost(int A, int[][] B) {
        // Create a graph as a list of lists where each vertex has a list of edges
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= A; i++) {
            graph.add(new ArrayList<>());
        }

        // Populate the graph with bridge information from input
        for (int[] bridge : B) {
            int from = bridge[0];
            int to = bridge[1];
            int cost = bridge[2];
            graph.get(from).add(new Edge(to, cost));
            graph.get(to).add(new Edge(from, cost)); // For an undirected graph
        }

        // Initialize variables to track minimal cost and visited nodes
        int minimalCost = 0;
        boolean[] visited = new boolean[A + 1];

        // Create a priority queue (minHeap) for efficient edge selection
        PriorityQueue<Edge> minHeap = new PriorityQueue<>();
        minHeap.offer(new Edge(1, 0)); // Start from node 1 with cost 0

        // Main loop of Prim's algorithm
        while (!minHeap.isEmpty()) {
            Edge edge = minHeap.poll();
            int node = edge.to;
            int cost = edge.cost;

            // Skip visited nodes
            if (visited[node]) {
                continue;
            }

            // Mark the node as visited and add the cost to the minimal cost
            visited[node] = true;
            minimalCost += cost;

            // Explore neighboring edges and add them to the minHeap if not visited
            for (Edge neighbor : graph.get(node)) {
                if (!visited[neighbor.to]) {
                    minHeap.offer(neighbor);
                }
            }
        }

        // Return the minimal cost as the result
        return minimalCost;
    }

    public static void main(String[] args) {
        int A1 = 4;
        int[][] B1 = {{1, 2, 1}, {2, 3, 4}, {1, 4, 3}, {4, 3, 2}, {1, 3, 10}};

        int A2 = 4;
        int[][] B2 = {{1, 2, 1}, {2, 3, 2}, {3, 4, 4}, {1, 4, 3}};

        PrismAlgo prim = new PrismAlgo();

        // Print the minimal cost for two different input scenarios
        System.out.println(prim.findMSTCost(A1, B1)); // Output: 6
        System.out.println(prim.findMSTCost(A2, B2)); // Output: 6
    }
}

