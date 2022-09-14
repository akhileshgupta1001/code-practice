package com.dsa.geeksforgeek.graph;

import java.util.*;

public class BFS {

    public static void  BFS(ArrayList<ArrayList<Integer> >adjacency, int vertex,int source){
        boolean visited[] = new boolean[vertex+1];
        Arrays.fill(visited,false);
        Queue<Integer> queue = new LinkedList<>();
        visited[source]=true;
        queue.add(source);
        while (!queue.isEmpty()){
            // front node
            int u = queue.poll();
            System.out.print(u+" ");
            for(int v : adjacency.get(u)){
                // not visited yet
                if(visited[v]==false){
                    visited[v]=true;
                    queue.add(v);
                }
            }
        }

    }
}
