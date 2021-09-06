package org.example.exam.shopee2;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 输入："abc"
 * 输出：["abc","acb","bac","bca","cba","cab"]
 *
 * @author lifei
 */
public class Solution3 {
    public String[] permutation(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[] visited = new int[n];
        char[] path = new char[n];
        LinkedList<String> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            dfs(chars, n, visited, i, 0, path, list);
        }
        String[] res = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void dfs(char[] chars, int n, int[] visited, int pos,
                     int depth, char[] path, LinkedList<String> list) {
        if (depth == n) {
            list.add(new String(path));
            return;
        }
        if (visited[pos] == 1) {
            return;
        }
        visited[pos] = 1;
        path[depth] = chars[pos];
        if (depth == n - 1) {
            dfs(chars, n, visited, pos, depth + 1, path, list);
        } else {
            for (int i = 0; i < n; i++) {
                dfs(chars, n, visited, i, depth + 1, path, list);
            }
        }
        visited[pos] = 0;
    }

    public static void main(String[] args) {
        String s = "abc";
        System.out.println(
                Arrays.toString(
                        new Solution3().permutation(s)
                )
        );
    }
}
