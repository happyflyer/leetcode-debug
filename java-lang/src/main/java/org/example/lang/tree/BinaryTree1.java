package org.example.lang.tree;

import java.util.Arrays;

/**
 * https://developer.aliyun.com/lesson_1012_9033#_9033
 *
 * @author lifei
 */
public class BinaryTree1<T extends Comparable<T>> {
    private class Node {
        private final T data;
        private Node left;
        private Node right;
        private Node parent;

        public Node(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return toString(this, 0);
        }

        private static final String INDENT_SYMBOL = "    ";

        /**
         * 打印节点
         */
        private String toString(Node node, int indent) {
            StringBuilder sb = new StringBuilder();
            sb.append("Node{data=");
            sb.append(node.data);
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

        public void addNode(Node newNode) {
            if (newNode.data.compareTo((T) this.data) < 0) {
                if (this.left == null) {
                    this.left = newNode;
                    newNode.parent = this;
                } else {
                    this.left.addNode(newNode);
                }
            } else {
                if (this.right == null) {
                    this.right = newNode;
                    newNode.parent = this;
                } else {
                    this.right.addNode(newNode);
                }
            }
        }

        /**
         * 中序遍历
         */
        public void toArrayNode() {
            if (this.left != null) {
                this.left.toArrayNode();
            }
            BinaryTree1.this.returnData[BinaryTree1.this.foot++] = this.data;
            if (this.right != null) {
                this.right.toArrayNode();
            }
        }
    }

    /* 以下是二叉树的功能实现 */

    private Node root;
    private int count;
    private Object[] returnData;
    private int foot = 0;

    @Override
    public String toString() {
        return this.root.toString();
    }

    public void add(T data) {
        if (data == null) {
            throw new NullPointerException("保存的数据不允许为空！");
        }
        Node newNode = new Node(data);
        if (this.root == null) {
            this.root = newNode;
        } else {
            this.root.addNode(newNode);
        }
        this.count++;
    }

    /**
     * 中序遍历
     */
    public Object[] toArray() {
        if (this.count == 0) {
            return new Object[]{};
        }
        this.returnData = new Object[this.count];
        this.foot = 0;
        if (this.root != null) {
            this.root.toArrayNode();
        }
        return this.returnData;
    }

    public static void main(String[] args) {
        BinaryTree1<Person> tree = new BinaryTree1<>();
        tree.add(new Person("张三", 22));
        tree.add(new Person("李四", 20));
        tree.add(new Person("王五", 25));
        tree.add(new Person("赵六", 18));
        System.out.println(tree);
        System.out.println(Arrays.toString(tree.toArray()));
        System.out.println(tree.count);
    }
}
