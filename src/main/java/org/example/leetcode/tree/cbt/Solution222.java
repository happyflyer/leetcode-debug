package org.example.leetcode.tree.cbt;

import org.example.leetcode.tree.TreeNode;

/**
 * https://leetcode-cn.com/problems/count-complete-tree-nodes/
 * <p>
 * 中等
 *
 * @author lifei
 */
public class Solution222 {
    /**
     * 完全二叉树
     */
    public int countNodes(TreeNode root) {
        int hl = 0;
        int hr = 0;
        TreeNode left = root;
        TreeNode right = root;
        while (left != null) {
            left = left.left;
            hl++;
        }
        while (right != null) {
            right = right.right;
            hr++;
        }
        if (hl == hr) {
            return (int) (Math.pow(2, hl) - 1);
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    public static void main(String[] args) {
    }
}
