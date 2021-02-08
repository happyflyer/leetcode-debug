package org.example.leetcode.esay.solution28.kmp;

/**
 * 28. 实现 strStr()
 * https://leetcode-cn.com/problems/implement-strstr/
 *
 * @author lifei
 */
class Solution1 {
    public int strStr(String haystack, String needle) {
        // 朴素模式匹配算法
        // 记录主串中的匹配开始位置
        // 位置编号从1开始
        int k = 1;
        int i = k;
        int j = 1;
        while (i <= haystack.length() && j <= needle.length()) {
            if (haystack.charAt(i - 1) == needle.charAt(j - 1)) {
                i++;
                j++;
            } else {
                k++;
                // 匹配失败时，指针i在回溯，这种情况经常发生
                i = k;
                j = 1;
            }
        }
        if (j > needle.length()) {
            return k - 1;
        }
        return -1;
    }
}
