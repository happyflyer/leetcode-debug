package org.example.algo.graph;

/**
 * @author lifei
 */
public class Vertex {
    public int id;
    Vertex[] neighbors;

    /**
     * 图遍历框架
     */
    void traverse(Vertex graph) {
        if (graph == null) {
            return;
        }
        int cur = getPos(graph);
        if (visited[cur]) {
            return;
        }
        visited[cur] = true;
        for (Vertex neighbor : graph.neighbors) {
            traverse(neighbor);
        }
        visited[cur] = false;
    }

    private int getPos(Vertex graph) {
        // 获取在visited中的下标
        return 0;
    }

    boolean[] visited;
}
