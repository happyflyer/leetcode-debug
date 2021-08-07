package org.example.leetcode.jianzhi.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * @author lifei
 */
public class Leetcode3 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n <= 1) {
            return n;
        }
        int start = 0;
        int end = 0;
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (end < n) {
            char endChar = s.charAt(end);
            if (map.containsKey(endChar) && map.get(endChar) >= start) {
                start = map.get(endChar) + 1;
            }
            map.put(endChar, end);
            ans = Math.max(ans, end - start + 1);
            System.out.println("start = " + start + ", end = " + end + ", ans = " + ans);
            System.out.println(map);
            end++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(
                // new Leetcode3().lengthOfLongestSubstring("arabcacfr")
                // new Leetcode3().lengthOfLongestSubstring("abcabcbb")
                new Leetcode3().lengthOfLongestSubstring("aabaab!bb")
        );
    }
}
