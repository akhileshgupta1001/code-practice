package com.dsa.scaller.graph; // Declare the package for the TopologicalSort class

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

public class TopologicalSort {

    // Function to perform topological sorting
    public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // Create a 2D ArrayList to represent the graph
        int n = A; // Store the number of nodes in the graph
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>()); // Initialize the adjacency lists for each node
        }
        for (ArrayList<Integer> edge : B) {
            int from = edge.get(0); // Get the "from" node of the edge
            int to = edge.get(1);   // Get the "to" node of the edge
            graph.get(from).add(to); // Add an edge from "from" to "to" in the graph
        }

        int[] inDegree = inDegree(graph, A, n); // Calculate the in-degrees of each node
        PriorityQueue<Integer> queue = new PriorityQueue<>(); // Create a priority queue for nodes with in-degree 0

        // Initialize the queue with nodes having in-degree 0
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        System.out.println("Priority Queue : "+queue);

        ArrayList<Integer> ans = new ArrayList<Integer>(); // Initialize an ArrayList to store the topological ordering
        while (!queue.isEmpty()) {
            int current = queue.poll(); // Get a node with in-degree 0 from the queue
            ans.add(current); // Add the node to the topological ordering

            // Process the neighbors of the current node
            for (int edge : graph.get(current)) {
                inDegree[edge]--; // Decrement the in-degree of the neighbor
                if (inDegree[edge] == 0) {
                    queue.add(edge); // If the in-degree becomes 0, add the neighbor to the queue
                }
            }
        }

        // Check if the topological ordering is valid (contains all nodes)
        if (ans.size() != A) return new ArrayList<Integer>();
        return ans; // Return the topological ordering
    }

    // Function to calculate the in-degrees of each node in the graph
    int[] inDegree(ArrayList<ArrayList<Integer>> graph, int A, int n) {
        int[] inDegree = new int[n + 1]; // Create an array to store in-degrees, initialized with zeros
        for (int i = 1; i <= A; i++) {
            for (int edge : graph.get(i)) {
                inDegree[edge]++; // Increment the in-degree for each neighbor of node i
            }
        }
        return inDegree; // Return the array of in-degrees
    }

    public ArrayList<Integer> solve2(int A, ArrayList<ArrayList<Integer>> B) {
        // Create an adjacency list to represent the directed graph
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= A; i++) {
            graph.add(new ArrayList<Integer>());
        }

        // Build the graph
        for (ArrayList<Integer> edge : B) {
            int from = edge.get(0);
            int to = edge.get(1);
            graph.get(from).add(to); // Add directed edge from 'from' to 'to'
        }

        // Arrays to track visited nodes and nodes currently on the stack
        boolean[] visited = new boolean[A + 1];
        boolean[] onStack = new boolean[A + 1];

        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();

        // Iterate through all nodes and perform DFS
        for (int i = 1; i <= A; i++) {
            if (!visited[i]) {
                // If a cycle is detected during DFS, return an empty list
                if (dfs(i, graph, visited, onStack, stack)) {
                    return new ArrayList<Integer>();
                }
            }
        }

        // Pop nodes from the stack to get the topological order
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }

    // Depth-First Search (DFS) function with cycle detection
    boolean dfs(int node, ArrayList<ArrayList<Integer>> graph, boolean[] visited,
                boolean[] onStack, Stack<Integer> stack) {
        visited[node] = true;
        onStack[node] = true;

        // Explore neighbors of the current node
        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                // Recursively perform DFS on unvisited neighbors
                if (dfs(neighbor, graph, visited, onStack, stack)) {
                    return true; // Cycle detected
                }
            } else if (onStack[neighbor]) {
                return true; // Cycle detected
            }
        }

        onStack[node] = false; // Remove the node from the stack
        stack.push(node); // Push the node onto the stack

        return false; // No cycle detected for this node
    }

public static void main(String[] args) {
        TopologicalSort topologicalSort = new TopologicalSort();

        // Test case 1: A simple directed acyclic graph (DAG)
        int nodes1 = 6;
        ArrayList<ArrayList<Integer>> edges1 = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(1, 2)),
                new ArrayList<>(Arrays.asList(1, 3)),
                new ArrayList<>(Arrays.asList(2, 4)),
                new ArrayList<>(Arrays.asList(3, 4)),
                new ArrayList<>(Arrays.asList(4, 5))
        ));
        ArrayList<Integer> expected1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        ArrayList<Integer> result1 = topologicalSort.solve(nodes1, edges1);

        if (result1.equals(expected1)) {
            System.out.println("Test case 1 passed.");
        } else {
            System.out.println("Test case 1 failed.");
        }

        // Test case 2: A graph with a cycle
        int nodes2 = 4;
        ArrayList<ArrayList<Integer>> edges2 = new ArrayList<>(Arrays.asList(
                new ArrayList<>(Arrays.asList(1, 2)),
                new ArrayList<>(Arrays.asList(2, 3)),
                new ArrayList<>(Arrays.asList(3, 1)),
                new ArrayList<>(Arrays.asList(4, 2))
        ));

        ArrayList<Integer> result2 = topologicalSort.solve(nodes2, edges2);

        if (result2.isEmpty()) {
            System.out.println("Test case 2 passed.");
        } else {
            System.out.println("Test case 2 failed.");
        }
    }
}
