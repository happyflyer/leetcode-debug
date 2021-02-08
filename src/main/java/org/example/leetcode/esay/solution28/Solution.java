package org.example.leetcode.esay.solution28;

/**
 * 28. 实现 strStr()
 * https://leetcode-cn.com/problems/implement-strstr/
 *
 * @author lifei
 */
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        // 挨个比较字符
        // 超时...
        // needle.length()==0 && haystack.length()>0
        // needle.length()==0 && haystack.length()==0
        int i;
        int j;
        for (i = 0; i < haystack.length(); i++) {
            for (j = 0; j < needle.length(); j++) {
                // charAt条件是i+j<n，n=haystack.length()
                if (i + j >= haystack.length() || haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }
}
