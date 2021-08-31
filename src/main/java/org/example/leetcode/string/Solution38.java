package org.example.leetcode.string;

/**
 * https://leetcode-cn.com/problems/count-and-say/
 * <p>
 * 中等
 *
 * @author lifei
 */
public class Solution38 {
    /**
     * 递归。
     */
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String s = countAndSay(n - 1);
        return getCountString(s);
    }

    private String getCountString(String s) {
        StringBuilder result = new StringBuilder();
        int count = 1;
        char preNum = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == preNum) {
                count++;
            } else {
                result.append(count).append(preNum);
                count = 1;
                preNum = s.charAt(i);
            }
        }
        result.append(count).append(preNum);
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution38().countAndSay(4)
        );
    }
}
