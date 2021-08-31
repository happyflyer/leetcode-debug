package org.example.leetcode.dp;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * <p>
 * 中等
 *
 * @author lifei
 */
public class Solution5 {
    /**
     * 动态规划。
     * P(i, j) 表示字符串s的第i到j个字母组成的串是否为回文串（包括j）。
     * 只有1个字符，if i==j, P(i, i) = true;
     * 有两个字符，if i+1=j, P(i,i+1) = (S_i==S_(i+1));
     * 子串长度大于2，P(i, j) = P(i+1,j-1) && (S_i==S_j)
     */
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        // offset 在矩阵中表示与主对角线的距离，在字符串中表示j-i
        for (int offset = 0; offset < n; offset++) {
            for (int i = 0; i < n - offset; i++) {
                int j = i + offset;
                boolean isEqual = s.charAt(i) == s.charAt(j);
                if (offset == 0) {
                    dp[i][j] = true;
                } else if (offset == 1) {
                    dp[i][j] = isEqual;
                } else {
                    dp[i][j] = dp[i + 1][j - 1] && isEqual;
                }
                if (dp[i][j] && offset + 1 > ans.length()) {
                    ans = s.substring(i, i + 1 + offset);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution5().longestPalindrome("babad")
        );
    }
}
