package org.example.leetcode.string.roman;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/roman-to-integer/
 * <p>
 * 简单
 *
 * @author lifei
 */
public class Solution13 {
    static Map<Character, Integer> map = new HashMap<>();

    static {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    /**
     * 前后指针。
     */
    public int romanToInt(String s) {
        int sum = 0;
        int prev = map.get(s.charAt(0));
        int cur;
        for (int i = 1; i < s.length(); i++) {
            cur = map.get(s.charAt(i));
            if (prev < cur) {
                sum -= prev;
            } else {
                sum += prev;
            }
            prev = cur;
        }
        // 最后一个字符
        sum += prev;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution13().romanToInt("MCMXCIV")
        );
    }
}
