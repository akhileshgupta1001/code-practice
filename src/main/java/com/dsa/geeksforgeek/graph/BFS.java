package com.dsa.geeksforgeek.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

public class BFS {

    public static void  BFS(ArrayList<Integer> adjacency, int vertex,int source){
        boolean visited[] = new boolean[vertex+1];
        Queue<Integer> queue = new LinkedList<>();
        visited[source]=true;
        queue.add(source);
        while (!queue.isEmpty()){
            // front node
            int u = queue.poll();
            System.out.print(u+" ");
            ListIterator<Integer> data = adjacency.listIterator(u);
            while(data.hasNext()){
                int v = data.next();
                // not visited yet
                if(visited[v]==false){
                    visited[v]=true;
                    queue.add(v);
                }
            }
        }

    }
}
