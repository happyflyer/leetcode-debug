package org.example.leetcode.normal.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 *
 * @author lifei
 */
public class Solution3 {
    /**
     * 滑动窗口
     * <p>
     * 假设我们选择字符串中的第 k 个字符作为起始位置，
     * 并且得到了不包含重复字符的最长子串的结束位置为 r_k，
     * 那么当我们选择第 k+1 个字符作为起始位置时，首先从 k+1 到 r_k 的字符显然是不重复的，
     * 并且由于少了原本的第 k 个字符，我们可以尝试继续增大 r_k，直到右侧出现了重复字符为止。
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> occ = new HashSet<>();
        int rk = 0;
        int ans = 0;
        for (int k = 0; k < n; k++) {
            // 删除上一个字符
            if (k > 0) {
                occ.remove(s.charAt(k - 1));
            }
            // 尝试继续增大 r_k
            while (rk < n && !occ.contains(s.charAt(rk))) {
                occ.add(s.charAt(rk));
                rk++;
            }
            ans = Math.max(ans, rk - k);
            // 当 rk==n 时，再向后移动 k 没有意义
            if (rk == n) {
                break;
            }
        }
        return ans;
    }

    /**
     * 滑动窗口
     * <p>
     * 遇到不重复的字符，就扩展窗口；
     * 遇到重复的字符，就调整窗口。
     */
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>(n);
        char c;
        int curLength = 0;
        int maxLength = 0;
        int startIndex = 0;
        for (int i = 0; i < n; i++) {
            c = s.charAt(i);
            if (!map.containsKey(c)) {
                // c 没有出现过，扩展窗口
                curLength++;
            } else {
                // c 出现过，收缩窗口
                maxLength = Math.max(maxLength, curLength);
                startIndex = Math.max(startIndex, map.get(c));
                curLength = i - startIndex;
            }
            map.put(c, i);
        }
        // 最后一个字符
        maxLength = Math.max(maxLength, curLength);
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution3().lengthOfLongestSubstring("abcabcbb")
        );
    }
}
