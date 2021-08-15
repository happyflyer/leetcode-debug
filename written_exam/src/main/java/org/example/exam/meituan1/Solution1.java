package org.example.exam.meituan1;

import java.util.Arrays;

/**
 * 水仙花数：各位数字的立方和等于其本身。
 * 找 m 和 n 范围内的水仙花数
 * <p>
 * 输入：100,120
 * 输出：no
 * <p>
 * 输入：300,380
 * 输出：370,371
 *
 * @author lifei
 */
public class Solution1 {
    /**
     * 范围内找水仙花数
     */
    public int[] findFlowerNumber(int m, int n) {
        int[] ans = new int[]{};
        while (m < n) {
            if (isFlowerNumber(m)) {
                ans = Arrays.copyOf(ans, ans.length + 1);
                ans[ans.length - 1] = m;
            }
            m++;
        }
        return ans;
    }

    /**
     * 水仙花数
     */
    private boolean isFlowerNumber(int x) {
        int sum = 0;
        int tmp = x;
        while (tmp != 0) {
            int t = tmp % 10;
            sum += (t * t * t);
            if (sum > x) {
                return false;
            }
            tmp /= 10;
        }
        return sum == x;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().isFlowerNumber(153));
        System.out.println(
                Arrays.toString(
                        new Solution1().findFlowerNumber(300, 380)
                )
        );
    }
}
