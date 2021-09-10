package org.example.algo.tree.bt;

import org.example.algo.tree.TreeNode;

/**
 * https://leetcode-cn.com/problems/invert-binary-tree/
 * <p>
 * 简单
 *
 * @author lifei
 */
public class Solution226 {
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
