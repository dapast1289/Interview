package algorithm.BFS;

import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Data
public class Vertex {

    private VertexColor color;

    private int distance;

    private Vertex pre;

    private List<Vertex> adjList;

    private int index;

    public Vertex(int index) {
        this.index = index;
        this.adjList = new LinkedList<>();
        this.color = VertexColor.WHITE;
        this.pre = null;
        this.distance = Integer.MAX_VALUE;
    }

    public void addVertex(Vertex v) {
        this.adjList.add(v);
    }

    @Override
    public String toString() {
        return String.format("到節點: %d的最短距離為: %d, 前驅節點下標為: %d, 當前顏色為: %s", index, distance, pre.index, color);
    }
}
