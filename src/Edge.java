/**
 * Class representing an edge in the graph.
 *
 * @param <T> The type of data stored in the edges.
 */
class Edge<T> {
    Vertex<T> source;
    Vertex<T> destination;
    double weight;

    /**
     * Constructor to initialize the edge with source, destination, and weight.
     *
     * @param source      The source vertex of the edge.
     * @param destination The destination vertex of the edge.
     * @param weight      The weight of the edge.
     */
    public Edge(Vertex<T> source, Vertex<T> destination, double weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    /**
     * Override toString method to provide a custom string representation.
     *
     * @return A string representation of the edge.
     */
    @Override
    public String toString() {
        return "(" + source.label + " -> " + destination.label + ", weight = " + weight + ")";
    }
}
