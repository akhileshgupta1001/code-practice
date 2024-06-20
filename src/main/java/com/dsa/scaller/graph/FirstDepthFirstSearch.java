package com.dsa.scaller.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FirstDepthFirstSearch {
    //Problem Description
    //You are given N towns (1 to N). All towns are connected via unique directed path as mentioned in the input.
    //
    //Given 2 towns find whether you can reach the first town from the second without repeating any edge.
    //
    //B C : query to find whether B is reachable from C.
    //
    //Input contains an integer array A of size N and 2 integers B and C ( 1 <= B, C <= N ).
    //
    //There exist a directed edge from A[i] to i+1 for every 1 <= i < N. Also, it's guaranteed that A[i] <= i for every 1 <= i < N.
    //
    //NOTE: Array A is 0-indexed. A[0] = 1 which you can ignore as it doesn't represent any edge.
    //
    //
    //
    //Problem Constraints
    //1 <= N <= 100000
    //
    //
    //
    //Input Format
    //First argument is vector A
    //
    //Second argument is integer B
    //
    //Third argument is integer C
    //
    //
    //
    //Output Format
    //Return 1 if reachable, 0 otherwise.
    //
    //
    //
    //Example Input
    //Input 1:
    //
    // A = [1, 1, 2]
    // B = 1
    // C = 2
    //Input 2:
    //
    // A = [1, 1, 2]
    // B = 2
    // C = 1
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
    // Tree is 1--> 2--> 3 and hence 1 is not reachable from 2.
    //Explanation 2:
    //
    // Tree is 1--> 2--> 3 and hence 2 is reachable from 1.
    //
    //
    //
    //
    //Expected Output
    //Provide sample input and click run to see the correct output for the provided input. Use this to improve your problem understanding and test edge cases


    public int solve(ArrayList<Integer> A, final int B, final int C) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int n = A.size();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < n; i++) {
            graph.get(A.get(i)).add(i + 1);
        }

        boolean[] visited = new boolean[n + 1];

        if (dfs(graph, C, B, visited)) {
            return 1;
        }

        return 0;
    }

    private boolean dfs(ArrayList<ArrayList<Integer>> graph, int source, int target, boolean[] visited) {
        if (source == target) {
            return true; // Found a path to the target town
        }

        visited[source] = true;

        for (int neighbor : graph.get(source)) {
            if (!visited[neighbor]) { // If the neighbor is not visited
                if (dfs(graph, neighbor, target, visited)) {
                    return true; // Found a path to the target town
                }
            }
        }

        return false; // No path found to the target town
    }

    public int solve2(ArrayList<Integer> A, final int B, final int C) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int n = A.size();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < n; i++) {
            graph.get(A.get(i)).add(i + 1);
        }

        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(B);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == C) {
                return 1; // Found a path to the target town
            }

            visited[current] = true;

            for (int neighbor : graph.get(current)) {
                if (!visited[neighbor]) {
                    queue.offer(neighbor);
                }
            }
        }

        return 0; // No path found to the target town
    }

    public static void main(String[] args) {

    }
}
