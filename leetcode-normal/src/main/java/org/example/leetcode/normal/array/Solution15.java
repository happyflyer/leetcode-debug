package org.example.leetcode.normal.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/3sum/
 *
 * @author lifei
 */
public class Solution15 {
    /**
     * 双指针
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        // 枚举 a
        for (int a = 0; a < n; ++a) {
            // 需要和上一次枚举的数不相同
            // 第一个数字一定是负数
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            // c 对应的指针初始指向数组的最右端
            int c = n - 1;
            int target = -nums[a];
            // 枚举 b
            for (int b = a + 1; b < n; ++b) {
                // 需要和上一次枚举的数不相同
                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    continue;
                }
                // 需要保证 b 的指针在 c 的指针的左侧
                while (b < c && nums[b] + nums[c] > target) {
                    --c;
                }
                // 如果指针重合，随着 b 后续的增加
                // 就不会有满足 a+b+c=0 并且 b<c 的 c 了，可以退出循环
                if (b == c) {
                    break;
                }
                if (nums[b] + nums[c] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[a]);
                    list.add(nums[b]);
                    list.add(nums[c]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution15().threeSum(
                        new int[]{-1, 0, 1, 2, -1, -4}
                )
        );
    }
}
