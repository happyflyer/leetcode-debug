package org.example.leetcode.exam.yuanfudao;

import java.util.Scanner;
import java.util.Stack;

/**
 * 数箱子。
 * <p>
 * 输入：[]3
 * 输出：3
 * <p>
 * 输入：[][[][][]2]3
 * 输出：16
 * <p>
 * 输入：[][][[[]3[]2]2]2
 * 输出：28
 * <p>
 * 输入：[][[]]2
 * 输出：5
 *
 * @author lifei
 */
public class Solution2 {
    public static final char LEFT = '[';
    public static final char RIGHT = ']';

    public int countBoxes(String boxes) {
        return countMultiNode(boxes);
    }

    /**
     * 解析多个节点，使用栈，一个一个数
     */
    private int countMultiNode(String s) {
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            sb.append(c);
            if (c == LEFT) {
                stack.push(LEFT);
            }
            if (c == RIGHT) {
                stack.pop();
            }
            boolean end = i == n - 1 || s.charAt(i + 1) == LEFT;
            if (stack.isEmpty() && end) {
                count += countOneNode(sb.toString());
                sb = new StringBuilder();
            }
        }
        return count;
    }

    /**
     * 解析单个节点，递归
     */
    private int countOneNode(String s) {
        System.out.println("s = " + s);
        int n = s.length();
        if (n == 2) {
            return 1;
        }
        char last = s.charAt(n - 1);
        if (n == 3) {
            return Character.getNumericValue(last);
        }
        if (Character.isDigit(last)) {
            return (1 + countMultiNode(s.substring(1, n - 2))) * Character.getNumericValue(last);
        } else {
            return 1 + countMultiNode(s.substring(1, n - 1));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String boxes = sc.nextLine();
        System.out.println(boxes);
        System.out.println(new Solution2().countBoxes(boxes));
    }
}
