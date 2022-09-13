package com.dsa.geeksforgeek.graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class MinimumDisatnceFromSourceToDestination {
    private static boolean bfs(ArrayList<ArrayList<Integer>> adj,
                               int source,int des, int vertex,
                               int[] predecessor,int[] distance,boolean visited[]){
        LinkedList<Integer> queue= new LinkedList<>();
       // boolean visited[] = new boolean[vertex];
        for(int i=0;i<vertex;i++){
         //   visited[i]=false;
            distance[i]=Integer.MAX_VALUE;
            predecessor[i]=-1;
        }

        visited[source]= true;
        distance[source]=0;
        queue.add(source);

        while (!queue.isEmpty()){
            int current = queue.remove();
            for(int i=0;i<adj.get(vertex).size();i++){
                int neighbour= adj.get(vertex).get(i);
                if(visited[i]==false){
                    visited[i]=true;
                    distance[neighbour] = distance[current]+1;
                    predecessor[neighbour]=current;
                    queue.add(neighbour);
                    if(neighbour==des)
                        return true;

                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int v= 6;
        int edge = 8;
        int pre[] = new int[v+1];
        int distance[] = new int[v+1];
        int component=0;
        boolean isVisited[] = new boolean[v+1];
        for(int i=1;i<v;i++){
            if(!isVisited[i]){
                component++;
                boolean isReached = bfs(adj,1,6,v,pre,distance,isVisited);

            }
        }

        System.out.println("Component : "+component);

    }
}
