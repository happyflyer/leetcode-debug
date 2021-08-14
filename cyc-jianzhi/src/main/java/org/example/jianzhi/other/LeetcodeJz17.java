package org.example.jianzhi.other;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 *
 * @author lifei
 */
public class LeetcodeJz17 {
    public int[] printNumbers(int n) {
        int max = 1;
        while (n-- > 0) {
            max *= 10;
        }
        int[] ans = new int[max - 1];
        for (int i = 1; i < max; i++) {
            ans[i - 1] = i;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(
                        new LeetcodeJz17().printNumbers(1)
                )
        );
    }
}
