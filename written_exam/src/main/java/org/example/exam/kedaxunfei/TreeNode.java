package org.example.exam.kedaxunfei;

/**
 * @author lifei
 */
public class TreeNode {
    public int val = 0;
    public TreeNode left = null;
    public TreeNode right = null;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
