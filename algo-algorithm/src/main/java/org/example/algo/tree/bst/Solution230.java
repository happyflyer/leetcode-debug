package org.example.algo.tree.bst;

import org.example.algo.tree.TreeNode;

/**
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
 * <p>
 * 中等
 *
 * @author lifei
 */
public class Solution230 {
    public int kthSmallest(TreeNode root, int k) {
        // [rank, res]
        int[] ans = new int[2];
        traverse(root, k, ans);
        return ans[1];
    }

    private void traverse(TreeNode root, int k, int[] ans) {
        if (root == null) {
            return;
        }
        traverse(root.left, k, ans);
        ans[0]++;
        if (ans[0] == k) {
            ans[1] = root.val;
            return;
        }
        traverse(root.right, k, ans);
    }

    public static void main(String[] args) {
    }
}
