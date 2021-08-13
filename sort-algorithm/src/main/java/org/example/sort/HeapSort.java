package org.example.sort;

/**
 * @author lifei
 */
public class HeapSort extends Sort {
    @Override
    public void sort(int[] nums) {
        int n = nums.length;
        // 构建大顶堆
        for (int i = n / 2 - 1; i >= 0; i--) {
            adjustHeap(nums, i, n);
        }
        // 调整堆结构+交换堆顶元素与末尾元素
        for (int j = n - 1; j > 0; j--) {
            swap(nums, 0, j);
            adjustHeap(nums, 0, j);
        }
    }

    public void adjustHeap(int[] nums, int i, int length) {
        // 先取出当前元素
        int tmp = nums[i];
        // 从i结点的左子结点开始，也就是2i+1处开始
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && nums[k] < nums[k + 1]) {
                // 如果左子结点小于右子结点，k指向右子结点
                k++;
            }
            if (nums[k] > tmp) {
                // 如果子节点大于父节点，将子节点值赋给父节点
                nums[i] = nums[k];
                i = k;
            } else {
                break;
            }
        }
        // 将tmp值放到最终的位置
        nums[i] = tmp;
    }
}
