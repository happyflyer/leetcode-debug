package org.example.leetcode.string.boring;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/zigzag-conversion/
 * <p>
 * 中等
 *
 * @author lifei
 */
public class Solution6 {
    /**
     * 模拟。
     */
    public String convert(String s, int numRows) {
        int n = s.length();
        if (n == 1) {
            return s;
        }
        // 每行一个 StringBuilder
        List<StringBuilder> rows = new ArrayList<>();
        numRows = Math.min(numRows, n);
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        // 模拟 Z 自行排列
        int cur = 0;
        boolean reverse = false;
        for (char c : s.toCharArray()) {
            rows.get(cur).append(c);
            // 最开始是正向、到底部就反向，到顶部就正向
            if (cur == 0 || cur == numRows - 1) {
                reverse = !reverse;
            }
            cur += reverse ? 1 : -1;
        }
        // 按行收集
        StringBuilder ans = new StringBuilder();
        for (StringBuilder row : rows) {
            ans.append(row);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution6().convert("PAYPALISHIRING", 4)
        );
    }
}
