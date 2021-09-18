package org.example.exam.wangyigame;

import java.util.*;

/**
 * 题目描述：
 * 输入：{"itemBuy":[{"roleName":"xiaolin","level":69,"roleId":10000009,"items":[{"itemId":1001,"num":10,"cash":100}]}]}
 * 输出：5
 * 说明：
 * 输入：{}
 * 输出：1
 * 通过：30%
 *
 * @author lifei
 */
public class Solution3 {
    public static int getAns(String s) {
        Deque<Character> stack = new LinkedList<>();
        int depth = 0;
        for (char c : s.toCharArray()) {
            if (c == '{' || c == '[') {
                stack.push(c);
            } else if (c == '}' || c == ']') {
                depth = Math.max(depth, stack.size());
            }
        }
        return depth;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(getAns(s));
    }
}
