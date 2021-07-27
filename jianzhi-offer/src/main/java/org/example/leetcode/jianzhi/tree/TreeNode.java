package org.example.leetcode.jianzhi.tree;

/**
 * @author lifei
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return toString(this, 0);
    }

    private static final String INDENT_SYMBOL = "    ";

    private String toString(TreeNode node, int indent) {
        StringBuilder sb = new StringBuilder();
        sb.append("TreeNode{val=");
        sb.append(node.val);
        sb.append("}");
        if (node.left != null) {
            sb.append("\n");
            int i = indent + 1;
            while (i-- > 0) {
                sb.append(INDENT_SYMBOL);
            }
            sb.append(" -l-> ");
            sb.append(toString(node.left, indent + 1));
        }
        if (node.right != null) {
            sb.append("\n");
            int i = indent + 1;
            while (i-- > 0) {
                sb.append(INDENT_SYMBOL);
            }
            sb.append(" -r-> ");
            sb.append(toString(node.right, indent + 1));
        }
        return sb.toString();
    }
}
