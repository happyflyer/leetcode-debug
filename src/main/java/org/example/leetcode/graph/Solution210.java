package org.example.leetcode.graph;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/course-schedule-ii/
 * <p>
 * 中等
 *
 * @author lifei
 */
public class Solution210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (!canFinish(numCourses, prerequisites)) {
            return new int[]{};
        }
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        boolean[] visited = new boolean[numCourses];
        LinkedList<Integer> postOrder = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            traverse2(graph, i, visited, postOrder);
        }
        // Collections.reverse(postOrder);
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = postOrder.get(i);
        }
        return res;
    }

    private void traverse2(List<Integer>[] graph, int pos,
                           boolean[] visited,
                           LinkedList<Integer> postOrder) {
        if (visited[pos]) {
            return;
        }
        visited[pos] = true;
        for (Integer i : graph[pos]) {
            traverse2(graph, i, visited, postOrder);
        }
        postOrder.add(pos);
    }

    private boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        boolean[] visited = new boolean[numCourses];
        boolean[] onPath = new boolean[numCourses];
        boolean[] haCycle = new boolean[1];
        for (int i = 0; i < numCourses; i++) {
            traverse1(graph, i, visited, onPath, haCycle);
        }
        return !haCycle[0];
    }

    private static void traverse1(List<Integer>[] graph, int pos,
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
            traverse1(graph, i, visited, onPath, hasCycle);
        }
        onPath[pos] = false;
    }

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
