package org.example.algo.binarysearch;

/**
 * https://leetcode-cn.com/problems/koko-eating-bananas/
 * <p>
 * 中等
 *
 * @author lifei
 */
public class Solution875 {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 1000000000 + 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // if (f(piles, mid) == h) {
            //     right = mid;
            // } else if (f(piles, mid) < h) {
            //     right = mid;
            // } else if (f(piles, mid) > h) {
            //     left = mid + 1;
            // }
            if (f(piles, mid) <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 定义：速度为 x 时，需要 f(x) 小时吃完所有香蕉。
     * f(x) 随着 x 的增加单调递减。
     */
    private int f(int[] piles, int x) {
        int hours = 0;
        for (int pile : piles) {
            hours += pile / x;
            if (pile % x > 0) {
                hours++;
            }
        }
        return hours;
    }

    public static void main(String[] args) {
    }
}
