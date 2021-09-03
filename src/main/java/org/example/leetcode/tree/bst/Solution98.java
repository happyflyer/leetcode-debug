package org.example.leetcode.tree.bst;

import org.example.leetcode.tree.TreeNode;

/**
 * https://leetcode-cn.com/problems/validate-binary-search-tree/
 * <p>
 * 中等
 *
 * @author lifei
 */
public class Solution98 {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        return isValidBST(root.left, min, root)
                && isValidBST(root.right, root, max);
    }

    public static void main(String[] args) {
    }
}
