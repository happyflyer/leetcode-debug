package org.example.exam.shopee3;

/**
 * 题目描述：
 * 输入：
 * 输出：
 * 说明：
 * 通过：AC
 *
 * @author lifei
 */
public class Solution1 {
    public int padovanSequence(int n) {
        int[] cache = new int[Math.max(4, n + 1)];
        cache[1] = 1;
        cache[2] = 1;
        cache[3] = 1;
        if (n < 4) {
            return cache[n];
        }
        for (int i = 4; i <= n; i++) {
            cache[i] = cache[i - 2] + cache[i - 3];
        }
        return cache[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().padovanSequence(20));
    }
}
