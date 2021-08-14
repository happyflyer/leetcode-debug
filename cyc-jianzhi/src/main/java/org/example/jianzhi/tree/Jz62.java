package org.example.jianzhi.tree;

import java.util.PriorityQueue;

/**
 * https://www.nowcoder.com/practice/ef068f602dde4d28aab2b210e859150a?tpId=13&tqId=11215
 *
 * @author lifei
 */
public class Jz62 {
    PriorityQueue<TreeNode> queue;

    private PriorityQueue<TreeNode> getQueue(int k) {
        if (queue == null) {
            queue = new PriorityQueue<>(k, (a, b) -> b.val - a.val);
        }
        return queue;
    }

    /**
     * 使用大顶堆
     */
    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k == 0) {
            return null;
        }
        PriorityQueue<TreeNode> queue = getQueue(k);
        if (queue.size() < k) {
            queue.offer(pRoot);
        } else {
            if (!queue.isEmpty() && pRoot.val < queue.peek().val) {
                queue.poll();
                queue.offer(pRoot);
            }
        }
        if (pRoot.left != null) {
            KthNode(pRoot.left, k);
        }
        if (pRoot.right != null) {
            KthNode(pRoot.right, k);
        }
        return queue.size() >= k ? queue.peek() : null;
    }

    private TreeNode ret;
    private int cnt = 0;

    TreeNode KthNode2(TreeNode pRoot, int k) {
        inOrder(pRoot, k);
        return ret;
    }

    /**
     * 中序遍历
     */
    private void inOrder(TreeNode node, int k) {
        if (node == null || k == 0) {
            return;
        }
        inOrder(node.left, k);
        cnt++;
        if (cnt == k) {
            ret = node;
        }
        inOrder(node.right, k);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(8);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        System.out.println(node1);
        System.out.println(
                new Jz62().KthNode2(node1, 3)
        );
    }
}
