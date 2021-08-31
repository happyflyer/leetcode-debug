package org.example.leetcode.string;

/**
 * https://leetcode-cn.com/problems/implement-strstr/
 * <p>
 * 简单
 *
 * @author lifei
 */
public class Solution28 {
    /**
     * 暴力法。
     */
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int n = haystack.length();
        int i;
        int j;
        for (i = 0; i < haystack.length(); i++) {
            for (j = 0; j < needle.length(); j++) {
                if (i + j >= n || haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 暴力法的优化版本。
     */
    public int strStr2(String haystack, String needle) {
        int n = haystack.length();
        int l = needle.length();
        for (int i = 0; i < n - l + 1; i++) {
            if (haystack.substring(i, i + l).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 朴素模式匹配算法。
     */
    public int strStr3(String haystack, String needle) {
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

    /**
     * KMP算法。
     */
    public int strStr4(String haystack, String needle) {
        int i = 1;
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

    public static void main(String[] args) {
        System.out.println(
                new Solution28().strStr4("hello", "ll")
        );
    }
}
