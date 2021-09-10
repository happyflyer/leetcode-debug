package org.example.algo.tree.bst;

import org.example.algo.tree.TreeNode;

/**
 * https://leetcode-cn.com/problems/search-in-a-binary-search-tree/
 * <p>
 * 简单
 *
 * @author lifei
 */
public class Solution700 {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        if (root.val < val) {
            return searchBST(root.right, val);
        } else {
            return searchBST(root.left, val);
        }
    }

    public static void main(String[] args) {
    }
}
