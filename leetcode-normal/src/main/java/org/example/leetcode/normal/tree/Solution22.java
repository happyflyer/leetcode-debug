package org.example.leetcode.normal.tree;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 *
 * @author lifei
 */
public class Solution22 {
    /**
     * 暴力法
     * <p>
     * 生成所有 2^(2n) 个由 ( 和 ) 构成的序列，
     * 检查每一个是否有效。
     */
    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<>(n * 2);
        generateAll(new char[n * 2], 0, combinations);
        return combinations;
    }

    private void generateAll(char[] arr, int pos, List<String> ans) {
        if (pos == arr.length) {
            if (isBalance(arr)) {
                ans.add(new String(arr));
            }
        } else {
            arr[pos] = '(';
            generateAll(arr, pos + 1, ans);
            arr[pos] = ')';
            generateAll(arr, pos + 1, ans);
        }
    }

    private boolean isBalance(char[] arr) {
        int balance = 0;
        for (char c : arr) {
            if (c == '(') {
                balance++;
            } else {
                balance--;
            }
            // 右括号多了
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }

    /**
     * 回溯法，
     * 暴力法的优化版本。
     * <p>
     * 左括号数量不大于 n，我们可以放一个左括号；
     * 如果右括号数量小于左括号的数量，我们可以放一个右括号。
     */
    public List<String> generateParenthesis2(int n) {
        List<String> combinations = new ArrayList<>();
        backTrack(new char[n * 2], 0, 0, 0, n, combinations);
        return combinations;
    }

    private void backTrack(char[] arr, int pos, int open, int close, int max, List<String> ans) {
        if (pos == max * 2) {
            ans.add(new String(arr));
        }
        if (open < max) {
            arr[pos] = '(';
            backTrack(arr, pos + 1, open + 1, close, max, ans);
        }
        if (close < open) {
            arr[pos] = ')';
            backTrack(arr, pos + 1, open, close + 1, max, ans);
        }
    }

    /**
     * 递归，
     * 按括号序列的长度递归
     * <p>
     * 任何一个括号序列都一定是由 "(" 开头，并且第一个 "(" 一定有一个唯一与之对应的 ")"，
     * 每一个括号序列可以用 "(a)b" 来表示，
     * 其中 a 与 b 分别是一个合法的括号序列（可以为空）。
     */
    public List<String> generateParenthesis3(int n) {
        cache = new HashMap<>(n);
        return generate(n);
    }

    /**
     * 加速递归计算
     */
    Map<Integer, List<String>> cache;

    public List<String> generate(int n) {
        if (cache.get(n) != null) {
            return cache.get(n);
        }
        List<String> ans = new ArrayList<>();
        if (n == 0) {
            ans.add("");
        } else {
            for (int i = n - 1; i >= 0; i--) {
                for (String a : generate(i)) {
                    for (String b : generate(n - i - 1)) {
                        ans.add("(" + a + ")" + b);
                    }
                }
            }
        }
        cache.put(n, ans);
        return ans;
    }

    /**
     * 深度优先遍历
     * <p>
     * 0                   ""
     * |                /      \
     * 1              "("       ")"
     * |            /      \
     * 2         "(("      "()"
     * |       /    \     /
     * 3    "(((" "(()" "()("
     */
    public List<String> generateParenthesis4(int n) {
        List<String> combinations = new ArrayList<>();
        if (n == 0) {
            return combinations;
        }
        dfs("", 0, 0, n, combinations);
        return combinations;
    }

    /**
     * 加法
     */
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
     * 深度优先遍历
     */
    public List<String> generateParenthesis5(int n) {
        List<String> combinations = new ArrayList<>();
        if (n == 0) {
            return combinations;
        }
        dfs("", n, n, combinations);
        return combinations;
    }

    /**
     * 减法
     */
    public void dfs(String cur, int left, int right, List<String> ans) {
        if (left == 0 && right == 0) {
            ans.add(cur);
            return;
        }
        if (left > right) {
            return;
        }
        if (left > 0) {
            dfs(cur + "(", left - 1, right, ans);
        }
        if (right > 0) {
            dfs(cur + ")", left, right - 1, ans);
        }
    }

    /**
     * 广度优先遍历
     * <p>
     * 0                   ""
     * |                /      \
     * 1              "("       ")"
     * |            /      \
     * 2         "(("      "()"
     * |       /    \     /
     * 3    "(((" "(()" "()("
     */
    public List<String> generateParenthesis6(int n) {
        List<String> combinations = new ArrayList<>();
        if (n == 0) {
            return combinations;
        }
        bfs(n, combinations);
        return combinations;
    }

    /**
     * 减法
     */
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
        System.out.println(
                new Solution22().generateParenthesis6(3)
        );
    }
}
