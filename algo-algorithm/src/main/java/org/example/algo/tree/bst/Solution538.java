package org.example.algo.tree.bst;

import org.example.algo.tree.TreeNode;

/**
 * https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
 * https://leetcode-cn.com/problems/binary-search-tree-to-greater-sum-tree/
 * <p>
 * 中等
 *
 * @author lifei
 */
public class Solution538 {
    public TreeNode convertBST(TreeNode root) {
        int[] sum = new int[1];
        traverse(root, sum);
        return root;
    }

    private int traverse(TreeNode root, int[] sum) {
        if (root == null) {
            return 0;
        }
        traverse(root.right, sum);
        sum[0] += root.val;
        root.val = sum[0];
        traverse(root.left, sum);
        return root.val;
    }

    public static void main(String[] args) {
    }
}
