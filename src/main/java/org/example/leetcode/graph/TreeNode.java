package org.example.leetcode.graph;

/**
 * @author lifei
 */
public class TreeNode {
    public int val;
    public TreeNode[] children;

    /**
     * 多叉树遍历框架
     */
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        for (TreeNode child : root.children) {
            traverse(child);
        }
    }
}
