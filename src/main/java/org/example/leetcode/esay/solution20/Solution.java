package org.example.leetcode.esay.solution20;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 20. 有效的括号
 * https://leetcode-cn.com/problems/valid-parentheses/
 *
 * @author lifei
 */
class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }
        // 栈
        // 遇到左括号就入栈
        // 遇到右括号时：
        // 如果栈中没有元素，直接false
        // 如果栈顶元素（一个左括号）与当前右括号不对应，直接false，否则，左括号出栈
        // 循环，匹配完所有字符后，
        // 如果栈中还有元素，就false，否则，true
        Map<Character, Character> pairs = new HashMap<>(3);
        pairs.put(')', '(');
        pairs.put(']', '[');
        pairs.put('}', '{');
        Deque<Character> stack = new LinkedList<>();
        char ch;
        for (int i = 0; i < n; i++) {
            ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                if (stack.isEmpty() || !stack.peek().equals(pairs.get(ch))) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
