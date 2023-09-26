package com.dsa.scaller.graph;
import java.util.*;

class GraphEdge implements Comparable<GraphEdge> {
    int from;
    int to;
    int cost;

    public GraphEdge(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(GraphEdge other) {
        return Integer.compare(this.cost, other.cost);
    }
}

public class KruskalAlgo {
    public int solve(int A, int[][] B) {
        List<GraphEdge> edges = new ArrayList<>();
        for (int[] bridge : B) {
            int from = bridge[0];
            int to = bridge[1];
            int cost = bridge[2];
            edges.add(new GraphEdge(from, to, cost));
        }

        // Sort edges in ascending order of cost
        Collections.sort(edges);

        int[] parent = new int[A + 1];
        for (int i = 1; i <= A; i++) {
            parent[i] = i; // Initialize each island as its own parent
        }

        int minimalCost = 0;
        int edgesAdded = 0;

        for (GraphEdge edge : edges) {
            int fromParent = findParent(edge.from, parent);
            int toParent = findParent(edge.to, parent);
            int mod = (int) 1e9+7;
            if (fromParent != toParent) {
                minimalCost = (minimalCost + edge.cost) % mod; // Apply modulo operation here
                union(fromParent, toParent, parent); // Union operation
                edgesAdded++;
            }

            if (edgesAdded == A - 1) {
                break; // We've connected all islands
            }
        }

        return minimalCost;
    }

    public static void union(int x, int y, int[] parent) {
        int parent_x = findParent(x, parent);
        int parent_y = findParent(y, parent);
        if (parent_x != parent_y) {
            // assign new parent for y. x and y will be combined into single connected component
            parent[parent_x] = parent_y;
        }
    }

    // Find the topmost parent of node x (with path compression)
    public static int findParent(int x, int[] parent) {
        if (x == parent[x]) {
            return x;
        }
        // Path compression: Make each node point directly to the root
        parent[x] = findParent(parent[x], parent);
        return parent[x];
    }

    public static void main(String[] args) {
        int A1 = 4;
        int[][] B1 = { { 1, 2, 1 }, { 2, 3, 4 }, { 1, 4, 3 }, { 4, 3, 2 }, { 1, 3, 10 } };

        int A2 = 4;
        int[][] B2 = { { 1, 2, 1 }, { 2, 3, 2 }, { 3, 4, 4 }, { 1, 4, 3 } };

        KruskalAlgo solution = new KruskalAlgo();
        System.out.println(solution.solve(A1, B1)); // Output: 6
        System.out.println(solution.solve(A2, B2)); // Output: 6
    }
}


