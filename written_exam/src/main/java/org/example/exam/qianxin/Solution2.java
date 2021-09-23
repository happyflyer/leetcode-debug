package org.example.exam.qianxin;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 题目描述：
 * 输入：[0,1,2],2
 * 输出：["01","02","10","12","20","21"]
 * 说明：
 * 输入：[0,1,2,3,A],3
 * 输出：["012","013","01A","021","023","02A","031","032","03A","0A1","0A2","0A3","102","103","10A","120","123","12A","130","132","13A","1A0","1A2","1A3","201","203","20A","210","213","21A","230","231","23A","2A0","2A1","2A3","301","302","30A","310","312","31A","320","321","32A","3A0","3A1","3A2","A01","A02","A03","A10","A12","A13","A20","A21","A23","A30","A31","A32"]
 * 通过：AC
 *
 * @author lifei
 */
public class Solution2 {
    public String[] Permutation(char[] seed, int size) {
        int n = seed.length;
        List<String> ans = new LinkedList<>();
        dfs(seed, n, size, new int[n], 0, new char[size], ans);
        Collections.sort(ans);
        return ans.toArray(new String[0]);
    }

    private void dfs(char[] seed, int n, int size,
                     int[] visited,
                     int depth, char[] path,
                     List<String> ans) {
        if (depth == size) {
            ans.add(new String(path));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] == 1) {
                continue;
            }
            visited[i] = 1;
            path[depth] = seed[i];
            dfs(seed, n, size, visited, depth + 1, path, ans);
            visited[i] = 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                new Solution2().Permutation(new char[]{'0', '1', '2', '3', 'A'}, 3)
        ));
    }
}
