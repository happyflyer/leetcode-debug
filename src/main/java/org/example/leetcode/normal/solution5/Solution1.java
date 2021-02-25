package org.example.leetcode.normal.solution5;

/**
 * 5. 最长回文子串
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 * @author lifei
 */
public class Solution1 {
    public String longestPalindrome(String s) {
        // 暴力破解，超时！
        int n = s.length();
        int ans = 0;
        String res = "";
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (isPalindromeString(s.substring(i, j)) && j - i > ans) {
                    ans = j - i;
                    res = s.substring(i, j);
                }
            }
        }
        return res;
    }

    public boolean isPalindromeString(String s) {
        int i = 0;
        int n = s.length();
        while (i <= n - i - 1) {
            if (s.charAt(i) != s.charAt(n - i - 1)) {
                return false;
            }
            i++;
        }
        return true;
    }
}
