package org.example.exam.meituan2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 小美在数轴上放置了若干个机器人，这些机器人每到整数时刻，就会检查是否和其他机器人重合。
 * 如果重合，它就会原地爆炸。
 * 这些机器人的移动速度均为 1 。
 * 举例来说，
 * 如果一个机器人初始位于点3，然后它的方向是向右的，则时刻1会位于点4，时刻2会位于点5。
 * 小美现在给小团这样一个任务：小美将给出所有机器人的初始位置和初始朝向。
 * 小团的任务是判断每个机器人的爆炸时刻。当然，如果有一些机器人永远不会爆炸，则输出-1。
 * 小团向你求助。你能帮帮小团吗？
 * 注意事项1：一个机器人爆炸了之后，就不会再继续存在在这个数轴上。
 * 举例来说，
 * 如果有三个机器人，一个位于位置0，向右，一个位于位置2，向右，一个位于位置4，向左。
 * 则时刻1的时候，后两个机器人会在位置3相遇并发生爆炸，
 * 此后第一个机器人和第三个机器人不会在时刻2继续爆炸（因为此时已经不存在第三个机器人了）
 * 注意事项2：请注意，只有整数时刻机器人才会检查重合。
 * 举例来说，
 * 如果有两个机器人，一个位于位置1，向右，一个位于位置2，向左，
 * 则它们并不会在整数时刻重合。因此它们两个不存在相遇爆炸。
 * 注意事项3：保证机器人初始时刻不会重叠。换句话说，不存在在时刻0就立刻爆炸的机器人。
 * <p>
 * 输入：
 * 10
 * 94 R
 * 74 L
 * 90 L
 * 75 R
 * 37 R
 * 99 R
 * 62 R
 * 4 L
 * 92 L
 * 44 R
 * 输出：
 * -1
 * 6
 * 23
 * -1
 * -1
 * -1
 * 6
 * -1
 * -1
 * 23
 * <p>
 * AK！
 *
 * @author lifei
 */
public class Solution3 {
    private static int[] getExplodeTime(int[] nums, String[] directions) {
        int n = nums.length;
        // 统计向右的个数
        int rightCount = 0;
        for (String s : directions) {
            if ("R".equals(s)) {
                rightCount++;
            }
        }
        int[] ans = new int[n];
        // 全左或全右肯定不会撞
        if (rightCount == 0 || rightCount == n) {
            for (int i = 0; i < n; i++) {
                ans[i] = -1;
            }
            return ans;
        }
        // 记录一下每个数字的位置
        Map<Integer, Integer> map = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            map.put(nums[i], i);
        }
        // 生成向左、向右两个数组
        int leftCount = n - rightCount;
        int[] toRight = new int[rightCount];
        int[] toLeft = new int[leftCount];
        int i = 0;
        int j = 0;
        for (int k = 0; k < n; k++) {
            if ("R".equals(directions[k])) {
                toRight[i++] = nums[k];
            } else {
                toLeft[j++] = nums[k];
            }
        }
        // 先排序
        Arrays.sort(toRight);
        Arrays.sort(toLeft);
        for (int k = rightCount - 1; k >= 0; k--) {
            int cur = toRight[k];
            // cur大于所有向左
            if (cur > toLeft[leftCount - 1]) {
                ans[map.get(cur)] = -1;
                continue;
            }
            // 找相遇
            int pos = 0;
            while (pos < leftCount
                    && (cur > toLeft[pos]
                    || ans[map.get(toLeft[pos])] != 0
                    || (toLeft[pos] - cur) % 2 != 0)) {
                pos++;
            }
            // 没找到
            if (pos == leftCount) {
                ans[map.get(cur)] = -1;
                continue;
            }
            // 找到了
            int t = (toLeft[pos] - cur) / 2;
            ans[map.get(cur)] = t;
            ans[map.get(toLeft[pos])] = t;
        }
        // 向左没相遇过的
        for (int k = 0; k < n; k++) {
            if (ans[k] == 0) {
                ans[k] = -1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        String[] directions = new String[n];
        int pos = 0;
        while (pos < n) {
            nums[pos] = sc.nextInt();
            directions[pos] = sc.next();
            pos++;
        }
        // int[] nums = new int[]{94, 74, 90, 75, 37, 99, 62, 4, 92, 44};
        // String[] directions = new String[]{"R", "L", "L", "R", "R", "R", "R", "L", "L", "R"};
        int[] ans = getExplodeTime(nums, directions);
        for (int i : ans) {
            System.out.println(i);
        }
    }
}
