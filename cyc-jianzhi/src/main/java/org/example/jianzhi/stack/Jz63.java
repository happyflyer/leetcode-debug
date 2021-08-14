package org.example.jianzhi.stack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://www.nowcoder.com/practice/9be0172896bd43948f8a32fb954e1be1?tpId=13&tqId=11216
 *
 * @author lifei
 */
public class Jz63 {
    List<Integer> list = new ArrayList<>(10);

    public void Insert(Integer num) {
        list.add(num);
    }

    public Double GetMedian() {
        int size = list.size();
        Collections.sort(list);
        if (size % 2 == 1) {
            return Double.valueOf(list.get(size / 2));
        } else {
            return (double) (list.get(size / 2 - 1) + list.get(size / 2)) / 2;
        }
    }

    /**
     * 小顶堆，存储大元素
     */
    PriorityQueue<Integer> right = new PriorityQueue<>();
    /**
     * 大顶堆，存储小元素
     */
    PriorityQueue<Integer> left = new PriorityQueue<>((a, b) -> b - a);
    int size = 0;

    public void Insert2(Integer num) {
        if (size % 2 == 0) {
            right.offer(num);
            left.offer(right.poll());
        } else {
            left.offer(num);
            right.offer(left.poll());
        }
        size++;
    }

    public Double GetMedian2() {
        if (left.isEmpty()) {
            return 0d;
        }
        if (right.isEmpty()) {
            return Double.valueOf(left.peek());
        }
        if (size % 2 == 0) {
            return ((left.peek() + right.peek()) / 2.0);
        } else {
            return Double.valueOf(left.peek());
        }
    }

    public static void main(String[] args) {
        Jz63 jz63 = new Jz63();
        int[] input = new int[]{5, 2, 3, 4, 1, 6, 7, 0, 8};
        // double[] output = new double[]{5.00, 3.50, 3.00, 3.50, 3.00, 3.50, 4.00, 3.50, 4.00};
        for (int i = 0; i < input.length; i++) {
            jz63.Insert(input[i]);
            System.out.println(jz63.GetMedian());
        }
    }
}
