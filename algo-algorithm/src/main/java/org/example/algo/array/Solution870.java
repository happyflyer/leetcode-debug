package org.example.algo.array;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/advantage-shuffle/
 * <p>
 * 中等
 *
 * @author lifei
 */
public class Solution870 {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        // 给nums2降序排序，不能改变nums2的位置，借助优先级队列
        PriorityQueue<Integer[]> maxPQ = new PriorityQueue<>(
                (Integer[] pair1, Integer[] pair2) -> pair2[1] - pair1[1]
        );
        for (int i = 0; i < n; i++) {
            maxPQ.offer(new Integer[]{i, nums2[i]});
        }
        // 给nums1升序排序
        Arrays.sort(nums1);
        int left = 0;
        int right = n - 1;
        int[] res = new int[n];
        while (!maxPQ.isEmpty()) {
            Integer[] pair = maxPQ.poll();
            int i = pair[0];
            int maxVal = pair[1];
            if (maxVal < nums1[right]) {
                // 比得过，跟他比
                res[i] = nums1[right];
                right--;
            } else {
                // 比不过，送人头
                res[i] = nums1[left];
                left++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
    }
}
