package org.example.exam.baidu;

import java.util.regex.Pattern;

/**
 * https:// www.nowcoder.com/practice/e69148f8528c4039ad89bb2546fd4ff8?tpId=13
 * <p>
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串”+100”,”5e2”,”-123”,”3.1416”和”-1E-16”都表示数值。
 * 但是”12e”,”1a3.14”,”1.2.3”,”+-5”和”12e+4.3”都不是。
 *
 * @author lifei
 */
public class Solution1 {
    /**
     * 正则
     */
    public boolean isNumeric(String str) {
        final String p = "[+-]?(\\d+|\\d+\\.\\d*|\\.\\d+)([eE][+-]?\\d+)?";
        return Pattern.matches(p, str.trim());
    }

    public boolean isNumeric2(String str) {
        str = str.trim();
        int n = str.length();
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return Character.isDigit(str.charAt(0));
        }
        // int signed = -1;
        int number = -1;
        int dot = -1;
        int exp = -1;
        for (int i = 0; i < n; i++) {
            char prev = i > 0 ? str.charAt(i - 1) : '\0';
            char cur = str.charAt(i);
            char next = i < n - 1 ? str.charAt(i + 1) : '\0';
            if (cur == '+' || cur == '-') {
                // 第一位出现，或者e之后出现
                if (i == 0) {
                    continue;
                }
                if (exp == -1) {
                    return false;
                }
                // +-之后必须是数字或小数点
                if (!Character.isDigit(next) && next != '.') {
                    return false;
                }
                // signed = i;
            } else if (cur == '.') {
                // .只能出现一次
                // 指数中不能出现.
                if (dot != -1 || exp != -1) {
                    return false;
                }
                // .前面或后面必须有数字
                if (!Character.isDigit(prev) && !Character.isDigit(next)) {
                    return false;
                }
                dot = i;
            } else if (cur == 'e' || cur == 'E') {
                // e只能出现一次
                // e不能是最后一个
                // e前面必须有数字
                if (exp != -1 || i == n - 1 || number == -1) {
                    return false;
                }
                exp = i;
            } else {
                if (!Character.isDigit(cur)) {
                    return false;
                } else {
                    if (number == -1) {
                        number = i;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        String[] strings = new String[]{
                "+100", "5e2", "-123", "3.1416", "-1E-16",
                "12e", "1a3.14", "1.2.3", "+-5", "12e+4.3",
                "+", "e", ".", "0", " 0", ".1",
                "3.", "e9", "-.", "-.123", "  1 ",
                " ", "1e+"
        };
        boolean[] booleans = new boolean[]{
                true, true, true, true, true,
                false, false, false, false, false,
                false, false, false, true, true,
                true, true, false, false, true, true,
                false, false
        };
        for (int i = 0; i < strings.length; i++) {
            System.out.println("字符串 '" + strings[i] + "' 是否是数字："
                    + booleans[i] + "，计算结果是："
                    + solution1.isNumeric(strings[i])
                    + "，结果是否一致："
                    + (booleans[i] == solution1.isNumeric(strings[i])));
        }
    }
}
