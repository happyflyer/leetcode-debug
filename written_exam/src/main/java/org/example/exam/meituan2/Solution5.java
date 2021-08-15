package org.example.exam.meituan2;

import java.util.Scanner;

/**
 * 小美现在想要经过一个总距离长为n的水洼地。
 * 其中一些地块是水坑，另一些是地面。初始的时候小美位于这段水洼地的首个地块的位置。
 * 很显然小美不想自己的鞋湿掉。于是小美想出一个办法：小美每次可以跳到非水坑的地方。
 * 不过小美的力气有限，每一步都至多跳距离p。
 * 换句话说，
 * 小美当前位置在第i个地块上，那么小美下一步可以位于[i+1, i+p]之间的非水坑的地块上。
 * 但小美每跳一步都会消耗力气，跳不同的距离对小美的力气消耗是不同的。
 * 你的任务是帮助小美计算最小的力气消耗，
 * 即在保证小美跳到第n个地块的前提下（注意：刚好是第n个地块，本题中不存在n+1之后的地块），
 * 求出最少要花费多少力气。
 * 第一行两个正整数n和p，空格隔开，n表示地块的数量，p表示小美单次的最远跳跃距离。
 * 接下来一行一个长度为n的字符串，只包含小写字母o和小写字母x，
 * 其中小写字母o表示地面，小写字母x表示水坑。
 * 保证字符串中的首个字符和末尾字符一定是地面（即小写字母o），
 * 保证从起点到终点至少存在一种合法路径。
 * 接下来一行p个正整数，第i个数字表示小美跳跃距离i所需要花费的体力值。
 * （请注意：不保证小美跳的近就一定花费更少的力气）
 * 一行一个正整数表示小美最少花费的体力值。
 * <p>
 * 输入：
 * 10 5
 * oxxoooxxxo
 * 1 6 9 15 18
 * 输出：
 * 26
 * 样例解释：
 * 地块1 -> 地块4 -> 地块5 -> 地块6 -> 地块10
 * 共计花费力气 9 + 1 + 1 + 15 = 26
 * 数据范围和说明
 * 对于40% 的数据保证 n <= 100, 5 <= p <= 10
 * 对于100%的数据保证 n <= 10,000, 5 <= p <= 100
 * 小美每步跳跃的力气保证是个[1,100]之间的正整数。
 * 但不保证跳的越远小美需要消耗的力气越大。
 * <p>
 * AF
 *
 * @author lifei
 */
public class Solution5 {
    private static int getMinCost(int n, int p, String s, int[] cost) {
        // 动态规划
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = sc.nextInt();
        String s = sc.next();
        int[] cost = new int[p];
        int i = 0;
        while (i < p) {
            cost[i] = sc.nextInt();
            i++;
        }
        System.out.println(getMinCost(n, p, s, cost));
    }
}
