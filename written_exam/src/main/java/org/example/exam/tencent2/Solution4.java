package org.example.exam.tencent2;

import java.util.*;

/**
 * 输入：10 3 10
 * 输出：5
 * <p>
 * 输入：5 1 7
 * 输出：5
 * <p>
 * 输入：66666 12345 54321
 * 输出：21351
 * <p>
 * 30.00%
 *
 * @author lifei
 */
public class Solution4 {
    public static int getAns(int n, int l, int r) {
        Map<Integer, Deque<Integer>> map = new HashMap<>();
        Deque<Integer> q = traverse(n, map);
        // System.out.println(q);
        int sum = 0;
        int i = 1;
        while (i < l) {
            q.removeFirst();
            i++;
        }
        while (i <= r) {
            sum += q.removeFirst();
            i++;
        }
        return sum;
    }

    private static Deque<Integer> traverse(int n, Map<Integer, Deque<Integer>> map) {
        Deque<Integer> res = new LinkedList<>();
        if (n == 1) {
            res.add(n);
            return res;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        }
        Deque<Integer> tmp = traverse(n / 2, map);
        res.addAll(tmp);
        res.add(n % 2);
        res.addAll(tmp);
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int r = sc.nextInt();
        // int n = 66666;
        // int l = 12345;
        // int r = 54321;
        System.out.println(getAns(n, l, r));
    }
}
