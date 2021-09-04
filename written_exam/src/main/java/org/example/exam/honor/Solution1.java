package org.example.exam.honor;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 输入：192.168.1.1 192.168.1.2 255.255.255.0
 * 输出：1 192.168.1.0
 *
 * 输入：192.168.1.1 192.168.2.1 255.255.255.0
 * 输出：0 192.168.1.0
 *
 * @author lifei
 */
public class Solution1 {
    private static final String SEP = ".";
    private static final String SPLIT = "\\.";

    private static Map<String, String> getAns(String ip1, String ip2, String mask) {
        Map<String, String> ans = new HashMap<>();
        String[] arr1 = ip1.split(SPLIT);
        String[] arr2 = ip2.split(SPLIT);
        String[] arr3 = mask.split(SPLIT);
        boolean same = true;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            int num1 = Integer.parseInt(arr1[i]);
            int num2 = Integer.parseInt(arr2[i]);
            int num3 = Integer.parseInt(arr3[i]);
            same = same && ((num1 & num3) == (num2 & num3));
            sb.append(SEP);
            sb.append(num1 & num3);
        }
        ans.put("ans1", same ? "1" : "0");
        ans.put("ans2", sb.substring(1));
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ip1 = sc.next();
        String ip2 = sc.next();
        String mask = sc.next();
        // String ip1 = "192.168.9.1";
        // String ip2 = "192.168.9.78";
        // String mask = "255.255.255.192";
        Map<String, String> ans = getAns(ip1, ip2, mask);
        System.out.print(ans.get("ans1"));
        System.out.print(" ");
        System.out.print(ans.get("ans2"));
    }
}
