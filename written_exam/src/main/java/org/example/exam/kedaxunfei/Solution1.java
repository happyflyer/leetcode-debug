package org.example.exam.kedaxunfei;

import java.util.Arrays;

/**
 * 题目描述：
 * 输入：[10,16,6,66,99,963]
 * 输出：[4,6,-1,18,27,243]
 * 说明：
 * 通过：
 *
 * @author lifei
 */
public class Solution1 {
    public int[] minimumNumber(int[] target) {
        int n = target.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = getAns(target[i]);
        }
        return res;
    }

    public int getAns(int x) {
        if (x < 10) {
            return -1;
        }
        x = x - 10;
        return 4 + x / 4 + (x % 4 > 0 ? 1 : 0);
    }

    public static void main(String[] args) {
        int[] target = new int[]{10, 16, 6, 66, 99, 963};
        System.out.println(Arrays.toString(new Solution1().minimumNumber(target)));
    }
}
