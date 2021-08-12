package org.example.jianzhi.tree;

import java.util.Arrays;

/**
 * https://www.nowcoder.com/practice/8a19cbe657394eeaac2f6ea9b0f6fcf6?tpId=13&tqId=11157
 *
 * @author lifei
 */
public class Jz4 {
    /**
     * 递归
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        int n = pre.length;
        if (n == 0) {
            return null;
        } else {
            TreeNode root = new TreeNode(pre[0]);
            if (n == 1) {
                return root;
            }
            int pos = -1;
            for (int i = 0; i < n; i++) {
                if (pre[0] == in[i]) {
                    pos = i;
                }
            }
            root.left = reConstructBinaryTree(
                    Arrays.copyOfRange(pre, 1, pos + 1),
                    Arrays.copyOfRange(in, 0, pos)
            );
            root.right = reConstructBinaryTree(
                    Arrays.copyOfRange(pre, pos + 1, n),
                    Arrays.copyOfRange(in, pos + 1, n)
            );
            return root;
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        node1.left = node2;
        node2.left = node4;
        node4.right = node7;
        node1.right = node3;
        node3.left = node5;
        node3.right = node6;
        node6.left = node8;
        System.out.println(node1);
        System.out.println(
                new Jz4().reConstructBinaryTree(
                        new int[]{1, 2, 4, 7, 3, 5, 6, 8},
                        new int[]{4, 7, 2, 1, 5, 3, 8, 6}
                )
        );
    }
}
