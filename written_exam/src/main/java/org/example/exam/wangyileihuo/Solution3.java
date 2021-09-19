package org.example.exam.wangyileihuo;

import java.util.*;

/**
 * 题目描述：
 * 输入：
 * 7 1 3
 * ABBCCBA
 * C
 * 输出：
 * 6
 * 说明：
 * 通过：
 *
 * @author lifei
 */
public class Solution3 {
    public static int getAns(int L1, int L2, int M, String s1, String s2) {
        int max = 0;
        LinkedList<Character> list = new LinkedList<>();
        for (char c : s1.toCharArray()) {
            list.addLast(c);
        }
        int ans = 0;
        ans = getScore(list, M);
        for (int i = 0; i < L2; i++) {
            char cur = s2.charAt(i);
            for (int j = 0; j <= list.size(); j++) {
                list.add(j, cur);
                ans = Math.max(ans, getScore(list, M));
                list.remove(j);
            }
            System.out.println(ans);
        }
        return max;
    }

    public static int getScore(List<Character> list, int m) {
        int score = 0;
        if (list.size() < 2) {
            return score;
        }
        int start = 0;
        int end = 1;
        while (end < list.size()) {
            // 相同，end++
            if (list.get(end).equals(list.get(start))) {
                end++;
                continue;
            }
            // 不同，算得分
            if (end - start >= m) {
                score += (end - start);
                // 删除[start,end)元素
                while (start < end) {
                    list.remove(start);
                    end--;
                }
            }
            start = end;
            end++;
        }
        return score == 0 ? score : (score + getScore(list, m));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int L1 = sc.nextInt();
        int L2 = sc.nextInt();
        int M = sc.nextInt();
        String s1 = sc.next();
        String s2 = sc.next();
        System.out.println(getAns(L1, L2, M, s1, s2));
    }
}
