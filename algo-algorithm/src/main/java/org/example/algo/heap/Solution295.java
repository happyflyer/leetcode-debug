package org.example.algo.heap;

import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/find-median-from-data-stream/
 * <p>
 * 困难
 *
 * @author lifei
 */
public class Solution295 {
    class MedianFinder {
        private PriorityQueue<Integer> large;
        private PriorityQueue<Integer> small;

        public MedianFinder() {
            // 小顶堆
            large = new PriorityQueue<>();
            // 大顶堆
            small = new PriorityQueue<>((a, b) -> b - a);
        }

        public void addNum(int num) {
        }

        public double findMedian() {
        }
    }

    public static void main(String[] args) {
    }
}
