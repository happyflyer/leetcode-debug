package org.example.leetcode.graph;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/course-schedule/
 * <p>
 * 中等
 *
 * @author lifei
 */
public class Solution207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        boolean[] visited = new boolean[numCourses];
        boolean[] onPath = new boolean[numCourses];
        boolean[] haCycle = new boolean[1];
        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i, visited, onPath, haCycle);
        }
        return !haCycle[0];
    }

    private static void traverse(List<Integer>[] graph, int pos,
                                 boolean[] visited,
                                 boolean[] onPath,
                                 boolean[] hasCycle) {
        if (onPath[pos]) {
            hasCycle[0] = true;
        }
        if (visited[pos] || hasCycle[0]) {
            return;
        }
        visited[pos] = true;
        onPath[pos] = true;
        for (Integer i : graph[pos]) {
            traverse(graph, i, visited, onPath, hasCycle);
        }
        onPath[pos] = false;
    }

    /**
     * 邻接表
     */
    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] ints : prerequisites) {
            graph[ints[0]].add(ints[1]);
        }
        return graph;
    }

    public static void main(String[] args) {
    }
}
