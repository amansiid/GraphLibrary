import java.util.Objects;

/**
 * Class representing a vertex in the graph.
 * @param <T> The type of data stored in the vertex.
 */
public class Vertex<T> {
    T label; // Label of the vertex

    /**
     * Constructor to initialize the vertex with a label.
     * @param label The label of the vertex.
     */
    public Vertex(T label) {
        this.label = label;
    }

    /**
     * Override equals method to compare vertices based on their labels.
     * @param obj The object to compare with this vertex.
     * @return true if the vertices are equal, false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        // Check if the object is the same instance as this vertex
        if (this == obj)
            return true;
        // Check if the object is an instance of Vertex class
        if (!(obj instanceof Vertex))
            return false;
        // Convert the object to Vertex type
        Vertex<?> other = (Vertex<?>) obj;
        // Compare the labels of this vertex and the other vertex
        return Objects.equals(label, other.label);
    }

    /**
     * Override hashCode method to generate a hash code based on the label.
     * @return The hash code of the vertex.
     */
    @Override
    public int hashCode() {
        return Objects.hash(label);
    }
}
