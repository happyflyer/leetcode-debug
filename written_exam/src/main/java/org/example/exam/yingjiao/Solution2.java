package org.example.exam.yingjiao;

/**
 * 输入：
 * 输出：
 *
 * @author lifei
 */
public class Solution2 {
    int max = 0;

    public int maxHuffman(TreeNode root) {
        countHuffMan(root);
        return max;
    }

    private void countHuffMan(TreeNode node) {
        if (node == null) {
            return;
        }
        if (isHuffman(node)) {
            max = Math.max(max, node.val);
        }
        countHuffMan(node.left);
        countHuffMan(node.right);
    }

    private boolean isHuffman(TreeNode node) {
        if (node.left == null && node.right == null) {
            return true;
        }
        if ((node.left == null) != (node.right == null)) {
            return false;
        }
        if (node.val != node.left.val + node.right.val) {
            return false;
        }
        return isHuffman(node.left) && isHuffman(node.right);
    }

    public static void main(String[] args) {
    }
}
