package org.example.jianzhi.tree;

import java.util.ArrayList;

/**
 * https://www.nowcoder.com/practice/b736e784e3e34731af99065031301bca?tpId=13&tqId=11177
 *
 * @author lifei
 */
public class Jz24 {
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root != null) {
            dfs(root, 0, new ArrayList<>(), target);
        }
        return ans;
    }

    /**
     * 深度优先搜索，递归
     */
    public void dfs(TreeNode cur, int sum, ArrayList<Integer> path, int target) {
        path.add(cur.val);
        sum += cur.val;
        // cur 是叶子节点
        if (cur.left == null && cur.right == null) {
            if (sum == target) {
                ans.add(new ArrayList<>(path));
            }
            return;
        }
        if (cur.left != null) {
            dfs(cur.left, sum, path, target);
            path.remove(path.size() - 1);
        }
        if (cur.right != null) {
            dfs(cur.right, sum, path, target);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(12);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        System.out.println(node1);
        System.out.println(
                new Jz24().FindPath(node1, 22)
        );
    }
}
