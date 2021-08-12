package org.example.sort.t;

import java.util.Arrays;

/**
 * @author lifei
 */
public class SelectionSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (less(nums[j], nums[i])) {
                    swap(nums, i, j);
                }
                System.out.println("i = " + i + ", j = " + j);
                System.out.println(Arrays.toString(nums));
            }
        }
    }

    /**
     * 优化
     */
    public void sort2(T[] nums) {
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(nums[j], nums[min])) {
                    min = j;
                }
            }
            if (min != i) {
                swap(nums, i, min);
            }
            System.out.println("i = " + i + ", min = " + min);
            System.out.println(Arrays.toString(nums));
        }
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{6, 4, 3, 2, 5, 1};
        System.out.println("排序前：" + Arrays.toString(nums));
        new SelectionSort<Integer>().sort2(nums);
        System.out.println("排序后：" + Arrays.toString(nums));
    }
}
