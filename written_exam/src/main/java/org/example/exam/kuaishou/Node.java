package org.example.exam.kuaishou;

/**
 * @author lifei
 */
public class Node {
    int val;
    Node left;
    Node right;

    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return toString(this, 0);
    }

    private String toString(Node node, int indent) {
        StringBuilder sb = new StringBuilder();
        sb.append("Node{val=");
        sb.append(node.val);
        sb.append("}");
        String indentSymbol = "    ";
        if (node.left != null) {
            sb.append("\n");
            int i = indent + 1;
            while (i-- > 0) {
                sb.append(indentSymbol);
            }
            sb.append(" -l-> ");
            sb.append(toString(node.left, indent + 1));
        }
        if (node.right != null) {
            sb.append("\n");
            int i = indent + 1;
            while (i-- > 0) {
                sb.append(indentSymbol);
            }
            sb.append(" -r-> ");
            sb.append(toString(node.right, indent + 1));
        }
        return sb.toString();
    }
}
