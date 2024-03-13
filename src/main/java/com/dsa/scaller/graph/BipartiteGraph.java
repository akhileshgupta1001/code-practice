package com.dsa.scaller.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BipartiteGraph {
    public static void main(String[] args) {
        // V = 4, E = 4
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(1).add(3);
        adj.get(3).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);

        BipartiteGraph obj = new BipartiteGraph();
        boolean ans = obj.isBipartite(4, adj);
        if (ans)
            System.out.println("1");
        else System.out.println("0");
    }

    private boolean isBipartite(int vertex, ArrayList<ArrayList<Integer>> adj) {
        int[] colour = new int[vertex];
        Arrays.fill(colour, -1);
        for (int i = 0; i < vertex; i++) {
            if (!checkIsBipartiteUsingBFS(i, vertex, adj, colour)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkIsBipartiteUsingBFS(int start, int vertex, ArrayList<ArrayList<Integer>> adj, int[] colour) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        colour[start] = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int nbr : adj.get(current)) {
                if (colour[nbr] == -1) {
                    colour[nbr] = 1 - colour[current];
                    queue.add(nbr);
                } else if (colour[nbr] == colour[current]) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isBipartiteUsingDFS(int vertex, ArrayList<ArrayList<Integer>> adj) {
        int[] colour = new int[vertex];
        Arrays.fill(colour, -1);
        for (int i = 0; i < vertex; i++) {
            if (!isBipartiteUsingDFS(i,0,adj,colour)) {
                return false;
            }
        }
        return true;
    }

    private boolean isBipartiteUsingDFS(int source, int col, ArrayList<ArrayList<Integer>> adj, int[] colour) {
        colour[source] = col;
        for (int nbr : adj.get(source)) {
            if (colour[nbr] == -1) {
                if (isBipartiteUsingDFS(nbr, 1 - col, adj, colour)) {
                    return false;
                } else if (colour[nbr] == col) {
                    return false;
                }
            }
        }
        return true;
    }
}
