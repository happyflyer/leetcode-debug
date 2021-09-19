package org.example.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 * <p>
 * 中等
 *
 * @author lifei
 */
public class Solution22 {
    /**
     * 深度优先+剪枝。
     */
    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<>();
        if (n == 0) {
            return combinations;
        }
        dfs("", 0, 0, n, combinations);
        return combinations;
    }

    public void dfs(String cur, int left, int right, int n, List<String> ans) {
        if (left == n && right == n) {
            ans.add(cur);
            return;
        }
        // 剪枝
        if (left < right) {
            return;
        }
        if (left < n) {
            dfs(cur + "(", left + 1, right, n, ans);
        }
        if (right < n) {
            dfs(cur + ")", left, right + 1, n, ans);
        }
    }

    /**
     * 广度优先（借助队列）。
     */
    public List<String> generateParenthesis2(int n) {
        List<String> combinations = new ArrayList<>();
        if (n == 0) {
            return combinations;
        }
        bfs(n, combinations);
        return combinations;
    }

    public void bfs(int n, List<String> ans) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node("", n, n));
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (cur.left == 0 && cur.right == 0) {
                ans.add(cur.val);
            }
            if (cur.left > 0) {
                queue.offer(new Node(cur.val + "(", cur.left - 1, cur.right));
            }
            if (cur.right > 0 && cur.left < cur.right) {
                queue.offer(new Node(cur.val + ")", cur.left, cur.right - 1));
            }
        }
    }

    public static class Node {
        String val;
        int left;
        int right;

        public Node(String val, int left, int right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        List<String> ans = new Solution22().generateParenthesis(4);
        System.out.println(ans);
    }
}
