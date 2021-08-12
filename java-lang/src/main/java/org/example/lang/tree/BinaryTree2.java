package org.example.lang.tree;

import java.util.Arrays;

/**
 * https://developer.aliyun.com/lesson_1012_9034#_9034
 *
 * @author lifei
 */
public class BinaryTree2<T extends Comparable<T>> {
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
            BinaryTree2.this.returnData[BinaryTree2.this.foot++] = this.data;
            if (this.right != null) {
                this.right.toArrayNode();
            }
        }

        /**
         * 二叉树查找
         */
        public Node findRemoveNode(Comparable<T> data) {
            if (data.compareTo((T) this.data) == 0) {
                return this;
            }
            if (data.compareTo((T) this.data) < 0) {
                if (this.left != null) {
                    return this.left.findRemoveNode(data);
                }
            } else {
                if (this.right != null) {
                    return this.right.findRemoveNode(data);
                }
            }
            return null;
        }

        /**
         * 找中序遍历 的 后继节点
         */
        public Node findNextNode() {
            if (this.right == null) {
                return null;
            }
            Node node = this.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        }
    }

    /* 以下是二叉树的功能实现 */

    private Node root;
    private int count;
    private Object[] returnData;
    private int foot = 0;

    @Override
    public String toString() {
        return this.root != null ? this.root.toString() : "";
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

    /**
     * 1、如果待删除节点没有子节点，那么直接删除即可；
     * 2、如果待删除节点只有一个子节点，那么直接删掉，并用其子节点去顶替它；
     * 3、如果待删除节点有两个子节点，这种情况比较复杂：
     * 3.1、首选找出它的后继节点；
     * 3.2、然后处理 后继节点 和 被删除节点的父节点 之间的关系，
     * 3.3、最后处理 后继节点的子节点 和 被删除节点的子节点 之间的关系。
     */
    public Node remove(Comparable<T> data) {
        Node removeNode = this.root.findRemoveNode(data);
        if (removeNode != null) {
            Node parent = removeNode.parent;
            // 待删除节点 是 根节点，创建一个伪父节点
            if (removeNode == this.root) {
                parent = new Node((T) new Person("", Integer.MAX_VALUE));
                parent.left = removeNode;
                removeNode.parent = parent;
            }
            if (removeNode.left == null && removeNode.right == null) {
                // 待删除节点 没有子节点
                if (removeNode.data.compareTo((T) parent.data) < 0) {
                    parent.left = null;
                } else {
                    parent.right = null;
                }
                removeNode.parent = null;
            } else if (removeNode.left != null && removeNode.right == null) {
                // 待删除节点 只有左子节点
                if (removeNode.data.compareTo((T) parent.data) < 0) {
                    parent.left = removeNode.left;
                } else {
                    parent.right = removeNode.left;
                }
                removeNode.left.parent = parent;
            } else if (removeNode.left == null && removeNode.right != null) {
                // 待删除节点 只有右子节点
                if (removeNode.data.compareTo((T) parent.data) < 0) {
                    parent.left = removeNode.right;
                } else {
                    parent.right = removeNode.right;
                }
                removeNode.right.parent = parent;
            } else {
                // 待删除节点 既有左子节点 也有右子节点
                // 先找到待删除节点 中序遍历的 后继节点next
                // 因为 被删除节点的左右子节点 都有，所以 next节点 不可能为空
                Node next = removeNode.findNextNode();
                // 待删除节点 是 根节点，this.root指针 指向 next节点
                if (removeNode == this.root) {
                    this.root = next;
                }
                // 1、待删除节点的父节点的子节点指针 指向 next节点
                if (removeNode.data.compareTo((T) parent.data) < 0) {
                    parent.left = next;
                } else {
                    parent.right = next;
                }
                // 2、next节点的原父节点的子节点指针 指向 next节点的子节点
                if (next == next.parent.left) {
                    next.parent.left = null;
                } else {
                    next.parent.right = next.right;
                }
                // 3、next节点的父节点指针 指向 待删除节点的父节点
                next.parent = parent;
                // 4、待删除节点的子节点 挂载到 next节点下
                next.left = removeNode.left;
                next.right = removeNode.right;
            }
            this.count--;
            return removeNode;
        }
        return null;
    }

    public static void main(String[] args) {
        BinaryTree2<Person> tree = new BinaryTree2<>();
        tree.add(new Person("张三", 80));
        tree.add(new Person("张三", 50));
        tree.add(new Person("张三", 90));
        tree.add(new Person("张三", 30));
        tree.add(new Person("张三", 60));
        tree.add(new Person("张三", 85));
        tree.add(new Person("张三", 95));
        tree.add(new Person("张三", 10));
        tree.add(new Person("张三", 55));
        tree.add(new Person("张三", 70));
        System.out.println(tree);
        System.out.println(Arrays.toString(tree.toArray()));
        System.out.println(tree.count);
        System.out.println(tree.remove(new Person("张三", 50)));
        System.out.println(tree);
        System.out.println(Arrays.toString(tree.toArray()));
        System.out.println(tree.count);
    }
}
