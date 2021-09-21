package org.example.algo.pointer2.array;

/**
 * https://leetcode-cn.com/problems/reverse-string/
 * <p>
 * 简单
 *
 * @author lifei
 */
public class Solution344 {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
    }
}
