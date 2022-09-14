package com.dsa.geeksforgeek.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// shortest path of undirected graph
//https://ide.geeksforgeeks.org/zJmXP8OpXg
//https://www.geeksforgeeks.org/shortest-path-unweighted-graph/
public class ShortestPath {
    static void addEdge(ArrayList<ArrayList<Integer>> adj, int u, int v)
    {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }

    public static void shortestPathUnidrectedGraph(ArrayList<ArrayList<Integer> > adj,int vertex,int source,int[] distance){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[vertex];
        Arrays.fill(isVisited,false);
        isVisited[0]=true;
        queue.add(source);
        while (!queue.isEmpty()){
            int u =queue.poll();
            for(int v : adj.get(u)){
                if(isVisited[v]==false){
                    isVisited[v]= true;
                    distance[v]= distance[u]+1;
                    queue.add(v);
                }
            }
        }
    }
    public static void main(String[] args) {
        int V = 4;
        ArrayList<ArrayList<Integer> > adj = new ArrayList<ArrayList<Integer>>(V);

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<Integer>());

        addEdge(adj,0,1);
        addEdge(adj,1,2);
        addEdge(adj,2,3);
        addEdge(adj,0,2);
        addEdge(adj,1,3);

        int[] dist=new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;
        shortestPathUnidrectedGraph(adj,V,0,dist);

        for(int i=0;i<V;i++){
            System.out.print(dist[i]+" ");
        }
    }
}

