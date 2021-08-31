package org.example.leetcode.string.roman;

/**
 * https://leetcode-cn.com/problems/integer-to-roman/
 * <p>
 * 中等
 *
 * @author lifei
 */
public class Solution12 {
    static final int[] values = {
            1000, 900, 500, 400,
            100, 90, 50, 40,
            10, 9, 5, 4,
            1
    };
    static final String[] symbols = {
            "M", "CM", "D", "CD",
            "C", "XC", "L", "XL",
            "X", "IX", "V", "IV",
            "I"
    };

    /**
     * 贪心。
     */
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length && num >= 0; i++) {
            while (values[i] <= num) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution12().intToRoman(1994)
        );
    }
}
