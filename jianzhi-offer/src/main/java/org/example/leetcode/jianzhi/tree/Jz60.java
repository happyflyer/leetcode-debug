package org.example.leetcode.jianzhi.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.nowcoder.com/practice/445c44d982d04483b04a54f298796288?tpId=13&tqId=11213
 *
 * @author lifei
 */
public class Jz60 {
    /**
     * 广度优先搜索，借助队列
     */
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (pRoot == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        int rowCount = queue.size();
        ArrayList<Integer> rowList = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            rowList.add(cur.val);
            rowCount--;
            if (cur.left != null) {
                queue.offer(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
            }
            if (rowCount == 0) {
                // 遇到行尾
                ans.add(rowList);
                rowList = new ArrayList<>();
                rowCount = queue.size();
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        System.out.println(node1);
        System.out.println(
                new Jz60().Print(node1)
        );
    }
}
