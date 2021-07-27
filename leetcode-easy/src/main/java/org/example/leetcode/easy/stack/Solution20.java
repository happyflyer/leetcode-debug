package org.example.leetcode.easy.stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 *
 * @author lifei
 */
public class Solution20 {
    private final Map<Character, Character> pairs;

    public Solution20() {
        pairs = new HashMap<>(3);
        pairs.put(')', '(');
        pairs.put(']', '[');
        pairs.put('}', '{');
    }

    /**
     * 栈
     * <p>
     * 遇到左括号就入栈
     * <p>
     * 遇到右括号时：
     * 如果栈中没有元素，直接false
     * 如果栈顶元素（一个左括号）与当前右括号不对应，直接false
     * 否则，左括号出栈
     * <p>
     * 循环，匹配完所有字符后，
     * 如果栈中还有元素，就false，否则，true
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
