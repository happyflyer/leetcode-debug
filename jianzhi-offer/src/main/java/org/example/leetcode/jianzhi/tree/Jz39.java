package org.example.leetcode.jianzhi.tree;

/**
 * https://www.nowcoder.com/practice/8b3b95850edb4115918ecebdf1b4d222?tpId=13&tqId=11192
 *
 * @author lifei
 */
public class Jz39 {
    /**
     * 平衡二叉树（Balanced Binary Tree），具有以下性质：
     * 它是一棵空树
     * 或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
     * 我们约定空树是平衡二叉树。
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftDepth = root.left == null ? 0 : countDepth(root.left, 1, 0);
        int rightDepth = root.right == null ? 0 : countDepth(root.right, 1, 0);
        return Math.abs(leftDepth - rightDepth) <= 1
                && IsBalanced_Solution(root.left)
                && IsBalanced_Solution(root.right);
    }

    /**
     * 深度优先搜索，递归
     */
    private int countDepth(TreeNode node, int curDepth, int maxDepth) {
        if (node.left == null && node.right == null) {
            maxDepth = Math.max(maxDepth, curDepth);
        }
        if (node.left != null) {
            int depth = countDepth(node.left, curDepth + 1, maxDepth);
            maxDepth = Math.max(maxDepth, depth);
        }
        if (node.right != null) {
            int depth = countDepth(node.right, curDepth + 1, maxDepth);
            maxDepth = Math.max(maxDepth, depth);
        }
        return maxDepth;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        System.out.println(node1);
        System.out.println(
                new Jz39().IsBalanced_Solution(node1)
        );
    }
}
