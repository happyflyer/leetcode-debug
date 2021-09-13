package org.example.algo.queue;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/sliding-window-maximum/
 * <p>
 * 困难
 *
 * @author lifei
 */
public class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        // 维护一个单调减队列（单调非增队列）。
        Deque<Integer> queue = new LinkedList<>();
        int[] ans = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            if (i < k - 1) {
                // push
                while (!queue.isEmpty() && nums[i] > queue.getLast()) {
                    queue.pollLast();
                }
                queue.offerLast(nums[i]);
            } else {
                // push
                while (!queue.isEmpty() && nums[i] > queue.getLast()) {
                    queue.pollLast();
                }
                queue.offerLast(nums[i]);
                // max
                ans[i - k + 1] = queue.getFirst();
                // pop
                if (nums[i - k + 1] == queue.getFirst()) {
                    queue.pollFirst();
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println(
                Arrays.toString(
                        new Solution239().maxSlidingWindow(nums, k)
                )
        );
    }
}
