package org.example.jianzhi.tree;

import java.util.Arrays;

/**
 * https://www.nowcoder.com/practice/9023a0c988684a53960365b889ceaf5e?tpId=13&tqId=11210
 *
 * @author lifei
 */
public class Jz57 {
    /**
     * 分情况讨论
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        // 如果当前节点有右子树，返回右子树中的最左节点
        if (pNode.right != null) {
            TreeLinkNode cur = pNode.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            return cur;
        }
        // 当前节点没有右子树，那就找根节点
        TreeLinkNode root = pNode;
        while (root.next != null) {
            root = root.next;
        }
        if (pNode == root) {
            return null;
        }
        // 如果当前节点是左叶子节点，返回当前节点的父节点
        if (pNode.next.left == pNode) {
            return pNode.next;
        }
        // 如果当前节点是右叶子节点
        if (pNode.next.right == pNode) {
            // 找到父节点，一直找到左子树的父节点，返回左子树的父节点
            // 找的过程中，如果找到根节点还没找到，返回 null
            pNode = pNode.next;
            while (pNode.next.left != pNode) {
                pNode = pNode.next;
                if (pNode == root) {
                    return null;
                }
            }
            return pNode.next;
        }
        return null;
    }

    /**
     * 如果一个节点的右子树不为空，那么该节点的下一个节点是右子树的最左节点；
     * 否则，向上找第一个左链接指向的树包含该节点的祖先节点。
     */
    public TreeLinkNode GetNext2(TreeLinkNode pNode) {
        if (pNode.right != null) {
            TreeLinkNode cur = pNode.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            return cur;
        } else {
            while (pNode.next != null) {
                TreeLinkNode parent = pNode.next;
                if (parent.left == pNode) {
                    return parent;
                }
                pNode = parent;
            }
        }
        return null;
    }

    /**
     * 获取中序遍历
     */
    private int[] getInOrder(TreeLinkNode node) {
        if (node == null) {
            return new int[]{};
        }
        return concat(getInOrder(node.left), node.val, getInOrder(node.right));
    }

    /**
     * 左+中+右
     */
    private int[] concat(int[] pre, int val, int[] post) {
        int length = pre.length + 1 + post.length;
        int[] ans = new int[length];
        System.arraycopy(pre, 0, ans, 0, pre.length);
        ans[pre.length] = val;
        System.arraycopy(post, 0, ans, pre.length + 1, post.length);
        return ans;
    }

    public static void main(String[] args) {
        TreeLinkNode node5 = new TreeLinkNode(5);
        TreeLinkNode node6 = new TreeLinkNode(6);
        TreeLinkNode node7 = new TreeLinkNode(7);
        TreeLinkNode node8 = new TreeLinkNode(8);
        TreeLinkNode node9 = new TreeLinkNode(9);
        TreeLinkNode node10 = new TreeLinkNode(10);
        TreeLinkNode node11 = new TreeLinkNode(11);
        node8.left = node6;
        node6.next = node8;
        node8.right = node10;
        node10.next = node8;
        node6.left = node5;
        node5.next = node6;
        node6.right = node7;
        node7.next = node6;
        node10.left = node9;
        node9.next = node10;
        node10.right = node11;
        node11.next = node10;
        System.out.println(node8);
        System.out.println(
                Arrays.toString(
                        new Jz57().getInOrder(node8)
                )
        );
        TreeLinkNode ans = new Jz57().GetNext2(node8);
        System.out.println(
                ans != null ? ans.val : null
        );
    }
}
