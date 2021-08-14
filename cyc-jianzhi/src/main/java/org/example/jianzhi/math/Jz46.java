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
     * 模拟
     */
    public int LastRemaining_Solution2(int n, int m) {
        int[] visited = new int[n];
        int cnt = n;
        int pos = 0;
        while (cnt > 1) {
            // 向后走m-1步，遇到访问过的不算
            int tmp = m - 1;
            while (tmp > 0) {
                pos = (pos + 1) % n;
                if (visited[pos] == 0) {
                    tmp--;
                }
            }
            visited[pos] = 1;
            // 走到下一个，遇到访问过的不算
            while (visited[pos] == 1) {
                pos = (pos + 1) % n;
            }
            cnt--;
            System.out.println(Arrays.toString(visited));
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 约瑟夫环
     * https://blog.csdn.net/u011500062/article/details/72855826
     * 递归
     */
    public int LastRemaining_Solution3(int n, int m) {
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return 0;
        }
        return (LastRemaining_Solution3(n - 1, m) + m) % n;
    }

    /**
     * 迭代
     */
    public int LastRemaining_Solution4(int n, int m) {
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return 0;
        }
        int[] cache = new int[n + 1];
        cache[0] = -1;
        cache[1] = 0;
        for (int i = 2; i <= n; i++) {
            cache[i] = (cache[i - 1] + m) % i;
        }
        return cache[n];
    }

    public static void main(String[] args) {
        System.out.println(
                new Jz46().LastRemaining_Solution3(5, 3)
        );
    }
}
