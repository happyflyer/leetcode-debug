package org.example.sort.t;

import java.util.Arrays;

/**
 * @author lifei
 */
public class BubbleSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (less(nums[j + 1], nums[j])) {
                    swap(nums, j, j + 1);
                }
                System.out.println("i = " + i + ", j = " + j);
                System.out.println(Arrays.toString(nums));
            }
        }
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{6, 4, 3, 2, 5, 1};
        System.out.println("排序前：" + Arrays.toString(nums));
        new BubbleSort<Integer>().sort(nums);
        System.out.println("排序后：" + Arrays.toString(nums));
    }
}
