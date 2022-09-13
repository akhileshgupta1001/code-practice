package com.dsa.geeksforgeek.graph;

import java.util.Iterator;
import java.util.LinkedList;


//Time complexity: O(V + E), where V is the number of vertices and E is the number of edges in the graph.
//Space Complexity: O(V), since an extra visited array of size V is required.
public class DFS {
    private int vertex;
    private LinkedList<Integer> adjacency[];

   public DFS(int vertex){
        this.vertex=vertex;
        adjacency = new LinkedList[vertex];
        for(int i=0;i<vertex;i++){
            adjacency[i]=new LinkedList<>();
        }
    }

    // Function to add an edge into the graph
    void addEdge(int v, int w)
    {
        adjacency[v].add(w); // Add w to v's list.
    }

    // A function used by DFS
    void DFSUtil(int v, boolean visited[])
    {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");

        // Recur for all the vertices adjacent to this
        // vertex
        Iterator<Integer> i = adjacency[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    // The function to do DFS traversal.
    // It uses recursive
    // DFSUtil()
    void DFS(int v)
    {
        // Mark all the vertices as
        // not visited(set as false by default in java)
        boolean visited[] = new boolean[this.vertex];

        // Call the recursive helper
        // function to print DFS
        // traversal
        DFSUtil(v, visited);
    }
    // Driver Code
    public static void main(String args[])
    {
        DFS g = new DFS(4);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);

        System.out.println(
                "Following is Depth First Traversal "
                        + "(starting from vertex 2)");

        g.DFS(0);
    }
}
