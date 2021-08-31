package org.example.leetcode.integer;

/**
 * https://leetcode-cn.com/problems/reverse-integer/
 * <p>
 * 简单
 *
 * @author lifei
 */
public class Solution7 {
    /**
     * 处理溢出情况。
     * pop = x % 10;
     * x /= 10;
     * temp = rev * 10 + pop;（这个步骤会导致整数溢出）
     * rev = temp;
     * if rev>INT_MAX/10, 溢出。
     * if rev==INT_MAX/10 && pop>7, 溢出（INT_MAX=2147483647）。
     * 负数具有相似逻辑（INT_MIN=-2147483648）。
     */
    public int reverse(int x) {
        int pop;
        int rev = 0;
        int maxDiv10 = Integer.MAX_VALUE / 10;
        int minDiv10 = Integer.MIN_VALUE / 10;
        while (x != 0) {
            pop = x % 10;
            x = x / 10;
            if (rev > maxDiv10 || (rev == maxDiv10 && pop > 7)) {
                return 0;
            }
            if (rev < minDiv10 || (rev == minDiv10 && pop > 8)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution7().reverse(-123)
        );
    }
}
