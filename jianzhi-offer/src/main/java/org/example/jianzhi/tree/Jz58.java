package org.example.jianzhi.tree;

/**
 * https://www.nowcoder.com/practice/ff05d44dfdb04e1d83bdbdab320efbcb?tpId=13&tqId=11211
 *
 * @author lifei
 */
public class Jz58 {
    public boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) {
            return true;
        }
        return isMirrorTree(pRoot.left, pRoot.right);
    }

    /**
     * 递归
     */
    public boolean isMirrorTree(TreeNode left, TreeNode right) {
        if ((left == null) != (right == null)) {
            return false;
        }
        if (left == null) {
            return true;
        }
        if (left.val == right.val) {
            return isMirrorTree(left.left, right.right)
                    && isMirrorTree(left.right, right.left);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        System.out.println(node1);
        System.out.println(
                new Jz58().isSymmetrical(node1)
        );
    }
}
