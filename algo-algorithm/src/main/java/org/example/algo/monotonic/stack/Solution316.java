package org.example.algo.monotonic.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/remove-duplicate-letters/
 * <p>
 * 中等
 *
 * @author lifei
 */
public class Solution316 {
    public String removeDuplicateLetters(String s) {
        Deque<Character> stack = new LinkedList<>();
        int[] count = new int[256];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        boolean[] inStack = new boolean[256];
        for (char c : s.toCharArray()) {
            count[c]--;
            // 去重
            if (inStack[c]) {
                continue;
            }
            // 实现单调栈
            while (!stack.isEmpty() && stack.peek() > c) {
                // 避免去重去没了
                if (count[stack.peek()] == 0) {
                    break;
                }
                inStack[stack.pop()] = false;
            }
            stack.push(c);
            inStack[c] = true;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution316().removeDuplicateLetters("bcac"));
    }
}
