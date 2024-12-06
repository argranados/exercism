import java.util.*;

public class Graph {
    List<Node> nodesList;
    List<Edge> edgeList;
    Map<String, String> attributes;

    public Graph() {
        nodesList = new ArrayList<>();
        edgeList = new ArrayList<>();
        attributes = new HashMap<>();
    }

    public Graph(Map<String, String> attributes) {
        this();
        this.attributes = attributes;
    }

    public Collection<Node> getNodes() {
        return nodesList;
    }

    public Collection<Edge> getEdges() {
        return edgeList;
    }

    public Graph node(String name) {
        Node node = new Node(name);
        nodesList.add(node);
        return this;
    }

    public Graph node(String name, Map<String, String> attributes) {
        Node node = new Node(name, attributes);
        nodesList.add(node);
        return this;
    }

    public Graph edge(String start, String end) {
        Edge edge = new Edge(start, end);
        edgeList.add(edge);

        return this;
    }

    public Graph edge(String start, String end, Map<String, String> attributes) {
        Edge edge = new Edge(start, end, attributes);
        edgeList.add(edge);

        return this;
    }

    public Map<String, String> getAttributes() {
        return attributes;
    }
}
