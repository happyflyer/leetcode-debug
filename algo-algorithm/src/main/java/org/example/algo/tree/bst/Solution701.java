package org.example.algo.tree.bst;

import org.example.algo.tree.TreeNode;

/**
 * https://leetcode-cn.com/problems/insert-into-a-binary-search-tree/
 * <p>
 * 中等
 *
 * @author lifei
 */
public class Solution701 {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        } else {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }

    public static void main(String[] args) {
    }
}
