package org.example.sort.t;

import java.util.Arrays;

/**
 * @author lifei
 */
public class MergeSort<T extends Comparable<T>> extends Sort<T> {
    @Override
    public void sort(T[] nums) {
        int n = nums.length;
        tmp = nums.clone();
        mergeSort(nums, 0, n - 1);
    }

    private void mergeSort(T[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        System.out.println("low = " + low + ", high = " + high);
        System.out.println(Arrays.toString(nums));
        int mid = (low + high) / 2;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }

    T[] tmp;

    private void merge(T[] nums, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high) {
            if (less(nums[i], nums[j])) {
                tmp[k++] = nums[i++];
            } else {
                tmp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            tmp[k++] = nums[i++];
        }
        while (j <= high) {
            tmp[k++] = nums[j++];
        }
        for (i = low, k = 0; i <= high; i++, k++) {
            nums[i] = tmp[k];
        }
    }

    public static void main(String[] args) {
        Integer[] nums = new Integer[]{6, 4, 3, 2, 5, 1};
        System.out.println("排序前：" + Arrays.toString(nums));
        new MergeSort<Integer>().sort(nums);
        System.out.println("排序后：" + Arrays.toString(nums));
    }
}
