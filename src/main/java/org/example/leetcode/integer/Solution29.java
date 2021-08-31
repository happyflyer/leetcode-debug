package org.example.leetcode.integer;

/**
 * https://leetcode-cn.com/problems/divide-two-integers/
 * <p>
 * 中等
 *
 * @author lifei
 */
public class Solution29 {
    /**
     * 处理溢出情况。
     * 1、当被除数为 MIN_VALUE 时，需要特殊考虑：
     * 1.1、当除数为 -1 时，结果溢出，返回 MAX_VALUE；
     * 1.2、当除数为 1 时，结果为 MIN_VALUE；
     * 1.3、当除数位于 (MAX_VALUE / 2 + 1, MAX_VALUE]时，结果为 -1；
     * 1.4、当除数位于 [MIN_VALUE, MIN_VALUE / 2)时，结果为 1；
     * 1.5、当除数位于 [MIN_VALUE / 2, 0) && (0, MAX_VALUE / 2 + 1]时，
     * 先计算 (MIN_VALUE / 2) / divisor，
     * 如果 余数*2 的绝对值 大于 divisor，则结果的绝对值需要 +1。
     * 2、当除数为 MIN_VALUE 时，结果为 0。
     * 3、其余情况，全部转换成正数运算，最后加上符号位。
     */
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE) {
            if (divisor == -1) {
                return Integer.MAX_VALUE;
            } else if (divisor == 1) {
                return Integer.MIN_VALUE;
            } else if (divisor > (Integer.MAX_VALUE >> 1) + 1) {
                return -1;
            } else if (divisor < Integer.MIN_VALUE >> 1) {
                return 1;
            } else {
                int half = Integer.MIN_VALUE >> 1;
                int result = divide(half, divisor);
                int remainder = half - result * divisor;
                boolean flag = Math.abs(remainder) * 2 >= Math.abs(divisor);
                if (flag) {
                    return result > 0 ? (result << 1) + 1 : (result << 1) - 1;
                } else {
                    return result << 1;
                }
            }
        }
        if (divisor == Integer.MIN_VALUE) {
            return 0;
        }
        boolean negative = (dividend ^ divisor) < 0;
        int result = 0;
        int t = Math.abs(dividend);
        int d = Math.abs(divisor);
        for (int i = 31; i >= 0; i--) {
            if ((t >> i) >= d) {
                result += 1 << i;
                t -= d << i;
            }
        }
        return negative ? -result : result;
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution29().divide(-2147483648, -1)
        );
    }
}
