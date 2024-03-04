package com.dsa.scaller.graph.striversheet;

import java.util.ArrayList;

//https://leetcode.com/problems/number-of-provinces/description/
public class NumberOfProvinces {
    static int numProvinces(ArrayList<ArrayList<Integer>> graph, int V){
        boolean visited[] = new boolean[V];
       ArrayList<ArrayList<Integer>> adjencyList = new ArrayList<>();
       for(int i=0;i<V;i++){
           adjencyList.add(new ArrayList<>());
       }

       for(int i=0;i<V;i++){
           for(int j=0;j<V;j++){
              // if( graph.get(i).get(j)==1 && i!=j) {
                   adjencyList.get(i).add(j);
                   adjencyList.get(j).add(i);
              // }
           }
       }
       int count =0;
       for(int i=0;i<V;i++){
           if(!visited[i]){
               count++;
               dfs(i,adjencyList,visited);
           }
       }
   return  count;
    }

    private static void dfs(int currentNode, ArrayList<ArrayList<Integer>> adjencyList, boolean[] visited) {
        visited[currentNode]=true;
        for(int neigbhour : adjencyList.get(currentNode)){
            if(!visited[neigbhour]){
                dfs(neigbhour,adjencyList,visited);
            }
        }
    }


    public static void main(String[] args) {

        // adjacency matrix
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

        adj.add(new ArrayList<Integer>());
        adj.get(0).add(0, 1);
        adj.get(0).add(1, 0);
        adj.get(0).add(2, 1);
        adj.add(new ArrayList<Integer>());
        adj.get(1).add(0, 0);
        adj.get(1).add(1, 1);
        adj.get(1).add(2, 0);
        adj.add(new ArrayList<Integer>());
        adj.get(2).add(0, 1);
        adj.get(2).add(1, 0);
        adj.get(2).add(2, 1);
        System.out.println(adj);
        System.out.println(numProvinces(adj,3));

    }
}
