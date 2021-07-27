package org.example.leetcode.easy.string;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/roman-to-integer/
 *
 * @author lifei
 */
public class Solution13 {
    Map<Character, Integer> map = new HashMap<>();

    public Solution13() {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    /**
     * 模拟
     * <p>
     * I, II, III, IV, V, VI, VII, VIII, IX, X
     * X, XX, XXX, XL, L, LX, LXX, LXXX, XC, C
     * <p>
     * 发现的规律：
     * 一个字母所代表的数字，如果前面一个数字比后面小，前面这个数字的符号为就是负
     * 如果前面一个数字大于等于后面数字，前面这个数字就是正数
     */
    public int romanToInt(String s) {
        int sum = 0;
        int preNum = map.get(s.charAt(0));
        int num;
        for (int i = 1; i < s.length(); i++) {
            num = map.get(s.charAt(i));
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

    public static void main(String[] args) {
        System.out.println(
                new Solution13().romanToInt("MCMXCIV")
        );
    }
}
