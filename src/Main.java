import java.util.Map;
import java.util.List;

/**
 * Aman Siid
 * Graph Library
 * 3/17/2024
 */
public class Main {

    // Test method to demonstrate the functionalities of the graph
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

        // Perform BFS starting from vertex v1
        System.out.println("BFS traversal from vertex vertex1: ");
        List<Edge<Integer>> bfsTraversal = graph.bfs(vertex1);
        for (Edge<Integer> edge : bfsTraversal) {
            System.out.println(edge);
        }

        // Perform DFS starting from vertex v1
        System.out.println("\nDFS traversal from vertex vertex1: ");
        List<Edge<Integer>> dfsTraversal = graph.dfs(vertex1);
        for (Edge<Integer> edge : dfsTraversal) {
            System.out.println(edge);
        }

        // Find the shortest paths from vertex vertex1 to all other vertices using Dijkstra's
        // algorithm
        System.out.println("\nShortest paths from vertex vertex1 using Dijkstra's algorithm:");
        Map<Vertex<Integer>, Double> distances = graph.dijkstra(vertex1);
        for (Map.Entry<Vertex<Integer>, Double> entry : distances.entrySet()) {
            System.out.println("Distance from vertex 1 to " + entry.getKey().label + ": " + entry.getValue());
        }

        // Find the path between vertices vertex1 and vertex4
        System.out.println("\nPath between vertex1 and vertex4: ");
        List<Edge<Integer>> path = graph.findPath(vertex1, vertex4);
        for (Edge<Integer> edge : path) {
            System.out.println(edge);
        }
    }
}
