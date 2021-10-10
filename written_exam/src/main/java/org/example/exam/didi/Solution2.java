package org.example.exam.didi;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 题目描述：
 * 输入：
 * 6
 * 000111
 * 输出：
 * 6
 * 输入：
 * 6
 * 010101
 * 输出：
 * 6
 * 输入：
 * 6
 * 021331
 * 输出：
 * 2
 * 说明：
 * 通过：81
 *
 * @author lifei
 */
public class Solution2 {
    public static int getAns(String s) {
        int max = 0;
        int cur = 0;
        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            if (c == '1' && stack.peek() == '0') {
                stack.pop();
                cur += 2;
                continue;
            }
            if (c == '3' && stack.peek() == '2') {
                stack.pop();
                cur += 2;
                continue;
            }
            max = Math.max(max, cur);
            cur = 0;
            stack.push(c);
        }
        max = Math.max(max, cur);
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // String s = sc.next();
        int n = 6;
        String s = "202313";
        System.out.println(getAns(s));
    }
}
