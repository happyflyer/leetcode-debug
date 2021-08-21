package org.example.exam.yingjiao;

import java.util.Arrays;

/**
 * 输入：
 * [[0,1],[1,0]]
 * 输出：
 * 4
 *
 * @author lifei
 */
public class Solution3 {
    final int startVal = 0;
    final int endVal = 1;
    long cnt = 0;

    public long pathOfZeroAndOne(int[][] maze) {
        int rows = maze.length;
        if (rows == 0) {
            return 0;
        }
        int cols = maze[0].length;
        int[][] visited = new int[rows][cols];
        int[] path = new int[rows * cols];
        for (int i = 0; i < rows * cols; i++) {
            path[i] = -1;
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (maze[i][j] == startVal) {
                    System.out.println("i = " + i + ", j = " + j);
                    dfs(maze, rows, cols, i, j, visited, 0, startVal, path);
                }
            }
        }
        return cnt;
    }

    private void dfs(int[][] matrix, int rows, int cols,
                     int x, int y, int[][] visited,
                     int depth, int target, int[] path) {
        if (depth == rows + cols) {
            return;
        }
        if (depth > 0 && path[depth - 1] == startVal && path[depth] == endVal) {
            cnt++;
        }
        if (x < 0 || x == rows || y < 0 || y == cols) {
            return;
        }
        if (visited[x][y] == 1) {
            return;
        }
        System.out.println();
        System.out.println("x = " + x + ", y = " + y);
        System.out.println("visited = " + Arrays.deepToString(visited));
        System.out.println("depth = " + depth + ", target = " + target);
        System.out.println("path = " + Arrays.toString(path));
        System.out.println("cnt = " + cnt);
        if (matrix[x][y] == target) {
            visited[x][y] = 1;
            path[depth] = target;
            target = target == startVal ? endVal : startVal;
            dfs(matrix, rows, cols, x - 1, y, visited, depth + 1, target, path);
            dfs(matrix, rows, cols, x + 1, y, visited, depth + 1, target, path);
            dfs(matrix, rows, cols, x, y - 1, visited, depth + 1, target, path);
            dfs(matrix, rows, cols, x, y + 1, visited, depth + 1, target, path);
            path[depth] = -1;
            visited[x][y] = 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution3().pathOfZeroAndOne(
                        new int[][]{
                                {0, 1},
                                {1, 0}
                        }
                )
        );
    }
}
