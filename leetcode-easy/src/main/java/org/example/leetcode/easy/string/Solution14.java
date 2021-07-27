package org.example.leetcode.easy.string;

/**
 * https://leetcode-cn.com/problems/longest-common-prefix/
 *
 * @author lifei
 */
public class Solution14 {
    /**
     * 横向扫描
     */
    public String longestCommonPrefix(String[] strs) {
        int count = strs.length;
        String prefix = strs[0];
        for (int i = 1; i < count; i++) {
            prefix = commonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }
        return prefix;
    }

    private String commonPrefix(String s1, String s2) {
        int minLength = Math.min(s1.length(), s2.length());
        int i = 0;
        while (i < minLength && s1.charAt(i) == s2.charAt(i)) {
            i++;
        }
        return s1.substring(0, i);
    }

    /**
     * 纵向扫描
     */
    public String longestCommonPrefix2(String[] strs) {
        int count = strs.length;
        int length = strs[0].length();
        char c;
        for (int i = 0; i < length; i++) {
            c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    /**
     * 基于横向扫描，分治法
     */
    public String longestCommonPrefix3(String[] strs) {
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }

    private String longestCommonPrefix(String[] strs, int start, int end) {
        if (start == end) {
            return strs[start];
        } else {
            int mid = start + (end - start) / 2;
            String left = longestCommonPrefix(strs, start, mid);
            String right = longestCommonPrefix(strs, mid + 1, end);
            return commonPrefix(left, right);
        }
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution14().longestCommonPrefix2(
                        new String[]{"flower", "flow", "flight"}
                )
        );
    }
}
