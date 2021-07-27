package org.example.leetcode.normal.string;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
 *
 * @author lifei
 */
public class Solution8 {
    /**
     * 自动机
     */
    public int myAtoi(String s) {
        Automaton automaton = new Automaton();
        int length = s.length();
        for (int i = 0; i < length; ++i) {
            automaton.get(s.charAt(i));
        }
        return (int) (automaton.sign * automaton.ans);
    }

    class Automaton {
        public int sign = 1;
        public long ans = 0;
        private String state = "start";
        private Map<String, String[]> table;

        public Automaton() {
            table = new HashMap<>();
            table.put("start", new String[]{"start", "signed", "in_number", "end"});
            table.put("signed", new String[]{"end", "end", "in_number", "end"});
            table.put("in_number", new String[]{"end", "end", "in_number", "end"});
            table.put("end", new String[]{"end", "end", "end", "end"});
        }

        public void get(char c) {
            state = table.get(state)[get_col(c)];
            if ("in_number".equals(state)) {
                ans = ans * 10 + c - '0';
                ans = sign == 1
                        ? Math.min(ans, Integer.MAX_VALUE)
                        : Math.min(ans, -(long) Integer.MIN_VALUE);
            } else if ("signed".equals(state)) {
                sign = c == '+' ? 1 : -1;
            }
        }

        private int get_col(char c) {
            if (c == ' ') {
                return 0;
            }
            if (c == '+' || c == '-') {
                return 1;
            }
            if (Character.isDigit(c)) {
                return 2;
            }
            return 3;
        }
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution8().myAtoi("4193 with words")
        );
    }
}
