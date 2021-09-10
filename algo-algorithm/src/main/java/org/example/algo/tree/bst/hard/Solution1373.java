package org.example.algo.tree.bst.hard;

import org.example.algo.tree.TreeNode;

/**
 * https://leetcode-cn.com/problems/maximum-sum-bst-in-binary-tree/
 * <p>
 * 困难
 *
 * @author lifei
 */
public class Solution1373 {
    public int maxSumBST(TreeNode root) {
        int[] maxSum = new int[1];
        traverse(root, maxSum);
        return maxSum[0];
    }

    /**
     * [isBST, min, max, sum]
     */
    private int[] traverse(TreeNode root, int[] maxSum) {
        if (root == null) {
            return new int[]{
                    1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0
            };
        }
        int[] left = traverse(root.left, maxSum);
        int[] right = traverse(root.right, maxSum);
        int[] res = new int[4];
        if (left[0] == 1 && right[0] == 1
                && root.val > left[2] && root.val < right[1]) {
            res[0] = 1;
            res[1] = Math.min(left[1], root.val);
            res[2] = Math.max(right[2], root.val);
            res[3] = left[3] + right[3] + root.val;
            maxSum[0] = Math.max(maxSum[0], res[3]);
        } else {
            res[0] = 0;
        }
        return res;
    }

    public static void main(String[] args) {
    }
}
