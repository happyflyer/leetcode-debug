package org.example.exam.kedaxunfei;

import java.util.*;

/**
 * 题目描述：
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
        Set<Integer> val = new HashSet<>(n);
        Set<Integer> square = new HashSet<>(n);
        Map<Integer, Integer> map = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            val.add(length[i]);
            square.add(length[i] * length[i]);
        }
        for (int i = 0; i < n - 2; i++) {
            int a = length[i];
            for (int j = i + 1; j < n - 1; j++) {
                int b = length[j];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] length = new int[]{5, 3, 4, 6, 6, 1};
        System.out.println(new Solution2().happyTriangle(length));
    }
}
