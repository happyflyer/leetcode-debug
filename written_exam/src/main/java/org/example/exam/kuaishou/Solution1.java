package org.example.exam.kuaishou;

/**
 * 计算一个二叉树所有左叶子节点的加和
 *
 * @author lifei
 */
public class Solution1 {
    /**
     * 递归 / 深度优先搜索
     */
    int calcLeftLeaveSum(Node root) {
        int sum = 0;
        if (root == null) {
            return sum;
        }
        // 处理左子树
        if (root.left != null) {
            if (root.left.left != null) {
                // root.left 不是叶子节点，继续向下
                sum += calcLeftLeaveSum(root.left);
            } else {
                // root.left 是叶子节点
                sum += root.left.val;
            }
        }
        // 处理右子树
        sum += calcLeftLeaveSum(root.right);
        return sum;
    }

    public static void main(String[] args) {
        Node node1 = new Node(4);
        Node node2 = new Node(2);
        Node node3 = new Node(20);
        Node node4 = new Node(1);
        Node node5 = new Node(5);
        Node node6 = new Node(3);
        Node node7 = new Node(7);
        Node node8 = new Node(4);
        Node node9 = new Node(6);
        Node node10 = new Node(10);
        Node node11 = new Node(18);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = node8;
        node4.right = node9;
        node7.left = node10;
        node7.right = node11;
        System.out.println(node1);
        System.out.println(
                new Solution1().calcLeftLeaveSum(node1)
        );
    }
}
