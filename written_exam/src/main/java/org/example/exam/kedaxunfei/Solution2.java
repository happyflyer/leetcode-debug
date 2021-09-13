package org.example.exam.kedaxunfei;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 题目描述：leetcode 611 变体。
 * 输入：[6,6,6]
 * 输出：0
 * 说明：
 * 输入：[6,1,3,1]
 * 输出：0
 * 输入：[5,3,4,6,6,1]
 * 输出：10
 * 通过：
 *
 * @author lifei
 */
public class Solution2 {
    public int happyTriangle(int[] length) {
        int n = length.length;
        Arrays.sort(length);
        System.out.println(Arrays.toString(length));
        // 每个元素有多少个
        int[] valToCount = new int[2001];
        // 每个元素的平方，快速判断平方是否存在
        Set<Integer> square = new HashSet<>();
        for (int cur : length) {
            valToCount[cur] += 1;
            square.add(cur * cur);
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int a = length[i];
            for (int j = i + 1; j < n; j++) {
                int b = length[j];
                int left = j + 1;
                int right = n - 1;
                int k = j;
                while (left <= right) {
                    int mid = (left + right) >> 1;
                    if (length[mid] < a + b) {
                        k = mid;
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                sum += (k - j);
                // 排除等边三角形
                if (a == b) {
                    left = j + 1;
                    while (left < n && length[left] == b) {
                        left++;
                    }
                    sum -= (left - j - 1);
                }
                // 排除直角三角形
                int cs = a * a + b * b;
                if (square.contains(cs)) {
                    int c = (int) Math.sqrt(cs);
                    sum -= valToCount[c];
                }
                System.out.println("i = " + i + ", j = " + j + ", sum = " + sum);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] length = new int[]{5, 3, 4, 6, 6, 1};
        // int[] length = new int[]{2, 2, 2, 3};
        System.out.println(new Solution2().happyTriangle(length));
    }
}
