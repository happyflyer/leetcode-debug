package org.example.exam.pdd1;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * 输入每个字符后的分数。
 * <p>
 * 输入：
 * 4
 * ()DD
 * 输出：
 * -1 1 -1 0
 * <p>
 * 输入：
 * 11
 * R))LL(((RR)
 * 输出：
 * 0 -1 -2 -2 -2 -1 2 -1 -1 -1 3
 *
 * @author lifei
 */
public class Solution3 {
    public int[] getScores(int n, String input) {
        int[] scores = new int[n];
        // 记录当前字符串
        StringBuilder sb = new StringBuilder();
        // 用于左右移动
        int pos = 0;
        for (int i = 0; i < n; i++) {
            char cur = input.charAt(i);
            if (cur == '(') {
                sb.insert(pos, '(');
                pos++;
            } else if (cur == ')') {
                sb.insert(pos, ')');
                pos++;
            } else if (cur == 'D') {
                pos--;
                sb.deleteCharAt(pos);
            } else if (cur == 'L') {
                if (sb.length() > 1 || pos > 1) {
                    pos--;
                }
            } else if (cur == 'R') {
                if (pos < sb.length()) {
                    pos++;
                }
            }
            scores[i] = getDepth(sb);
        }
        return scores;
    }

    /**
     * 括号深度
     */
    private int getDepth(CharSequence s) {
        int n = s.length();
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        int maxDepth = 0;
        for (int i = 0; i < n; i++) {
            char cur = s.charAt(i);
            if (cur == '(') {
                left.push(cur);
            } else if (cur == ')') {
                if (left.isEmpty() || left.peek() != '(') {
                    right.push(')');
                } else {
                    maxDepth = Math.max(maxDepth, left.size());
                    left.pop();
                }
            }
        }
        // 字符串不合法，返回负数
        if (!left.isEmpty() || !right.isEmpty()) {
            maxDepth = -(left.size() + right.size());
        }
        System.out.println(s + " 计算深度：" + maxDepth);
        return maxDepth;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String input = sc.next();
        System.out.println(
                Arrays.toString(
                        new Solution3().getScores(n, input)
                )
        );
    }
}
