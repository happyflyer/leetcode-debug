package org.example.exam.wangyi;

/**
 * 矩阵中的路径。
 * <p>
 * 输入：[[1,1,1,1,0],[0,1,0,1,0],[1,1,2,1,1],[0,2,0,0,1]]
 * 输出：7
 *
 * @author lifei
 */
public class Solution4 {
    private static int ans = Integer.MAX_VALUE;

    public static int minSailCost(int[][] input) {
        int rows = input.length;
        if (rows == 0) {
            return 0;
        }
        int cols = input[0].length;
        dfs(input, rows, cols, new int[rows][cols],
                0, 0, 0, new int[rows * cols]);
        if (ans == Integer.MAX_VALUE) {
            return -1;
        }
        return ans;
    }

    private static void dfs(int[][] input, int rows, int cols, int[][] visited,
                            int x, int y, int depth, int[] path) {
        if (x == rows - 1 && y == cols - 1) {
            int sum = 0;
            for (int i = 1; i < path.length; i++) {
                sum += path[i];
            }
            sum += (input[rows - 1][cols - 1] == 1 ? 1 : 2);
            ans = Math.min(ans, sum);
            return;
        }
        if (x < 0 || y < 0 || x >= rows || y >= cols) {
            return;
        }
        if (visited[x][y] == 1) {
            return;
        }
        if (input[x][y] == 2) {
            return;
        }
        visited[x][y] = 1;
        path[depth] = input[x][y] == 1 ? 1 : 2;
        // dfs(input, rows, cols, visited, x - 1, y, depth + 1, path);
        // dfs(input, rows, cols, visited, x, y - 1, depth + 1, path);
        dfs(input, rows, cols, visited, x + 1, y, depth + 1, path);
        dfs(input, rows, cols, visited, x, y + 1, depth + 1, path);
        path[depth] = 0;
        visited[x][y] = 0;
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{
                {1, 1, 1, 1, 0},
                {0, 1, 0, 1, 0},
                {1, 1, 2, 1, 1},
                {0, 2, 0, 0, 1}
        };
        System.out.println(minSailCost(input));
    }
}
