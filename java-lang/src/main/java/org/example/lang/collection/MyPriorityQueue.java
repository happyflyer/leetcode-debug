package org.example.lang.collection;

import java.util.*;

/**
 * https://blog.csdn.net/qq_41682302/article/details/95910651
 * https://blog.csdn.net/tiansheshouzuo/article/details/103951835
 *
 * @author lifei
 */
public class MyPriorityQueue {
    /**
     * 寻找无序数组的前k个最大数
     */
    public List<Integer> topMax(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                queue.offer(nums[i]);
            } else if (!queue.isEmpty() && nums[i] > queue.peek()) {
                queue.poll();
                queue.offer(nums[i]);
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            ans.add(queue.poll());
        }
        return ans;
    }

    /**
     * 寻找无序数组的前k个最小数
     */
    public List<Integer> topMin(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k, (a, b) -> b - a);
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                queue.offer(nums[i]);
            } else if (!queue.isEmpty() && nums[i] < queue.peek()) {
                queue.poll();
                queue.offer(nums[i]);
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            ans.add(queue.poll());
        }
        return ans;
    }

    /**
     * 给定一个非空的整数数组，返回其中出现频率前k高的元素
     */
    public List<Integer> topFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(k,
                Comparator.comparingInt(map::get));
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
        List<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            ans.add(queue.poll());
        }
        return ans;
    }

    public static void main(String[] args) {
        MyPriorityQueue queue = new MyPriorityQueue();
        int[] nums = new int[]{4, 1, -1, 2, -1, 2, 3};
        System.out.println(queue.topMax(nums, 3));
        System.out.println(queue.topMin(nums, 3));
        System.out.println(queue.topFrequent(nums, 2));
    }
}
