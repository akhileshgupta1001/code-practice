package com.dsa.scaller.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class TopologicalSort {

    public ArrayList<Integer> solve(int A, ArrayList<ArrayList<Integer>> B) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int n = A;
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for (ArrayList<Integer> edge : B) {
            int from = edge.get(0);
            int to = edge.get(1);
            graph.get(from).add(to);
        }

        int[] inDegree = inDegree(graph, A, n);
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        ArrayList<Integer> ans = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            int current = queue.poll();
            ans.add(current);

            for (int edge : graph.get(current)) {
                inDegree[edge]--;
                if (inDegree[edge] == 0) {
                    queue.add(edge);
                }
            }
        }
        if (ans.size() != A) return new ArrayList<Integer>();
        return ans;
    }

    int[] inDegree(ArrayList<ArrayList<Integer>> graph, int A, int n) {
        int[] inDegree = new int[n + 1];
        for (int i = 1; i <= A; i++) {
            for (int edge : graph.get(i)) {
                inDegree[edge]++;
            }
        }
        return inDegree;
    }
}
