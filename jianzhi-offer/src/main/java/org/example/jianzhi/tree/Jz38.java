package org.example.jianzhi.tree;

/**
 * https://www.nowcoder.com/practice/435fb86331474282a3499955f0a41e8b?tpId=13&tqId=11191
 *
 * @author lifei
 */
public class Jz38 {
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return countDepth(root, 1, 0);
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
        node3.right = node6;
        node5.left = node7;
        System.out.println(node1);
        System.out.println(
                new Jz38().TreeDepth(node1)
        );
    }
}
