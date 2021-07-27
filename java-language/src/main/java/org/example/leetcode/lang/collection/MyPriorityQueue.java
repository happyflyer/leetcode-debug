package org.example.leetcode.lang.collection;

import java.util.*;

/**
 * https://blog.csdn.net/qq_41682302/article/details/95910651
 * https://blog.csdn.net/tiansheshouzuo/article/details/103951835
 * <p>
 * 构造小顶堆：
 * {@code PriorityQueue<Integer> small = new PriorityQueue<>(k);}
 * 构造大顶堆：
 * {@code PriorityQueue<Integer> big = new PriorityQueue<>(k, (a, b) -> b - a);}
 *
 * @author lifei
 */
public class MyPriorityQueue {
    /**
     * 问题：寻找无序数组的前 k 个最大数
     * <p>
     * 思路：遍历数组，用一个大小为 k 的小顶堆保存当前找到的前 k 个最大数，
     * 如果数组下一个元素比堆顶大，那堆顶元素必然不是前 k 大，将堆顶元素出堆，此元素入堆。
     *
     * @param nums nums
     * @param k    k
     * @return List<Integer>
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
     * 问题：寻找无序数组的前 k 个最小数
     * <p>
     * 思想：遍历数组，用一个大小为 k 的大顶堆保存当前找到的前 k 个最小数，
     * 如果下一个数组元素比堆顶小，那堆顶元素必然不是前 k 小，将堆顶元素出堆，此数组元素入堆。
     *
     * @param nums nums
     * @param k    k
     * @return List<Integer>
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
     * 问题：给定一个非空的整数数组，返回其中出现频率前 k 高的元素
     * <p>
     * 思路：“前 k 个最”是堆的一般使用场景，
     * 该题中的计量标准为频率，因此堆中比较的应该是元素频率。
     * 而堆中一般存的就是最终需要导进返回数组里的元素，
     * 因此需要重写 PriorityQueue 类中的比较函数，
     * 使得堆中存元素，但堆排序比较的是元素频率。
     *
     * @param nums nums
     * @param k    k
     * @return List<Integer>
     */
    public List<Integer> topFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
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
