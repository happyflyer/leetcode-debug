package org.example.leetcode.esay.solution9;

/**
 * 9. 回文数
 * https://leetcode-cn.com/problems/palindrome-number/
 *
 * @author lifei
 */
class Solution {
    public boolean isPalindrome(int x) {
        // 针对示例2和示例4，x<0时直接返回false
        // 针对示例3，最后一位为0时（0除外），直接返回false
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        // 思路一：数字转字符串，浪费空间
        // 思路二：反转一半的数字，可取

        // 奇数长
        // 12321，转换后，x=12，revertedNumber=123
        // 偶数长
        // 123321，转换后，x=123，revertedNumber=123
        // 判断条件：
        // x == revertedNumber / 10
        // x == revertedNumber

        // 时间复杂度：每次都x除以10，O(logn)
        // 空间复杂度：O(1)
        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
