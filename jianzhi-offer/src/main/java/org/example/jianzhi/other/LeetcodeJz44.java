package org.example.jianzhi.other;

/**
 * https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/
 *
 * @author lifei
 */
public class LeetcodeJz44 {
    /**
     * 暴力法，超时
     */
    public int findNthDigit(int n) {
        if (n < 10) {
            return n;
        }
        n -= 10;
        int num = 10;
        while (getCount(num) <= n) {
            System.out.println("num = " + num + ", n = " + n);
            n -= getCount(num);
            num++;
        }
        System.out.println("num = " + num + ", n = " + n);
        return getValue(num, n);
    }

    /**
     * n的位数
     */
    private int getCount(int n) {
        int cnt = 0;
        while (n > 0) {
            cnt++;
            n /= 10;
        }
        return cnt;
    }

    /**
     * n第i位上的数字，i从0开始
     */
    private int getValue(int n, int i) {
        i = getCount(n) - i;
        while (i > 1) {
            n /= 10;
            i--;
        }
        return n % 10;
    }

    /**
     * 使用api，超出内存限制
     */
    public int findNthDigit2(int n) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (sb.length() <= n) {
            sb.append(i);
            i++;
        }
        return sb.charAt(n) - '0';
    }

    public int findNthDigit3(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) {
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit;
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }

    public static void main(String[] args) {
        System.out.println(
                new LeetcodeJz44().findNthDigit3(100000000)
        );
    }
}
