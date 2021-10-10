package org.example.exam.kedaxunfei1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 题目描述：每层向右移动k。
 * 输入：{1,2,3,4,5,#,6,#,#,7},1
 * 输出：{1,2,5,6,3,#,7,#,#,4}
 * 说明：
 * 输入：{2,3,5,1,#,#,4},2
 * 输出：{2,3,5,1,#,#,4}
 * 通过：
 *
 * @author lifei
 */
public class Solution3 {
    public TreeNode shiftTree(TreeNode root, int k) {
        // VL表
        int[] valToLayer = new int[100001];
        // VI表
        int[] valToIndex = new int[100001];
        // LV表
        Map<Integer, LinkedList<Integer>> layerToVals = new HashMap<>();
        build(root, valToLayer, valToIndex, layerToVals);
        shift(root, k, valToLayer, valToIndex, layerToVals);
        return root;
    }

    /**
     * 返回当前层号。
     */
    private int build(TreeNode root,
                      int[] valToLayer,
                      int[] valToIndex,
                      Map<Integer, LinkedList<Integer>> layerToVals) {
        if (root == null) {
            return 0;
        }
        int left = build(root.left, valToLayer, valToIndex, layerToVals);
        int right = build(root.right, valToLayer, valToIndex, layerToVals);
        int curLayer = Math.max(left, right) + 1;
        // 更新VL表
        valToLayer[root.val] = curLayer;
        // 更新VI表
        LinkedList<Integer> vals = layerToVals.getOrDefault(curLayer, new LinkedList<>());
        valToIndex[root.val] = vals.size();
        // 更新LV表
        vals.addLast(root.val);
        layerToVals.put(curLayer, vals);
        return curLayer;
    }

    private void shift(TreeNode root,
                       int k,
                       int[] valToLayer,
                       int[] valToIndex,
                       Map<Integer, LinkedList<Integer>> layerToVals) {
        if (root == null) {
            return;
        }
        // 找到替换当前位置的那个val
        int layer = valToLayer[root.val];
        int index = valToIndex[root.val];
        LinkedList<Integer> vals = layerToVals.getOrDefault(layer, new LinkedList<>());
        int size = vals.size();
        // index = (index2 + k) % size
        int index2 = index - k;
        index2 = index2 >= 0 ? index2 : index2 + size;
        root.val = vals.get(index2);
        shift(root.left, k, valToLayer, valToIndex, layerToVals);
        shift(root.right, k, valToLayer, valToIndex, layerToVals);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node6;
        node5.left = node7;
        System.out.println(new Solution3().shiftTree(node1, 1));
    }
}
