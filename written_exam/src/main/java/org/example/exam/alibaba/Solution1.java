package org.example.exam.alibaba;

import java.util.Scanner;

/**
 * 计算所有变量占用的字节数。
 * <p>
 * 输入：long aaaa[10][10][10],b,c;
 * 输出：8016
 * <p>
 * 输入：char c,b,a[10000];
 * 输出：10002
 * <p>
 * 通过率：11%
 *
 * @author lifei
 */
public class Solution1 {
    private static int getByteCount(String s) {
        int sum = 0;
        // 排除分号
        s = s.trim();
        if (s.contains(";")) {
            String[] sp1 = s.split(";");
            for (String sp : sp1) {
                sum += getByteCount(sp);
            }
            return sum;
        }
        // 空格
        int unit = 0;
        s = s.trim();
        int n = s.length();
        if ("int".equals(s.substring(0, 3))) {
            unit = 4;
            s = s.substring(3, n);
        } else if ("long".equals(s.substring(0, 4))) {
            unit = 8;
            s = s.substring(4, n);
        } else if ("char".equals(s.substring(0, 4))) {
            unit = 1;
            s = s.substring(4, n);
        }
        // 逗号隔开
        String[] sp3 = s.split(",");
        for (String sp : sp3) {
            int ssum = unit;
            if (sp.contains("[")) {
                sp = sp.trim();
                String[] sp4 = sp.split("\\[");
                int len = sp4.length;
                for (int i = 1; i < len; i++) {
                    ssum *= Integer.parseInt(sp4[i].substring(0, sp4[i].length() - 1));
                }
            }
            sum += ssum;
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // String s = sc.next();
        String s = "long aaaa[10][10][10],b,c;";
        // String s = "char c,b,a[10000];";
        System.out.println(getByteCount(s));
    }
}
