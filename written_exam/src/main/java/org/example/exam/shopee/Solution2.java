package org.example.exam.shopee;

/**
 * 掰花瓣，
 * 手上有 n 朵花，每朵的花瓣数保存在一个数组中。
 * 我们每次可以选择任意一朵，拿走其中的一瓣或者两瓣，求掰完所有花的最少次数。
 * <p>
 * 输入：[4,2,1]
 * 输出：4
 * <p>
 * 输入：[2,3,10]
 * 输出：8
 * <p>
 * 输入：[0,1]
 * 输出：1
 *
 * @author lifei
 */
public class Solution2 {
    /**
     * 简单题
     */
    public int petalsBreak(int[] petals) {
        int cnt = 0;
        for (int p : petals) {
            cnt += p / 2 + p % 2;
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution2().petalsBreak(
                        new int[]{2, 3, 10}
                )
        );
    }
}
