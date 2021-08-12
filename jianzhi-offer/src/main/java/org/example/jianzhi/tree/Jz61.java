package org.example.jianzhi.tree;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.nowcoder.com/practice/cf7e25aa97c04cc1a68c8f040e71fb84?tpId=13&tqId=11214
 *
 * @author lifei
 */
public class Jz61 {
    public static final String SEPARATOR = ",";
    public static final String PLACEHOLDER = "#";

    /**
     * 实现一，根据层序遍历并特定标志空结点的方案序列化。
     * 广度优先，队列。
     */
    String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            return sb.toString();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode cur;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            if (cur == null) {
                sb.append(PLACEHOLDER);
                sb.append(SEPARATOR);
            } else {
                sb.append(cur.val);
                sb.append(SEPARATOR);
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }
        return sb.substring(0, sb.length() - 1);
    }

    TreeNode Deserialize(String str) {
        if (str.length() == 0) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        String[] split = str.split(SEPARATOR);
        int pos = 0;
        TreeNode head = new TreeNode(Integer.parseInt(split[pos++]));
        queue.offer(head);
        TreeNode cur;
        while (!queue.isEmpty()) {
            cur = queue.poll();
            if (PLACEHOLDER.equals(split[pos])) {
                cur.left = null;
            } else {
                TreeNode left = new TreeNode(Integer.parseInt(split[pos]));
                queue.offer(left);
                cur.left = left;
            }
            pos++;
            if (PLACEHOLDER.equals(split[pos])) {
                cur.right = null;
            } else {
                TreeNode right = new TreeNode(Integer.parseInt(split[pos]));
                queue.offer(right);
                cur.right = right;
            }
            pos++;
        }
        return head;
    }

    public static final Integer LENGTH_POS = -1;

    /**
     * 实现二，根据满二叉树结点位置的标号规律来序列化。
     */
    String Serialize2(TreeNode root) {
        String str = Serialize(root);
        String[] split = str.split(SEPARATOR);
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < split.length; i++) {
            if (!PLACEHOLDER.equals(split[i])) {
                map.put(i, Integer.parseInt(split[i]));
            }
        }
        map.put(LENGTH_POS, split.length);
        return JSON.toJSONString(map);
    }

    TreeNode Deserialize2(String str) {
        HashMap<Integer, Integer> map = JSON.parseObject(str, HashMap.class);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < map.get(LENGTH_POS); i++) {
            if (map.containsKey(i)) {
                sb.append(map.get(i));
            } else {
                sb.append(PLACEHOLDER);
            }
            sb.append(SEPARATOR);
        }
        return Deserialize(sb.substring(0, sb.length() - 1));
    }

    public static final String ORDER_SEPARATOR = "::";

    /**
     * 实现三：根据先序遍历和中序遍历的结果来序列化。
     */
    String Serialize3(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        sb.append(getPreOrder(root));
        sb.append(ORDER_SEPARATOR);
        sb.append(getInOrder(root));
        return sb.toString();
    }

    TreeNode Deserialize3(String str) {
        String[] split = str.split(ORDER_SEPARATOR);
        String[] preOrder = split[0].split(SEPARATOR);
        String[] inOrder = split[1].split(SEPARATOR);
        return reGenerateTree(preOrder, inOrder);
    }

    private TreeNode reGenerateTree(String[] pre, String[] in) {
        int n = pre.length;
        if (n == 0) {
            return null;
        } else {
            TreeNode root = new TreeNode(Integer.parseInt(pre[0]));
            if (n == 1) {
                return root;
            }
            int pos = -1;
            for (int i = 0; i < n; i++) {
                if (pre[0].equals(in[i])) {
                    pos = i;
                }
            }
            root.left = reGenerateTree(
                    Arrays.copyOfRange(pre, 1, pos + 1),
                    Arrays.copyOfRange(in, 0, pos)
            );
            root.right = reGenerateTree(
                    Arrays.copyOfRange(pre, pos + 1, n),
                    Arrays.copyOfRange(in, pos + 1, n)
            );
            return root;
        }
    }

    /**
     * 前序遍历
     */
    private String getPreOrder(TreeNode node) {
        StringBuilder sb = new StringBuilder();
        sb.append(node.val);
        sb.append(SEPARATOR);
        if (node.left != null) {
            sb.append(getPreOrder(node.left));
            sb.append(SEPARATOR);
        }
        if (node.right != null) {
            sb.append(getPreOrder(node.right));
            sb.append(SEPARATOR);
        }
        return sb.substring(0, sb.length() - 1);
    }

    /**
     * 中序遍历
     */
    private String getInOrder(TreeNode node) {
        StringBuilder sb = new StringBuilder();
        if (node.left != null) {
            sb.append(getInOrder(node.left));
            sb.append(SEPARATOR);
        }
        sb.append(node.val);
        sb.append(SEPARATOR);
        if (node.right != null) {
            sb.append(getInOrder(node.right));
            sb.append(SEPARATOR);
        }
        return sb.substring(0, sb.length() - 1);
    }

    /**
     * 后序遍历
     */
    private String getPostOrder(TreeNode node) {
        StringBuilder sb = new StringBuilder();
        if (node.left != null) {
            sb.append(getPostOrder(node.left));
            sb.append(SEPARATOR);
        }
        if (node.right != null) {
            sb.append(getPostOrder(node.right));
            sb.append(SEPARATOR);
        }
        sb.append(node.val);
        return sb.toString();
    }

    public static void main(String[] args) {
        // 树1
        // TreeNode node1 = new TreeNode(1);
        // TreeNode node2 = new TreeNode(2);
        // node1.right = node2;
        // System.out.println(node1);

        // 树2
        TreeNode node1 = new TreeNode(8);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(10);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(9);
        TreeNode node7 = new TreeNode(11);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        System.out.println(node1);

        // 测试 fasjson
        HashMap<Integer, Integer> map = new HashMap();
        map.put(0, 1);
        map.put(2, 2);
        System.out.println(map);
        String s = JSON.toJSONString(map);
        System.out.println(s);
        HashMap<Integer, Integer> map1 = JSON.parseObject(s, HashMap.class);
        System.out.println(map1);

        Jz61 jz61 = new Jz61();

        // 实现一
        System.out.println(jz61.Serialize(node1));
        System.out.println(jz61.Deserialize(jz61.Serialize(node1)));

        // 实现二
        System.out.println(jz61.Serialize2(node1));
        System.out.println(jz61.Deserialize2(jz61.Serialize2(node1)));

        // 测试先序遍历、中序遍历、后续遍历
        System.out.println(jz61.getPreOrder(node1));
        System.out.println(jz61.getInOrder(node1));
        System.out.println(jz61.getPostOrder(node1));

        // 实现三
        System.out.println(jz61.Serialize3(node1));
        System.out.println(jz61.Deserialize3(jz61.Serialize3(node1)));
    }
}
