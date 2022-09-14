package com.dsa.geeksforgeek.graph;

import java.util.ArrayList;

public class Graph {

    //https://www.geeksforgeeks.org/graph-and-its-representations/
    public static void addEdge(ArrayList<ArrayList<Integer>> adjacencyList,int u, int vertex){

        adjacencyList.get(u).add(vertex);
        adjacencyList.get(vertex).add(u);
    }

    public static void print(ArrayList<ArrayList<Integer>> adjacencyList){
        for(int i=0;i<adjacencyList.size();i++){
            for(int j=0;j<adjacencyList.get(i).size();j++){
                System.out.print(adjacencyList.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int vertex =5;
        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>(vertex);
        for (int i=0;i<vertex;i++){
            adjacencyList.add(new ArrayList<Integer>());
        }
        addEdge(adjacencyList, 0, 1);
        addEdge(adjacencyList, 0, 4);
        addEdge(adjacencyList, 1, 2);
        addEdge(adjacencyList, 1, 3);
        addEdge(adjacencyList, 1, 4);
        addEdge(adjacencyList, 2, 3);
        addEdge(adjacencyList, 3, 4);
      // print(adjacencyList);
        BFS.BFS(adjacencyList,vertex,0);

    }
}
