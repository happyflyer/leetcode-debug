package org.example.exam.tencent2;

import java.util.*;

/**
 * 输入：
 * 3
 * 1 3 5
 * 4 2 6
 * 输出：
 * 0
 * <p>
 * 输入：
 * 3
 * 5 8 9
 * 4 12 6
 * 输出：
 * 1
 * <p>
 * 40.00%
 *
 * @author lifei
 */
public class Solution2 {
    public static int getAns(int n, int[] a, int[] b) {
        for (int i = 0; i < n; i++) {
            a[i] = getFactorCount(a[i]);
            b[i] = getFactorCount(b[i]);
        }
        // System.out.println(Arrays.toString(a));
        // System.out.println(Arrays.toString(b));
        Arrays.sort(a);
        Arrays.sort(b);
        int win = 0;
        int i = 0;
        int j = 0;
        int x = a.length - 1;
        int y = b.length - 1;
        while (i <= x) {
            if (a[x] > b[y]) {
                x--;
                y--;
                win++;
            } else if (a[i] > b[j]) {
                i++;
                j++;
                win++;
            } else {
                i++;
                y--;
            }
        }
        return win;
    }

    private static int getFactorCount(int n) {
        LinkedList<Integer> list = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int k = 2;
        while (k <= n) {
            if (k == n) {
                list.add(n);
                map.put(n, map.getOrDefault(n, 0) + 1);
                break;
            } else if (n % k == 0) {
                list.add(k);
                map.put(k, map.getOrDefault(k, 0) + 1);
                n /= k;
            } else {
                k++;
            }
        }
        // System.out.println(list);
        // System.out.print ln(map);
        int sum = 1;
        for (Integer value : map.values()) {
            sum *= (value + 1);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int i = 0;
        while (i < n) {
            a[i] = sc.nextInt();
            i++;
        }
        int j = 0;
        while (j < n) {
            b[j] = sc.nextInt();
            j++;
        }
        // int n = 3;
        // int[] a = new int[]{5, 8, 9};
        // int[] b = new int[]{4, 12, 6};
        System.out.println(getAns(n, a, b));
    }
}
