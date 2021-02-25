package org.example.leetcode.normal.solution3;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * @author lifei
 */
class Solution1 {
    public int lengthOfLongestSubstring(String s) {
        // 暴力破解，双层循环，时间复杂度较高
        Set<Character> occ = new HashSet<>();
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            occ.clear();
            for (int j = i; j < n; j++) {
                if (!occ.contains(s.charAt(j))) {
                    occ.add(s.charAt(j));
                } else {
                    break;
                }
            }
            ans = Math.max(ans, occ.size());
        }
        return ans;
    }
}
