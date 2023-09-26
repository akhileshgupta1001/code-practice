package com.dsa.scaller.graph;

import java.util.ArrayList;

public class PossibilityofFinishing {
    public int solve(int A, ArrayList<Integer> B, ArrayList<Integer> C) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= A; i++) {
            graph.add(new ArrayList<Integer>());
        }

        // Build the graph
        for (int i = 0; i < B.size(); i++) {
            int from = B.get(i);
            int to = C.get(i);
            graph.get(from).add(to);
        }

        boolean[] visited = new boolean[A + 1];
        boolean[] recStack = new boolean[A + 1];

        for (int i = 1; i <= A; i++) {
            if (!visited[i]) {
                if (isCyclicExistByDFS(graph, i, visited, recStack)) {
                    return 0; // Cycle detected, cannot finish all courses
                }
            }
        }

        return 1; // No cycle detected, it is possible to finish all courses
    }

    private boolean isCyclicExistByDFS(ArrayList<ArrayList<Integer>> graph, int node, boolean[] visited, boolean[] recStack) {
        visited[node] = true;
        recStack[node] = true;

        for (int neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                if (isCyclicExistByDFS(graph, neighbor, visited, recStack)) {
                    return true;
                }
            } else if (recStack[neighbor]) {
                return true; // Cycle detected
            }
        }

        recStack[node] = false;
        return false;
    }

}
