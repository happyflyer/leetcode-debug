package org.example.leetcode.easy.integer;

/**
 * https://leetcode-cn.com/problems/reverse-integer/
 *
 * @author lifei
 */
public class Solution7 {
    /**
     * 使用字符串反转
     */
    public int reverse(int x) {
        String s = String.valueOf(x);
        boolean negative = s.charAt(0) == '-';
        s = negative ? s.substring(1) : s;
        // 字符串反转
        s = reverseString(s);
        // 处理整数溢出情况
        String zero = "0";
        if (negative) {
            s = compareString(String.valueOf(Integer.MIN_VALUE).substring(1), s) > 0 ? ("-" + s) : zero;
        } else {
            s = compareString(String.valueOf(Integer.MAX_VALUE), s) > 0 ? s : zero;
        }
        return Integer.parseInt(s);
    }

    public String reverseString(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public int compareString(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        if (n1 != n2) {
            return n1 > n2 ? 1 : -1;
        } else {
            char c1;
            char c2;
            for (int i = 0; i < n1; i++) {
                c1 = s1.charAt(i);
                c2 = s2.charAt(i);
                if (c1 > c2) {
                    return 1;
                } else if (c1 < c2) {
                    return -1;
                }
            }
        }
        return 0;
    }

    /**
     * 整数反转
     * <p>
     * pop operation:
     * pop = x % 10;
     * x /= 10;
     * <p>
     * push operation:
     * temp = rev * 10 + pop;（这个步骤会导致整数溢出）
     * rev = temp;
     * <p>
     * 溢出判断
     * 如果 rev > INT_MAX / 10，则 temp 一定溢出
     * 如果 rev == INT_MAX / 10，且 pop > 7，则 temp 溢出
     * <p>
     * 负数具有相似的逻辑
     */
    public int reverse2(int x) {
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
                new Solution7().reverse2(-123)
        );
    }
}
