package org.example.algo.tree.bst;

/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 * <p>
 * 中等
 *
 * @author lifei
 */
public class Solution96 {
    public int numTrees(int n) {
        return count(1, n, new int[n + 1][n + 1]);
    }

    private int count(int low, int high, int[][] cache) {
        if (low > high) {
            return 1;
        }
        if (cache[low][high] != 0) {
            return cache[low][high];
        }
        int res = 0;
        for (int i = low; i <= high; i++) {
            int left = count(low, i - 1, cache);
            int right = count(i + 1, high, cache);
            res += (left * right);
        }
        cache[low][high] = res;
        return res;
    }

    public static void main(String[] args) {
    }
}
