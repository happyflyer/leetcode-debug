package org.example.exam.alibaba;

import java.util.Scanner;

/**
 * n,m
 * a1,a2,...,an表示每个队伍的人数
 * i和j结盟计算：(i+j)^(x+y)
 * x,y表示人数
 * t,a,b
 * t=1表示结盟
 * t=2表示查询
 * <p>
 * 输入：
 * 6 9
 * 1 2 3 3 2 1
 * 2 6 3
 * 1 1 1
 * 1 6 1
 * 2 3 6
 * 2 1 6
 * 1 6 3
 * 1 1 3
 * 2 1 3
 * 2 6 3
 * 输出：
 * NO
 * 7
 * NO
 * YES
 * 5
 * YES
 * YES
 * <p>
 * AF
 *
 * @author lifei
 */
public class Solution2 {
    private static void getPrint(int n, int m, int[] persons,
                                 int[] alias, int[] aliaPersons,
                                 int[] tArr, int[] aArr, int[] bArr) {
        for (int i = 0; i < m; i++) {
        }
    }

    private void calcPayAndSetAlias(int[] persons, int[] alias, int[] aliaPersons,
                                    int i, int j) {
        if (i != alias[i]) {
            i = alias[i];
        }
        if (j != alias[j]) {
            j = alias[j];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        // 部队人数
        int[] persons = new int[n];
        int i = 0;
        while (i < n) {
            persons[i] = sc.nextInt();
            i++;
        }
        int[] tArr = new int[m];
        int[] aArr = new int[m];
        int[] bArr = new int[m];
        i = 0;
        while (i < m) {
            tArr[i] = sc.nextInt();
            aArr[i] = sc.nextInt();
            bArr[i] = sc.nextInt();
            i++;
        }
        // 所属联盟，初始化
        int[] alias = new int[n];
        for (i = 0; i < n; i++) {
            alias[i] = i;
        }
        // 联盟人数
        int[] aliaPersons = persons.clone();
        // 处理
        getPrint(n, m, persons, alias, aliaPersons, tArr, aArr, bArr);
    }
}
