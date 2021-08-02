package org.example.leetcode.jianzhi.tree;

/**
 * https://www.nowcoder.com/practice/947f6eb80d944a84850b0538bf0ec3a5?tpId=13&tqId=11179
 *
 * @author lifei
 */
public class Jz26 {
    private TreeNode pre = null;
    private TreeNode head = null;

    public TreeNode Convert(TreeNode pRootOfTree) {
        inOrder(pRootOfTree);
        return head;
    }

    /**
     * 深度优先，递归
     */
    private void inOrder(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        node.left = pre;
        if (pre != null) {
            pre.right = node;
        }
        pre = node;
        if (head == null) {
            head = node;
        }
        inOrder(node.right);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(14);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(8);
        TreeNode node6 = new TreeNode(12);
        TreeNode node7 = new TreeNode(16);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        System.out.println(node1);
        TreeNode head = new Jz26().Convert(node1);
        TreeNode cur = head;
        TreeNode tail = head;
        while (cur != null) {
            System.out.print(cur.val);
            System.out.print(" ");
            if (cur.right == null) {
                tail = cur;
            }
            cur = cur.right;
        }
        System.out.println();
        cur = tail;
        while (cur != null) {
            System.out.print(cur.val);
            System.out.print(" ");
            cur = cur.left;
        }
    }
}
