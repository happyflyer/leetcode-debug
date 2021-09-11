package org.example.exam.tianyiyun;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 题目描述：不重复最长子串长度
 * 输入：abcabcbb
 * 输出：3
 * 说明：
 * 通过：AC
 *
 * @author lifei
 */
public class Solution1 {
    public static int getAns(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>(n);
        int start = 0;
        int end;
        int max = 0;
        for (end = 0; end < n; end++) {
            if (map.containsKey(s.charAt(end))) {
                start = Math.max(start, map.get(s.charAt(end)) + 1);
            }
            map.put(s.charAt(end), end);
            max = Math.max(max, end - start + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(getAns(s));
    }
}
