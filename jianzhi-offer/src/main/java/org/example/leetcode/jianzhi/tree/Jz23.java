package org.example.leetcode.jianzhi.tree;

import java.util.Arrays;

/**
 * https://www.nowcoder.com/practice/a861533d45854474ac791d90e447bafd?tpId=13&tqId=11176
 *
 * @author lifei
 */
public class Jz23 {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        return validSequence(sequence);
    }

    /**
     * 递归，
     * 二叉搜索树的特点：左子节点 < 当前节点 < 右子节点，
     * 二叉搜索树后续遍历的结构：
     * [左子树的后续遍历序列，右子树的后续遍历序列，当前节点]
     */
    public boolean validSequence(int[] sequence) {
        int n = sequence.length;
        if (n == 0 || n == 1) {
            return true;
        }
        int last = sequence[n - 1];
        // 找到左子树、右子树后续遍历序列的分界
        int pos = 0;
        while (sequence[pos] < last) {
            pos++;
        }
        for (int i = pos; i < n - 1; i++) {
            if (sequence[i] < last) {
                return false;
            }
        }
        return validSequence(Arrays.copyOfRange(sequence, 0, pos))
                && validSequence(Arrays.copyOfRange(sequence, pos, n - 1));
    }

    public static void main(String[] args) {
        // int[] sequence = new int[]{4, 8, 6, 12, 16, 14, 10};
        int[] sequence = new int[]{7, 4, 6, 5};
        System.out.println(Arrays.toString(sequence));
        System.out.println(
                new Jz23().VerifySquenceOfBST(sequence)
        );
    }
}
