package org.example.algo.tree.bt.serialize;

import org.example.algo.tree.TreeNode;

import java.util.LinkedList;

/**
 * https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 * <p>
 * 困难
 *
 * @author lifei
 */
public class Solution297Postorder {
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
        serialize(root.right, sb);
        sb.append(root.val).append(SEP);
    }

    public TreeNode deserialize(String data) {
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(SEP)) {
            nodes.addLast(s);
        }
        return deserialize(nodes);
    }

    private TreeNode deserialize(LinkedList<String> nodes) {
        if (nodes.isEmpty()) {
            return null;
        }
        String last = nodes.removeLast();
        if (last.equals(NULL)) {
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(last));
        root.right = deserialize(nodes);
        root.left = deserialize(nodes);
        return root;
    }

    public static void main(String[] args) {
    }
}
