package org.example.exam.qqmusic;

/**
 * 题目描述：
 * 输入：5,3
 * 输出：5
 * 说明：
 * 输入：10,10
 * 输出：17
 * 通过：57.89%
 *
 * @author lifei
 */
public class Solution3 {
    public long minM(int n, int k) {
        long m = 0;
        while (n > 0) {
            m++;
            n -= getCount1(m, k);
        }
        return m;
    }

    /**
     * x在k进制下有几个1
     */
    private int getCount1(long x, int k) {
        int cnt = 0;
        while (x > 0) {
            cnt += x % k == 1 ? 1 : 0;
            x /= k;
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new Solution3().minM(10, 10));
    }
}
