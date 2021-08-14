package org.example.jianzhi.binary;

import java.util.Arrays;

/**
 * https://www.nowcoder.com/practice/9f3231a991af4f55b95579b44b7a01ba?tpId=13&tqId=11159
 *
 * @author lifei
 */
public class Jz6 {
    /**
     * 遍历一遍
     */
    public int minNumberInRotateArray(int[] array) {
        int n = array.length;
        if (n == 0) {
            return 0;
        }
        int pos = n - 1;
        while (pos > 0) {
            if (array[pos - 1] > array[pos]) {
                break;
            }
            pos--;
        }
        return array[pos];
    }

    /**
     * 二分查找，递归
     */
    public int minNumberInRotateArray2(int[] array) {
        int n = array.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return array[0];
        }
        int mid = (n - 1) / 2;
        if (array[mid] > array[n - 1]) {
            return minNumberInRotateArray2(Arrays.copyOfRange(array, mid + 1, n));
        } else if (array[mid] < array[n - 1]) {
            return minNumberInRotateArray2(Arrays.copyOfRange(array, 0, mid + 1));
        } else {
            return minNumberInRotateArray2(Arrays.copyOfRange(array, 0, n - 1));
        }
    }

    /**
     * 二分查找
     */
    public int minNumberInRotateArray3(int[] array) {
        int n = array.length;
        if (n == 0) {
            return 0;
        }
        int low = 0;
        int high = n - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (array[mid] > array[high]) {
                low = mid + 1;
            } else if (array[mid] < array[high]) {
                high = mid;
            } else {
                high--;
            }
        }
        return array[low];
    }

    public static void main(String[] args) {
        System.out.println(
                new Jz6().minNumberInRotateArray3(new int[]{3, 4, 5, 1, 2})
        );
    }
}
