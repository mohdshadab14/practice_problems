package greedy;
import java.util.*;

// Class to represent an edge in the graph
class Edge implements Comparable<Edge>{
    int source;
    int dest;
    int weight;

    // Constructor to initialize an edge
    Edge(int source, int dest, int weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge other) {
        return this.weight-other.weight;
    }
}

// Class to represent the graph
class Graph {
    int vertices;
    LinkedList<Edge>[] adjacencyList;

    // Constructor to initialize the graph with the given number of vertices
    Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    // Method to add an edge to the graph
    void addEdge(int source, int dest, int weight) {
        Edge edge = new Edge(source, dest, weight);
        adjacencyList[source].add(edge);
        // Adding the reverse edge since it's an undirected graph
        adjacencyList[dest].add(new Edge(dest, source, weight));
    }

    // Method to implement Prim's algorithm to find the MST
    void getMST() {
        boolean[] inMST = new boolean[vertices]; // Array to track vertices included in MST
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        List<Edge> mst = new ArrayList<>(); // List to store the MST edges

        int startVertex = 0; // Start from any vertex (here it's 0)
        inMST[startVertex] = true;

        for (Edge edge : adjacencyList[startVertex]) {
            priorityQueue.add(edge); // Add all edges from the start vertex to the priority queue
        }

        while (!priorityQueue.isEmpty()) {
            Edge currentEdge = priorityQueue.poll();
            if (!inMST[currentEdge.dest]) {
                mst.add(currentEdge); // Add the edge to the MST
                inMST[currentEdge.dest] = true;
                for (Edge edge : adjacencyList[currentEdge.dest]) {
                    if (!inMST[edge.dest]) {
                        priorityQueue.add(edge);
                    }
                }
            }
        }

        // Print the edges in the MST
        System.out.println("Minimum Spanning Tree:");
        for (Edge edge : mst) {
            System.out.println("Edge: " + edge.source + " - " + edge.dest + " Weight: " + edge.weight);
        }
    }
}

// Main class to test the Prim's algorithm implementation
public class PrimsMST {
    public static void main(String[] args) {
        Graph graph = new Graph(4); // Create a graph with 4 vertices
        graph.addEdge(0, 1, 1);
        graph.addEdge(1, 2, 2);
        graph.addEdge(2, 3, 3);
        graph.addEdge(0, 3, 4);

        graph.getMST(); // Find and print the MST using Prim's algorithm
    }
}