package org.example.algo.slidewindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * https://leetcode-cn.com/problems/minimum-window-substring/
 * <p>
 * 困难
 *
 * @author lifei
 */
public class Solution76 {
    /**
     * 1、我们在字符串 S 中使用双指针中的左右指针技巧，初始化 left = right = 0，
     * 把索引左闭右开区间 [left, right) 称为一个「窗口」。
     * 2、我们先不断地增加 right 指针扩大窗口 [left, right)，
     * 直到窗口中的字符串符合要求（包含了 T 中的所有字符）。
     * 3、此时，我们停止增加 right，转而不断增加 left 指针缩小窗口 [left, right)，
     * 直到窗口中的字符串不再符合要求（不包含 T 中的所有字符了）。
     * 同时，每次增加 left，我们都要更新一轮结果。
     * 4、重复第 2 和第 3 步，直到 right 到达字符串 S 的尽头。
     */
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        int start = 0;
        int len = Integer.MAX_VALUE;
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.getOrDefault(c, 0) > 0) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (Objects.equals(window.get(c), need.get(c))) {
                    valid++;
                }
            }
            while (valid == need.size()) {
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                char d = s.charAt(left);
                left++;
                if (need.getOrDefault(d, 0) > 0) {
                    if (Objects.equals(window.get(d), need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public static void main(String[] args) {
        System.out.println(new Solution76().minWindow("a", "aa"));
    }
}
