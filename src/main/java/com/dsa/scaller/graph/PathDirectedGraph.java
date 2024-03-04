package com.dsa.scaller.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PathDirectedGraph {
    //Problem Description
    //Given an directed graph having A nodes labelled from 1 to A containing M edges given by matrix B of size M x 2such that there is a edge directed from node
    //
    //B[i][0] to node B[i][1].
    //
    //Find whether a path exists from node 1 to node A.
    //
    //Return 1 if path exists else return 0.
    //
    //NOTE:
    //
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
    //Return 1 if path exists between node 1 to node A else return 0.
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
    // 0
    //Output 2:
    //
    // 1
    //
    //
    //Example Explanation
    //Explanation 1:
    //
    // The given doens't contain any path from node 1 to node 5 so we will return 0.
    //Explanation 2:
    //
    // Path from node1 to node 5 is ( 1 -> 2 -> 3 -> 4 -> 5 ) so we will return 1.

    public int solve(int A, ArrayList<ArrayList<Integer>> B) {
        boolean[] isVisited = new boolean[A + 1];
        ArrayList<Integer>[] graph = new ArrayList[A + 1];

        for (int i = 1; i <= A; i++) {
            graph[i] = new ArrayList<>();
        }

        for (ArrayList<Integer> edge : B) {
            int from = edge.get(0);
            int to = edge.get(1);
            graph[from].add(to);
        }

       for( ArrayList<Integer> data : graph){
           System.out.println("Data : "+ data);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1); // Start from node 1
        isVisited[1] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (current == A) {
                return 1; // Path exists from node 1 to node A
            }
            for (int neighbor : graph[current]) {
                if (!isVisited[neighbor]) {
                    queue.add(neighbor);
                    isVisited[neighbor] = true;
                }
            }
        }

        return 0; // No path exists from node 1 to node A
    }

    public int solveUsingDFS(int A, ArrayList<ArrayList<Integer>> B) {
        // Create an adjacency list to represent the graph
        ArrayList<Integer>[] graph = new ArrayList[A + 1];
        for (int i = 1; i <= A; i++) {
            graph[i] = new ArrayList<>();
        }

        // Populate the adjacency list with edges
        for (ArrayList<Integer> edge : B) {
            int from = edge.get(0);
            int to = edge.get(1);
            graph[from].add(to);
        }

        // Create an array to keep track of visited nodes
        boolean[] visited = new boolean[A + 1];

        // Start DFS from node 1
        if (dfs(1, A, graph, visited)) {
            return 1; // Path exists from node 1 to node A
        }

        return 0; // No path exists from node 1 to node A
    }

    private boolean dfs(int current, int destination, ArrayList<Integer>[] graph, boolean[] visited) {
        if (current == destination) {
            return true;
        }

        visited[current] = true;

        for (int neighbor : graph[current]) {
            if (!visited[neighbor] && dfs(neighbor, destination, graph, visited)) {
                return true;
            }
        }

        return false;
    }

    public boolean dfs(ArrayList<Integer>[] graph,int node, boolean[] isVisited, int target){
        isVisited[node] = true;
        if(node==target){
            return true;
        }
        for(int neignhour : graph[node]){
            if(!isVisited[neignhour] && dfs(graph,neignhour,isVisited,target)){
                return true;
            }
        }
        return false;
    }
    public int solve2(int A, ArrayList<ArrayList<Integer>> B) {
        boolean[] isVisited = new boolean[A + 1];
        ArrayList<Integer>[] graph = new ArrayList[A + 1];

        for (int i = 1; i <= A; i++) {
            graph[i] = new ArrayList<>();
        }

        for (ArrayList<Integer> edge : B) {
            int from = edge.get(0);
            int to = edge.get(1);
            graph[from].add(to);
        }

        if(dfs(graph,1,isVisited,A)){
            return 1;
        }


        return 0; // No path exists from node 1 to node A
    }

    public static void main(String[] args) {
        PathDirectedGraph graphSolver = new PathDirectedGraph();

        // Example 1
        int A1 = 5;
        ArrayList<ArrayList<Integer>> B1 = new ArrayList<>();
        B1.add(new ArrayList<>(Arrays.asList(1, 2)));
        B1.add(new ArrayList<>(Arrays.asList(4, 1)));
        B1.add(new ArrayList<>(Arrays.asList(2, 4)));
        B1.add(new ArrayList<>(Arrays.asList(3, 4)));
        B1.add(new ArrayList<>(Arrays.asList(5, 2)));
        B1.add(new ArrayList<>(Arrays.asList(1, 3)));
        int result1 = graphSolver.solve(A1, B1);
        System.out.println("Result 1: " + result1); // Expected output: 0

        // Example 2
        int A2 = 5;
        ArrayList<ArrayList<Integer>> B2 = new ArrayList<>();
        B2.add(new ArrayList<>(Arrays.asList(1, 2)));
        B2.add(new ArrayList<>(Arrays.asList(2, 3)));
        B2.add(new ArrayList<>(Arrays.asList(3, 4)));
        B2.add(new ArrayList<>(Arrays.asList(4, 5)));
        int result2 = graphSolver.solve(A2, B2);
        System.out.println("Result 2: " + result2); // Expected output: 1
    }
}