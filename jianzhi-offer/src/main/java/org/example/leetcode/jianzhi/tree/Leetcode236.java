package org.example.leetcode.jianzhi.tree;

/**
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 *
 * @author lifei
 */
public class Leetcode236 {
    /**
     * 递归，比较耗时
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        boolean leftExistP = findNode(root.left, p);
        boolean leftExistQ = findNode(root.left, q);
        if (leftExistP && leftExistQ) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (!leftExistP && !leftExistQ) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    /**
     * 判断 node 是否在 root 树中
     */
    private boolean findNode(TreeNode root, TreeNode node) {
        if (root == null) {
            return false;
        }
        if (root.val == node.val) {
            return true;
        }
        return findNode(root.left, node) || findNode(root.right, node);
    }

    /**
     * 递归
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor2(root.left, p, q);
        TreeNode right = lowestCommonAncestor2(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode node0 = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        node3.left = node5;
        node3.right = node1;
        node5.left = node6;
        node5.right = node2;
        node2.left = node7;
        node2.right = node4;
        node1.left = node0;
        node1.right = node8;
        System.out.println(node3);
        System.out.println(
                new Leetcode236().lowestCommonAncestor2(node3, node5, node4).val
        );
    }
}
