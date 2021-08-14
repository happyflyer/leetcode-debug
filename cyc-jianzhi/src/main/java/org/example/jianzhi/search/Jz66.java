package org.example.jianzhi.search;

import java.util.Arrays;

/**
 * https://www.nowcoder.com/practice/6e5207314b5241fb83f2329e89fdecc8?tpId=13&tqId=11219
 *
 * @author lifei
 */
public class Jz66 {
    public int movingCount(int threshold, int rows, int cols) {
        int[][] visited = new int[rows][cols];
        int cnt = dfs(0, 0, visited, threshold);
        System.out.println(Arrays.deepToString(visited));
        return cnt;
    }

    /**
     * 深度优先搜索，避免搜索之后重新遍历visited
     */
    private int dfs(int x, int y, int[][] visited, int threshold) {
        int rows = visited.length;
        int cols = visited[0].length;
        // 越界
        if (x < 0 || x == rows || y < 0 || y == cols) {
            return 0;
        }
        // 访问过
        if (visited[x][y] == 1) {
            return 0;
        }
        int inc = 0;
        if (x % 10 + x / 10 + y % 10 + y / 10 <= threshold) {
            visited[x][y] = 1;
            inc += 1;
            inc += dfs(x - 1, y, visited, threshold);
            inc += dfs(x + 1, y, visited, threshold);
            inc += dfs(x, y - 1, visited, threshold);
            inc += dfs(x, y + 1, visited, threshold);
        }
        return inc;
    }

    public static void main(String[] args) {
        System.out.println(
                new Jz66().movingCount(5, 10, 10)
        );
    }
}
