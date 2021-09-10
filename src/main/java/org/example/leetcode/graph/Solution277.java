package org.example.leetcode.graph;

/**
 * https://leetcode-cn.com/problems/find-the-celebrity/
 * <p>
 * 中等
 *
 * @author lifei
 */
public abstract class Solution277 {
    abstract boolean knows(int i, int j);

    /**
     * 暴力解法
     */
    int findCelebrity(int n) {
        for (int cand = 0; cand < n; cand++) {
            int other;
            for (other = 0; other < n; other++) {
                if (other == cand) {
                    continue;
                }
                if (knows(cand, other) || !knows(other, cand)) {
                    break;
                }
            }
            if (other == n) {
                return cand;
            }
        }
        return -1;
    }

    /**
     * 优化解法
     */
    int findCelebrity2(int n) {
        return -1;
    }

    /**
     * 最终解法
     */
    int findCelebrity3(int n) {
        return -1;
    }

    public static void main(String[] args) {
    }
}
