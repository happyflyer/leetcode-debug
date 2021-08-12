package org.example.jianzhi.math;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * https://www.nowcoder.com/practice/f78a359491e64a50bce2d89cff857eb6?tpId=13&tqId=11199
 *
 * @author lifei
 */
public class Jz46 {
    /**
     * 模拟
     */
    public int LastRemaining_Solution(int n, int m) {
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int winner = 0;
        while (list.size() > 1) {
            winner = (winner + m - 1) % list.size();
            list.remove(winner);
            System.out.println(list);
        }
        return list.size() == 1 ? list.get(0) : -1;
    }

    /**
     * 约瑟夫环
     */
    public int LastRemaining_Solution2(int n, int m) {
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return 0;
        }
        return (LastRemaining_Solution2(n - 1, m) + m) % n;
    }

    /**
     * 迭代
     */
    public int LastRemaining_Solution3(int n, int m) {
        if (n <= 0) {
            return -1;
        }
        int index = 0;
        for (int i = 2; i <= n; i++) {
            index = (index + m) % i;
        }
        return index;
    }

    /**
     * 辅助数组
     */
    public int LastRemaining_Solution4(int n, int m) {
        int[] mark = new int[n];
        for (int i = 0; i < n; i++) {
            mark[i] = 1;
        }
        int cnt = n;
        int pos = 0;
        while (cnt > 1) {
            // 向后移动m次
            int tmp = m;
            while (tmp-- > 0) {
                pos += (pos + 1) % n;
                if (mark[pos] == 1) {
                    tmp--;
                }
            }
            while (mark[pos] == 0) {
                pos = (pos + 1) % n;
            }
            mark[pos] = 0;
            System.out.println(Arrays.toString(mark));
            pos++;
            cnt--;
        }
        for (int i = 0; i < n; i++) {
            if (mark[i] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(
                new Jz46().LastRemaining_Solution4(5, 3)
        );
    }
}
