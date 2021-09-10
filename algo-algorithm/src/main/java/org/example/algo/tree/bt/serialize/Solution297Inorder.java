package org.example.algo.tree.bt.serialize;

import org.example.algo.tree.TreeNode;

/**
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 * <p>
 * 困难
 *
 * @author lifei
 */
public class Solution297Inorder {
    public static final String SEP = ",";
    public static final String NULL = "#";

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    public void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }
        serialize(root.left, sb);
        sb.append(root.val).append(SEP);
        serialize(root.right, sb);
    }

    /**
     * 无法进行反序列化
     */
    public TreeNode deserialize(String data) {
        return null;
    }

    public static void main(String[] args) {
    }
}
