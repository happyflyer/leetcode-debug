package org.example.exam.baidu1;

import java.util.Arrays;

/**
 * 快速排序：6 3 8 2 9 1
 *
 * @author lifei
 */
public class Solution2 {
    private void sort(int[] nums) {
        int n = nums.length;
        quickSort(nums, 0, n - 1);
    }

    private void quickSort(int[] nums, int low, int high) {
        if (low > high) {
            return;
        }
        int pivot = nums[low];
        int i = low;
        int j = high;
        while (i < j) {
            while (i < j && nums[j] >= pivot) {
                j--;
            }
            while (i < j && nums[i] <= pivot) {
                i++;
            }
            if (i < j) {
                swap(nums, i, j);
            }
        }
        swap(nums, low, i);
        quickSort(nums, low, i - 1);
        quickSort(nums, i + 1, high);
    }

    public void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{6, 3, 8, 2, 9, 1};
        new Solution2().sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
