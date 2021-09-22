package org.example.exam.vivo;

import java.util.Arrays;

/**
 * 题目描述：
 * 输入：
 * [
 * [60,35,20],
 * [30,40,30],
 * [40,50,40],
 * [50,60,50],
 * [55,45,60]
 * ]
 * 输出：
 * 3
 * 说明：
 * 输入：
 * 输入：
 * [
 * [4,5,1,1],
 * [6,4,2,2],
 * [7,3,3,3]
 * ]
 * 输出：
 * 0
 * 通过：40
 *
 * @author lifei
 */
public class Solution3 {
    public int maxRollingHeroes(int[][] heroes) {
        Arrays.sort(heroes, this::oneLarger);
        // System.out.println(Arrays.deepToString(heroes));
        int ans = 0;
        int[] prev = heroes[0];
        for (int i = 1; i < heroes.length; i++) {
            int[] cur = heroes[i];
            if (allLarger(cur, prev) > 0) {
                if (i == 1) {
                    ans += 2;
                } else {
                    ans++;
                }
            }
            prev = cur;
        }
        return ans;
    }

    private int oneLarger(int[] a, int[] b) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            if (a[i] > b[i]) {
                return 1;
            }
        }
        return -1;
    }

    private int allLarger(int[] a, int[] b) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            if (a[i] < b[i]) {
                return -1;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        int[][] heroes = new int[][]{
                {60, 35, 20},
                {30, 40, 30},
                {40, 50, 40},
                {50, 60, 50},
                {55, 45, 60}
        };
        // int[][] heroes = new int[][]{
        //         {4, 5, 1, 1},
        //         {6, 4, 2, 2},
        //         {7, 3, 3, 3}
        // };
        System.out.println(new Solution3().maxRollingHeroes(heroes));
    }
}
