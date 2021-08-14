package org.example.jianzhi.other;

/**
 * https://www.nowcoder.com/practice/28970c15befb4ff3a264189087b99ad4?tpId=13&tqId=11205
 *
 * @author lifei
 */
public class Jz52 {
    /**
     * 递归
     */
    public boolean match(String str, String pattern) {
        if (pattern.length() == 0) {
            return str.length() == 0;
        }
        // 一对一匹配 或 .
        boolean match = str.length() > 0
                && (str.charAt(0) == pattern.charAt(0)
                || pattern.charAt(0) == '.');
        // 有*
        if (pattern.length() > 1 && pattern.charAt(1) == '*') {
            // 0个 || 多个
            return match(str, pattern.substring(2))
                    || (match && match(str.substring(1), pattern));
        } else {
            // 无*
            return match && match(str.substring(1), pattern.substring(1));
        }
    }

    public static void main(String[] args) {
        System.out.println(
                new Jz52().match("aaa", "a*a")
        );
    }
}
