package org.example.exam.kedaxunfei2;

import java.util.Scanner;

/**
 * 题目描述：
 * 输入：
 * 3 3
 * .##
 * ##.
 * ...
 * 输出：
 * 1
 * 输入：
 * 3 3
 * .##
 * #.#
 * ##.
 * 输出：
 * 2
 * 说明：
 * 通过：
 *
 * @author lifei
 */
public class Solution3 {
    public static int getAns(int n, int m, String[][] maze) {
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // int m = sc.nextInt();
        // String[][] maze = new String[n][m];
        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < m; j++) {
        //         maze[i][j] = sc.next();
        //     }
        // }
        int n = 3;
        int m = 3;
        // String[][] maze = new String[][]{
        //         {".", "#", "#"},
        //         {"#", "#", "."},
        //         {".", ".", "."},
        // };
        String[][] maze = new String[][]{
                {".", "#", "#"},
                {"#", ".", "#"},
                {"#", "#", "."},
        };
        System.out.println(getAns(n, m, maze));
    }
}
