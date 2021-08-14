package org.example.jianzhi.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.nowcoder.com/practice/91b69814117f4e8097390d107d2efbe0?tpId=13&tqId=11212
 *
 * @author lifei
 */
public class Jz59 {
    /**
     * 广度优先搜索，借助队列
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (pRoot == null) {
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(pRoot);
        int rowCount = queue.size();
        boolean rowReverse = false;
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
                if (rowReverse) {
                    Collections.reverse(rowList);
                }
                rowReverse = !rowReverse;
                ans.add(rowList);
                rowList = new ArrayList<>();
                rowCount = queue.size();
            }
        }
        return ans;
    }

    public static void main(String[] args) {
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
        System.out.println(
                new Jz59().Print(node1)
        );
    }
}
