package com.dsa.scaller.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Problem Description
//There are A islands and there are M bridges connecting them. Each bridge has some cost attached to it.
//
//We need to find bridges with minimal cost such that all islands are connected.
//
//It is guaranteed that input data will contain at least one possible scenario in which all islands are connected with each other.
//
//
//
//Problem Constraints
//1 <= A, M <= 6*104
//
//1 <= B[i][0], B[i][1] <= A
//
//1 <= B[i][2] <= 103
//
//
//
//Input Format
//The first argument contains an integer, A, representing the number of islands.
//
//The second argument contains an 2-d integer matrix, B, of size M x 3 where Island B[i][0] and B[i][1] are connected using a bridge of cost B[i][2].
//
//
//
//Output Format
//Return an integer representing the minimal cost required.
//
//
//
//Example Input
//Input 1:
//
// A = 4
// B = [  [1, 2, 1]
//        [2, 3, 4]
//        [1, 4, 3]
//        [4, 3, 2]
//        [1, 3, 10]  ]
//Input 2:
//
// A = 4
// B = [  [1, 2, 1]
//        [2, 3, 2]
//        [3, 4, 4]
//        [1, 4, 3]   ]
//
//
//Example Output
//Output 1:
//
// 6
//Output 2:
//
// 6
//
//
//Example Explanation
//Explanation 1:
//
// We can choose bridges (1, 2, 1), (1, 4, 3) and (4, 3, 2), where the total cost incurred will be (1 + 3 + 2) = 6.
//Explanation 2:
//
// We can choose bridges (1, 2, 1), (2, 3, 2) and (1, 4, 3), where the total cost incurred will be (1 + 2 + 3) = 6.

public class CommutableIslands {
    public int solve(int A, int[][] B) {
        List<GraphEdge> edges = new ArrayList<>();
        for (int[] bridge : B) {
            int from = bridge[0];
            int to = bridge[1];
            int cost = bridge[2];
            edges.add(new GraphEdge(from, to, cost));
        }

        // Sort edges in ascending order of cost
        Collections.sort(edges);

        int[] parent = new int[A + 1];
        for (int i = 1; i <= A; i++) {
            parent[i] = i; // Initialize each island as its own parent
        }

        int minimalCost = 0;
        int edgesAdded = 0;

        for (GraphEdge edge : edges) {
            int fromParent = KruskalAlgo.findParent(edge.from, parent);
            int toParent = KruskalAlgo.findParent(edge.to, parent);

            if (fromParent != toParent) {
                minimalCost += edge.cost;
                KruskalAlgo.union(fromParent, toParent, parent); // Union operation
                edgesAdded++;
            }

            if (edgesAdded == A - 1) {
                break; // We've connected all islands
            }
        }

        return minimalCost;
    }

}
