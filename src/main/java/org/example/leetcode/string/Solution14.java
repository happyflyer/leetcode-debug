package org.example.leetcode.string;

/**
 * https://leetcode-cn.com/problems/longest-common-prefix/
 * <p>
 * 简单。
 *
 * @author lifei
 */
public class Solution14 {
    /**
     * 纵向扫描。
     */
    public String longestCommonPrefix2(String[] strs) {
        int rows = strs.length;
        int cols = strs[0].length();
        char c;
        for (int i = 0; i < cols; i++) {
            c = strs[0].charAt(i);
            for (int j = 1; j < rows; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution14().longestCommonPrefix2(
                        new String[]{"flower", "flow", "flight"}
                )
        );
    }
}
