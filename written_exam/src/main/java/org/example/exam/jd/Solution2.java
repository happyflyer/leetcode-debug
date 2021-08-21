package org.example.exam.jd;

import java.util.Scanner;

/**
 * 小明有一个只包含0和1的字符串，
 * 现在小明希望将整个字符串尽可能的切割成多个字符串，
 * 要求是每个字符串里面0出现的次数和1出现的次数的比例是一致的。
 * 解释：假设一个字符串出现0的次数是a次，出现1的次数是b，
 * 另一个字符串出现0的次数是c次，出现1的次数是d次，
 * 那么这两个字符串01出现次数比例相同表示a:b=c:d，即a*d=b*c。
 * 注意这里a,b,c,d都是可以为0的。
 * 现在对于一个字符串的所有前缀字符串，
 * 输出最多可以切割成多少个符合要求的字符串。
 * 输入描述：
 * 第一行一个整数n，表示01字符串的长度，1<=n<=500000
 * 第二行一个长度为n的01字符串。
 * 输出描述：
 * 一行n个整数，第i个数表示原字符串中下标由0到i组成的前缀字符串可以切割出多少符合要求的字符串。
 * <p>
 * 输入：
 * 3
 * 001
 * 输出：
 * 1 2 1
 * 说明：
 * 第一个前缀字符串是0，没法切，答案是1
 * 第二个前缀字符串是00，可以切得到0，0，答案是2
 * 第三个前缀字符串是001，可以切，但是切后没法保证比例要求，因此答案是1
 * <p>
 * 样例2：
 * 输入：
 * 4
 * 0000
 * 输出：
 * 1 2 3 4
 * <p>
 * 样例3：
 * 输入：
 * 4
 * 0101
 * 输出：
 * 1 1 1 2
 * 样例4：
 * 输入：
 * 9
 * 010100001
 * 输出：
 * 1 1 1 2 1 2 1 1 3
 * <p>
 * AC：9%
 *
 * @author lifei
 */
public class Solution2 {
    public static void getCount(int n, String s) {
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = getInt(s.substring(0, i + 1));
        }
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(ans[i]);
        }
    }

    private static int getInt(String s) {
        int n = s.length();
        int cnt0 = getZeroCount(s);
        if (cnt0 == 0 || cnt0 == n) {
            return n;
        }
        if (cnt0 == 1 || cnt0 == n - 1) {
            return 1;
        }
        int cnt1 = n - cnt0;
        int base = getBase(cnt0, cnt1);
        if (base == 1){
            return 1;
        }
        int unit = cnt0 / base + cnt1 / base;
        int i = 0;
        while (i < n) {
            int tmp = getZeroCount(s.substring(i, i + unit));
            // tmp:unit == cnt1:n
            if (tmp == 0 || tmp == unit || tmp * n != cnt0 * unit) {
                return 1;
            }
            i += unit;
        }
        return n / unit;
    }

    private static int getZeroCount(String s) {
        int cnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '0') {
                cnt++;
            }
        }
        return cnt;
    }

    private static int getBase(int a, int b) {
        if (a == b) {
            return a;
        }
        if (a > b) {
            if (a % b == 0) {
                return b;
            } else {
                return getBase(b, a - b);
            }
        } else {
            return getBase(b, a);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        getCount(n, s);
    }
}
