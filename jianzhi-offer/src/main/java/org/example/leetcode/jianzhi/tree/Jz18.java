package org.example.leetcode.jianzhi.tree;

/**
 * https://www.nowcoder.com/practice/a9d0ecbacef9410ca97463e4a5c83be7?tpId=13&tqId=11171
 *
 * @author lifei
 */
public class Jz18 {
    /**
     * 递归
     */
    public TreeNode Mirror(TreeNode pRoot) {
        if (pRoot == null) {
            return null;
        }
        TreeNode left = pRoot.left;
        TreeNode right = pRoot.right;
        Mirror(left);
        Mirror(right);
        pRoot.left = right;
        pRoot.right = left;
        return pRoot;
    }

    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);
        TreeNode node11 = new TreeNode(11);
        node8.left = node6;
        node8.right = node10;
        node6.left = node5;
        node6.right = node7;
        node10.left = node9;
        node10.right = node11;
        System.out.println(node8);
        System.out.println(
                new Jz18().Mirror(node8)
        );
    }
}
