package org.example.algo.graph;

import java.util.LinkedList;

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
     * 暴力解法。
     * 所谓「名人」有两个条件：
     * 1、所有其他人都认识「名人」。
     * 2、「名人」不认识任何其他人。
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
     * 优化解法。
     * 人群中最多有一个名人。
     */
    int findCelebrity2(int n) {
        if (n == 1) {
            return 0;
        }
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.addLast(i);
        }
        while (q.size() > 2) {
            int cand = q.removeFirst();
            int other = q.removeFirst();
            if (knows(cand, other) || !knows(other, cand)) {
                // cand 肯定不是名人
                q.addLast(other);
            } else {
                // other 肯定不是名人
                q.addLast(cand);
            }
        }
        int cand = q.removeFirst();
        for (int other = 0; other < n; other++) {
            if (other == cand) {
                continue;
            }
            if (!knows(other, cand) || knows(cand, other)) {
                return -1;
            }
        }
        return cand;
    }

    /**
     * 最终解法。
     */
    int findCelebrity3(int n) {
        int cand = 0;
        for (int other = 1; other < n; other++) {
            if (knows(cand, other) || !knows(other, cand)) {
                cand = other;
            }
        }
        for (int other = 0; other < n; other++) {
            if (other == cand) {
                continue;
            }
            if (!knows(other, cand) || knows(cand, other)) {
                return -1;
            }
        }
        return cand;
    }

    public static void main(String[] args) {
    }
}
