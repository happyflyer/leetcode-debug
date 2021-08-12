package org.example.exam.yuanfudao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 中奖种类多少种。
 * n个数，
 * 抽m次（抽完放回），
 * 按照抽取顺序组成m位的C，
 * C%x=k 且 C任意相邻位上数和为奇数，中奖。
 * <p>
 * 输入：
 * 3 2 0 2
 * 1 4 3
 * 输出：
 * 2
 * 说明：
 * 11 14 13 41 44 43 31 34 33，中奖的是：14 34
 * <p>
 * 输入：
 * 3 3 1 2
 * 1 4 3
 * 输出：
 * 4
 * 说明：
 * 141 143 341 343
 *
 * @author lifei
 */
public class Solution3 {
    private List<Integer> winNumbers;
    int[] winNumberArr;
    int x;
    int k;

    public int getCount(int n, int m, int k, int x, int[] arr) {
        winNumbers = new ArrayList<>();
        winNumberArr = new int[m];
        this.x = x;
        this.k = k;
        int[][] oddArrAndEvenArr = getOddArrAndEvenArr(arr);
        int[] oddArr = oddArrAndEvenArr[0];
        int[] evenArr = oddArrAndEvenArr[1];
        System.out.println("奇数：" + Arrays.toString(oddArr));
        System.out.println("偶数：" + Arrays.toString(evenArr));
        getCrossNumber(oddArr, evenArr, m - 1);
        getCrossNumber(evenArr, oddArr, m - 1);
        return winNumbers.size();
    }

    /**
     * 将arr中元素重新组织，奇数在前，偶数在后。
     */
    private int[][] getOddArrAndEvenArr(int[] arr) {
        int n = arr.length;
        int[][] ans = new int[2][];
        if (n == 1) {
            if (arr[0] % 2 == 1) {
                ans[0] = new int[]{arr[0]};
                ans[1] = new int[]{};
            } else {
                ans[0] = new int[]{};
                ans[1] = new int[]{arr[0]};
            }
            return ans;
        }
        int low = 0;
        int high = n - 1;
        while (low < high) {
            if (arr[low] % 2 == 0 && arr[high] % 2 == 1) {
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
                low++;
                high--;
                continue;
            }
            if (arr[low] % 2 == 1) {
                low++;
            }
            if (arr[high] % 2 == 0) {
                high--;
            }
        }
        ans[0] = Arrays.copyOfRange(arr, 0, low);
        ans[1] = Arrays.copyOfRange(arr, high + 1, n);
        return ans;
    }

    /**
     * arr转int
     */
    private int arr2Int(int[] arr) {
        int ans = 0;
        for (int j : arr) {
            ans = ans * 10 + j;
        }
        return ans;
    }

    /**
     * 获得奇偶交叉的int
     */
    private void getCrossNumber(int[] arr1, int[] arr2, int layer) {
        for (int i : arr1) {
            winNumberArr[layer] = i;
            if (layer == 0) {
                int j = arr2Int(winNumberArr);
                if (j % x == k) {
                    System.out.println("中奖数字：" + j);
                    winNumbers.add(j);
                }
            } else {
                getCrossNumber(arr2, arr1, layer - 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        String[] split = line1.split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int k = Integer.parseInt(split[2]);
        int x = Integer.parseInt(split[3]);
        String line2 = sc.nextLine();
        String[] strArr = line2.split(" ");
        int[] intArr = Arrays.stream(strArr).mapToInt(Integer::valueOf).toArray();
        System.out.println(new Solution3().getCount(n, m, k, x, intArr));
    }
}
