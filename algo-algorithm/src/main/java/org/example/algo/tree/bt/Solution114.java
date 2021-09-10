package org.example.algo.tree.bt;

import org.example.algo.tree.TreeNode;

/**
 * https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
 * <p>
 * 中等
 *
 * @author lifei
 */
public class Solution114 {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        // 1、左子树、右子都已经拉平成链表
        TreeNode left = root.left;
        TreeNode right = root.right;
        // 2、左子树当作右子树
        root.left = null;
        root.right = left;
        // 3、右子树接到左子树下方
        TreeNode leftTail = root;
        while (leftTail.right != null) {
            leftTail = leftTail.right;
        }
        leftTail.right = right;
    }

    public static void main(String[] args) {
    }
}
