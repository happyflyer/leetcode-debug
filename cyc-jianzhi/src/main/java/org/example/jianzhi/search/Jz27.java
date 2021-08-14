package org.example.jianzhi.search;

import java.util.ArrayList;

/**
 * https://www.nowcoder.com/practice/fe6b651b66ae47d7acce78ffdd9a96c7?tpId=13&tqId=11180
 *
 * @author lifei
 */
public class Jz27 {
    public ArrayList<String> Permutation(String str) {
        int n = str.length();
        ArrayList<String> list = new ArrayList<>();
        dfs(list, str.toCharArray(), new int[n], 0, new char[n]);
        return list;
    }

    private void dfs(ArrayList<String> list, char[] chars, int[] visited,
                     int len, char[] collected) {
        // 找到
        if (len == chars.length) {
            String s = new String(collected);
            // 去重
            if (!list.contains(s)) {
                list.add(s);
            }
        }
        for (int i = 0; i < chars.length; i++) {
            // 访问过
            if (visited[i] == 1) {
                continue;
            }
            visited[i] = 1;
            collected[len] = chars[i];
            dfs(list, chars, visited, len + 1, collected);
            visited[i] = 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(
                new Jz27().Permutation("aa")
        );
    }
}
