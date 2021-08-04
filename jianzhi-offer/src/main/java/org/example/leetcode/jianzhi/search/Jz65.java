package org.example.leetcode.jianzhi.search;

import java.util.Arrays;

/**
 * https://www.nowcoder.com/practice/2a49359695a544b8939c77358d29b7e6?tpId=13&tqId=11218
 *
 * @author lifei
 */
public class Jz65 {
    public boolean hasPath2(char[][] matrix, String word) {
        int rows = matrix.length;
        if (rows == 0) {
            return false;
        }
        int cols = matrix[0].length;
        int[][] visited = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == word.charAt(0)) {
                    // 第一个字母正确的时候，进入dfs
                    if (dfs2(matrix, i, j, visited, word, 0)) {
                        System.out.println(Arrays.deepToString(matrix));
                        System.out.println(Arrays.deepToString(visited));
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 深度优先搜索
     */
    private boolean dfs2(char[][] matrix, int x, int y,
                         int[][] visited,
                         String word, int cur) {
        // 找到
        if (cur == word.length()) {
            return true;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        // 越界
        if (x < 0 || x == rows || y < 0 || y == cols) {
            return false;
        }
        // 访问过
        if (visited[x][y] == 1) {
            return false;
        }
        if (matrix[x][y] == word.charAt(cur)) {
            // 字符相同，继续深度搜索
            visited[x][y] = 1;
            if (dfs2(matrix, x - 1, y, visited, word, cur + 1)
                    || dfs2(matrix, x + 1, y, visited, word, cur + 1)
                    || dfs2(matrix, x, y - 1, visited, word, cur + 1)
                    || dfs2(matrix, x, y + 1, visited, word, cur + 1)) {
                return true;
            }
            visited[x][y] = 0;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(
                new Jz65().hasPath2(
                        new char[][]{
                                {'a', 'b', 'c', 'e'},
                                {'s', 'f', 'c', 's'},
                                {'a', 'd', 'e', 'e'}
                        },
                        "abcced"
                )
        );
    }
}
