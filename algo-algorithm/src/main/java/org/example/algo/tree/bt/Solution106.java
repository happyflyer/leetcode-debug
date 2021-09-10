package org.example.algo.tree.bt;

import org.example.algo.tree.TreeNode;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * <p>
 * 中等
 *
 * @author lifei
 */
public class Solution106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(
                inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1
        );
    }

    private TreeNode build(int[] inorder, int low1, int high1,
                           int[] postorder, int low2, int high2) {
        if (low2 > high2) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[high2]);
        int pos = 0;
        for (int i = low1; i <= high1; i++) {
            if (inorder[i] == postorder[high2]) {
                pos = i;
                break;
            }
        }
        root.right = build(
                inorder, pos + 1, high1,
                postorder, high2 - 1 - (high1 - pos - 1), high2 - 1
        );
        root.left = build(
                inorder, low1, pos - 1,
                postorder, low2, high2 - 1 - (high1 - pos - 1) - 1
        );
        return root;
    }

    public static void main(String[] args) {
    }
}
