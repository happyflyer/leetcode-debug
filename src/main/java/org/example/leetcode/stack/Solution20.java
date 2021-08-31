package org.example.leetcode.stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 * <p>
 * 简单
 *
 * @author lifei
 */
public class Solution20 {
    static final Map<Character, Character> pairs = new HashMap<>(3);

    static {
        pairs.put(')', '(');
        pairs.put(']', '[');
        pairs.put('}', '{');
    }

    /**
     * 栈。
     */
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
        Deque<Character> stack = new LinkedList<>();
        char ch;
        for (int i = 0; i < n; i++) {
            ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                // 遇到右括号，看是否栈空、栈顶是否对应
                if (stack.isEmpty() || !stack.peek().equals(pairs.get(ch))) {
                    return false;
                }
                // 栈顶元素对应，出栈
                stack.pop();
            } else {
                // 遇到左括号就入栈
                stack.push(ch);
            }
        }
        // 还有左括号
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution20().isValid("()[]{}")
        );
    }
}
