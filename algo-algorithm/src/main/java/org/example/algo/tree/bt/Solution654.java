package org.example.algo.tree.bt;

import org.example.algo.tree.TreeNode;

/**
 * https://leetcode-cn.com/problems/maximum-binary-tree/
 * <p>
 * 中等
 *
 * @author lifei
 */
public class Solution654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }

    private TreeNode construct(int[] nums, int low, int high) {
        if (low > high) {
            return null;
        }
        int maxVal = nums[low];
        int pos = low;
        for (int i = low + 1; i <= high; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                pos = i;
            }
        }
        TreeNode root = new TreeNode(maxVal);
        root.left = construct(nums, low, pos - 1);
        root.right = construct(nums, pos + 1, high);
        return root;
    }

    public static void main(String[] args) {
    }
}
