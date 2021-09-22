package org.example.exam.vivo;

import java.util.Arrays;

/**
 * 题目描述：
 * 输入：
 * [1,2,3,4,5],[2.0, 3.0, 1.0, 4.0, 2.0],[0.2, 0.1, 0.2, 0.1, 0.4],9.5
 * 输出：
 * [1,2,3,5]
 * 说明：
 * 通过：50
 *
 * @author lifei
 */
public class Solution1 {
    public int[] calculateUserList(int[] userIdList, double[] costList, double[] conversionList, double avg_cost) {
        double[][] tmp = new double[userIdList.length][3];
        for (int i = 0; i < userIdList.length; i++) {
            tmp[i][0] = userIdList[i];
            tmp[i][1] = costList[i];
            tmp[i][2] = conversionList[i];
        }
        Arrays.sort(tmp, (arr1, arr2) -> {
            double t1 = arr1[1] / arr1[2];
            double t2 = arr2[1] / arr2[2];
            if (t1 < t2) {
                return -1;
            } else if (t1 > t2) {
                return 1;
            }
            return 0;
        });
        int index = 0;
        double sumCost = tmp[0][1];
        double sumConversion = tmp[0][2];
        while (index < userIdList.length && sumCost / sumConversion < avg_cost) {
            index++;
            sumCost += tmp[index][1];
            sumConversion += tmp[index][2];
        }
        int[] res = new int[index];
        for (int i = 0; i < index; i++) {
            res[i] = (int) tmp[i][0];
        }
        Arrays.sort(res);
        return res;
    }

    public static void main(String[] args) {
    }
}
