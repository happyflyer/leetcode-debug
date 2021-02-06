package org.example.leetcode.esay.solution13;

/**
 * 13. 罗马数字转整数
 * https://leetcode-cn.com/problems/roman-to-integer/
 *
 * @author lifei
 */
class Solution {
    public int romanToInt(String s) {
        // I
        // II
        // III
        // IV
        // V
        // VI
        // VII
        // VIII
        // IX
        // X

        // X
        // XX
        // XXX
        // XL
        // L
        // LX
        // LXX
        // LXXX
        // XC
        // C

        // 发现的规律：
        // 一个字母所代表的数字，如果前面一个数字比后面小，前面这个数字的符号为就是负
        // 如果前面一个数字大于等于后面数字，前面这个数字就是正数

        int sum = 0;
        int preNum = getValue(s.charAt(0));
        int num;
        for (int i = 1; i < s.length(); i++) {
            num = getValue(s.charAt(i));
            if (preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    private int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
