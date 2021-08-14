package org.example.jianzhi.stack;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://www.nowcoder.com/practice/6a296eb82cf844ca8539b57c23e6e9bf?tpId=13&tqId=11182
 *
 * @author lifei
 */
public class Jz29 {
    /**
     * 使用大顶堆
     * <p>
     * 遍历 input 数组，
     * 如果当前元素比堆顶元素小，那堆顶元素一定不是前k最小，移除堆顶元素，当前元素进堆。
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (k == 0) {
            return new ArrayList<>();
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, (a, b) -> b - a);
        for (int i : input) {
            if (k-- > 0) {
                heap.offer(i);
            } else if (!heap.isEmpty() && i < heap.peek()) {
                heap.poll();
                heap.offer(i);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>(heap.size());
        while (!heap.isEmpty()) {
            ans.add(heap.poll());
        }
        // 逆序
        Collections.reverse(ans);
        return ans;
    }

    static ArrayList<Integer> intArray2IntegerArrayList(int[] arr) {
        return Arrays.stream(arr).boxed().collect(Collectors.toCollection(ArrayList::new));
    }

    public static void main(String[] args) {
        System.out.println(
                new Jz29().GetLeastNumbers_Solution(
                        new int[]{4, 5, 1, 6, 2, 7, 3, 8},
                        4
                )
        );
    }
}
