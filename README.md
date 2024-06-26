# Graph Library

This is a Java graph library that provides functionality for working with graphs, including operations such as inserting edges and vertices, performing depth-first search (DFS), breadth-first search (BFS), Dijkstra's algorithm for finding the shortest paths, and finding paths between vertices.

## Features

- Insert Edge: Add an edge between two vertices to the graph.
- Insert Vertex: Add a new vertex to the graph.
- DFS (Depth-First Search): Traverse the graph in a depth-first manner.
- BFS (Breadth-First Search): Traverse the graph in a breadth-first manner.
- Dijkstra's Algorithm: Find the shortest paths from a given source vertex to all other vertices in the graph.
- Find Path between u-v: Find a path between two specified vertices in the graph.

## Usage

To use this graph library, follow these steps:

1. Import the `Graph` class into your Java project.
2. Create a new instance of the `Graph` class.
3. Use the provided methods to perform various graph operations.

Here's an example of how to use the graph library:

```java
public class Main {
    public static void main(String[] args) {
        // Create a new graph
        Graph<Integer> graph = new Graph<>();

        // Create vertices
        Vertex<Integer> vertex1 = new Vertex<>(1);
        Vertex<Integer> vertex2 = new Vertex<>(2);
        Vertex<Integer> vertex3 = new Vertex<>(3);
        Vertex<Integer> vertex4 = new Vertex<>(4);
        Vertex<Integer> vertex5 = new Vertex<>(5);

        // Add edges to the graph
        graph.addEdge(vertex1, vertex2, 5);
        graph.addEdge(vertex1, vertex3, 10);
        graph.addEdge(vertex2, vertex4, 2);
        graph.addEdge(vertex3, vertex5, 7);

        // Perform graph operations (DFS, BFS, Dijkstra, etc.)
        // Insert test cases here

        // Print results
        // Print test results here
    }
}
