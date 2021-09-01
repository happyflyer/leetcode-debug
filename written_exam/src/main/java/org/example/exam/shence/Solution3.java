package org.example.exam.shence;

import java.util.*;

/**
 * 输入：
 * (1)
 * 输出：
 * 1
 * 0
 * 2
 * <p>
 * 输入：
 * (1)23(4()5)6
 * 输出：
 * 3
 * 0
 * 2
 * 5
 * 10
 * 7
 * 8
 * <p>
 * 输入：
 * ()(()(()))
 * 输出：
 * 5
 * 0
 * 1
 * 2
 * 9
 * 3
 * 4
 * 5
 * 8
 * 6
 * 7
 *
 * @author lifei
 */
public class Solution3 {
    public static Map<Integer, Integer> getAns(String s, int[] arr) {
        int n = s.length();
        Deque<Integer> stack = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                arr[0]++;
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                int x = stack.peek();
                map.put(x, i);
                stack.pop();
            }
        }
        return map;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int[] cnt = new int[1];
        Map<Integer, Integer> map = getAns(s, cnt);
        System.out.println(cnt[0]);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }
    }
}
