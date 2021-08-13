package org.example.sort;

/**
 * @author lifei
 */
public class MergeSort extends Sort {
    @Override
    public void sort(int[] nums) {
        int n = nums.length;
        tmp = nums.clone();
        mergeSort(nums, 0, n - 1);
    }

    private void mergeSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);
        merge(nums, low, mid, high);
    }

    int[] tmp;

    private void merge(int[] nums, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high) {
            if (nums[i] <= nums[j]) {
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
}
