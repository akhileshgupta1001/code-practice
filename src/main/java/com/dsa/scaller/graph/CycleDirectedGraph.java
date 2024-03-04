package com.dsa.scaller.graph;

import java.util.ArrayList;
import java.util.Arrays;

//Problem Description
//Given an directed graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].
//
//Find whether the graph contains a cycle or not, return 1 if cycle is present else return 0.
//
//NOTE:
//
//The cycle must contain atleast two nodes.
//There are no self-loops in the graph.
//There are no multiple edges between two nodes.
//The graph may or may not be connected.
//Nodes are numbered from 1 to A.
//Your solution will run on multiple test cases. If you are using global variables make sure to clear them.
//
//
//Problem Constraints
//2 <= A <= 105
//
//1 <= M <= min(200000,A*(A-1))
//
//1 <= B[i][0], B[i][1] <= A
//
//
//
//Input Format
//The first argument given is an integer A representing the number of nodes in the graph.
//
//The second argument given a matrix B of size M x 2 which represents the M edges such that there is a edge directed from node B[i][0] to node B[i][1].
//
//
//
//Output Format
//Return 1 if cycle is present else return 0.
//
//
//
//Example Input
//Input 1:
//
// A = 5
// B = [  [1, 2]
//        [4, 1]
//        [2, 4]
//        [3, 4]
//        [5, 2]
//        [1, 3] ]
//Input 2:
//
// A = 5
// B = [  [1, 2]
//        [2, 3]
//        [3, 4]
//        [4, 5] ]
//
//
//Example Output
//Output 1:
//
// 1
//Output 2:
//
// 0
//
//
//Example Explanation
//Explanation 1:
//
// The given graph contain cycle 1 -> 3 -> 4 -> 1 or the cycle 1 -> 2 -> 4 -> 1
//Explanation 2:
//
// The given graph doesn't contain any cycle.


public class CycleDirectedGraph {
    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        boolean isVisited[] = new boolean[A + 1];
        boolean path[] = new boolean[A + 1];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i <= A; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < B.size(); i++) {
            int from = B.get(i).get(0);
            int to = B.get(i).get(1);
            adj.get(from).add(to);
        }
        System.out.println("Adj list" + adj);

        // Start DFS from node 1
        for (int i = 1; i <= A; i++) {
            if (!isVisited[i]) {
                if (dfs(i, adj, isVisited, path)) {
                    return 1;
                }
            }
        }

        return 0;
    }

    private boolean dfs(int currentNode, ArrayList<ArrayList<Integer>> adj, boolean[] isVisited, boolean[] path) {
        isVisited[currentNode] = true;
        path[currentNode] = true;

        for (int neighbor : adj.get(currentNode)) {
            if (!isVisited[neighbor]) {
                if (dfs(neighbor, adj, isVisited, path)) {
                    return true;
                }
            } else if (path[neighbor]) {
                return true;
            }
        }
        path[currentNode] = false; // Mark the current node as not on the current path
        return false;
    }

    public static void main(String[] args) {
        // Test cases
        CycleDirectedGraph cycleDirectedGraph = new CycleDirectedGraph();

        // Example 1
        int A1 = 5;
        ArrayList<ArrayList<Integer>> B1 = new ArrayList<>();
        B1.add(new ArrayList<>(Arrays.asList(1, 2)));
        B1.add(new ArrayList<>(Arrays.asList(4, 1)));
        B1.add(new ArrayList<>(Arrays.asList(2, 4)));
        B1.add(new ArrayList<>(Arrays.asList(3, 4)));
        B1.add(new ArrayList<>(Arrays.asList(5, 2)));
        B1.add(new ArrayList<>(Arrays.asList(1, 3)));
        // System.out.println("Example 1: " + cycleDirectedGraph.solve(A1, B1)); // Output: 1

        // Example 2
        int A2 = 5;
        ArrayList<ArrayList<Integer>> B2 = new ArrayList<>();
        B2.add(new ArrayList<>(Arrays.asList(1, 2)));
        B2.add(new ArrayList<>(Arrays.asList(2, 3)));
        B2.add(new ArrayList<>(Arrays.asList(3, 4)));
        B2.add(new ArrayList<>(Arrays.asList(4, 5)));
        // System.out.println("Example 2: " + cycleDirectedGraph.solve(A2, B2)); // Output: 0


        int A3 = 2;
        ArrayList<ArrayList<Integer>> B3 = new ArrayList<>();
        B2.add(new ArrayList<>(Arrays.asList(1, 2)));
        System.out.println("Example 3: " + cycleDirectedGraph.solve(A3, B3)); // Output: 0
    }
}
