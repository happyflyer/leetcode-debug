package org.example.exam.xiaohongshu;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 段式回文类似于回文，最小的单位可以是多个字符而不仅是单个字母
 * 例如：一般的回文字符串形式如“level、noon、civic”，而“gotogo”不是，
 * 但如果我们把“gotogo”分为“go”、“to”、“go”三段，则可以认为“go to go”是段式回文
 * 给定一个字符串s（s仅由小写英文字母组成，且s长度<= 30），
 * 请将s分割成一些子串，使每个子串都是段式回文。返回s所有可能的分割方案的个数
 * 例如gotogo，可有6种分隔方案，即：
 * [g, o, t, o, g, o],
 * [g, o, t, ogo],
 * [g, oto, g, o],
 * [g, otogo],
 * [gotog, o],
 * [gotogo]
 * <p>
 * 输入：gotogo
 * 输出：6
 * <p>
 * leetcode 132 ac
 *
 * @author lifei
 */
public class Solution2 {
    public int partitionNumber(String text) {
        int n = text.length();
        boolean[][] g = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(g[i], true);
        }
        for (int i = n - 1; i >= 0; --i) {
            for (int j = i + 1; j < n; j++) {
                g[i][j] = g[i + 1][j - 1] && text.charAt(i) == text.charAt(j);
            }
        }
        int[] f = new int[n];
        for (int i = 0; i < n; i++) {
            if (g[0][i]) {
                f[i] = 0;
            } else {
                for (int j = 0; j < i; j++) {
                    if (g[j + 1][i]) {
                        f[i] = Math.min(f[i], f[j] + 1);
                    }
                }
            }
        }
        return f[n - 1];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;
        String _text;
        try {
            _text = in.nextLine();
        } catch (Exception e) {
            _text = null;
        }
        res = new Solution2().partitionNumber(_text);
        System.out.println(String.valueOf(res));
    }
}
