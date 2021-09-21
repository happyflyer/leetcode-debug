package org.example.algo.slidewindow;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/find-all-anagrams-in-a-string/
 * <p>
 * 中等
 *
 * @author lifei
 */
public class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        int left = 0;
        int right = 0;
        int valid = 0;
        List<Integer> res = new LinkedList<>();
        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.getOrDefault(c, 0) > 0) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (Objects.equals(window.get(c), need.get(c))) {
                    valid++;
                }
            }
            while (right - left >= p.length()) {
                if (valid == need.size()) {
                    res.add(left);
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
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution438().findAnagrams("cbaebabacd", "abc"));
    }
}
