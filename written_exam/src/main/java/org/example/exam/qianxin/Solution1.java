package org.example.exam.qianxin;

import java.util.LinkedList;
import java.util.List;

/**
 * 题目描述：
 * 输入：3,5
 * 输出：1
 * 说明：
 * 通过：AC
 *
 * @author lifei
 */
public class Solution1 {
    /**
     * 约瑟夫环。
     */
    public int DoPermute(int M, int N) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            list.add(i);
        }
        int winner = 0;
        while (list.size() > 1) {
            winner = (winner + M - 1) % list.size();
            list.remove(winner);
            M++;
            // System.out.println(list);
        }
        return list.get(0) + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().DoPermute(3, 5));
    }
}
