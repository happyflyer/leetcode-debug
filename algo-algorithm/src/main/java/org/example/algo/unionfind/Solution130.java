package org.example.algo.unionfind;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/surrounded-regions/
 * <p>
 * 中等
 *
 * @author lifei
 */
public class Solution130 {
    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }
        int m = board.length;
        int n = board[0].length;
        UnionFind uf = new UnionFindImpl2(m * n + 1);
        int dummy = m * n;
        // 首列和末列与dummy连通
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                uf.union(i * n, dummy);
            }
            if (board[i][n - 1] == 'O') {
                uf.union(i * n + n - 1, dummy);
            }
        }
        // 首行和末行与dummy连通
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                uf.union(j, dummy);
            }
            if (board[m - 1][j] == 'O') {
                uf.union((m - 1) * n + j, dummy);
            }
        }
        // 上下左右搜索连通
        int[][] d = new int[][]{{1, 0}, {0, 1}, {0, -1}, {-1, 0}};
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (board[i][j] == 'O') {
                    for (int k = 0; k < 4; k++) {
                        int x = i + d[k][0];
                        int y = j + d[k][1];
                        if (board[x][y] == 'O') {
                            uf.union(x * n + y, i * n + j);
                        }
                    }
                }
            }
        }
        // 找到不与dummy连通的，替换
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (!uf.connected(dummy, i * n + j)) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'X', 'O', 'X', 'X'},
                {'O', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X'}
        };
        new Solution130().solve(board);
        System.out.println(Arrays.deepToString(board));
    }
}
