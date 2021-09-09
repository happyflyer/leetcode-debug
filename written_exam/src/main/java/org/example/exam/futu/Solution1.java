package org.example.exam.futu;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 题目描述：两个数组相加和最大的前k个
 * 输入：[1,2,3,4,5],[3,5,7,9,11],4
 * 输出：[16,15,14,14]
 * 说明：
 * 通过：
 *
 * @author lifei
 */
public class Solution1 {
    public int[] findTopKinTwoSortedArray(int[] arr1, int[] arr2, int k) {
        int n = arr1.length;
        int m = arr2.length;
        if (n == 0 || m == 0) {
            return new int[]{};
        }
        k = Math.min(k, n * m);
        int resIndex = 0;
        int[] res = new int[k];
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> b.sum - a.sum);
        Set<String> visited = new HashSet<>();
        maxHeap.offer(new Pair(n - 1, m - 1, arr1[n - 1] + arr2[m - 1]));
        visited.add((n - 1) + "#" + (m - 1));
        while (resIndex < k) {
            Pair curr = maxHeap.poll();
            res[resIndex++] = curr.sum;
            int rowIndex = curr.row;
            int colIndex = curr.col;
            if (rowIndex > 0 && !visited.contains((rowIndex - 1) + "#" + colIndex)) {
                maxHeap.offer(new Pair(rowIndex - 1, colIndex, arr1[rowIndex - 1] + arr2[colIndex]));
                visited.add((rowIndex - 1) + "#" + colIndex);
            }
            if (colIndex > 0 && !visited.contains(rowIndex + "#" + (colIndex - 1))) {
                maxHeap.offer(new Pair(rowIndex, colIndex - 1, arr1[rowIndex] + arr2[colIndex - 1]));
                visited.add(rowIndex + "#" + (colIndex - 1));
            }
        }
        return res;
    }

    class Pair {
        int row;
        int col;
        int sum;

        public Pair(int row, int col, int sum) {
            this.row = row;
            this.col = col;
            this.sum = sum;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 3, 4, 5};
        int[] arr2 = new int[]{3, 5, 7, 9, 11};
        int k = 4;
        System.out.println(
                Arrays.toString(
                        new Solution1().findTopKinTwoSortedArray(arr1, arr2, k)
                )
        );
    }
}
