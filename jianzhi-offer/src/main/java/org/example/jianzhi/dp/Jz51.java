package org.example.jianzhi.dp;

import java.util.Arrays;

/**
 * https://www.nowcoder.com/practice/94a4d381a68b47b7a8bed86f2975db46?tpId=13&tqId=11204
 *
 * @author lifei
 */
public class Jz51 {
    /**
     * 动态规划。
     * ans[i] = left[i - 1] * right[i + 1]
     */
    public int[] multiply(int[] A) {
        int n = A.length;
        if (n == 0) {
            return new int[]{};
        }
        int[] left = new int[n];
        left[0] = A[0];
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * A[i];
        }
        int[] right = new int[n];
        right[n - 1] = A[n - 1];
        for (int i = n - 2; i > 0; i--) {
            right[i] = right[i + 1] * A[i];
        }
        int[] ans = new int[n];
        ans[0] = right[1];
        ans[n - 1] = left[n - 2];
        for (int i = 1; i < n - 1; i++) {
            ans[i] = left[i - 1] * right[i + 1];
        }
        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(new Jz51().multiply(new int[]{1, 2, 3, 4, 5}))
        );
    }
}
