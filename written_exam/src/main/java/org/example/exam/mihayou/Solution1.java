package org.example.exam.mihayou;

import java.util.PriorityQueue;

/**
 * 题目描述：数组中第k大的元素
 * 输入：[3,2,1,5,6,4],2
 * 输出：5
 * 说明：
 * 通过：AC
 *
 * @author lifei
 */
public class Solution1 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>(k);
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                q.offer(nums[i]);
            } else if (!q.isEmpty() && nums[i] > q.peek()) {
                q.poll();
                q.offer(nums[i]);
            }
        }
        return q.isEmpty() ? -1 : q.peek();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(new Solution1().findKthLargest(nums, k));
    }
}
