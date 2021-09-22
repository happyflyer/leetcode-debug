package org.example.algo.pq;

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
            // 小顶堆，堆顶是堆中最小的元素
            large = new PriorityQueue<>();
            // 大顶堆，堆顶是堆中最大的元素
            small = new PriorityQueue<>((a, b) -> b - a);
        }

        public double findMedian() {
            if (large.size() < small.size()) {
                return small.peek();
            } else if (large.size() > small.size()) {
                return large.peek();
            }
            if (large.isEmpty()) {
                return -1;
            }
            return (large.peek() + small.peek()) / 2.0d;
        }

        public void addNum(int num) {
            if (small.size() >= large.size()) {
                small.offer(num);
                large.offer(small.poll());
            } else {
                large.offer(num);
                small.offer(large.poll());
            }
        }
    }

    public static void main(String[] args) {
    }
}
