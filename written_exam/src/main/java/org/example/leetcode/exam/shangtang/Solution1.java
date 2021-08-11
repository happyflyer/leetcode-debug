package org.example.leetcode.exam.shangtang;

import java.util.Arrays;

/**
 * 图像顺时针旋转90度。
 * <p>
 * 输入：[[1,2,3],[4, 5, 6], [7, 8, 9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 *
 * @author lifei
 */
public class Solution1 {
    /**
     * 双层循环
     */
    public int[][] rotate_img(int[][] img) {
        int n = img.length;
        if (n == 0) {
            return new int[][]{};
        }
        int[][] ans = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = img[n - 1 - j][i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.deepToString(
                        new Solution1().rotate_img(
                                new int[][]{
                                        {1, 2, 3},
                                        {4, 5, 6},
                                        {7, 8, 9}
                                }
                        )
                )
        );
    }
}
