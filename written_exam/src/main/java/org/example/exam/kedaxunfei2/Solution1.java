package org.example.exam.kedaxunfei2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 题目描述：
 * 输入：
 * 285 271 270 268 264 251 237 236 228 227 226 225 224 217 216 205 198 193 192 190 182 168 165 161 157 146 141 135 127 126 122 114 105 81 80 76 70 67 63 59 55 44 34 24 19 14 9 5 2 1
 * 251
 * 输出：
 * A0
 * 输入：
 * 299 293 291 288 287 286 278 276 275 269 262 260 244 239 236 232 213 209 204 199 197 184 179 178 175 170 167 166 162 158 141 130 128 124 115 111 108 105 63 60 57 54 49 44 40 34 17 11 4 3
 * 4
 * 输出：
 * F
 * 说明：
 * 通过：
 *
 * @author lifei
 */
public class Solution1 {
    public static String getAns(int[] scores, int n) {
        Arrays.sort(scores);
        int i = 50 - Arrays.binarySearch(scores, n);
        i++;
        if (i <= 5) {
            return "A+";
        } else if (i <= 15) {
            return "A0";
        } else if (i <= 30) {
            return "B+";
        } else if (i <= 35) {
            return "B0";
        } else if (i <= 45) {
            return "C+";
        } else if (i <= 48) {
            return "C0";
        } else {
            return "F";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int[] scores = new int[50];
        // for (int i = 0; i < 50; i++) {
        //     scores[i] = sc.nextInt();
        // }
        // int n = sc.nextInt();
        int[] scores = new int[]{
                285, 271, 270, 268, 264, 251, 237, 236, 228, 227, 226, 225, 224, 217, 216, 205, 198, 193, 192, 190, 182, 168, 165, 161, 157, 146, 141, 135, 127, 126, 122, 114, 105, 81, 80, 76, 70, 67, 63, 59, 55, 44, 34, 24, 19, 14, 9, 5, 2, 1
                // 299, 293, 291, 288, 287, 286, 278, 276, 275, 269, 262, 260, 244, 239, 236, 232, 213, 209, 204, 199, 197, 184, 179, 178, 175, 170, 167, 166, 162, 158, 141, 130, 128, 124, 115, 111, 108, 105, 63, 60, 57, 54, 49, 44, 40, 34, 17, 11, 4, 3
        };
        int n = 237;
        // int n = 4;
        System.out.println(getAns(scores, n));
    }
}
