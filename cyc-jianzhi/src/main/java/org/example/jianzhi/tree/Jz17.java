package org.example.jianzhi.tree;

/**
 * https://www.nowcoder.com/practice/6e196c44c7004d15b1610b9afca8bd88?tpId=13&tqId=11170
 *
 * @author lifei
 */
public class Jz17 {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        // root2==null 空树不是任意一个树的子结构
        // root2!=null && root1==null
        if (root2 == null || root1 == null) {
            return false;
        }
        return isSameTree(root1, root2)
                || HasSubtree(root1.left, root2)
                || HasSubtree(root1.right, root2);
    }

    /**
     * 递归
     */
    public boolean isSameTree(TreeNode node1, TreeNode node2) {
        if (node2 == null) {
            return true;
        }
        if (node1 == null) {
            return false;
        }
        if (node1.val == node2.val) {
            return isSameTree(node1.left, node2.left)
                    && isSameTree(node1.right, node2.right);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(9);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node2.left = node3;
        node3.left = node4;
        node4.left = node5;
        System.out.println(node1);
        TreeNode node7 = new TreeNode(8);
        TreeNode node8 = new TreeNode(9);
        TreeNode node9 = new TreeNode(2);
        node7.left = node8;
        node8.left = node9;
        System.out.println(node7);
        System.out.println(
                new Jz17().HasSubtree(node1, node7)
        );
    }
}
