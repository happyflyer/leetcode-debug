package org.example.exam.webank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 题目描述：机甲移动。
 * 一台机甲在一个二维空间里移动，它的移动受到一串事先写好的指令的控制，每条指令会让它往特定方向移动一格。
 * 该空间为矩形，四周都是墙壁，无法通过，
 * 空间中每个格子位置的阻力不同，我们用一个数值来表示它的阻力，还有一些格子存在障碍无法通过。
 * 机器人每走一格，需要消耗能量，能量数为走之前和走之后位置的阻力数值中较大的那个数。
 * 当它的方向改变时，消耗能量 x，当它走向墙壁或者障碍物时，会停在原地并消耗能量 y（如果需要，仍会先改变方向）。
 * 一开始它位于整个空间的左上角，第一步移动不需要花能量改变方向，请计算它最后总共消耗了多少能量。
 * 第一行四个整数 n, m, x, y，（0 < n, m <= 100，1 <= x, y <= 100000）
 * 后面 n 行，每行 m 个数，形成一个方阵，表示各个格子位置的阻力数值，如果为 -1，表示该位置无法通过。
 * 各个位置的数值范围为 [-1, 100000]。
 * 最后一行一个字符串，由 hjkl 四种字母组成，表示指令序列。
 * h 表示向左移动一格，j 表示向下移动一格，k 表示向上移动一格，l 表示向右移动一格。
 * 字符串长度不超过 100000。
 * 输入：
 * 2 2 2 2
 * 1 2
 * -1 3
 * kjljk
 * 输出：
 * 20
 * 说明：
 * 通过：63%
 *
 * @author lifei
 */
public class Solution2 {
    public static int getAns(int n, int m, int x, int y, int[][] mat, String s) {
        int steps = s.length();
        int cost = 0;
        Map<Character, Integer[]> dMap = new HashMap<>();
        dMap.put('h', new Integer[]{0, -1});
        dMap.put('j', new Integer[]{1, 0});
        dMap.put('k', new Integer[]{-1, 0});
        dMap.put('l', new Integer[]{0, 1});
        int i = 0;
        int j = 0;
        for (int k = 0; k < steps; k++) {
            char cur = s.charAt(k);
            if (k > 0) {
                char prev = s.charAt(k - 1);
                if (prev != cur) {
                    cost += x;
                }
            }
            Integer[] d = dMap.get(cur);
            int expectX = i + d[0];
            int expectY = j + d[1];
            if (expectX < 0 || expectX == n
                    || expectY < 0 || expectY == m
                    || mat[expectX][expectY] == -1) {
                cost += y;
            } else {
                cost += Math.max(mat[i][j], mat[expectX][expectY]);
                i = expectX;
                j = expectY;
            }
        }
        return cost;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[][] mat = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        String s = sc.next();
        // int n = 2;
        // int m = 2;
        // int x = 2;
        // int y = 2;
        // int[][] mat = new int[][]{
        //         {1, 2},
        //         {-1, 3}
        // };
        // String s = "kjljk";
        System.out.println(getAns(n, m, x, y, mat, s));
    }
}
