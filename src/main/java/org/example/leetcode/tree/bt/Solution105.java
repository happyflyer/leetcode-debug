package org.example.leetcode.tree.bt;

import org.example.leetcode.tree.TreeNode;

/**
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * <p>
 * 中等
 *
 * @author lifei
 */
public class Solution105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(
                preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1
        );
    }

    private TreeNode build(int[] preorder, int low1, int high1,
                           int[] inorder, int low2, int high2) {
        if (low1 > high1) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[low1]);
        int pos = 0;
        for (int i = low2; i <= high2; i++) {
            if (inorder[i] == preorder[low1]) {
                pos = i;
                break;
            }
        }
        // high2-low2 == high1-low1
        root.left = build(
                preorder, low1 + 1, low1 + 1 + (pos - 1 - low2),
                inorder, low2, pos - 1
        );
        root.right = build(
                preorder, low1 + 1 + (pos - 1 - low2) + 1, high1,
                inorder, pos + 1, high2
        );
        return root;
    }

    public static void main(String[] args) {
    }
}
