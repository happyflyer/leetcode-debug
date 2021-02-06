package org.example.leetcode.esay.solution14;

/**
 * 14. 最长公共前缀
 * https://leetcode-cn.com/problems/longest-common-prefix/
 *
 * @author lifei
 */
public class Solution4 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        // 基于横向扫描，二分查找
        int minLength = Integer.MAX_VALUE;
        for (String str : strs) {
            minLength = Math.min(minLength, str.length());
        }
        int low = 0;
        int high = minLength;
        int mid;
        while (low < high) {
            mid = low + (high - low + 1) / 2;
            if (isCommonPrefix(strs, mid)) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return strs[0].substring(0, low);
    }

    private boolean isCommonPrefix(String[] strs, int length) {
        String str0 = strs[0].substring(0, length);
        int count = strs.length;
        for (int i = 1; i < count; i++) {
            for (int j = 0; j < length; j++) {
                if (str0.charAt(j) != strs[i].charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}
