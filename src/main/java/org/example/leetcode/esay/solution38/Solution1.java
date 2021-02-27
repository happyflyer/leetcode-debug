package org.example.leetcode.esay.solution38;

/**
 * 38. 外观数列
 * https://leetcode-cn.com/problems/count-and-say/
 *
 * @author lifei
 */
class Solution1 {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String s = countAndSay(n - 1);
        return getCountString(s);
    }

    public String getCountString(String s) {
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
}
