package org.example.leetcode.normal.string;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 *
 * @author lifei
 */
public class Solution5 {
    /**
     * 动态规划
     * <p>
     * 对于一个子串而言，如果它是回文串，并且长度大于 2，
     * 那么将它首尾的两个字母去除之后，它仍然是个回文串。
     * 例如对于字符串 “ababa”，
     * 如果我们已经知道 “bab” 是回文串，那么 “ababa” 一定是回文串，
     * 这是因为它的首尾两个字母都是 “a”
     * <p>
     * P(i,j) = true|false
     * 表示字符串 s 的第 i 到 j 个字母组成的串是否为回文串
     * <p>
     * 动态规划的转移方程：在子串长度大于 2 的前提下
     * P(i,j) = P(i+1,j-1) && (S_i==S_j)
     * <p>
     * 子串长度为 1 的情况：
     * P(i,i) = true
     * <p>
     * 子串长度为 2 的情况：
     * P(i,i+1) = (S_i==S_(i+1))
     * <p>
     * |0|1|2|3|4|
     * | |0|1|2|3|
     * | | |0|1|2|
     * | | | |0|1|
     * | | | | |0|
     */
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        // offset 在矩阵中表示距离主对角线的距离，在字符串中表示 j-i
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
