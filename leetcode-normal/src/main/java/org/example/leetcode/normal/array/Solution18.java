package org.example.leetcode.normal.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode-cn.com/problems/4sum/
 *
 * @author lifei
 */
public class Solution18 {
    /**
     * 双指针
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return ans;
        }
        int n = nums.length;
        Arrays.sort(nums);
        int a;
        int b;
        int c;
        int d;
        int cur;
        // 时间复杂度：O(n^3)
        for (a = 0; a < n; a++) {
            if (a > n - 4) {
                continue;
            }
            for (b = a + 1; b < n; b++) {
                if (b > n - 3) {
                    continue;
                }
                c = b + 1;
                d = n - 1;
                while (c < d) {
                    cur = nums[a] + nums[b] + nums[c] + nums[d];
                    if (cur == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[a]);
                        list.add(nums[b]);
                        list.add(nums[c]);
                        list.add(nums[d]);
                        // 去重
                        if (!ans.contains(list)) {
                            ans.add(list);
                        }
                    }
                    if (cur < target) {
                        if (c < n - 1) {
                            c++;
                        } else {
                            break;
                        }
                    } else {
                        if (d > b + 1) {
                            d--;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution18().fourSum(
                        new int[]{1, 0, -1, 0, -2, 2},
                        0
                )
        );
    }
}
