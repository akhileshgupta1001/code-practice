import java.util.*;

/**
 * Aman's Delivery Optimization Program.
 * Helps Aman find the best path to deliver orders in the shortest time.
 */
public class DeliveryOptimization {

    /**
     * Main method to run the delivery optimization.
     * @param args Command-line arguments (not used)
     */
    public static void main(String[] args) {
        // Assuming geo-locations: Koramangala, R1, R2, C1, C2
        int numberOfLocations = 5;
        int koramangala = 0, r1 = 1, r2 = 2, c1 = 3, c2 = 4;

        // Prepare the adjacency list representing the graph
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < numberOfLocations; i++) {
            adj.add(new ArrayList<>());
        }

        // Define the travel times between locations
        // Assuming average speeds, distances, and preparation times
        // These values can be replaced with actual data
        int travelTimeKoramangalaToR1 = 10; // in minutes
        int travelTimeKoramangalaToR2 = 15; // in minutes
        int travelTimeR1ToC1 = 5; // in minutes
        int travelTimeR2ToC2 = 8; // in minutes

        // Add edges and weights for each location
        adj.get(koramangala).add(new Edge(r1, travelTimeKoramangalaToR1));
        adj.get(koramangala).add(new Edge(r2, travelTimeKoramangalaToR2));
        adj.get(r1).add(new Edge(c1, travelTimeR1ToC1));
        adj.get(r2).add(new Edge(c2, travelTimeR2ToC2));

        // Aman starts from Koramangala
        int startLocation = koramangala;

        // Run Dijkstra's algorithm to find the shortest paths
        int[] shortestDistances = Dijkstra.shortestDistances(numberOfLocations, adj, startLocation);

        // Display the shortest distances from the starting location
        System.out.println("Shortest distances from Koramangala:");
        for (int i = 0; i < numberOfLocations; i++) {
            System.out.println("To Location " + i + ": " + (shortestDistances[i] == Integer.MAX_VALUE ? "INF" : shortestDistances[i]) + " minutes");
        }
    }

    /**
     * Represents an edge with a destination and weight.
     */
    static class Edge {
        int destination;
        int weight;

        /**
         * Constructs an Edge object.
         * @param destination The destination location
         * @param weight The weight (travel time) associated with the edge
         */
        public Edge(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    /**
     * Class to handle Dijkstra's algorithm for finding shortest paths.
     */
    static class Dijkstra {
        /**
         * Finds the shortest distances from a starting location using Dijkstra's algorithm.
         * @param V Number of vertices (locations)
         * @param adj Adjacency list representing the graph
         * @param S Starting location
         * @return Array of shortest distances from the starting location
         */
        static int[] shortestDistances(int V, ArrayList<ArrayList<Edge>> adj, int S) {
            PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.distance - y.distance);
            int[] dist = new int[V];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[S] = 0;
            pq.add(new Pair(0, S));

            while (!pq.isEmpty()) {
                int dis = pq.peek().distance;
                int node = pq.peek().node;
                pq.remove();

                for (Edge edge : adj.get(node)) {
                    int adjNode = edge.destination;
                    int edgeWeight = edge.weight;

                    if (dis + edgeWeight < dist[adjNode]) {
                        dist[adjNode] = dis + edgeWeight;
                        pq.add(new Pair(dist[adjNode], adjNode));
                    }
                }
            }

            return dist;
        }
    }

    /**
     * Represents a pair of distance and node.
     */
    static class Pair {
        int distance;
        int node;

        /**
         * Constructs a Pair object.
         * @param distance The distance from the starting location
         * @param node The node (location)
         */
        public Pair(int distance, int node) {
            this.distance = distance;
            this.node = node;
        }
    }
}
