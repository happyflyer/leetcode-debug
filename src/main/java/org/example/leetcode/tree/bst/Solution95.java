package org.example.leetcode.tree.bst;

import org.example.leetcode.tree.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 * <p>
 * 中等
 *
 * @author lifei
 */
public class Solution95 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return build(1, n);
    }

    private List<TreeNode> build(int low, int high) {
        List<TreeNode> res = new LinkedList<>();
        if (low > high) {
            res.add(null);
            return res;
        }
        for (int i = low; i <= high; i++) {
            List<TreeNode> left = build(low, i - 1);
            List<TreeNode> right = build(i + 1, high);
            for (TreeNode node1 : left) {
                for (TreeNode node2 : right) {
                    TreeNode root = new TreeNode(i);
                    root.left = node1;
                    root.right = node2;
                    res.add(root);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
    }
}
