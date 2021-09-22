package org.example.exam.vivo;

/**
 * 题目描述：
 * 输入：0
 * 输出：0
 * 说明：
 * 输入：3
 * 输出：3
 * 输入：5
 * 输出：10
 * 通过：0
 *
 * @author lifei
 */
public class Solution2 {
    public int workSchedule (int n) {
        if (n <= 3) {
            return n;
        }
        int[] ans = new int[n + 1];
        for (int i = 0; i < 4; i++) {
            ans[i] = i;
        }
        for (int i = 4; i <= n; i++) {
        }
        return ans[n];
    }

    public static void main(String[] args) {
    }
}
