package org.example.exam.shangtang;

import java.util.*;

/**
 * 最近常出现的k个元素。
 * <p>
 * 输入：[1,1,1,2,2,3],2
 * 输出：[1,2]
 *
 * @author lifei
 */
public class Solution2 {
    /**
     * 小顶堆
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        System.out.println(map);
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, Comparator.comparingInt(map::get));
        int size = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (size < k) {
                queue.offer(entry.getKey());
                size++;
            } else if (entry.getValue() > map.get(queue.peek())) {
                queue.poll();
                queue.add(entry.getKey());
            }
        }
        System.out.println(queue);
        int[] ans = new int[k];
        int i = 0;
        while (!queue.isEmpty()) {
            ans[i++] = queue.poll();
        }
        Arrays.sort(ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        new Solution2().topKFrequent(
                                new int[]{1, 1, 1, 2, 2, 3}, 2
                        )
                )
        );
    }
}
