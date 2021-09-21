package org.example.algo.slidewindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * https://leetcode-cn.com/problems/permutation-in-string/
 * <p>
 * 中等
 *
 * @author lifei
 */
public class Solution567 {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            if (need.getOrDefault(c, 0) > 0) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (Objects.equals(window.get(c), need.get(c))) {
                    valid++;
                }
            }
            while (right - left >= s1.length()) {
                if (valid == need.size()) {
                    return true;
                }
                char d = s2.charAt(left);
                left++;
                if (need.getOrDefault(d, 0) > 0) {
                    if (Objects.equals(window.get(d), need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Solution567().checkInclusion("abcdxabcde", "abcdeabcdx"));
    }
}
