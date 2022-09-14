package com.dsa.geeksforgeek.graph;

import java.util.ArrayList;

import static com.dsa.geeksforgeek.graph.Graph.addEdge;

public class Cycle {


    public static boolean isCycleExsist(ArrayList<ArrayList<Integer>> adj,int source,int parent,boolean[] isVisted) {
        isVisted[source]= true;

        for(int u: adj.get(source)){
             if(isVisted[u]== false){
                 if(isCycleExsist(adj,u,source,isVisted)) return true;
                 else if( u != parent) return true;
             }
        }
       return false;
    }

    // find cycle in undirected graph
    //https://ide.geeksforgeeks.org/dXvbF50WSL
    //https://www.geeksforgeeks.org/detect-cycle-undirected-graph/
    public static boolean isCycleExsistByDFS(ArrayList<ArrayList<Integer>> adj,int vertex) {
        boolean[] visited = new boolean[vertex];
        for(int i=0;i<vertex;i++){
            if(visited[i]==false)
                if(isCycleExsist(adj,i,-1,visited)) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(V);

        for (int i = 0; i < V; i++)
            adj.add(new ArrayList<Integer>());

        addEdge(adj,0,1);
        addEdge(adj,1,2);
        addEdge(adj,2,4);
        addEdge(adj,4,5);
        addEdge(adj,1,3);
        addEdge(adj,2,3);

        if(isCycleExsistByDFS(adj,V)==true)
            System.out.println("Cycle found");
        else
            System.out.println("No cycle found");
    }
}
