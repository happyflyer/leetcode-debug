package org.example.leetcode.esay.solution28;

/**
 * 28. 实现 strStr()
 * https://leetcode-cn.com/problems/implement-strstr/
 *
 * @author lifei
 */
class Solution2 {
    public int strStr(String haystack, String needle) {
        // 挨个比较
        // 也不咋地...
        int n = haystack.length();
        int l = needle.length();
        for (int i = 0; i < n - l + 1; i++) {
            // substring的条件是i+l<=n，也就是i<=n-l，也就是i<n-l+1
            if (haystack.substring(i, i + l).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
