package org.example.leetcode.string;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * <p>
 * 中等
 *
 * @author lifei
 */
public class Solution3 {
    /**
     * 双指针。
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>(n);
        int start = 0;
        int end;
        int max = 0;
        for (end = 0; end < n; end++) {
            if (map.containsKey(s.charAt(end))) {
                start = Math.max(start, map.get(s.charAt(end)) + 1);
            }
            map.put(s.charAt(end), end);
            max = Math.max(max, end - start + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution3().lengthOfLongestSubstring("pwwkew")
        );
    }
}
