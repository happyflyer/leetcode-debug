package org.example.sort;

/**
 * @author lifei
 */
public abstract class Sort {
    public abstract void sort(int[] nums);

    protected void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
