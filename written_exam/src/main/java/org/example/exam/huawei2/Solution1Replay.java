package org.example.exam.huawei2;

import java.util.Scanner;

/**
 * 题目描述：
 * 输入：
 * 1 3 5
 * 2
 * 输出：
 * 3
 * 说明：
 * 通过：
 *
 * @author lifei
 */
public class Solution1Replay {
    public static int getAns(int[] workstations, int[] sterilizers) {
        int left = 1;
        int right = 1000000000;
        // 搜索区间[left,right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (canCoverAll(workstations, sterilizers, mid) >= workstations.length) {
                // 搜索区间[left,mid-1]
                right = mid - 1;
            } else {
                // 搜索区间[mid+1,right]
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * cover = f(radius)
     */
    private static int canCoverAll(int[] workstations, int[] sterilizers, int radius) {
        int n = workstations.length;
        // 能覆盖到的工位数
        int cover = 0;
        for (int center : sterilizers) {
            while (cover < n
                    && center - radius <= workstations[cover]
                    && center + radius >= workstations[cover]) {
                cover++;
            }
        }
        return cover;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] line1 = input.nextLine().split(" ");
        int[] workstations = new int[line1.length];
        for (int i = 0; i < line1.length; i++) {
            workstations[i] = Integer.parseInt(line1[i]);
        }
        String[] line2 = input.nextLine().split(" ");
        int[] sterilizers = new int[line2.length];
        for (int i = 0; i < line2.length; i++) {
            sterilizers[i] = Integer.parseInt(line2[i]);
        }
        System.out.println(getAns(workstations, sterilizers));
    }
}
