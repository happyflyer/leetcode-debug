package org.example.leetcode.exam.meituan;

/**
 * 求数列的和，
 * 数列第一项为 n，以后各项为前一项的平方根，求数列的前 m 项之和
 * <p>
 * 输入：81,4
 * 输出：94.73
 * <p>
 * 输入：2,2
 * 输出：3.41
 *
 * @author lifei
 */
public class Solution2 {
    public double getSum(int n, int m) {
        double sum = 0d;
        double nd = n;
        while (m-- > 0) {
            sum += nd;
            nd = Math.sqrt(nd);
        }
        int ni = (int) (sum * 100);
        return ni / 100.0;
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution2().getSum(81, 4)
        );
    }
}
