package org.example.algo.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/all-paths-from-source-to-target/
 * <p>
 * 中等
 *
 * @author lifei
 */
public class Solution797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new LinkedList<>();
        LinkedList<Integer> path = new LinkedList<>();
        traverse(graph, 0, path, ans);
        return ans;
    }

    private void traverse(int[][] graph, int i,
                          LinkedList<Integer> path,
                          List<List<Integer>> ans) {
        path.addLast(i);
        int n = graph.length;
        if (i == n - 1) {
            ans.add(new LinkedList<>(path));
            path.removeLast();
            return;
        }
        for (int v : graph[i]) {
            traverse(graph, v, path, ans);
        }
        path.removeLast();
    }

    public static void main(String[] args) {
    }
}
