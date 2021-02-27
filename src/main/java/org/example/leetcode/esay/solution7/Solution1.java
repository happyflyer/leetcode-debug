package org.example.leetcode.esay.solution7;

/**
 * 7. 整数反转
 * https://leetcode-cn.com/problems/reverse-integer/
 *
 * @author lifei
 */
class Solution1 {
    public int reverse(int x) {
        // pop operation:
        // pop = x % 10;
        // x /= 10;
        // push operation:
        // temp = rev * 10 + pop;（这个步骤会导致整数溢出）
        // rev = temp;

        // 溢出判断
        // 如果 rev > INT_MAX / 10，则 temp 一定溢出
        // 如果 rev == INT_MAX / 10，且 pop > 7，则 temp 溢出
        // 负数具有相似的逻辑

        int rev = 0;
        int pop;
        while (x != 0) {
            pop = x % 10;
            x = x / 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop > 8)) {
                return 0;
            }
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
