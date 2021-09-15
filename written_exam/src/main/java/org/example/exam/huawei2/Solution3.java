package org.example.exam.huawei2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述：
 * 输入：
 * a,1,5
 * b,3,5
 * c,1,3
 * 输出：
 * b c
 * 说明：
 * 通过：
 *
 * @author lifei
 */
public class Solution3 {
    public static void getAns(char[] clients, int[][] startEnd) {
        System.out.println(1);
        System.out.println(clients);
        System.out.println(Arrays.deepToString(startEnd));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] client = new char[15];
        int[][] startEnd = new int[15][2];
        int i = 0;
        while (sc.hasNext()) {
            String s = sc.next();
            if (s.contains(",")) {
                String[] sp = s.split(",");
                client[i] = sp[0].charAt(0);
                startEnd[i][0] = Integer.parseInt(sp[1]);
                startEnd[i][1] = Integer.parseInt(sp[2]);
                i++;
            }
        }
        getAns(client, startEnd);
    }
}
