import java.util.*;

/**
 * Class representing a graph with various operations.
 * @param <T> The type of data stored in the vertices.
 */
public class Graph<T> {
    // Adjacency list to store vertices and their corresponding edges
    Map<Vertex<T>, List<Edge<T>>> adjacencyList;

    // Constructor initializing the adjacency list
    public Graph() {
        adjacencyList = new HashMap<>();
    }

    // Method to add a vertex to the graph
    public void addVertex(Vertex<T> vertex) {
        adjacencyList.putIfAbsent(vertex, new ArrayList<>());
    }

    /**
     * Method to add an edge between two vertices.
     * @param source The source vertex.
     * @param destination The destination vertex.
     * @param weight The weight of the edge.
     */
    public void addEdge(Vertex<T> source, Vertex<T> destination, double weight) {
        // Add vertices if they don't exist in the adjacency list
        if (!adjacencyList.containsKey(source))
            addVertex(source);
        if (!adjacencyList.containsKey(destination))
            addVertex(destination);
        // Add the edge to the source vertex's list of edges
        adjacencyList.get(source).add(new Edge<>(source, destination, weight));
    }

    /**
     * Method for Breadth-First Search (BFS).
     * @param s The starting vertex for BFS.
     * @return List of edges visited during BFS.
     */
    public List<Edge<T>> bfs(Vertex<T> s) {
        List<Edge<T>> result = new ArrayList<>();
        Queue<Vertex<T>> queue = new LinkedList<>();
        Set<Vertex<T>> visited = new HashSet<>();

        // Start BFS from vertex s
        queue.add(s);
        visited.add(s);

        while (!queue.isEmpty()) {
            Vertex<T> v = queue.poll();
            // Visit each adjacent vertex
            for (Edge<T> edge : adjacencyList.getOrDefault(v, Collections.emptyList())) {
                Vertex<T> w = edge.destination;
                // If the vertex has not been visited, add it to the queue
                if (!visited.contains(w)) {
                    result.add(edge);
                    queue.add(w);
                    visited.add(w);
                }
            }
        }
        //return result
        return result;
    }

    /**
     * Method for Depth-First Search (DFS).
     * @param s The starting vertex for DFS.
     * @return List of edges visited during DFS.
     */
    public List<Edge<T>> dfs(Vertex<T> s) {
        List<Edge<T>> result = new ArrayList<>();
        Stack<Vertex<T>> stack = new Stack<>();
        Set<Vertex<T>> visited = new HashSet<>();

        // Start DFS from vertex s
        stack.push(s);
        visited.add(s);

        while (!stack.isEmpty()) {
            Vertex<T> v = stack.pop();
            // Visit each adjacent vertex
            for (Edge<T> edge : adjacencyList.getOrDefault(v, Collections.emptyList())) {
                Vertex<T> w = edge.destination;
                // If the vertex has not been visited, add it to the stack
                if (!visited.contains(w)) {
                    stack.push(w);
                    visited.add(w);
                    result.add(edge);
                }
            }
        }
        //return result
        return result;
    }

    /**
     * Method for Dijkstra's algorithm to find the shortest path.
     * @param s The source vertex for Dijkstra's algorithm.
     * @return Map containing distances from the source vertex to other vertices.
     */
    public Map<Vertex<T>, Double> dijkstra(Vertex<T> s) {
        Map<Vertex<T>, Double> distances = new HashMap<>();
        PriorityQueue<Vertex<T>> pq = new PriorityQueue<>(Comparator.comparingDouble(distances::get));

        // Initialize distances to all vertices as infinity
        for (Vertex<T> v : adjacencyList.keySet()) {
            distances.put(v, Double.POSITIVE_INFINITY);
        }
        // Distance from source to itself is 0
        distances.put(s, 0.0);
        pq.add(s);

        while (!pq.isEmpty()) {
            Vertex<T> u = pq.poll();
            //Update distances for edges leaving vertex u
            for (Edge<T> edge : adjacencyList.getOrDefault(u, Collections.emptyList())) {
                Vertex<T> v = edge.destination;
                double newDistance = distances.get(u) + edge.weight;
                if (newDistance < distances.get(v)) {
                    distances.put(v, newDistance);
                    pq.add(v);
                }
            }
        }
        //return distances
        return distances;
    }

    /**
     * Method to find a path between two vertices using Dijkstra's algorithm.
     * @param u The source vertex.
     * @param v The destination vertex.
     * @return List of edges representing the path between u and v.
     */
    public List<Edge<T>> findPath(Vertex<T> u, Vertex<T> v) {
        Map<Vertex<T>, Vertex<T>> predecessors = new HashMap<>();
        Map<Vertex<T>, Double> distances = new HashMap<>();
        PriorityQueue<Vertex<T>> pq = new PriorityQueue<>(Comparator.comparingDouble(distances::get));

        // Initialize distances to all vertices as infinity
        for (Vertex<T> vertex : adjacencyList.keySet()) {
            distances.put(vertex, Double.POSITIVE_INFINITY);
        }
        // Distance from source to itself is 0
        distances.put(u, 0.0);
        pq.add(u);

        // Run Dijkstra's algorithm
        while (!pq.isEmpty()) {
            Vertex<T> current = pq.poll();
            // Update edges outgoing from the current vertex
            for (Edge<T> edge : adjacencyList.getOrDefault(current, Collections.emptyList())) {
                Vertex<T> neighbor = edge.destination;
                double newDistance = distances.get(current) + edge.weight;
                if (newDistance < distances.get(neighbor)) {
                    distances.put(neighbor, newDistance);
                    predecessors.put(neighbor, current);
                    pq.add(neighbor);
                }
            }
        }

        // Reconstruct the path from the predecessors map
        List<Edge<T>> path = new ArrayList<>();
        Vertex<T> current = v;
        while (predecessors.containsKey(current)) {
            Vertex<T> predecessor = predecessors.get(current);
            for (Edge<T> edge : adjacencyList.getOrDefault(predecessor, Collections.emptyList())) {
                if (edge.destination.equals(current)) {
                    path.add(edge);
                    break;
                }
            }
            current = predecessor;
        }
        // Reverse the path to get the correct order
        Collections.reverse(path);
        return path;
    }
}
