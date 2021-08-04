package org.example.leetcode.jianzhi.binary;

/**
 * https://www.nowcoder.com/practice/70610bf967994b22bb1c26f9ae901fa2?tpId=13&tqId=11190
 *
 * @author lifei
 */
public class Jz37 {
    /**
     * 遍历一遍
     */
    public int GetNumberOfK(int[] array, int k) {
        int cnt = 0;
        for (int i : array) {
            if (i == k) {
                cnt++;
            } else if (i > k) {
                break;
            }
        }
        return cnt;
    }

    /**
     * 二分查找
     */
    public int GetNumberOfK2(int[] array, int k) {
        int n = array.length;
        if (n == 1) {
            return array[0] == k ? 1 : 0;
        }
        int cnt = 0;
        int low = 0;
        int high = n - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (array[mid] < k) {
                low = mid + 1;
            } else if (array[mid] > k) {
                high = mid;
            } else {
                int cur = mid;
                while (cur < n && array[cur] == k) {
                    cnt++;
                    cur++;
                }
                cur = mid - 1;
                while (cur >= 0 && array[cur] == k) {
                    cnt++;
                    cur--;
                }
                break;
            }
        }
        return cnt;
    }

    /**
     * 二分查找
     */
    public int GetNumberOfK3(int[] array, int k) {
        int kStart = binarySearchStart(array, k);
        int k1Start = binarySearchStart(array, k + 1);
        return (kStart == array.length || array[kStart] != k) ? 0 : k1Start - kStart;
    }

    /**
     * 标准的二分查找
     */
    private int binarySearch(int[] array, int k) {
        int n = array.length;
        int low = 0;
        int high = n - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (array[mid] == k) {
                return mid;
            } else if (array[mid] < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return -1;
    }

    /**
     * 二分查找，非递减序列中第一个出现的位置。
     * k小于整个序列返回0，k大于整个序列返回n。
     */
    private int binarySearchStart(int[] array, int k) {
        int n = array.length;
        int low = 0;
        int high = n;
        while (low < high) {
            int mid = (low + high) / 2;
            if (array[mid] >= k) {
                high = mid;
            } else if (array[mid] < k) {
                low = mid + 1;
            }
        }
        // return array[low] == k ? low : -1;
        return low;
    }

    public static void main(String[] args) {
        System.out.println(
                new Jz37().GetNumberOfK3(new int[]{1, 3, 3, 3, 3, 4, 5}, 6)
        );
    }
}
