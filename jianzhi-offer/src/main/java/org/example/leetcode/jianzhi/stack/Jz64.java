package org.example.leetcode.jianzhi.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * https://www.nowcoder.com/practice/1624bc35a45c42c0bc17d17fa0cba788?tpId=13&tqId=11217
 *
 * @author lifei
 */
public class Jz64 {
    /**
     * 双层循环
     */
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if (size > num.length || size == 0) {
            return list;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < num.length - size + 1; i++) {
            if (i == 0 || num[i - 1] == max) {
                max = maxInt(num, i, i + size);
            } else {
                max = Math.max(max, num[i + size - 1]);
            }
            list.add(max);
        }
        return list;
    }

    private int maxInt(int[] num, int start, int end) {
        int max = Integer.MIN_VALUE;
        for (int i = start; i < end; i++) {
            max = Math.max(max, num[i]);
        }
        return max;
    }

    /**
     * 维护一个大顶堆
     */
    public ArrayList<Integer> maxInWindows2(int[] num, int size) {
        int length = size + 1;
        ArrayList<Integer> list = new ArrayList<>(length);
        if (size > num.length || size == 0) {
            return list;
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(size, (a, b) -> b - a);
        for (int i = 0; i < size; i++) {
            heap.offer(num[i]);
        }
        list.add(heap.peek());
        for (int i = 0, j = i + size; j < num.length; i++, j++) {
            heap.remove(num[i]);
            heap.offer(num[j]);
            list.add(heap.peek());
        }
        return list;
    }

    static ArrayList<Integer> intArray2IntegerArrayList(int[] arr) {
        return Arrays.stream(arr).boxed().collect(Collectors.toCollection(ArrayList::new));
    }

    public static void main(String[] args) {
        System.out.println(
                new Jz64().maxInWindows(
                        new int[]{2, 3, 4, 2, 6, 2, 5, 1},
                        3
                )
        );
    }
}
