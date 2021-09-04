package org.example.exam.yy;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 输入：[-1.1, 3, 7, 79.6, 9.8]
 * 输出：[3.00000,7.00000]
 * <p>
 * 输入：[-5, -2.2, 19, 28, 19, -1.5]
 * 输出：[-2.20000]
 * <p>
 * 输入：[0, -2.2, 11, 22, 15, -18]
 * 输出：[]
 *
 * @author lifei
 */
public class Solution1 {
    public ArrayList<Double> findPoints(double[] data) {
        int n = data.length;
        if (n <= 2) {
            return new ArrayList<>();
        }
        Deque<Integer> lowToHigh = new LinkedList<>();
        Deque<Integer> highToLow = new LinkedList<>();
        double max = data[0];
        for (int i = 1; i < n - 1; i++) {
            if (data[i] <= max) {
                continue;
            } else {
                max = data[i];
            }
            if (lowToHigh.isEmpty()) {
                if (data[i] > data[i - 1]) {
                    lowToHigh.push(i);
                }
            } else {
                if (data[i] > data[lowToHigh.peek()]) {
                    lowToHigh.push(i);
                }
            }
        }
        double min = data[n - 1];
        for (int i = n - 2; i > 0; i--) {
            if (data[i] >= min) {
                continue;
            } else {
                min = data[i];
            }
            if (highToLow.isEmpty()) {
                if (data[i] < data[i + 1]) {
                    highToLow.push(i);
                }
            } else {
                if (data[i] < data[highToLow.peek()]) {
                    highToLow.push(i);
                }
            }
        }
        // System.out.println(lowToHigh);
        // System.out.println(highToLow);
        ArrayList<Double> ans = new ArrayList<>();
        while (!highToLow.isEmpty() && !lowToHigh.isEmpty()) {
            if (highToLow.peek().equals(lowToHigh.pollLast())) {
                ans.add(data[highToLow.pop()]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // double[] data = new double[]{-1.1, 3, 7, 79.6, 9.8};
        // double[] data = new double[]{-5, -2.2, 19, 28, 19, -1.5};
        double[] data = new double[]{0, -2.2, 11, 22, 15, -18};
        System.out.println(new Solution1().findPoints(data));
    }
}
