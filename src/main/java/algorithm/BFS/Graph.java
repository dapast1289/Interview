package algorithm.BFS;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Graph {

    private List<Vertex> vertexes;

    public Graph(int len) {
        vertexes = new ArrayList<>(len);
    }

    public void addVertex(Vertex v) {
        this.vertexes.add(v);
    }
}
