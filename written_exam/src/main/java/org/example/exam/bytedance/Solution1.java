package org.example.exam.bytedance;

import java.util.Arrays;

/**
 * S 中的元素不重复，输出所有递增的子集
 * <p>
 * 输入：[1, 2, 3]
 * 输出：[[], [1], [2], [3], [1,2], [1,3], [2,3], [1,2,3]]
 *
 * @author lifei
 */
public class Solution1 {
    /**
     * 递归
     */
    public int[][] getSubSets(int[] S) {
        int n = S.length;
        if (n == 0) {
            return new int[][]{{}};
        } else {
            Arrays.sort(S);
            int[][] res = getSubSets(Arrays.copyOfRange(S, 0, n - 1));
            int len = res.length;
            int[][] ans = Arrays.copyOf(res, len * 2);
            for (int i = 0; i < len; i++) {
                int[] tmp = Arrays.copyOf(res[i], res[i].length + 1);
                tmp[res[i].length] = S[n - 1];
                ans[len + i] = tmp;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        System.out.println(
                Arrays.deepToString(new Solution1().getSubSets(
                        new int[]{1, 2, 3}
                ))
        );
    }
}
