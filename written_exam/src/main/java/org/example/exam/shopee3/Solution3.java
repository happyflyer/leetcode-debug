package org.example.exam.shopee3;

/**
 * 题目描述：
 * 输入：
 * 输出：
 * 说明：
 * 通过：AC
 *
 * @author lifei
 */
public class Solution3 {
    public int getMaxMoney(TreeNode node) {
        if (node == null) {
            return 0;
        }
        // 方案1，当前节点和孙子节点
        int ans1 = node.val;
        // 方案2，左右子节点
        int ans2 = 0;
        if (node.left != null) {
            ans1 += getMaxMoney(node.left.left) + getMaxMoney(node.left.right);
            ans2 += getMaxMoney(node.left);
        }
        if (node.right != null) {
            ans1 += getMaxMoney(node.right.left) + getMaxMoney(node.right.right);
            ans2 += getMaxMoney(node.right);
        }
        return Math.max(ans1, ans2);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        System.out.println(new Solution3().getMaxMoney(node1));
    }
}
