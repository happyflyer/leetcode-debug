package org.example.leetcode.integer;

/**
 * https://leetcode-cn.com/problems/palindrome-number/
 * <p>
 * 简单
 *
 * @author lifei
 */
public class Solution9 {
    /**
     * if x<0, false（示例2和示例4）。
     * if x!=0 && x%10==0, false（示例3）。
     * 奇数长，x==revertedNumber/10（12321分成123和12）。
     * 偶数长，x==revertedNumber（123321分成123和123）。
     */
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int reverse = 0;
        while (x > reverse) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        return x == reverse || x == reverse / 10;
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution9().isPalindrome(-101)
        );
    }
}
