package org.example.exam.baidu2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 题目描述：
 * 输入：
 * 6 5
 * eecbad
 * 输出：
 * 3
 * <p>
 * 输入：
 * 10 2
 * aaaccebecd
 * 输出：
 * 126
 *
 * @author lifei
 */
public class Solution3 {
    public static int getAns(int n, int k, String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        System.out.println(map);
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // int k = sc.nextInt();
        // String s = sc.next();
        int n = 6;
        int k = 5;
        String s = "eecbad";
        // int n = 10;
        // int k = 2;
        // String s = "aaaccebecd";
        System.out.println(getAns(n, k, s) % 1000000007);
    }
}
