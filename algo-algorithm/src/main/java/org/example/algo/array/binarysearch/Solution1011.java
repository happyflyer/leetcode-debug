package org.example.algo.array.binarysearch;

/**
 * https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/
 * <p>
 * 中等
 *
 * @author lifei
 */
public class Solution1011 {
    public int shipWithinDays(int[] weights, int days) {
        int left = 0;
        int right = 1;
        for (int w : weights) {
            left = Math.max(left, w);
            right += w;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            // if (f(weights, mid) == days) {
            //     right = mid;
            // } else if (f(weights, mid) < days) {
            //     right = mid;
            // } else if (f(weights, mid) > days) {
            //     left = mid + 1;
            // }
            if (f(weights, mid) <= days) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * 定义：当运载能力为 x 时，需要 f(x) 天运完所有货物。
     * f(x) 随着 x 的增加单调递减。
     */
    private int f(int[] weights, int x) {
        int days = 0;
        for (int i = 0; i < weights.length; ) {
            int cap = x;
            while (i < weights.length) {
                if (cap < weights[i]) {
                    break;
                } else {
                    cap -= weights[i];
                }
                i++;
            }
            days++;
        }
        return days;
    }

    public static void main(String[] args) {
    }
}
