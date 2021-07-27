package org.example.leetcode.jianzhi.tree;

/**
 * @author lifei
 */
public class TreeLinkNode {
    int val;
    TreeLinkNode left;
    TreeLinkNode right;
    TreeLinkNode next;

    TreeLinkNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return toString(this, 0);
    }

    private static final String INDENT_SYMBOL = "    ";

    private String toString(TreeLinkNode node, int indent) {
        StringBuilder sb = new StringBuilder();
        sb.append("TreeLinkNode{val=");
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
