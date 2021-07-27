package org.example.leetcode.easy.integer;

/**
 * https://leetcode-cn.com/problems/palindrome-number/
 *
 * @author lifei
 */
public class Solution9 {
    /**
     * 整数反转
     * <p>
     * 针对 示例2 和 示例4 ，x<0 时直接返回 false
     * <p>
     * 针对 示例3 ，最后一位为 0 时（ 0 除外），直接返回 false
     * <p>
     * 奇数长
     * 12321，转换后，x=12，revertedNumber=123
     * 偶数长
     * 123321，转换后，x=123，revertedNumber=123
     * <p>
     * 判断条件：
     * x == revertedNumber / 10
     * x == revertedNumber
     */
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution9().isPalindrome(-101)
        );
    }
}
