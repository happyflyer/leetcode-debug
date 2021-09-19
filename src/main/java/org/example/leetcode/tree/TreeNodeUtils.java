package org.example.leetcode.tree;

import java.util.*;

/**
 * @author lifei
 */
public class TreeNodeUtils {
    /**
     * 直观打印二叉树。
     */
    public static void printBinaryTree(TreeNode root) {
        int treeDepth = getBinaryDepth(root);
        int unit = treeDepth / 3 + 1;
        String format = "%" + unit + "s";
        int high = treeDepth * 2 - 1;
        int width = (int) (Math.pow(2, treeDepth + 1) - 1);
        Map<Integer, TreeNode> indexToTree = serializeBinaryTreeToFull(root);
        Map<Integer, Node> indexToNode = getFullBinaryTreeIndexTable(treeDepth);
        List<LinkedList<Integer>> lines = new ArrayList<>(high);
        for (int h = 0; h < high; h++) {
            lines.add(new LinkedList<>());
        }
        int capacity = (int) Math.pow(2, treeDepth);
        int index = 1;
        while (index < capacity) {
            if (indexToTree.containsKey(index)) {
                if (index > 1) {
                    // 符号
                    lines.get(indexToNode.get(index).edge.row - 1).add(index);
                }
                // 数字
                lines.get(indexToNode.get(index).row - 1).add(index);
            }
            index++;
        }
        for (int h = 1; h <= high; h++) {
            LinkedList<Integer> line = lines.get(h - 1);
            if (h % 2 == 1) {
                // 数字行
                index = line.isEmpty() ? 0 : line.removeFirst();
                int col = index == 0 ? 0 : indexToNode.get(index).col;
                for (int w = 1; w <= width; w++) {
                    if (w != col) {
                        System.out.printf(format, "");
                    } else {
                        int val = indexToTree.get(index).val;
                        System.out.printf(format, val);
                        index = line.isEmpty() ? 0 : line.removeFirst();
                        col = index == 0 ? 0 : indexToNode.get(index).col;
                    }
                }
            } else {
                // 符号行
                index = line.isEmpty() ? 0 : line.removeFirst();
                int col = index == 0 ? 0 : indexToNode.get(index).edge.col;
                for (int w = 1; w <= width; w++) {
                    if (w != col) {
                        System.out.printf(format, "");
                    } else {
                        char type = indexToNode.get(index).edge.type;
                        System.out.printf(format, type);
                        index = line.isEmpty() ? 0 : line.removeFirst();
                        col = index == 0 ? 0 : indexToNode.get(index).edge.col;
                    }
                }
            }
            System.out.println();
        }
    }

    /**
     * 获取二叉树深度。
     */
    public static int getBinaryDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = getBinaryDepth(root.left);
        int rightDepth = getBinaryDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    /**
     * 满二叉树节点编号到二叉树节点的映射。index -> TreeNode
     */
    public static Map<Integer, TreeNode> serializeBinaryTreeToFull(TreeNode root) {
        Map<Integer, TreeNode> ans = new HashMap<>();
        if (root == null) {
            return ans;
        }
        serializeBinaryTreeToFull(root, 1, ans);
        return ans;
    }

    private static void serializeBinaryTreeToFull(TreeNode node,
                                                  int index,
                                                  Map<Integer, TreeNode> ans) {
        if (node == null) {
            return;
        }
        ans.put(index, node);
        serializeBinaryTreeToFull(node.left, index * 2, ans);
        serializeBinaryTreeToFull(node.right, index * 2 + 1, ans);
    }

    /**
     * 满二叉树节点编号到打印坐标的映射。index -> Node
     */
    public static Map<Integer, Node> getFullBinaryTreeIndexTable(int treeDepth) {
        int capacity = (int) Math.pow(2, treeDepth);
        Map<Integer, Node> ans = new HashMap<>(capacity);
        int row = 0;
        int col = 0;
        int index = 1;
        while (index < capacity) {
            // 数字坐标
            if (index >= Math.pow(2, row)) {
                row++;
                col = (int) Math.pow(2, treeDepth - row + 1);
            } else {
                col += Math.pow(2, treeDepth - row + 2);
            }
            // 符号坐标
            Edge edge = null;
            if (row > 1) {
                char edgeType = index % 2 == 0 ? '/' : '\\';
                int edgeRow = row * 2 - 2;
                int edgeCol = col;
                if (index % 2 == 0) {
                    edgeCol += Math.pow(2, treeDepth - row);
                } else {
                    edgeCol -= Math.pow(2, treeDepth - row);
                }
                edge = new Edge(edgeType, edgeRow, edgeCol);
            }
            ans.put(index, new Node(row * 2 - 1, col, edge));
            index++;
        }
        return ans;
    }

    private static class Node {
        int row;
        int col;
        // 每个数字节点与父节点的边，根节点为null
        Edge edge;

        public Node(int row, int col, Edge edge) {
            this.row = row;
            this.col = col;
            this.edge = edge;
        }

        @Override
        public String toString() {
            return "(" + row + ',' + col + ',' + edge + ')';
        }
    }

    private static class Edge {
        // 左边或右边
        char type;
        int row;
        int col;

        public Edge(char type, int row, int col) {
            this.type = type;
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "(" + type + ',' + +row + ',' + col + ')';
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);
        TreeNode node10 = new TreeNode(10);
        TreeNode node11 = new TreeNode(11);
        TreeNode node12 = new TreeNode(12);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node5.right = node9;
        node6.left = node10;
        node6.right = node11;
        node7.left = node12;
        printBinaryTree(node1);
    }
}
