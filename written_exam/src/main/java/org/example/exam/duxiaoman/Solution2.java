package org.example.exam.duxiaoman;

import java.util.Scanner;

/**
 * 在xxxx年，小A成功研发出了一种新型疗法：节奏疗法。
 * 节奏疗法是这样的：使用心跳节奏器来识别病人的心跳是否稳定，并在合适的时候按下节奏器上的按钮，
 * 来调节引导病人的心跳保持稳定。但是，在不合适的地方按下时，则可能会导致病情恶化。
 * 于是，医生在治疗的时候需要时刻保持专注。
 * 在某一段时间内，病人的心跳节奏可以用OX来表示，
 * 其中O表示此时可以按下按钮或者不按，而X表示此时不能按下按钮。
 * 为了训练，小A找来m位医生，并给他们一段模拟的心跳节奏，之后小A得到了这m位医生各自的按键情况。
 * 小A找你帮忙写个程序，来判断哪些医生的按键是合法的。
 * <p>
 * 输入：
 * OOXX
 * 3
 * 1111
 * 1100
 * 0100
 * 输出：
 * NO
 * YES
 * YES
 *
 * @author lifei
 */
public class Solution2 {
    public static String getAns(String s, String x) {
        int n = s.length();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'X' && x.charAt(i) == '1') {
                return "NO";
            }
        }
        return "YES";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int m = sc.nextInt();
        int i = 0;
        while (i < m) {
            String x = sc.next();
            System.out.println(getAns(s, x));
            i++;
        }
    }
}
