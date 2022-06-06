package algorithm.BFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    public static void main(String[] args) {
        BFS bfs = new BFS();
        Graph g = bfs.initialGraph();
        for (Vertex vertex : g.getVertexes()) {
            if (vertex.getIndex() == 3) {
                bfs.bfs(g, vertex);
            }
        }
    }

    public void bfs(Graph g, Vertex root) {
        Queue<Vertex> queue = new LinkedList<>();
        queue.add(root);
        root.setDistance(0);
        root.setColor(VertexColor.GRAY);
        while (!queue.isEmpty()) {
            Vertex v = queue.remove();
            List<Vertex> vertexList = v.getAdjList();
            for (Vertex vertex : vertexList) {
                if (vertex.getColor() == VertexColor.WHITE) {
                    vertex.setColor(VertexColor.GRAY);
                    vertex.setDistance(v.getDistance() + 1);
                    vertex.setPre(v);
                    queue.add(vertex);
                }
            }
            v.setColor(VertexColor.BLACK);
        }

        for (Vertex vertex : g.getVertexes()) {
            if (vertex == root || vertex.getDistance() == Integer.MAX_VALUE) {
                continue;
            }
            System.out.println(vertex);
        }
    }

    public Graph initialGraph() {
        Graph g = new Graph(6);

        Vertex v1 = new Vertex(1);
        Vertex v2 = new Vertex(2);
        Vertex v3 = new Vertex(3);
        Vertex v4 = new Vertex(4);
        Vertex v5 = new Vertex(5);
        Vertex v6 = new Vertex(6);

        g.addVertex(v1);
        g.addVertex(v2);
        g.addVertex(v3);
        g.addVertex(v4);
        g.addVertex(v5);
        g.addVertex(v6);

        v1.addVertex(v2);
        v1.addVertex(v4);

        v2.addVertex(v4);

        v3.addVertex(v1);
        v3.addVertex(v5);

        v4.addVertex(v5);
        v4.addVertex(v6);

        v5.addVertex(v6);
        return g;
    }
}
