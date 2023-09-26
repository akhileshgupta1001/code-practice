package com.dsa.scaller.graph;

import java.util.*;

public class Batches {
    //A students applied for admission in IB Academy. An array of integers B is given representing the strengths of A people i.e. B[i] represents the strength of ith student.
    //
    //Among the A students some of them knew each other. A matrix C of size M x 2 is given which represents relations where ith relations depicts that C[i][0] and C[i][1] knew each other.
    //
    //All students who know each other are placed in one batch.
    //
    //Strength of a batch is equal to sum of the strength of all the students in it.
    //
    //Now the number of batches are formed are very much, it is impossible for IB to handle them. So IB set criteria for selection: All those batches having strength at least D are selected.
    //
    //Find the number of batches selected.
    //
    //NOTE: If student x and student y know each other, student y and z know each other then student x and student z will also know each other.
    //
    //
    //
    //Problem Constraints
    //
    //1 <= A <= 105
    //
    //1 <= M <= 2*105
    //
    //1 <= B[i] <= 104
    //
    //1 <= C[i][0], C[i][1] <= A
    //
    //1 <= D <= 109
    //
    //
    //
    //Input Format
    //
    //The first argument given is an integer A.
    //The second argument given is an integer array B.
    //The third argument given is a matrix C.
    //The fourth argument given is an integer D.
    //
    //
    //
    //Output Format
    //
    //Return the number of batches selected in IB.
    //
    //
    //
    //Example Input
    //
    //Input 1:
    //
    // A = 7
    // B = [1, 6, 7, 2, 9, 4, 5]
    // C = [  [1, 2]
    //        [2, 3]
    //       `[5, 6]
    //        [5, 7]  ]
    // D = 12
    //Input 2:
    //
    // A = 5
    // B = [1, 2, 3, 4, 5]
    // C = [  [1, 5]
    //        [2, 3]  ]
    // D = 6
    //
    //
    //Example Output
    //
    //Output 1:
    //
    // 2
    //Output 2:
    //
    // 1
    //
    //
    //Example Explanation
    //
    //Explanation 1:
    //
    // Initial Batches :
    //    Batch 1 = {1, 2, 3} Batch Strength = 1 + 6 + 7 = 14
    //    Batch 2 = {4} Batch Strength = 2
    //    Batch 3 = {5, 6, 7} Batch Strength = 9 + 4 + 5 = 18
    //    Selected Batches are Batch 1 and Batch 2.
    //Explanation 2:
    //
    // Initial Batches :
    //    Batch 1 = {1, 5} Batch Strength = 1 + 5  = 6
    //    Batch 2 = {2, 3} Batch Strength = 5
    //    Batch 3 = {4} Batch Strength = 4
    //    Selected Batch is only Batch 1.
    //
    //
    //Expected Output
    //Provide sample input and click run to see the correct output for the provided input. Use this to improve your problem understanding and test edge cases

    public int solve(int A, int[] B, int[][] C, int D) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= A; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < C.length; i++) {
            adj.get(C[i][0]).add(C[i][1]);
            adj.get(C[i][1]).add(C[i][0]);
        }

        boolean[] visited = new boolean[A + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;
        int batchSum = B[0];
        int countBatch = 0;

        while (!q.isEmpty()) {
            int front = q.poll();
            for (int curr : adj.get(front)) {
                if (!visited[curr]) {
                    visited[curr] = true;
                    batchSum += B[curr - 1];
                    q.add(curr);
                }
            }
            if (q.isEmpty()) {
                if (batchSum >= D) countBatch++;
                for (int i = 1; i <= A; i++) {
                    if (!visited[i]) {
                        q.add(i);
                        batchSum = B[i - 1];
                        visited[i] = true;
                        break;
                    }
                }
            }
        }
        return countBatch;
    }

    public static int solve2(int A, int[] B, int[][] C, int D) {

        int[] parent = new int[A + 1];
        for (int i = 1; i <= A; i++) {
            parent[i] = i;
        }

        // combine node x and y for each edge into a single batch
        for (int i = 0; i < C.length; i++) {
            int x = C[i][0];
            int y = C[i][1];
            union(x, y, parent);
        }

        // find the parent of each node. This is required to finally map the topmost parent for each node
        for (int i = 1; i <= A; i++) {
            parent[i] = findParent(i, parent);
        }

        // count strength for each parent
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= A; i++) {
            int strength = B[i - 1];
            if (!map.containsKey(parent[i])) {
                map.put(parent[i], strength);
            } else {
                map.put(parent[i], map.get(parent[i]) + strength);
            }
        }

        // consider all parents/components/batches whose strength is >= D
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= D) {
                count++;
            }
        }

        // Print intermediate results for debugging
        System.out.println("Parent Array:");
        for (int i = 1; i <= A; i++) {
            System.out.print(parent[i] + " ");
        }
        System.out.println();

        System.out.println("Strength Map:");
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println("Parent: " + entry.getKey() + " Strength: " + entry.getValue());
        }

        System.out.println("Selected Batches Count: " + count);

        return count;
    }



    // combine x and y of those are part of different connected components
    public static void union(int x, int y, int[] parent) {

        int parent_x = findParent(x, parent);
        int parent_y = findParent(y, parent);
        if (parent_x != parent_y) {
            // assign new parent for y. x and y will be combined into single connected
            // component
            parent[parent_x] = parent_y;
        }
    }

    // find top most parent of node x
    // Path comparison
    public static int findParent(int x, int[] parent) {
        if (x == parent[x]) {
            return x;
        }
        // this will override the existing parent of x
        parent[x] = findParent(parent[x], parent);
        return parent[x];
    }

    public static void main(String[] args) {
        int A1 = 7;
        int[] B1 = {1, 6, 7, 2, 9, 4, 5};
        int[][] C1 = {{1, 2}, {2, 3}, {5, 6}, {5, 7}};
        int D1 = 12;

        int result1 = solve2(A1, B1, C1, D1);
        System.out.println("Output 1:");
        System.out.println(result1);

        int A2 = 5;
        int[] B2 = {1, 2, 3, 4, 5};
        int[][] C2 = {{1, 5}, {2, 3}};
        int D2 = 6;

        int result2 = solve2(A2, B2, C2, D2);
        System.out.println("Output 2:");
        System.out.println(result2);
    }

}
class Solution {
    public int solve(int A, int[][] B) {
        return new Kruskal(A, B).find();
        //return new Prim(A, B).find();
    }
}

//T.C (ElogE + E) S.C(N+E)
class Kruskal {
    int[][] graph;
    DSU dsu;
    final int mod = 1000000007;

    public Kruskal(int n, int[][] graph) {
        this.graph = graph;

        //Sort the graph based on weights
        Arrays.sort(graph, Comparator.comparingInt(a -> a[2]));

        dsu = new DSU(n);
    }

    public int find() {
        int ans = 0;
        for (int[] ints : graph) {
            int u = ints[0],
                    v = ints[1],
                    w = ints[2];
            if (dsu.union(u, v)) ans = (ans + w)%mod;
        }
        return ans;
    }

    class DSU {
        private final int[] size;
        private final int[] parents;

        public DSU(int N) {
            this.size = new int[N+1];
            Arrays.fill(this.size, 1);

            this.parents = new int[N+1];
            for(int i = 0; i < this.parents.length; i++){
                this.parents[i] = i;
            }
        }

        public int getRoot(int x) {
            if(this.parents[x] == x) return  x;
            return this.parents[x] = getRoot(parents[x]);
        }

        public boolean union(int x, int y) {
            int rx = getRoot(x);
            int ry = getRoot(y);

            if (rx == ry) return false;

            if (this.size[rx] <= this.size[ry]) {
                this.parents[rx] = ry;
                this.size[ry] += this.size[rx];
            } else {
                this.parents[ry] = rx;
                this.size[rx] += this.size[ry];
            }

            return true;
        }
    }
}

//T.C (ElogE) S.C(N+E)
class Prim {
    ArrayList<Pair>[] graph;
    boolean[] visited;

    final int mod = 1000000007;

    public Prim(int n, int[][] graph) {
        this.graph = buildGraph(n, graph);
        this.visited = new boolean[n+1];
    }

    private ArrayList<Pair>[] buildGraph (int n, int[][] graph) {
        ArrayList<Pair>[] g = new ArrayList[n+1];
        for(int i = 0; i < g.length; i++) {
            g[i] = new ArrayList<>();
        }
        for(int[] i : graph){
            int u = i[0], v = i[1], w = i[2];
            g[u].add(new Pair(v, w));
            g[v].add(new Pair(u, w));
        }
        return g;
    }

    public int find() {
        int ans = 0;
        PriorityQueue<Pair> minHeap = new PriorityQueue<>();
        minHeap.offer(new Pair(1, 0));
        while (!minHeap.isEmpty()) {
            Pair x = minHeap.poll();
            if (this.visited[x.node]) continue;
            this.visited[x.node] = true;
            ans = (ans + x.weight)%mod;
            for(Pair nbr : this.graph[x.node]) {
                if(!this.visited[nbr.node]) {
                    minHeap.offer(nbr);
                }
            }
        }
        return ans;
    }

    class Pair implements Comparable<Pair>{
        int node;
        int weight;

        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Pair o) {
            return this.weight - o.weight;
        }
    }
}
