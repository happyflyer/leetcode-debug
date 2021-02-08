package org.example.leetcode.esay.solution28.kmp;

/**
 * 28. 实现 strStr()
 * https://leetcode-cn.com/problems/implement-strstr/
 *
 * @author lifei
 */
class Solution2 {
    public int strStr(String haystack, String needle) {
        // https://github.com/happyflyer/wangdao-data-structure/blob/main/ch4/README.md#6-KMP-%E7%AE%97%E6%B3%95
        // KMP匹配算法，主串指针i不回溯，只有模式串指针j回溯
        // 位置编号从1开始
        // 主串指针i
        int i = 1;
        // 模式串指针j
        int j = 1;
        // int[] next = getNext(needle);
        int[] next = getNextVal(needle);
        while (i <= haystack.length() && j <= needle.length()) {
            if (j == 0 || haystack.charAt(i - 1) == needle.charAt(j - 1)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if (j > needle.length()) {
            return i - needle.length() - 1;
        }
        return -1;
    }

    public int[] getNext(String needle) {
        int[] next = new int[needle.length() + 1];
        int i = 1;
        int j = 0;
        if (needle.length() > 0) {
            next[1] = 0;
        }
        while (i < needle.length()) {
            if (j == 0 || needle.charAt(i - 1) == needle.charAt(j - 1)) {
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        }
        return next;
    }

    public int[] getNextVal(String needle) {
        int[] next = getNext(needle);
        int[] nextVal = new int[needle.length() + 1];
        if (needle.length() > 0) {
            nextVal[1] = 0;
        }
        for (int j = 2; j <= needle.length(); j++) {
            if (needle.charAt(next[j] - 1) == needle.charAt(j - 1)) {
                nextVal[j] = nextVal[next[j]];
            } else {
                nextVal[j] = next[j];
            }
        }
        return nextVal;
    }
}
