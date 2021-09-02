package org.example.leetcode.tree.bt;

import org.example.leetcode.tree.TreeNode;

/**
 * https://leetcode-cn.com/problems/invert-binary-tree/
 * <p>
 * 简单
 *
 * @author lifei
 */
public class Solution226 {
    /**
     * 二叉树遍历的递归结构
     */
    public void traverse(TreeNode root) {
        // 前序遍历
        traverse(root.left);
        // 中序遍历
        traverse(root.left);
        // 后续遍历
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode node = root.left;
        root.left = root.right;
        root.right = node;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    public static void main(String[] args) {
    }
}
