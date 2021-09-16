package org.example.exam.qqmusic;

/**
 * 题目描述：二进制取反。
 * 输入："1000"
 * 输出："1111"
 * 说明：
 * 输入："1001"
 * 输出："1111"
 * 通过：66.67%
 *
 * @author lifei
 */
public class Solution2 {
    public String maxLexicographical(String num) {
        int n = num.length();
        if (n == 0) {
            return num;
        }
        StringBuilder sb = new StringBuilder(num);
        int start = 0;
        while (sb.charAt(start) == '1') {
            start++;
        }
        if (start == n) {
            return sb.toString();
        }
        while (sb.charAt(start) == '0') {
            sb.setCharAt(start, '1');
            start++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().maxLexicographical("-1101"));
    }
}
