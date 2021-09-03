package org.example.leetcode.tree.bt;

import org.example.leetcode.tree.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/find-duplicate-subtrees/
 * <p>
 * 中等
 *
 * @author lifei
 */
public class Solution652 {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> map = new HashMap<>();
        List<TreeNode> ans = new LinkedList<>();
        traverse(root, map, ans);
        return ans;
    }

    private String traverse(TreeNode root, Map<String, Integer> map, List<TreeNode> ans) {
        if (root == null) {
            return "#";
        }
        String left = traverse(root.left, map, ans);
        String right = traverse(root.right, map, ans);
        String subTree = left + "," + right + "," + root.val;
        int freq = map.getOrDefault(subTree, 0);
        if (freq == 1) {
            ans.add(root);
        }
        map.put(subTree, freq + 1);
        return subTree;
    }

    public static void main(String[] args) {
    }
}
